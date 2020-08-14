/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.config;

import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.dao.inter.VergiEmpDaoInter;
import com.mycompany.entity.DailySalary;
import com.mycompany.entity.Employee;
import com.mycompany.entity.MonthDate;
import com.mycompany.entity.Vergi;
import com.mycompany.entity.VergiEmp;
import com.mycompany.main.Contex;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Virtu
 */
public class Config {

    private static final DailySalaryDaoInter dsdi = Contex.instanceDailySalaryDao();
    private static final EmployeDaoInter edi = Contex.instanceEmployeeDao();
    private static final VergiEmpDaoInter vedi = Contex.instanceVergiEmpDao();
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

    public static void addDailySalary(java.sql.Date sqlDate) {

        java.util.Date d = new java.util.Date();
        String zaman = sdf1.format(d);

        List<Employee> empList = null;
        List<DailySalary> dList = null;
        List<DailySalary> dl = dsdi.SearchByDate(zaman);

        empList = edi.allList();
        dList = dsdi.allGet();

        if (dList.isEmpty()) {
            searchEmployer(sqlDate);
            System.out.println("1");
        }

        if (!dList.isEmpty()) {

            if (dl.isEmpty()) {
                searchEmployer(sqlDate);
                System.out.println("2");
            }
        }
        for (Employee emp : empList) {
            DailySalary ds = dsdi.SearchByFinAndSeriaAndDate(emp.getIdentity_fin(), emp.getIdentity_seria(), zaman);
            if (ds == null) {

                System.out.println("3");
                Config.addDailySalary(emp,sqlDate);
            }

        }
    }

    private static void searchEmployer(java.sql.Date sqlDate) {

        List<Employee> empList = null;
        empList = edi.allListStatus();

        for (Employee emps : empList) {
            if (emps.getStatus() == 1) {
                Config.addDailySalary(emps,sqlDate);
            }

        }

    }

    private static void addDailySalary(Employee emp,java.sql.Date sqlDate) {

        MonthDate md = FindMonthAllDay.getDaily();
        int day = md.getDay();

        double guneDusenPul = 0;

        List<DailySalary> dList = null;
        dList = dsdi.allGet();

        VergiEmp ve = vedi.SearchEmployeById(emp.getId());

        double daily_salary = ve.getNet_salary() / day;

        double bonus = 12;
        double advance = 14.5;
        double penalty = 3;
        double taken_daily_salary = 9;
        int status = 1;

        java.sql.Date about_date = new java.sql.Date(utilDate().getTime());

        DailySalary ds = new DailySalary(0, emp, bonus, advance, penalty, taken_daily_salary, daily_salary, sqlDate, status);
        dsdi.AddDailySalary(ds);

    }

    public static VergiEmp vergiNet(VergiEmp ver) {

        Employee emp = edi.SearchById(ver.getEmpId().getId());

        VergiDaoInter vgi = Contex.instanceVergiDao();
        Vergi v = vgi.SearchById(ver.getVergiId().getId());

        VergiEmp ve = new VergiEmp();
        ve.setEmpId(emp);
        ve.setVergiId(v);
        ve.setStatus(1);

        double salary = emp.getSalary();
        double max = v.getSalary_max();
        double minSalary = v.getSalary_min();
        if (salary < max) {

            double gv = 0;
            ve.setGv_200(0);

            double min = (v.getSalary_min() * v.getSsh_200_gore()) / 100;
            ve.setSsh_200_gore(min);

            double other = ((emp.getSalary() - v.getSalary_min()) * v.getSsh_200dan_yuxari()) / 100;
            ve.setSsh_200dan_yuxari(other);
            //System.out.println(other);
            double ssh = min + other;

            double ish = (emp.getSalary() * v.getIsh_200_gore()) / 100;
            ve.setIsh_200_gore(ish);

            double itsh = (emp.getSalary() * v.getItsh_200()) / 100;
            ve.setItsh_200(itsh);

            ve.setGv_8000(0);
            ve.setSsh_8000in200(0);
            ve.setSsh_8000dan_qalani(0);
            ve.setIsh_8000_gore(0);
            ve.setItsh_8000_gore(0);
            ve.setItsh_8000_elave(0);

            double net_Salary = emp.getSalary() - (gv + min + other + ish + itsh);
            ve.setNet_salary(net_Salary);

        }
        if (salary > max) {

            ve.setGv_200(0);
            ve.setSsh_200_gore(0);
            ve.setSsh_200dan_yuxari(0);
            ve.setIsh_200_gore(0);
            ve.setItsh_200(0);

            double gv = ((emp.getSalary() - v.getSalary_max()) * v.getGv_8000()) / 100;
            ve.setGv_8000(gv);

            double ssh200 = (v.getSalary_min() * v.getSsh_8000in200()) / 100;
            ve.setSsh_8000in200(ssh200);

            double sshQalani = ((emp.getSalary() - v.getSalary_min()) * v.getSsh_8000dan_qalani()) / 100;
            ve.setSsh_8000dan_qalani(sshQalani);

            double ish = (emp.getSalary() * v.getIsh_8000_gore()) / 100;
            ve.setIsh_8000_gore(ish);

            double itsh8000gore = (v.getSalary_max() * v.getItsh_8000_gore()) / 100;
            ve.setItsh_8000_gore(itsh8000gore);

            double itsh_8000_elave = ((emp.getSalary() - v.getSalary_max()) * v.getItsh_8000_elave()) / 100;
            ve.setItsh_8000_elave(itsh_8000_elave);

            double net_Salary = emp.getSalary() - (gv + ssh200 + sshQalani + ish + itsh8000gore + itsh_8000_elave);
            ve.setNet_salary(net_Salary);
        }

        return ve;
    }

    public static String getDateNow() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        String date = df.format(d);
        return date;
    }

    private static Date utilDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        return d;
    }

    public static void addMonthlySalary() {
        System.out.println("Ayliq Maas ise dusdu");
        List<Employee> listEmp = edi.allListStatus();
        for (Employee employee : listEmp) {
            if (employee.getPayType().getValue().equals("a")) {
                System.out.println("Ayliq maasa girildi");
                addTamAy(employee);

            }
        }

    }

    private static void addTamAy(Employee employee) {
        System.out.println("Tam ayin icindedi");

        String startDate = String.valueOf(employee.getSend_salary_day());
        System.out.println("StartDate: "+startDate);
        String endDate = getDateNow();
        System.out.println("endDate: "+endDate);

        char[] startChary = startDate.toCharArray();
        String start = startChary[8] + "" + startChary[9];
        System.out.println("Star: "+start);

        char[] endChary = endDate.toCharArray();
        String end = endChary[8] + "" + endChary[9];
        System.out.println("End: "+end);

        int id = employee.getId();

        double bonus = 0;
        double advance = 0;
        double penalty = 0;
        double take_salary = 0;
        double daily_salary = 0;

        if (start.equals(end)) {
            System.out.println("Baslangic ve indiki zaman yoxlanildi ve kecdi");

            List<DailySalary> listDs = dsdi.SearchByDateRanger(id, startDate, endDate);
            for (DailySalary listD : listDs) {
                System.out.println("Forun icindeyik");
                bonus = bonus + listD.getBonus();
                advance = advance + listD.getAdvance();
                penalty = penalty + listD.getPenalty();
                take_salary = take_salary + listD.getTaken_daily_salary();
                daily_salary = daily_salary + listD.getDaily_salary();
            }

        }
        System.out.println("Bonus: "+bonus+" Advance: "+advance+" Penalty: "+penalty+" Take Salary: "+take_salary+
                " Dail Salary: "+daily_salary);

    }

}
