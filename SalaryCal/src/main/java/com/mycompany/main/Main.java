/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.config.Config;
import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.dao.inter.VergiEmpDaoInter;
import com.mycompany.entity.DailySalary;
import com.mycompany.entity.Employee;
import com.mycompany.entity.PayType;
import com.mycompany.entity.Position;
import com.mycompany.entity.Vergi;
import com.mycompany.entity.VergiEmp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Virtu
 */
public class Main {

    public static void main(String[] args) throws ParseException {

        EmployeDaoInter edi = Contex.instanceEmployeeDao();
        VergiDaoInter vdi = Contex.instanceVergiDao();
        VergiEmpDaoInter vedi = Contex.instanceVergiEmpDao();
//        String name = "Elgiz";
//        String surname = "Cebrayiov";
//        String phone = "+99470608368";
//        String address = "Baki";
//        String identity_fin = "SHDJHK";
//        String identity_seria = "SHDJHK";
//        String email = "virtu309a7@gmail.com";
//        int salary = 780;
//        int num_of_day = 5;
//        int position = 1;
//        String fullname = name + " " + surname;
//        int status = 1;
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            java.util.Date utilDate = format.parse("2020-08-01");
//            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//            System.out.println("Salam: "+sqlDate);
//
//            Employee emp = new Employee();
//            emp.setName(name);
//            emp.setSurname(surname);
//            emp.setPhone(phone);
//            emp.setIdentity_fin(identity_fin);
//            emp.setIdentity_seria(identity_seria);
//            emp.setEmail(email);
//            emp.setSalary(salary);
//            emp.setJob_start(sqlDate);
//            emp.setJob_end(sqlDate);
//            emp.setNum_of_day(num_of_day);
//            Position p = new Position();
//            p.setId(1);
//            emp.setPositionId(p);
//            emp.setFullname(fullname);
//            emp.setStatus(status);
//            PayType pt = new PayType();
//            pt.setId(1);
//            emp.setPayType(pt);
//            emp.setSend_salary_day(sqlDate);
//            edi.AddEmploye(emp);
//
//        } catch (ParseException e) {
//            System.out.println("Error: "+e.getMessage());
//        }

        Employee emp = edi.SearchById(12);
        DailySalary ds=new DailySalary();
//        Vergi v=vdi.SearchById(1);
//        VergiEmp ve=new VergiEmp(emp, v);
//        vedi.AddVergiEmp(ve);

        
        String date = "";
        int ay = 0;
        int il = 2020;
        int gun = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int a = 7; a < 9; a++) {
            for (int g = 1; g < 32; g++) {
                gun = g;
                ay = a;
                if (g<10) {
                date = il + "-0" + ay + "-0" + gun;
                    
                }else{
                    
                date = il + "-0" + ay + "-" + gun;
                }
                System.out.println("Date: " + date);
                try {
                    java.util.Date utilDate = format.parse(date);
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    Config.addDailySalary(sqlDate);

                    Config.addMonthlySalary();
                } catch (ParseException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
