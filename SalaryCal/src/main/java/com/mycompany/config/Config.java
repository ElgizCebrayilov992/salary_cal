/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.config;

import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.MonthlySalaryDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.dao.inter.VergiEmpDaoInter;
import com.mycompany.entity.DailySalary;
import com.mycompany.entity.Employee;
import com.mycompany.entity.MonthDate;
import com.mycompany.entity.MonthlySalary;
import com.mycompany.entity.Vergi;
import com.mycompany.entity.VergiEmp;
import com.mycompany.main.Contex;
import java.text.DateFormat;
import java.text.ParseException;
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
    private static final MonthlySalaryDaoInter msdi = Contex.instanceMonthlySalaryDao();

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

        }

        if (!dList.isEmpty()) {

            if (dl.isEmpty()) {
                searchEmployer(sqlDate);

            }
        }
        for (Employee emp : empList) {
            DailySalary ds = dsdi.SearchByFinAndSeriaAndDate(emp.getIdentity_fin(), emp.getIdentity_seria(), zaman);
            if (ds == null) {

                Config.addDailySalary(emp, sqlDate);
            }

        }
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
            ve.setSsh_200_gore(Math.rint(min));

            double other = ((emp.getSalary() - v.getSalary_min()) * v.getSsh_200dan_yuxari()) / 100;
            ve.setSsh_200dan_yuxari(Math.rint(other));
            //System.out.println(other);
            double ssh = min + other;

            double ish = (emp.getSalary() * v.getIsh_200_gore()) / 100;
            ve.setIsh_200_gore(Math.rint(ish));

            double itsh = (emp.getSalary() * v.getItsh_200()) / 100;
            ve.setItsh_200(Math.rint(itsh));

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
            ve.setGv_8000(Math.rint(gv));

            double ssh200 = (v.getSalary_min() * v.getSsh_8000in200()) / 100;
            ve.setSsh_8000in200(Math.rint(ssh200));

            double sshQalani = ((emp.getSalary() - v.getSalary_min()) * v.getSsh_8000dan_qalani()) / 100;
            ve.setSsh_8000dan_qalani(Math.rint(sshQalani));

            double ish = (emp.getSalary() * v.getIsh_8000_gore()) / 100;
            ve.setIsh_8000_gore(Math.rint(ish));

            double itsh8000gore = (v.getSalary_max() * v.getItsh_8000_gore()) / 100;
            ve.setItsh_8000_gore(Math.rint(itsh8000gore));

            double itsh_8000_elave = ((emp.getSalary() - v.getSalary_max()) * v.getItsh_8000_elave()) / 100;
            ve.setItsh_8000_elave(Math.rint(itsh_8000_elave));

            double net_Salary = emp.getSalary() - (gv + ssh200 + sshQalani + ish + itsh8000gore + itsh_8000_elave);
            ve.setNet_salary(Math.rint(net_Salary));
        }

        return ve;
    }

    public static String getDateNow() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        String date = df.format(d);
        return date;
    }

    public static void addAyliqMaas(java.sql.Date sqlDate) throws ParseException {

        List<Employee> listEmp = edi.allListStatus();

        for (Employee employee : listEmp) {

            String value = employee.getPayType().getValue();
            switch (value) {
                case "a":
                    addIscininIsegirdiyiGundenGelenAyinHeminGununeQeder(employee, sqlDate);
                    break;
                case "b":
                    addAyinTamOlduguGun(employee, sqlDate);
                    break;

                default:
                    addIsininVerilenGunSayisinaGore(employee, sqlDate);

            }

        }

    }

    private static java.sql.Date getSqlDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        java.sql.Date about_date = new java.sql.Date(d.getTime());
        return about_date;
    }

    private static void searchEmployer(java.sql.Date sqlDate) {

        List<Employee> empList = null;
        empList = edi.allListStatus();

        for (Employee emps : empList) {
            if (emps.getStatus() == 1) {
                Config.addDailySalary(emps, sqlDate);
            }

        }

    }

    private static void addDailySalary(Employee emp, java.sql.Date sqlDate) {

        MonthDate md = FindMonthAllDay.getDaily();
        int day = md.getDay();

        double guneDusenPul = 0;

        List<DailySalary> dList = null;
        dList = dsdi.allGet();

        VergiEmp ve = vedi.SearchEmployeById(emp.getId());

        double daily_salary = ve.getNet_salary() / day;

        double bonus = 10;
        double advance = 3;
        double penalty = 8;
        double taken_daily_salary = 10;
        int status = 1;

        //java.sql.Date about_date = getSqlDate();
        java.sql.Date about_date = sqlDate;

        DailySalary ds = new DailySalary(0, emp, bonus, advance, penalty, taken_daily_salary, Math.rint(daily_salary), about_date, status);
        dsdi.AddDailySalary(ds);

    }

    private static void addIscininIsegirdiyiGundenGelenAyinHeminGununeQeder(Employee employee, java.sql.Date sqlDate) throws ParseException {

        String startDate = String.valueOf(employee.getSend_salary_day());

        // String endDate = getDateNow();
        String endDate = String.valueOf(sqlDate);

        char[] startChary = startDate.toCharArray();
        String start = startChary[8] + "" + startChary[9];

        char[] endChary = endDate.toCharArray();
        String end = endChary[8] + "" + endChary[9];

        if (start.equals(end)) {
            addIscilerinAyliqMaaslarinHesablanmasi(employee, startDate, endDate, sqlDate);
        }

    }

    private static void addAyinTamOlduguGun(Employee employee, java.sql.Date sqlDate) throws ParseException {

        MonthDate md = FindMonthAllDay.getDaily();

        String ay = "";
        int a = md.getMonth() - 1;
        if (md.getMonth() < 10) {
            ay = "0" + a;
        } else {
            ay = a + "";
        }
        String startDate = employee.getSend_salary_day() + ""; // iscinin ise girdiyi gun verileceyi maas
        String endDate = md.getYear() + "-" + ay + "-" + md.getDay(); //ayin sonuncu gunun tapmaq
        String endDate1 = String.valueOf(sqlDate); // bize gelen zaman

        String gelenZaman = String.valueOf(sqlDate);

//        if (endDate.equals(getDateNow())) {
//        addIscilerinAyliqMaaslarinHesablanmasi(employee, startDate, endDate);
//            
//        }
        char[] endDate2 = endDate1.toCharArray();
        String start = endDate2[8] + "" + endDate2[9];

        char[] gelenZaman2 = endDate.toCharArray();
        String end = gelenZaman2[8] + "" + gelenZaman2[9];

        if (start.equals(end)) {

            addIscilerinAyliqMaaslarinHesablanmasi(employee, startDate, endDate, sqlDate);

        }

    }

    private static void addIscilerinAyliqMaaslarinHesablanmasi(Employee emp, String start, String end, java.sql.Date sqlDate) throws ParseException {

        List<MonthlySalary> yoxla1 = null;
        List<DailySalary> listDs = null;

        int id = emp.getId();

        VergiEmp ve = vedi.SearchEmployeById(id);

        yoxla1 = msdi.SearchEmployeById(id);

        if (yoxla1.isEmpty() && yoxla1 == null) {
            listDs = dsdi.SearchByDateRangerBeraber(id, start, end);

            addAll(listDs, emp, start, end, sqlDate);

        }

        if (!yoxla1.isEmpty() && yoxla1 != null) {
            listDs = null;
            listDs = dsdi.SearchByDateRangerBoyuk(id, start, end);

            if (!listDs.isEmpty() && listDs != null) {

                addAll(listDs, emp, start, end, sqlDate);

            }
        }

    }

    private static void addAll(List<DailySalary> listDs, Employee emp, String start, String end, java.sql.Date sqlDate) throws ParseException {
        double bonus = 0;
        double advance = 0;
        double penalty = 0;
        double take_salary = 0;
        double daily_salary = 0;
        double employee_debit = 0;
        double company_debit = 0;
        double giveSalary = 0;
        double netSalary = 0;
        System.out.println("Baslangic zaman: " + start);
        System.out.println("Bitis zaman: " + end);
        for (DailySalary listD : listDs) {

            bonus = bonus + listD.getBonus();
            System.out.println("bonus: " + bonus);
            advance = advance + listD.getAdvance();
            penalty = penalty + listD.getPenalty();
            take_salary = take_salary + listD.getTaken_daily_salary();
            daily_salary=daily_salary+listD.getDaily_salary();
            netSalary = netSalary + listD.getDaily_salary();
            System.out.println("SALAM: " + listD);

        }

        double yoxla = netSalary - (advance + penalty + take_salary);

        if (yoxla < 0) {

            employee_debit = -1 * yoxla;
        }
        if (yoxla > 0) {

            giveSalary = yoxla;

        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = df.parse(end);
        java.sql.Date sqlStartDate = new java.sql.Date(d.getTime());

        MonthlySalary ms = new MonthlySalary();
        ms.setEmploye_id(emp);
        ms.setTotal_bonus(bonus);
        ms.setTotal_advance(advance);
        ms.setTotal_penalty(penalty);
        ms.setTotal_taken_daily_salary(take_salary);
        ms.setEmployee_debit(employee_debit);
        ms.setCompany_debit(company_debit);
        //ms.setAbout_date(getSqlDate());

        ms.setAbout_date(sqlStartDate);
        ms.setNet_salary(netSalary);
        ms.setStatus(1);
        ms.setGive_salary(giveSalary);

        emp.setSend_salary_day(sqlStartDate);
        edi.Updateemploye(emp);

        msdi.AddMonthlySalary(ms);
        System.out.println("net salary: " + netSalary);
        System.out.println("Bonus: " + bonus + " Advance: " + advance + " Penalty: " + penalty + " Take Salary: " + take_salary
                + " Dail Salary: " + daily_salary);
    }

    private static void addIsininVerilenGunSayisinaGore(Employee emp, java.sql.Date sqlDate) throws ParseException {

        List<MonthlySalary> msList = msdi.SearchEmployeById(emp.getId());

        if (msList.isEmpty()) {
            limitYoxla(dsdi.SearchByDateRangerBeraberLimit(emp.getId(),
                    String.valueOf(emp.getSend_salary_day()), String.valueOf(sqlDate), Integer.valueOf(emp.getPayType().getValue())), emp, sqlDate);

        }

        if (!msList.isEmpty()) {
            limitYoxla(dsdi.SearchByDateRangerBoyukLimit(emp.getId(),
                    String.valueOf(emp.getSend_salary_day()), String.valueOf(sqlDate), Integer.valueOf(emp.getPayType().getValue())), emp, sqlDate);

        }

    }

    private static void limitYoxla(List<DailySalary> list, Employee emp, java.sql.Date sqlDate) throws ParseException {

        int count = 0;
        String empDate = String.valueOf(emp.getSend_salary_day());
        String gelenDate = String.valueOf(sqlDate);

        count = list.stream().map(_item -> 1).reduce(count, Integer::sum);
        
        if (emp.getPayType().getValue().equals(String.valueOf(count))) {

            addAll(list, emp, empDate, gelenDate, sqlDate);

        }

    }
}
