/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.dao.impl.DailySalaryDaoImpl;
import com.mycompany.dao.impl.EmployeDaoImpl;
import com.mycompany.dao.impl.PositionDaoImpl;
import com.mycompany.dao.impl.VergiDaoImpl;
import com.mycompany.dao.impl.VergiEmpDaoImpl;
import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.PositionDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.dao.inter.VergiEmpDaoInter;

/**
 *
 * @author Virtu
 */
public class Contex {

    public static EmployeDaoInter instanceEmployeeDao() {
        return new EmployeDaoImpl();
    }

    public static PositionDaoInter instancePositionDao() {
        return new PositionDaoImpl();
    }

    public static VergiDaoInter instanceVergiDao() {
        return new VergiDaoImpl();
    }

    public static VergiEmpDaoInter instanceVergiEmpDao() {
        return new VergiEmpDaoImpl();
    }
    
    public static DailySalaryDaoInter instanceDailySalaryDao() {
        return new DailySalaryDaoImpl();
    }
}
