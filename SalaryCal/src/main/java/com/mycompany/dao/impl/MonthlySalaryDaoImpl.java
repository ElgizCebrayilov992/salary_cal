/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.MonthlySalaryDaoInter;
import com.mycompany.entity.DailySalary;
import com.mycompany.entity.Employee;
import com.mycompany.entity.MonthlySalary;
import com.mycompany.entity.PayType;
import com.mycompany.entity.Position;
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
public class MonthlySalaryDaoImpl extends AbstractDao implements MonthlySalaryDaoInter {

    private MonthlySalary getMonthlySalary(ResultSet rs) throws Exception {

//*******************************************************************
        int employe_id = rs.getInt("employe_id");
        int empStatus = rs.getInt("empStatus");
        String identity_fin = rs.getString("identity_fin");
        String identity_seria = rs.getString("identity_seria");
        String full_name = rs.getString("full_name");
        String phone = rs.getString("phone");

        Employee emp = new Employee();
        emp.setId(employe_id);
        emp.setIdentity_fin(identity_fin);
        emp.setIdentity_seria(identity_seria);
        emp.setFullname(full_name);
        emp.setPhone(phone);
        emp.setStatus(empStatus);

        String value = rs.getString("value");
        String type = rs.getString("type");

        PayType pt = new PayType();
        pt.setType(type);
        pt.setValue(value);

        emp.setPayType(pt);

        String pos_name = rs.getString("pos_name");

        Position p = new Position();
        p.setName(pos_name);

        emp.setPositionId(p);

//**********************************************************************
        int id = rs.getInt("id");
        double total_bonus = rs.getDouble("total_bonus");
        double total_advance = rs.getDouble("total_advance");
        double total_penalty = rs.getDouble("total_penalty");
        double total_taken_daily_salary = rs.getDouble("total_taken_daily_salary");
        double employee_debit = rs.getDouble("employee_debit");
        double company_debit = rs.getDouble("company_debit");
        double give_salary = rs.getDouble("give_salary");
        Date about_date = rs.getDate("about_date");
        double net_salary = rs.getDouble("net_salary");
        double send_salary = rs.getDouble("send_salary");
        int status = rs.getInt("status");
        Date send_date = rs.getDate("send_date");

        return new MonthlySalary(id, emp, total_bonus, total_advance, total_penalty, total_taken_daily_salary, employee_debit, company_debit, about_date, net_salary, status, give_salary, send_salary,send_date);
    }

