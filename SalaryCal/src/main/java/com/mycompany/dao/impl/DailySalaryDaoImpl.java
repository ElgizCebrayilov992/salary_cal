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
        String identity_fin = rs.getString("identity_fin");
        String identity_seria = rs.getString("identity_seria");
        String full_name = rs.getString("full_name");
        Employee emp = new Employee();
        emp.setId(employe_id);
        emp.setIdentity_fin(identity_fin);
        emp.setIdentity_seria(identity_seria);
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

        String sql = "SELECT\n"
                + " ds.*,\n"
                + " ae.full_name,\n"
                + "	 ae.identity_fin,\n"
                + "	 ae.identity_seria \n"
                + "FROM\n"
                + " daily_salary ds \n"
                + "	LEFT JOIN about_employee ae ON ae.id = ds.employe_id ORDER BY about_date DESC";

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
            ps.setInt(9, ve.getId());
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
            stm.execute("SELECT\n"
                    + "	ds.*,\n"
                    + "	ae.full_name,\n"
                    + "	ae.identity_fin,\n"
                    + "	ae.identity_seria\n"
                    + "FROM\n"
                    + "	daily_salary ds \n"
                    + "	LEFT JOIN about_employee ae ON ae.id = ds.employe_id \n"
                    + "WHERE\n"
                    + "	ds.id =" + id);
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
            stm.execute("SELECT\n"
                    + "	ds.*,\n"
                    + "	ae.full_name \n"
                    + "FROM\n"
                    + "	daily_salary ds \n"
                    + "	LEFT JOIN about_employee ae ON ae.id = ds.employe_id \n"
                    + "WHERE\n"
                    + "	ae.id=" + id);
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
    public DailySalary SearchByFinAndSeriaAndDate(String fin, String seria, String date) {

        DailySalary emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT\n"
                    + "	ds.*,\n"
                    + "	ae.full_name,\n"
                    + "	ae.identity_seria,\n"
                    + "	ae.identity_fin \n"
                    + "FROM\n"
                    + "	daily_salary ds\n"
                    + "	LEFT JOIN about_employee ae ON ae.id = ds.employe_id \n"
                    + "WHERE\n"
                    + "	ae.identity_fin = '" + fin + "' \n"
                    + "	AND ae.identity_seria = '" + seria + "' \n"
                    + "	AND ds.about_date = '" + date + "'");
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
            stm.execute("SELECT\n"
                    + "	ds.*,\n"
                    + "	ae.full_name,\n"
                    + "	ae.identity_fin,\n"
                    + "	ae.identity_seria\n"
                    + "FROM\n"
                    + "	daily_salary ds \n"
                    + "	LEFT JOIN about_employee ae ON ae.id = ds.employe_id \n"
                    + "WHERE\n"
                    + "	ds.about_date = '" + date + "';");
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
    public List<DailySalary> FrontSearch(String bonus, String advance, String penalty, String taken_daily_salary, String daily_salary, String about_date, String full_name, String identity_fin, String identity_seria) {
        System.out.println("FullName: " + full_name);
        List<DailySalary> list = new ArrayList<>();
        String query = "SELECT\n"
                + "	* \n"
                + "FROM\n"
                + "	monthly_salary ms\n"
                + "	LEFT JOIN (\n"
                + "	SELECT\n"
                + "	aa.`status` AS sts,\n"
                + "		aa.full_name,\n"
                + "		aa.identity_fin,\n"
                + "		aa.identity_seria,\n"
                + "		aa.phone,\n"
                + "		aa.id AS emp_id,\n"
                + "		pt.`value`,\n"
                + "		pt.type,\n"
                + "		p.`name` AS pos_name \n"
                + "	FROM\n"
                + "		about_employee aa\n"
                + "		LEFT JOIN pay_type pt ON pt.id = aa.pay_type_id\n"
                + "		LEFT JOIN position p ON p.id = aa.position_id \n"
                + "	) ae ON ae.emp_id = ms.employe_id \n"
                + "WHERE\n"
                + "	ae.sts=1 ";

        if (!bonus.trim().isEmpty() && bonus != null) {
            String tBonus = "AND bonus LIKE '%" + bonus + "%' ";
            query = query + tBonus;

        }
        if (!advance.trim().isEmpty() && advance != null) {
            String tBonus = "AND advance LIKE '%" + advance + "%' ";
            query = query + tBonus;

        }
        if (!penalty.trim().isEmpty() && penalty != null) {
            String tBonus = "AND penalty LIKE '%" + penalty + "%' ";
            query = query + tBonus;

        }
        if (!taken_daily_salary.trim().isEmpty() && taken_daily_salary != null) {
            String tBonus = "AND taken_daily_salary LIKE '%" + taken_daily_salary + "%' ";
            query = query + tBonus;

        }
        if (!daily_salary.trim().isEmpty() && daily_salary != null) {
            String tBonus = "AND daily_salary LIKE '%" + daily_salary + "%' ";
            query = query + tBonus;

        }
        if (!about_date.trim().isEmpty() && about_date != null) {
            String tBonus = "AND about_date LIKE '%" + about_date + "%' ";
            query = query + tBonus;

        }
        if (!full_name.trim().isEmpty() && full_name != null) {
            System.out.println("full name girildi");
            String tBonus = "AND full_name LIKE '%" + full_name + "%' ";
            query = query + tBonus;

        }
        if (!identity_fin.trim().isEmpty() && identity_fin != null) {
            String tBonus = "AND identity_fin LIKE '%" + identity_fin + "%' ";
            query = query + tBonus;

        }

        if (!identity_seria.trim().isEmpty() && identity_seria != null) {
            String tBonus = "AND identity_seria LIKE '%" + identity_seria + "%' ";
            query = query + tBonus;

        }

        query = query + " ORDER BY\n"
                + "	about_date DESC ";
        System.out.println("Hazirlanan query:   " + query);
        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute(query);
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
    public List<DailySalary> SearchByDateRangerBeraber(int id, String start, String end) {

        List<DailySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT\n"
                    + "	ds.*,\n"
                    + "	ae.full_name,\n"
                    + "	ae.identity_fin,\n"
                    + "	ae.identity_seria \n"
                    + "FROM\n"
                    + "	daily_salary ds\n"
                    + "	LEFT JOIN about_employee ae ON ae.id = ds.employe_id \n"
                    + "WHERE\n"
                    + "	ds.about_date >= DATE( '" + start + "' ) \n"
                    + "	AND ds.about_date <= DATE( '" + end + "' ) \n"
                    + "	AND ae.id=" + id + "\n"
                    + "AND ds.`status` = 1	\n"
                    + "ORDER BY\n"
                    + "	ds.about_date DESC;");
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
    public List<DailySalary> SearchByDateRangerBoyuk(int id, String start, String end) {
        List<DailySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT\n"
                    + "	ds.*,\n"
                    + "	ae.full_name,\n"
                    + "	ae.identity_fin,\n"
                    + "	ae.identity_seria \n"
                    + "FROM\n"
                    + "	daily_salary ds\n"
                    + "	LEFT JOIN about_employee ae ON ae.id = ds.employe_id \n"
                    + "WHERE\n"
                    + "	ds.about_date > DATE( '" + start + "' ) \n"
                    + "	AND ds.about_date <= DATE( '" + end + "' ) \n"
                    + "	AND ae.id=" + id + "\n"
                    + "AND ds.`status` = 1	\n"
                    + "ORDER BY\n"
                    + "	ds.about_date DESC;");
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
    public List<DailySalary> SearchByDateRangerBeraberLimit(int id, String start, String end, int limit) {
        List<DailySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT\n"
                    + "	 ds.*,\n"
                    + "ae.full_name,\n"
                    + " ae.identity_fin,\n"
                    + "	 ae.identity_seria  \n"
                    + "FROM\n"
                    + " daily_salary ds \n"
                    + "	LEFT JOIN about_employee ae ON ae.id = ds.employe_id \n"
                    + "WHERE\n"
                    + "	ds.about_date >= DATE( '" + start + "' ) \n"
                    + "	AND ds.about_date <= DATE( '" + end + "' ) \n"
                    + "	AND ae.id = " + id + " \n"
                    + "	AND ds.`status` = 1 \n"
                    + "ORDER BY\n"
                    + " ds.about_date ASC\n"
                    + " LIMIT " + limit);
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
    public List<DailySalary> SearchByDateRangerBoyukLimit(int id, String start,String end, int limit) {

        List<DailySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT\n"
                    + "	 ds.*,\n"
                    + "ae.full_name,\n"
                    + " ae.identity_fin,\n"
                    + "	 ae.identity_seria  \n"
                    + "FROM\n"
                    + " daily_salary ds \n"
                    + "	LEFT JOIN about_employee ae ON ae.id = ds.employe_id \n"
                    + "WHERE\n"
                    + "	ds.about_date > DATE( '" + start + "' ) \n"
                    + "	AND ds.about_date <= DATE( '" + end + "' ) \n"
                    + "	AND ae.id = " + id + " \n"
                    + "	AND ds.`status` = 1 \n"
                    + "ORDER BY\n"
                    + " ds.about_date ASC\n"
                    + " LIMIT " + limit);
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
