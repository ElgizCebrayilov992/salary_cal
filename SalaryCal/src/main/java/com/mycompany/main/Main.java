/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.config.Config;
import com.mycompany.config.FindMonthAllDay;
import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.MonthlySalaryDaoInter;
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

    public static void main(String[] args) throws ParseException, InterruptedException {
//int a=0;
        EmployeDaoInter edi = Contex.instanceEmployeeDao();
        VergiDaoInter vdi = Contex.instanceVergiDao();
        VergiEmpDaoInter vedi = Contex.instanceVergiEmpDao();
        MonthlySalaryDaoInter msdi = Contex.instanceMonthlySalaryDao();
        DailySalaryDaoInter dsdi = Contex.instanceDailySalaryDao();
        List<MonthlySalary> list = msdi.SearchEmployeById(13);
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
        String date = "";
        String ay = "";
        int il = 2020;
        String gun = "";
        String ay1 = "";
        String gun2 = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        for (int a = 7; a <= 10; a++) {
            
            for (int g = 1; g < 32; g++) {
                
                gun = g + "";
                ay = a + "";
                if (g < 10) {
                    gun2 = "0" + gun;
                }
                
                if (g >= 10) {
                    gun2 = gun;
                }
                
                if (a < 10) {
                    ay1 = "0" + ay;
                }
                if (a >= 10) {
                    ay1 = ay;
                }
                
                date = il + "-" + ay1 + "-" + gun2;
                
                System.out.println("Date: "+date);
                try {
                    java.util.Date utilDate = format.parse(date);
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                   
                    Config.addDailySalary(sqlDate);
                    Thread.sleep(2000);
                    Config.addAyliqMaas(sqlDate);
                    Thread.sleep(2000);
                    
                } catch (ParseException e) {
                    
                }
                
            }
        }
//        MonthDate md=FindMonthAllDay.getDaily();
    }

}