    @Override
    public List<MonthlySalary> allGet() {
        List<MonthlySalary> list = new ArrayList<>();

        String sql = "SELECT\n"
                + " *  \n"
                + "FROM\n"
                + " monthly_salary ms \n"
                + "	LEFT JOIN (\n"
                + "	 SELECT\n"
                + "	 aa.full_name,\n"
                + "	 aa.identity_fin,\n"
                + " aa.identity_seria,\n"
                + " aa.phone,\n"
                + " aa.id AS emp_id,\n"
                + "	pt.`value`,\n"
                + " pt.type,\n"
                + " p.`name` AS pos_name,\n"
                + "aa.`status` AS empStatus\n"
                + "	FROM\n"
                + " about_employee aa \n"
                + "		LEFT JOIN pay_type pt ON pt.id = aa.pay_type_id \n"
                + "		LEFT JOIN position p ON p.id = aa.position_id \n"
                + "	\n"
                + ") ae ON ae.emp_id = ms.employe_id WHERE ae.empStatus=1\n"
                + "ORDER BY\n"
                + " ms.about_date DESC";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                MonthlySalary u = getMonthlySalary(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public boolean AddMonthlySalary(MonthlySalary ms) {
        System.out.println("MSL: "+ms);
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO monthly_salary "
                    + "(employe_id,total_bonus,total_advance,total_penalty,"
                    + "total_taken_daily_salary,employee_debit,company_debit,about_date,net_salary,`status`,give_salary) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, ms.getEmploye_id().getId());
            ps.setDouble(2, ms.getTotal_bonus());
            ps.setDouble(3, ms.getTotal_advance());
            ps.setDouble(4, ms.getTotal_penalty());
            ps.setDouble(5, ms.getTotal_taken_daily_salary());
            ps.setDouble(6, ms.getEmployee_debit());
            ps.setDouble(7, ms.getCompany_debit());
            ps.setDate(8, ms.getAbout_date());
            ps.setDouble(9, ms.getNet_salary());
            ps.setInt(10, ms.getStatus());
            ps.setDouble(11, ms.getGive_salary());
           

            ps.execute();
            
        } catch (Exception e) {
            System.out.println("Bu Nedir:  "+e.getMessage());
            e.printStackTrace();
            return false;
        }
        System.out.println("Add");
        return true;
    }

    @Override
    public boolean UpdateMonthlySalary(MonthlySalary ms) {
        System.out.println("MSSSI "+ms);
        try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update monthly_salary set "
                    + "employe_id=?,"
                    + "total_bonus=?,"
                    + "total_advance=?,"
                    + "total_penalty=?,"
                    + "total_taken_daily_salary=?,"
                    + "employee_debit=?,"
                    + "company_debit=?,"
                    +"about_date=?,"
                    + "net_salary=?,"
                    + "status=?,"
                    + "give_salary=?,"
                    + "send_salary=?, "
                    + "send_date=? "
                    + " where id=?");

            ps.setInt(1, ms.getEmploye_id().getId());
            ps.setDouble(2, ms.getTotal_bonus());
            ps.setDouble(3, ms.getTotal_advance());
            ps.setDouble(4, ms.getTotal_penalty());
            ps.setDouble(5, ms.getTotal_taken_daily_salary());
            ps.setDouble(6, ms.getEmployee_debit());
            ps.setDouble(7, ms.getCompany_debit());
            ps.setDate(8, ms.getAbout_date());
            ps.setDouble(9, ms.getNet_salary());
            ps.setInt(10, ms.getStatus());
            ps.setDouble(11, ms.getGive_salary());
            ps.setDouble(12, ms.getSend_salary());
            ps.setDate(13, ms.getSend_date());
            ps.setInt(14, ms.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean RemoveMonthlySalary(int id) {
        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("UPDATE monthly_salary set `status`=0 WHERE id=" + id);
            ResultSet rs = stm.getResultSet();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public MonthlySalary SearchById(int id) {
        MonthlySalary emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT\n"
                    + "	* \n"
                    + "FROM\n"
                    + "	monthly_salary ms\n"
                    + "	LEFT JOIN (\n"
                    + "	SELECT\n"
                    + "		aa.full_name,\n"
                    + "		aa.identity_fin,\n"
                    + "		aa.identity_seria,\n"
                    + "		aa.phone,\n"
                    + "		aa.id AS emp_id,\n"
                    + "		pt.`value`,\n"
                    + "		pt.type,\n"
                    + "		p.`name` AS pos_name, \n"
                    + "aa.`status` AS empStatus\n"
                    + "	FROM\n"
                    + "		about_employee aa\n"
                    + "		LEFT JOIN pay_type pt ON pt.id = aa.pay_type_id\n"
                    + "	LEFT JOIN position p ON p.id = aa.position_id \n"
                    + "	) ae ON ae.emp_id = ms.employe_id WHERE ae.empStatus=1 AND id=" + id + " ORDER BY\n"
                    + "	ms.about_date DESC");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                emp = getMonthlySalary(rs);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return emp;

    }

    @Override
    public MonthlySalary SearchByFinAndSeriaAndDate(String fin, String seria, String date) {

        MonthlySalary emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT\n"
                    + " * \n"
                    + "FROM\n"
                    + " monthly_salary ms \n"
                    + "	LEFT JOIN (\n"
                    + "	 SELECT\n"
                    + "	 aa.full_name,\n"
                    + "	 aa.identity_fin,\n"
                    + "	 aa.identity_seria,\n"
                    + "	 aa.phone,\n"
                    + "	 aa.id AS emp_id,\n"
                    + "	 pt.`value`,\n"
                    + "	 pt.type,\n"
                    + "	 p.`name` AS pos_name,  \n"
                    + "aa.`status` AS empStatus\n"
                    + "	FROM\n"
                    + " about_employee aa \n"
                    + "		LEFT JOIN pay_type pt ON pt.id = aa.pay_type_id \n"
                    + "		LEFT JOIN position p ON p.id = aa.position_id \n"
                    + "	) ae ON ae.emp_id = ms.employe_id \n"
                    + "	\n"
                    + "	WHERE ae.empStatus=1 AND"
                    + " ae.identity_fin='" + fin + "' AND\n"
                    + "	ae.identity_seria='" + seria + "' AND\n"
                    + "	ms.about_date='" + date + "'\n"
                    + "ORDER BY\n"
                    + " ms.about_date DESC");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                emp = getMonthlySalary(rs);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return emp;

    }

    @Override
    public List<MonthlySalary> SearchEmployeById(int id) {
        List<MonthlySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT\n"
                    + "	* \n"
                    + "FROM\n"
                    + "	monthly_salary ms\n"
                    + "	LEFT JOIN (\n"
                    + "	SELECT\n"
                    + "		aa.full_name,\n"
                    + "		aa.identity_fin,\n"
                    + "		aa.identity_seria,\n"
                    + "		aa.phone,\n"
                    + "		aa.id AS emp_id,\n"
                    + "		pt.`value`,\n"
                    + "		pt.type,\n"
                    + "		p.`name` AS pos_name, \n"
                    + "aa.`status` AS empStatus\n"
                    + "	FROM\n"
                    + "		about_employee aa\n"
                    + "		LEFT JOIN pay_type pt ON pt.id = aa.pay_type_id\n"
                    + "	LEFT JOIN position p ON p.id = aa.position_id \n"
                    + "	) ae ON ae.emp_id = ms.employe_id \n"
                    + "	WHERE ae.empStatus=1 AND employe_id=" + id + " ORDER BY ms.about_date DESC");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                MonthlySalary result = getMonthlySalary(rs);
                list.add(result);

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public List<MonthlySalary> SearchByFullName(String fullName) {

        List<MonthlySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT\n"
                    + "	* \n"
                    + "FROM\n"
                    + "	monthly_salary ms\n"
                    + "	LEFT JOIN (\n"
                    + "	SELECT\n"
                    + "		aa.full_name,\n"
                    + "		aa.identity_fin,\n"
                    + "		aa.identity_seria,\n"
                    + "		aa.phone,\n"
                    + "		aa.id AS emp_id,\n"
                    + "		pt.`value`,\n"
                    + "		pt.type,\n"
                    + "		p.`name` AS pos_name, \n"
                    + "aa.`status` AS empStatus\n"
                    + "	FROM\n"
                    + "		about_employee aa\n"
                    + "		LEFT JOIN pay_type pt ON pt.id = aa.pay_type_id\n"
                    + "		LEFT JOIN position p ON p.id = aa.position_id \n"
                    + "	) ae ON ae.emp_id = ms.employe_id \n"
                    + "	\n"
                    + "	WHERE ae.empStatus=1 AND ae.full_name LIKE '%" + fullName + "%' ORDER BY about_date DESC");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                MonthlySalary result = getMonthlySalary(rs);
                list.add(result);

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public List<MonthlySalary> SearchByDate(String date) {
        List<MonthlySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT\n"
                    + "	* \n"
                    + "FROM\n"
                    + "	monthly_salary ms\n"
                    + "	LEFT JOIN (\n"
                    + "	SELECT\n"
                    + "		aa.full_name,\n"
                    + "		aa.identity_fin,\n"
                    + "		aa.identity_seria,\n"
                    + "		aa.phone,\n"
                    + "		aa.id AS emp_id,\n"
                    + "		pt.`value`,\n"
                    + "		pt.type,\n"
                    + "		p.`name` AS pos_name, \n"
                    + "aa.`status` AS empStatus\n"
                    + "	FROM\n"
                    + "		about_employee aa\n"
                    + "		LEFT JOIN pay_type pt ON pt.id = aa.pay_type_id\n"
                    + "		LEFT JOIN position p ON p.id = aa.position_id \n"
                    + "	) ae ON ae.emp_id = ms.employe_id \n"
                    + "WHERE\n"
                    + " ae.empStatus=1 AND ms.about_date='" + date + "'\n"
                    + "ORDER BY\n"
                    + "	ms.about_date DESC");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                MonthlySalary result = getMonthlySalary(rs);
                list.add(result);

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public List<MonthlySalary> SearchByDateRanger(int id, String start, String end) {
        List<MonthlySalary> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute("SELECT\n"
                    + "	* \n"
                    + "FROM\n"
                    + "	monthly_salary ms\n"
                    + "	LEFT JOIN (\n"
                    + "	SELECT\n"
                    + "		aa.full_name,\n"
                    + "		aa.identity_fin,\n"
                    + "		aa.identity_seria,\n"
                    + "		aa.phone,\n"
                    + "		aa.id AS emp_id,\n"
                    + "		pt.`value`,\n"
                    + "		pt.type,\n"
                    + "		p.`name` AS pos_name, \n"
                    + "aa.`status` AS empStatus\n"
                    + "	FROM\n"
                    + "		about_employee aa\n"
                    + "		LEFT JOIN pay_type pt ON pt.id = aa.pay_type_id\n"
                    + "		LEFT JOIN position p ON p.id = aa.position_id \n"
                    + "	) ae ON ae.emp_id = ms.employe_id \n"
                    + "	\n"
                    + "	WHERE \n"
                    + "  ae.empStatus=1 AND ms.about_date >= DATE( '" + start + "' )\n"
                    + "	AND ms.about_date <= DATE( '" + end + "' )\n"
                    + "	AND ae.emp_id=" + id + "\n"
                    + "	AND ms.`status` = 1\n"
                    + "	\n"
                    + "ORDER BY\n"
                    + "	ms.about_date DESC");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                MonthlySalary result = getMonthlySalary(rs);
                list.add(result);

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public List<MonthlySalary> FrontSearch(String total_bonus, String total_advance, String total_penalty, String total_taken_daily_salary, String employee_debit, String company_debit, String about_date, String net_salary, String identity_fin, String identity_seria, String full_name, String phone, String value, String type, String pos_name) {
        List<MonthlySalary> list = new ArrayList<>();
        String query = "SELECT\n"
                + "	* \n"
                + "FROM\n"
                + "	monthly_salary ms\n"
                + "	LEFT JOIN (\n"
                + "	SELECT\n"
                + "		aa.full_name,\n"
                + "		aa.identity_fin,\n"
                + "		aa.identity_seria,\n"
                + "		aa.phone,\n"
                + "		aa.id AS emp_id,\n"
                + "		pt.`value`,\n"
                + "		pt.type,\n"
                + "		p.`name` AS pos_name, \n"
                + "aa.`status` AS empStatus\n"
                + "	FROM\n"
                + "		about_employee aa\n"
                + "		LEFT JOIN pay_type pt ON pt.id = aa.pay_type_id\n"
                + "		LEFT JOIN position p ON p.id = aa.position_id \n"
                + "	) ae ON ae.emp_id = ms.employe_id \n"
                + "WHERE\n"
                + "  ae.empStatus=1 AND	ms.`status`=1 ";

        if (!total_bonus.trim().isEmpty() && total_bonus != null) {
            String tBonus = "AND total_bonus LIKE '%" + total_bonus + "%' ";
            query = query + tBonus;

        }
        if (!total_advance.trim().isEmpty() && total_advance != null) {
            String tBonus = "AND total_advance LIKE '%" + total_advance + "%' ";
            query = query + tBonus;

        }
        if (!total_penalty.trim().isEmpty() && total_penalty != null) {
            String tBonus = "AND total_penalty LIKE '%" + total_penalty + "%' ";
            query = query + tBonus;

        }
        if (!total_taken_daily_salary.trim().isEmpty() && total_taken_daily_salary != null) {
            String tBonus = "AND total_taken_daily_salary LIKE '%" + total_taken_daily_salary + "%' ";
            query = query + tBonus;

        }
        if (!employee_debit.trim().isEmpty() && employee_debit != null) {
            String tBonus = "AND employee_debit LIKE '%" + employee_debit + "%' ";
            query = query + tBonus;

        }
        if (!company_debit.trim().isEmpty() && company_debit != null) {
            String tBonus = "AND company_debit LIKE '%" + company_debit + "%' ";
            query = query + tBonus;

        }
        if (!about_date.trim().isEmpty() && about_date != null) {
            String tBonus = "AND about_date LIKE '%" + about_date + "%' ";
            query = query + tBonus;

        }
        if (!net_salary.trim().isEmpty() && net_salary != null) {
            String tBonus = "AND net_salary LIKE '%" + net_salary + "%' ";
            query = query + tBonus;

        }
        if (!full_name.trim().isEmpty() && full_name != null) {
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
        if (!phone.trim().isEmpty() && phone != null) {
            String tBonus = "AND phone LIKE '%" + phone + "%' ";
            query = query + tBonus;

        }
        if (!value.trim().isEmpty() && value != null) {
            String tBonus = "AND value LIKE '%" + value + "%' ";
            query = query + tBonus;

        }
        if (!type.trim().isEmpty() && type != null) {
            String tBonus = "AND type LIKE '%" + type + "%' ";
            query = query + tBonus;

        }
        if (!pos_name.trim().isEmpty() && pos_name != null) {
            String tBonus = " AND pos_name LIKE '%" + pos_name + "%' ";
            query = query + tBonus;

        }
        query = query + " ORDER BY\n"
                + "	ms.about_date DESC ";
        try (Connection con = connection()) {
            //String sql="";

//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
            Statement stm = connection().createStatement();
            stm.execute(query);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                MonthlySalary result = getMonthlySalary(rs);
                list.add(result);

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

}
