/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.util.Util;
import com.mycompany.util.FindMonthAllDay;
import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.MonthlySalaryDaoInter;
import com.mycompany.dao.inter.PayTypeDaoInter;
import com.mycompany.dao.inter.PositionDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.dao.inter.VergiEmpDaoInter;
import com.mycompany.entity.DailySalary;
import com.mycompany.entity.Employee;
import com.mycompany.entity.MonthDate;
import com.mycompany.entity.MonthlySalary;
import com.mycompany.entity.PayType;
import com.mycompany.entity.Position;
import com.mycompany.entity.Vergi;
import com.mycompany.entity.VergiEmp;
import java.io.IOException;
import java.sql.Date;
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
public class Main {

    private static boolean NullPointerException;

    public static void main(String[] args) throws ParseException, InterruptedException, IOException {
//int a=0;
        EmployeDaoInter edi = Contex.instanceEmployeeDao();
        VergiDaoInter vdi = Contex.instanceVergiDao();
        VergiEmpDaoInter vedi = Contex.instanceVergiEmpDao();
        MonthlySalaryDaoInter msdi = Contex.instanceMonthlySalaryDao();
        PositionDaoInter pdi = Contex.instancePositionDao();
        DailySalaryDaoInter dsdi = Contex.instanceDailySalaryDao();
        PayTypeDaoInter ptdi = Contex.instancePayTypeDao();
        //        Vergi v=vdi.SearchById(1);
        //        v.setSsh_200_gore(3);
        //        Util.UpdateVergi(v);

        //        Employee emp=new Employee();
        //        emp.setIdentity_fin("MMKISA");
        //        emp.setIdentity_seria("2YUXAQ");
        //        MonthlySalary ms = msdi.SearchByFinAndSeriaAndDate(emp.getIdentity_fin(), emp.getIdentity_seria(), "2020-07-11");
        //
        //        
        //        Boolean a=ms.getEmployee_debit()==null;
        //            System.out.println("a: "+a);
        //        
        //      List<MonthlySalary> ms=msdi.SearchEmployeById(13);
        //        System.out.println("ms: "+ms);
        //        boolean c=ms.isEmpty();
        //        System.out.println("c: "+c);
        //        boolean d=ms==null;
        //        System.out.println("d: "+d);
        //        for (MonthlySalary m : ms) {
        //            System.out.println("m: "+m.getEmploye_id());
        //        }
        //        boolean a=ms==null;
        //        System.out.println(a);
        //        System.out.println(ms);
        //
        //        Vergi v = new Vergi();
        //        v.setId(1);
        //        Employee emp = edi.SearchById(14);
        //
        //        VergiEmp ve=new VergiEmp(emp, v);
        //         vedi.AddVergiEmp(ve);
        //        boolean v=emp.getPayType().getValue()==;
        //List<DailySalary> liste=dsdi.FrontSearch(null, null, null, null, null, null, "El", null, null);
        //        List<DailySalary> liste=dsdi.FrontSearch("", "", "", "", "", "", "El", "", "");
        //        for (DailySalary dailySalary : liste) {
        //            System.out.println(dailySalary);
        //        }
        //        String date = "";
        //        String ay = "";
        //        int il = 2020;
        //        String gun = "";
        //        String ay1 = "";
        //        String gun2 = "";
        //        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //        
        //        for (int a = 7; a <= 10; a++) {
        //            
        //            for (int g = 1; g < 32; g++) {
        //                
        //                gun = g + "";
        //                ay = a + "";
        //                if (g < 10) {
        //                    gun2 = "0" + gun;
        //                }
        //                
        //                if (g >= 10) {
        //                    gun2 = gun;
        //                }
        //                
        //                if (a < 10) {
        //                    ay1 = "0" + ay;
        //                }
        //                if (a >= 10) {
        //                    ay1 = ay;
        //                }
        //                
        //                date = il + "-" + ay1 + "-" + gun2;
        //                
        //                System.out.println("Date: "+date);
        //                try {
        //                    java.util.Date utilDate = format.parse(date);
        //                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        //                   
        //                    Util.addDailySalary(sqlDate);
        //                    Thread.sleep(2000);
        //                    Util.addAyliqMaas(sqlDate);
        //                    Thread.sleep(2000);
        //                    
        //                } catch (ParseException e) {
        //                    
        //                }
        //                
        //            }
        //        }
        //        MonthDate md=FindMonthAllDay.getDaily();
        //        String name="Asim";
        //        String surname="Agabeyov";
        //        String phone="+9946187545";
        //        String address="Baki";
        //        String fin="AMO5W";
        //        String seria="4867AQ8O4";
        //        String email="BabayevMurad@gmai.com";
        //        int num=5;
        //        Double salary=987.0;
        //        Position p=new Position();
        //        p.setId(2);
        //        PayType pt=new PayType();
        //        pt.setId(4);
        //        Vergi v=new Vergi();
        //        v.setId(1);
        //        String mesaj=Util.addEmploye(name,
        //                surname, 
        //                phone,
        //                address,
        //                fin, seria, email, salary, num, pt, p, v);
        //        System.out.println("Mesaj: "+mesaj);
        //List<Employee> emp=edi.searchFrontEnd("e", "+", "b", "s", "4", "@", "8", "-", "a");
        //        for (Employee employee : emp) {
        //            System.out.println("emp: "+emp);
        //        }
        //Employee empp=edi.SearchByIdentityFinAndSeria("SHDJHK", "SHDJHK");
        //        System.out.println("Empp: "+empp);
        //     Process process = java.lang.Runtime.getRuntime().exec("ping www.geeksforgeeks.org"); 
        //        int x = process.waitFor(); 
        //        if (x == 0) { 
        //            System.out.println("Connection Successful, "
        //                               + "Output was " + x); 
        //        } 
        //        else { 
        //            System.out.println("Internet Not Connected, "
        //                               + "Output was " + x); 
        //        } 
        //    
//
//        Double b=4.5-4.5;
//        System.out.println("0: "+(b==0));
//        System.out.println("0.0: "+(b==0.0));
//        
//        System.out.println("SQL: "+Util.getSqlDate());
        MonthlySalary ms = msdi.SearchById(611);
        System.out.println("MS: " + ms);
        ms.setSend_salary(Double.valueOf(20));
        Util.maasVermek(ms);
   
    }

}
