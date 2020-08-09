/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.dao.inter.VergiEmpDaoInter;
import com.mycompany.entity.DailySalary;
import com.mycompany.entity.Employee;
import com.mycompany.entity.MonthDa;
import com.mycompany.entity.Vergi;
import com.mycompany.entity.VergiEmp;
import com.mycompany.main.Contex;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Virtu
 */
public class DailySalaryUtil {

    private static final DailySalaryDaoInter dsdi = Contex.instanceDailySalaryDao();
    private static final EmployeDaoInter edi = Contex.instanceEmployeeDao();
    private static final VergiEmpDaoInter vedi = Contex.instanceVergiEmpDao();

    public static void AddDailySalary() {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        String zaman = df.format(d);

        List<Employee> empList = null;
        List<DailySalary> dList = null;
        List<DailySalary> dl = dsdi.SearchByDate(zaman);

        empList = edi.allList();
        dList = dsdi.allGet();

        if (dList.isEmpty()) {
            addUser();
        }

        if (!dList.isEmpty()) {

            if (dl.isEmpty()) {
                addUser();
            }
        }
        for (Employee emp : empList) {
            DailySalary ds = dsdi.SearchByFullNameAndDate(emp.getFullname(), zaman);
            if (ds == null) {
                System.out.println(emp);
                AddUser2(emp);
            }

        }
    }

    private static void addUser() {

        double guneDusenPul = 0;

        List<Employee> empList = null;
        empList = edi.allList();

        for (Employee emps : empList) {
            if (emps.getStatus() == 1) {
                AddUser2(emps);
            }

        }

    }

    private static void AddUser2(Employee emp) {
        System.out.println("EMp2: " + emp);
        MonthDa md = GetMonthDaysUtil.getMonthDay();
        int day = md.getDay();

        Calendar now = Calendar.getInstance();
        int day2 = now.get(Calendar.DATE);
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        String zaman = df.format(d);

        double guneDusenPul = 0;

//        List<Employee> empList = null;
//        empList = edi.allList();
        List<DailySalary> dList = null;
        dList = dsdi.allGet();

        VergiEmp ve = vedi.SearchEmployeById(emp.getId());
        System.out.println("VERGIEMP: " + ve);
        System.out.println("EMP ID: " + emp.getId());
        double daily_salary = ve.getNet_salary() / day;

        double bonus = 0;
        double advance = 0;
        double penalty = 0;
        double taken_daily_salary = 0;
        int status = 1;

        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf1.parse(zaman);
            System.out.println("parse date: " + date);
            java.sql.Date about_date = new java.sql.Date(date.getTime());

            DailySalary ds = new DailySalary(0, emp, bonus, advance, penalty, taken_daily_salary, daily_salary, about_date, status);
            dsdi.AddDailySalary(ds);
        } catch (ParseException ex) {
            Logger.getLogger(DailySalaryUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static VergiEmp vergiNet(VergiEmp ver) {

        EmployeDaoInter edi = Contex.instanceEmployeeDao();
        Employee emp = edi.SearchById(ver.getEmpId().getId());
        System.out.println("BURda 2: " + emp);

        VergiDaoInter vgi = Contex.instanceVergiDao();
        Vergi v = vgi.SearchById(ver.getVergiId().getId());
        System.out.println("BURda 3: " + v);

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
            System.out.println("BURDA MIN: " + min);

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
}
