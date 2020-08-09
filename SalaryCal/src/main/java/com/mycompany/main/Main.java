/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.dao.inter.VergiEmpDaoInter;
import com.mycompany.entity.DailySalary;
import com.mycompany.entity.Employee;
import com.mycompany.entity.MonthDa;
import com.mycompany.entity.Vergi;
import com.mycompany.entity.VergiEmp;
import com.mycompany.util.DailySalaryUtil;
import com.mycompany.util.GetMonthDaysUtil;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Virtu
 */
public class Main {

    public static void main(String[] args) {

//        EmployeDaoInter edi=Contex.instanceEmployeeDao();
//        System.out.println(edi.SearchById(1));
//        Employee emp=edi.SearchById(2);
//        
//        System.out.println(emp);
//        
//        VergiDaoInter vdi=Contex.instanceVergiDao();
//        Vergi v=vdi.SearchById(1);
//        System.out.println(v);
//        
//        VergiEmp ve=new VergiEmp();
//        ve.setEmpId(emp);
//        ve.setVergiId(v);
//        
//        VergiEmpDaoInter vedi=Contex.instanceVergiEmpDao();
//        vedi.AddVergiEmp(ve);
//        
//        System.out.println(vedi.allList());
//        DailySalaryDaoInter dsd = Contex.instanceDailySalaryDao();
//        List<DailySalary> lsit = dsd.allGet();
//        System.out.println("list: " + lsit);
//        lsit.forEach(dailySalary -> {
//            System.out.println(dailySalary);
//        });
//
//        String startDate = "01-02-2013";
//        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
//        java.util.Date date = sdf1.parse(startDate);
//        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//        MonthDa  md=GetMonthDaysUtil.getMonthDay();
//        System.out.println(md.getDay());
//        VergiEmpDaoInter vedi=Contex.instanceVergiEmpDao();
//         EmployeDaoInter edi = Contex.instanceEmployeeDao();
//        Employee emp = edi.SearchById(5);
//        
//        VergiDaoInter vgi = Contex.instanceVergiDao();
//        Vergi v = vgi.SearchById(1);
//        
//        
//        VergiEmp vergi=new VergiEmp(emp, v);
//        vedi.AddVergiEmp(vergi);
        
//        DailySalaryDaoInter dsdi = Contex.instanceDailySalaryDao();
//        DailySalary ds=dsdi.SearchByFullNameAndDate("Elgiz Cebrayilov", "2020-08-08");
//        
//        System.out.println("yoxla: "+ds);
//        System.out.println(dsdi.SearchByFullNameAndDate("Elgiz Cebrayilov", "2020-08-08"));
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date dss = new java.util.Date();
//        String zaman=df.format(dss);
//        
//        
//        List<DailySalary> ds = dsdi.allGet();
//        for (DailySalary d : ds) {
//            System.out.println("zaman: " + dss);
//            System.out.println("Sql zaman: "+d.getAbout_date().toString());
//            System.out.println("-------------");
//            
//            boolean b = zaman.equals(d.getAbout_date().toString());
//                        
//            System.out.println("b: " + b);
//            
//            System.out.println("-----------------------");
//            
//            boolean a = zaman == d.getAbout_date().toString();
//            
//            System.out.println("a: " + a);
//
//        }
DailySalaryUtil.AddDailySalary();
    }

}
