/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.dao.impl.DailySalaryDaoImpl;
import com.mycompany.dao.impl.EmployeDaoImpl;
import com.mycompany.dao.impl.MonthlySalaryDaoImpl;
import com.mycompany.dao.impl.PayTypeDaoImp;
import com.mycompany.dao.impl.PositionDaoImpl;
import com.mycompany.dao.impl.VergiDaoImpl;
import com.mycompany.dao.impl.VergiEmpDaoImpl;
import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.MonthlySalaryDaoInter;
import com.mycompany.dao.inter.PayTypeDaoInter;
import com.mycompany.dao.inter.PositionDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.dao.inter.VergiEmpDaoInter;

/**
 *
 * @author Virtu
 */
public class Contex {

    private static EmployeDaoImpl edi = null;
    private static PositionDaoImpl pdi = null;
    private static VergiDaoImpl vdi = null;
    private static VergiEmpDaoImpl vedi = null;
    private static DailySalaryDaoImpl dsdi = null;
    private static PayTypeDaoImp ptdi = null;
    private static MonthlySalaryDaoImpl msdi = null;

    public static EmployeDaoInter instanceEmployeeDao() {
        if (edi == null) {
            edi = new EmployeDaoImpl();
        }
        return edi;
    }

    public static PositionDaoInter instancePositionDao() {
        if (pdi == null) {
            pdi = new PositionDaoImpl();
        }
        return pdi;
    }

    public static VergiDaoInter instanceVergiDao() {
        if (vdi == null) {
            vdi = new VergiDaoImpl();
        }
        return vdi;
    }

    public static VergiEmpDaoInter instanceVergiEmpDao() {
        if (vedi == null) {
            vedi = new VergiEmpDaoImpl();
        }
        return vedi;
    }

    public static DailySalaryDaoInter instanceDailySalaryDao() {
        if (dsdi == null) {
            dsdi = new DailySalaryDaoImpl();
        }
        return dsdi;

    }

    public static PayTypeDaoInter instancePayTypeDao() {
        if (ptdi == null) {
            ptdi = new PayTypeDaoImp();
        }
        return ptdi;

    }

    public static MonthlySalaryDaoInter instanceMonthlySalaryDao() {
        if (msdi == null) {
            msdi = new MonthlySalaryDaoImpl();
        }
        return msdi;

    }
}
