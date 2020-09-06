/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import com.mycompany.dao.impl.VergiEmpDaoImpl;
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
import java.util.List;

/**
 *
 * @author Virtu
 */
public class Util {

    private static final DailySalaryDaoInter dsdi = Contex.instanceDailySalaryDao();
    private static final EmployeDaoInter edi = Contex.instanceEmployeeDao();
    private static final VergiEmpDaoInter vedi = Contex.instanceVergiEmpDao();
    private static final MonthlySalaryDaoInter msdi = Contex.instanceMonthlySalaryDao();
    private static final VergiDaoInter vdi = Contex.instanceVergiDao();
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    private static int NullPointerException;

    //Gunluk maas
    public static void addDailySalary(java.sql.Date sqlDate) {

        java.util.Date d = new java.util.Date();
        String zaman = sdf1.format(sqlDate);

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

                Util.addDailySalary(emp, sqlDate);
            }

        }
    }

    //Zaman String
    public static String getDateNow() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        String date = df.format(d);
        return date;
    }

    //ayliq maas
    public static void addAyliqMaas(java.sql.Date sqlDate) throws ParseException {

        List<Employee> listEmp = edi.allListStatus();

        for (Employee employee : listEmp) {
            if (employee.getStatus() == 1) {

                String value = employee.getPayType().getValue();
                switch (value) {
                    case "a":
                        System.out.println("a: " + employee.getId());
                        addIscininIsegirdiyiGundenGelenAyinHeminGununeQeder(employee, sqlDate);
                        break;
                    case "b":
                        System.out.println("B: " + employee.getId());
                        addAyinTamOlduguGun(employee, sqlDate);
                        break;

                    default:
                        System.out.println("Def: " + employee.getId());
                        addIsininVerilenGunSayisinaGore(employee, sqlDate);

                }

            }
        }

    }

    //isci elave etmek ve yenilemek
    public static String addEmployeAndUpdate(Employee empSend, Vergi v) {

        System.out.println("AddEmploye icindeyik");

        Employee emp = new Employee();

        if (empSend.getName() == null && empSend.getName().trim().isEmpty()) {
            return "name empty";

        }
        if (empSend.getSurname() == null && empSend.getSurname().trim().isEmpty()) {
            return "surname empty";

        }
        if (empSend.getPhone() == null && empSend.getPhone().trim().isEmpty()) {
            return "phone empty";

        }
        if (empSend.getAddress() == null && empSend.getAddress().trim().isEmpty()) {
            return "address empty";

        }
        if (empSend.getIdentity_fin() == null && empSend.getIdentity_fin().trim().isEmpty()) {
            return "fin empty";

        }
        if (empSend.getIdentity_seria() == null && empSend.getIdentity_seria().trim().isEmpty()) {
            return "seria empty";

        }
        if (empSend.getEmail() == null && empSend.getEmail().trim().isEmpty()) {
            return "email empty";

        }
        if (empSend.getNum_of_day() == NullPointerException) {
            return "num_day empty";

        }
        if (empSend.getSalary() == NullPointerException) {
            return "salary empty";

        }
        if (empSend.getPayType().getType() == null) {
            return "PayType empty";

        }
        if (empSend.getPositionId().getName() == null) {
            return "Position empty";

        }
        if (v.getName() == null) {
            return "Vergi empty";

        }

        emp.setId(empSend.getId());
        emp.setName(empSend.getName());
        emp.setSurname(empSend.getSurname());
        emp.setPhone(empSend.getPhone());
        emp.setAddress(empSend.getAddress());
        emp.setIdentity_fin(empSend.getIdentity_fin());
        emp.setIdentity_seria(empSend.getIdentity_seria());
        emp.setEmail(empSend.getEmail());
        emp.setSalary(empSend.getSalary());
        emp.setNum_of_day(empSend.getNum_of_day());
        emp.setPayType(empSend.getPayType());
        emp.setJob_start(empSend.getJob_start());
        emp.setPositionId(empSend.getPositionId());
        emp.setStatus(empSend.getStatus());

        System.out.println("id yoxlanir");
        if (empSend.getId() == 0) {
            System.out.println("0-a girdi");

            emp.setSend_salary_day(empSend.getJob_start());

            edi.AddEmploye(emp);
            emp = edi.SearchByIdentityFinAndSeria(empSend.getIdentity_fin(), empSend.getIdentity_seria());
            VergiEmp ver = new VergiEmp(emp, v);
            vedi.AddVergiEmp(ver);
            System.out.println("Yazildi");
            return "Add";
        }
        if (empSend.getId() != 0) {
            System.out.println("0-dan ferqli");

            emp.setSend_salary_day(empSend.getSend_salary_day());
            System.out.println("maas gunu set edildi");
            edi.Updateemploye(emp);
            System.out.println("update edildi");
            System.out.println("EMP: " + emp);

            VergiEmp v1 = new VergiEmp(emp, v);

            VergiEmp v2 = vedi.SearchEmployeByIdAndVergiId(emp.getId(), v.getId());
            v1.setId(v2.getId());
            System.out.println("V1: " + v1);
            System.out.println("V2: " + v2);

            System.out.println("vergi emp add edildi");

            VergiEmp ver = VergiEmpDaoImpl.vergiNet(v1);
            System.out.println("VER: " + ver);

            System.out.println("emeliiyar olundu");
            vedi.UpdateVergiEmp(ver);
            return "update";
        }

        return "Failed";
    }

    //zaman sql format
    public static java.sql.Date getSqlDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        java.sql.Date about_date = new java.sql.Date(d.getTime());
        return about_date;
    }

    //Vergi yenilenmesi
    public static boolean UpdateVergi(Vergi v) {
        vdi.UpdateVergi(v);

        List<VergiEmp> listVergiEmp = vedi.SearchByVergi(v.getId());

        for (VergiEmp vergiEmp : listVergiEmp) {
            System.out.println("fora girildi");
            VergiEmp ve = vergiEmp;

            Employee emp = edi.SearchById(ve.getEmpId().getId());
            Vergi v1 = vdi.SearchById(ve.getVergiId().getId());
            addEmployeAndUpdate(emp, v1);

        }

        return true;
    }

    //maas vermek
    public static void maasVermek(MonthlySalary ms) {

        Double verildi = ms.getSend_salary();
        System.out.println("verildi: "+verildi);
        Double balansBorc = ms.getGive_salary() - verildi;
        System.out.println("BorcBalans: "+balansBorc);
        ms.setSend_date(getSqlDate());
        ms.setSend_salary(verildi);
        if (balansBorc > 0) {
            ms.setCompany_debit(balansBorc);
         
        }
        msdi.UpdateMonthlySalary(ms);
        
    }

    private static void searchEmployer(java.sql.Date sqlDate) {

        List<Employee> empList = edi.allListStatus();

        for (Employee emps : empList) {

            addDailySalary(emps, sqlDate);

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

        double bonus = 1;
        double advance = 3;
        double penalty = 2;
        double taken_daily_salary = 4;
        int status = 1;

        //java.sql.Date about_date = getSqlDate();
        java.sql.Date about_date = sqlDate;

        DailySalary ds = new DailySalary(0, emp, bonus, advance, penalty, taken_daily_salary, Math.rint(daily_salary), about_date, status);
        dsdi.AddDailySalary(ds);

    }

    private static void addIscininIsegirdiyiGundenGelenAyinHeminGununeQeder(Employee employee, java.sql.Date sqlDate) throws ParseException {
        System.out.println("Adan geldi addIscininIsegirdiyiGundenGelenAyinHeminGununeQeder: " + employee.getId());
        String startDate = String.valueOf(employee.getSend_salary_day());

        // String endDate = getDateNow();
        String endDate = String.valueOf(sqlDate);

        char[] startChary = startDate.toCharArray();
        String start = startChary[8] + "" + startChary[9];

        char[] endChary = endDate.toCharArray();
        String end = endChary[8] + "" + endChary[9];
        System.out.println("Start ve ENd: " + start + " : " + end);
        if (start.equals(end)) {

            addIscilerinAyliqMaaslarinHesablanmasi(employee, startDate, endDate, sqlDate);
        }

    }

    private static void addAyinTamOlduguGun(Employee employee, java.sql.Date sqlDate) throws ParseException {
        System.out.println("Bden geldik");
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
        System.out.println("Binin end ve start yoxlanir: " + start + " : " + end);

        if (start.equals(end)) {

            addIscilerinAyliqMaaslarinHesablanmasi(employee, startDate, endDate, sqlDate);

        }

    }

    private static void addIscilerinAyliqMaaslarinHesablanmasi(Employee emp, String start, String end, java.sql.Date sqlDate) throws ParseException {
        System.out.println("Anin addIscilerinAyliqMaaslarinHesablanmasi " + emp.getId());
        List<MonthlySalary> yoxla1 = null;
        List<DailySalary> listDs = dsdi.SearchByDateRangerBeraber(emp.getId(), start, end);
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        VergiEmp ve = vedi.SearchEmployeById(emp.getId());

        yoxla1 = msdi.SearchEmployeById(emp.getId());
        System.out.println("Bdeki msdi: " + yoxla1);

        boolean c = yoxla1.isEmpty();
        System.out.println("c: " + c);
        boolean d = yoxla1 == null;
        System.out.println("d: " + d);

        if (yoxla1.isEmpty()) {

            System.out.println("Anin 1ci ifiine girdi");
            addAll(listDs, emp, start, end, sqlDate);

        }

        if (!yoxla1.isEmpty()) {

            System.out.println("Anin 2ci ifiine girdi");

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
        MonthlySalary yoxlaMonth = msdi.SearchByFinAndSeriaAndDate(emp.getIdentity_fin(), emp.getIdentity_seria(), end);
        if (yoxlaMonth == null) {
            for (DailySalary listD : listDs) {

                bonus = bonus + listD.getBonus();
                System.out.println("bonus: " + bonus + " : day: " + listD.getAbout_date());
                advance = advance + listD.getAdvance();
                penalty = penalty + listD.getPenalty();
                take_salary = take_salary + listD.getTaken_daily_salary();
                daily_salary = daily_salary + listD.getDaily_salary();
                netSalary = netSalary + listD.getDaily_salary();

            }

            MonthlySalary kecenAyBorcYoxla = msdi.SearchByFinAndSeriaAndDate(emp.getIdentity_fin(), emp.getIdentity_seria(), start);
            System.out.println("Employe Debit1: " + employee_debit);

            if (kecenAyBorcYoxla != null) {

                if (kecenAyBorcYoxla.getEmployee_debit() != null) {

                    employee_debit = employee_debit + kecenAyBorcYoxla.getEmployee_debit();

                    System.out.println("Employe Debit2: " + employee_debit);

                }

                if (kecenAyBorcYoxla.getCompany_debit() != null) {

                    company_debit = company_debit + kecenAyBorcYoxla.getCompany_debit();

                }

            }

            double yoxla = netSalary - (advance + penalty + take_salary + employee_debit);
            System.out.println("Yoxa qiymet: " + yoxla);

            if (yoxla < 0) {

                employee_debit = -1 * yoxla;
                System.out.println("Employe Debit3: " + employee_debit);

            }
            if (yoxla > 0) {

                giveSalary = yoxla;

            }
            System.out.println("Employe Debi4: " + employee_debit);

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
            System.out.println("MS: " + ms);

            System.out.println("MSSSS: " + msdi.AddMonthlySalary(ms));
            System.out.println("net salary: " + netSalary);
            System.out.println("Bonus: " + bonus + " Advance: " + advance + " Penalty: " + penalty + " Take Salary: " + take_salary
                    + " Dail Salary: " + daily_salary);
        }
    }

    private static void addIsininVerilenGunSayisinaGore(Employee emp, java.sql.Date sqlDate) throws ParseException {

        List<MonthlySalary> msList = msdi.SearchEmployeById(emp.getId());

        System.out.println("Mlist  null : " + (msList == null));
        System.out.println("Mlist isempty : " + (msList.isEmpty()));
        if (msList.isEmpty()) {
            System.out.println("Mlist isempty girildi ");
            limitYoxla(dsdi.SearchByDateRangerBeraberLimit(emp.getId(),
                    String.valueOf(emp.getSend_salary_day()), String.valueOf(sqlDate), Integer.valueOf(emp.getPayType().getValue())), emp, sqlDate);

        }

        if (!msList.isEmpty()) {

            for (MonthlySalary monthlySalary : msList) {
                if (!monthlySalary.getAbout_date().equals(sqlDate)) {

                    limitYoxla(dsdi.SearchByDateRangerBoyukLimit(emp.getId(),
                            String.valueOf(emp.getSend_salary_day()), String.valueOf(sqlDate), Integer.valueOf(emp.getPayType().getValue())), emp, sqlDate);
                }

            }

        }

    }

    private static void limitYoxla(List<DailySalary> list, Employee emp, java.sql.Date sqlDate) throws ParseException {

        int count = 0;
        String empDate = String.valueOf(emp.getSend_salary_day());
        String gelenDate = String.valueOf(sqlDate);

        MonthlySalary ms = msdi.SearchByFinAndSeriaAndDate(emp.getIdentity_fin(), emp.getIdentity_seria(),
                gelenDate);

        System.out.println("Limit Yoxladaki ms: " + ms);
        if (ms == null) {
            count = list.stream().map(_item -> 1).reduce(count, Integer::sum);

            if (emp.getPayType().getValue().equals(String.valueOf(count))) {
                System.out.println("COUNT: " + count);
                addAll(list, emp, empDate, gelenDate, sqlDate);

            }
        } else {
            System.out.println("bele zaman bazada var");
        }

    }
}
