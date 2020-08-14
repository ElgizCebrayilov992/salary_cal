/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.DailySalary;
import com.mycompany.entity.MonthlySalary;
import java.util.List;

/**
 *
 * @author Virtu
 */
public interface MonthlySalaryDaoInter {

    public List<MonthlySalary> allGet();

    public boolean AddMonthlySalary(MonthlySalary ver);

    public boolean UpdateMonthlySalary(MonthlySalary ver);

    public boolean RemoveMonthlySalary(int id);

    public MonthlySalary SearchById(int id);

    public MonthlySalary SearchByFinAndSeriaAndDate(String fin, String seria, String date);

    public List<MonthlySalary> SearchEmployeById(int id);

    public List<MonthlySalary> SearchByFullName(String fullName);

    public List<MonthlySalary> SearchByDate(String date);

    public List<MonthlySalary> SearchByDateRanger(int id, String start, String end);

    public List<MonthlySalary> FrontSearch(String total_bonus, String total_advance, String total_penalty,
            String total_taken_daily_salary,
    String employee_debit,String company_debit,String about_date,String net_salary,
    String identity_fin,String identity_seria,String full_name,String phone,String value,String type,String pos_name );

}
