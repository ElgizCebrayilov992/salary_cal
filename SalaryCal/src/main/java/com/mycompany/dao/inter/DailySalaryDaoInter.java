/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.DailySalary;
import com.mycompany.entity.VergiEmp;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Virtu
 */
public interface DailySalaryDaoInter {

    public List<DailySalary> allGet();

    public boolean AddDailySalary(DailySalary ver);

    public boolean UpdateDailySalary(DailySalary ver);

    public boolean RemoveDailySalary(int id);

    public DailySalary SearchById(int id);

    public DailySalary SearchByFullNameAndDate(String fullname, String date);

    public List<DailySalary> SearchEmployeById(int id);

    public List<DailySalary> SearchByFullName(String fullName);
    
    public List<DailySalary> SearchByDate(String date);
    

}
