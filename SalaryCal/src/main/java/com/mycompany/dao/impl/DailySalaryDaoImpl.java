/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.DailySalaryDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.entity.DailySalary;
import com.mycompany.entity.Employee;
import com.mycompany.entity.VergiEmp;
import com.mycompany.main.Contex;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Virtu
 */
public class DailySalaryDaoImpl extends AbstractDao implements DailySalaryDaoInter {

    private DailySalary getDailySalary(ResultSet rs) throws Exception {

        int id = rs.getInt("id");

        int employe_id = rs.getInt("employe_id");
        String full_name = rs.getString("full_name");
        Employee emp = new Employee();
        emp.setId(employe_id);
        emp.setFullname(full_name);
        double bonus = rs.getDouble("bonus");
        double advance = rs.getDouble("advance");
        double penalty = rs.getDouble("penalty");
        double taken_daily_salary = rs.getDouble("taken_daily_salary");
        double daily_salary = rs.getDouble("daily_salary");
        Date about_date = rs.getDate("about_date");
        int status = rs.getInt("status");

        return new DailySalary(id, emp, bonus, advance, penalty, taken_daily_salary, daily_salary, about_date, status);

    }

    @Override
    public List<DailySalary> allGet() {
        List<DailySalary> list = new ArrayList<>();

        String sql = "SELECT ds.*,ae.full_name FROM daily_salary ds\n"
                + "LEFT JOIN about_employee ae ON ae.id=ds.employe_id";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                DailySalary u = getDailySalary(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public boolean AddDailySalary(DailySalary ve) {

        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO daily_salary "
                    + "(employe_id,bonus,advance,penalty,taken_daily_salary,daily_salary,about_date,`status`) "
                    + "VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, ve.getEmp().getId());
            ps.setDouble(2, ve.getBonus());
            ps.setDouble(3, ve.getAdvance());
            ps.setDouble(4, ve.getPenalty());
            ps.setDouble(5, ve.getTaken_daily_salary());
            ps.setDouble(6, ve.getDaily_salary());
            ps.setDate(7, ve.getAbout_date());
            ps.setInt(8, ve.getStatus());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean UpdateDailySalary(DailySalary ve) {

        try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update daily_salary set employe_id=?,"
                    + "bonus=?,"
                    + "advance=?,penalty=?,taken_daily_salary=?,"
                    + "daily_salary=?,about_date=?,`status`=?"
                    + " where id=?");
            ps.setInt(1, ve.getEmp().getId());
            ps.setDouble(2, ve.getBonus());
            ps.setDouble(3, ve.getAdvance());
            ps.setDouble(4, ve.getPenalty());
            ps.setDouble(5, ve.getTaken_daily_salary());
            ps.setDouble(6, ve.getDaily_salary());
            ps.setDate(7, ve.getAbout_date());
            ps.setInt(8, ve.getStatus());
            ps.setInt(16, ve.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean RemoveDailySalary(int id) {

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("UPDATE daily_salary set `status`=0 WHERE id=" + id);
            ResultSet rs = stm.getResultSet();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public DailySalary SearchById(int id) {
        DailySalary emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT ds.*,ae.full_name FROM daily_salary ds\n"
                    + "LEFT JOIN about_employee ae ON ae.id=ds.employe_id where ds.id=" + id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                emp = getDailySalary(rs);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return emp;

    }

    @Override
    public List<DailySalary> SearchEmployeById(int id) {
        List<DailySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT ds.*,ae.full_name FROM daily_salary ds\n"
                    + "LEFT JOIN about_employee ae ON ae.id=ds.employe_id where ds.id=" + id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                DailySalary result = getDailySalary(rs);
                list.add(result);

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public List<DailySalary> SearchByFullName(String fullName) {

        List<DailySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT ds.*,ae.full_name FROM daily_salary ds\n"
                    + "LEFT JOIN about_employee ae ON ae.id=ds.employe_id where ae.full_name LIKE '%" + fullName + "%'");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                DailySalary result = getDailySalary(rs);
                list.add(result);

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public DailySalary SearchByFullNameAndDate(String fullname, String date) {

        DailySalary emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT ds.*,ae.full_name FROM daily_salary ds\n"
                    + "LEFT JOIN about_employee ae ON ae.id=ds.employe_id where ae.full_name='" + fullname + "' and ds.about_date='" + date + "'");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                emp = getDailySalary(rs);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return emp;

    }

    @Override
    public List<DailySalary> SearchByDate(String date) {
        List<DailySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT ds.*,ae.full_name,ae.salary FROM daily_salary ds\n"
                    + "LEFT JOIN about_employee ae ON ae.id=ds.employe_id WHERE ds.about_date='" + date + "';");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                DailySalary result = getDailySalary(rs);
                list.add(result);

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

}
