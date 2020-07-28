/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.dao.inter.VergiEmpDaoInter;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Vergi;
import com.mycompany.entity.VergiEmp;

/**
 *
 * @author Virtu
 */
public class Main {
    
    public static void main(String[] args) {
        
        EmployeDaoInter edi=Contex.instanceEmployeeDao();
        System.out.println(edi.SearchById(1));
        Employee emp=edi.SearchById(2);
        
//        System.out.println(emp);
        
        VergiDaoInter vdi=Contex.instanceVergiDao();
        Vergi v=vdi.SearchById(1);
        System.out.println(v);
        
        VergiEmp ve=new VergiEmp();
        ve.setEmpId(emp);
        ve.setVergiId(v);
        
        VergiEmpDaoInter vedi=Contex.instanceVergiEmpDao();
        vedi.AddVergiEmp(ve);
        
        System.out.println(vedi.allList());
        
    }
    
}
