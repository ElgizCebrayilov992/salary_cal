/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.DailySalary;
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

    public DailySalary SearchByFinAndSeriaAndDate(String fin, String seria, String date);

    public List<DailySalary> SearchEmployeById(int id);

    public List<DailySalary> SearchByDate(String date);

    public List<DailySalary> SearchByDateRangerBeraber(int id, String start, String end);

    public List<DailySalary> SearchByDateRangerBoyuk(int id, String start, String end);

    public List<DailySalary> SearchByDateRangerBeraberLimit(int id, String start,String end, int limit);

    public List<DailySalary> SearchByDateRangerBoyukLimit(int id, String start,String end, int limit);

    public List<DailySalary> FrontSearch(String bonus, String advance,
            String penalty, String taken_daily_salary,
            String daily_salary, String about_date, String full_name,
            String identity_fin, String identity_seria);

}
