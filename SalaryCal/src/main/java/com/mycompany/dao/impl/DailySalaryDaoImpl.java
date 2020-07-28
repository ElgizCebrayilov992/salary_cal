/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.entity.DailySalary;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Vergi;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Virtu
 */
public class DailySalaryDaoImpl extends AbstractDao implements DailySalaryDaoInter {

    private DailySalary getDailySalary(ResultSet rs) throws Exception {

        int id = rs.getInt("id");

        int employe_id = rs.getInt("employe_id");
        Employee emp = new Employee();
        emp.setId(employe_id);
        double bonus = rs.getDouble("bonus");
        double advance = rs.getDouble("advance");
        double penalty = rs.getDouble("penalty");
        double taken_daily_salary = rs.getDouble("taken_daily_salary");
        double daily_salary = rs.getDouble("daily_salary");
        Date about_date = rs.getDate("about_date");

        return new DailySalary(id, emp, bonus, advance, penalty, taken_daily_salary, daily_salary, about_date);
    }

    @Override
    public List<DailySalaryDaoInter> allGet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
