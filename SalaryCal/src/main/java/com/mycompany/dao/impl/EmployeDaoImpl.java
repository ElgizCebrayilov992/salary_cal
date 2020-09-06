/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.util.Util;
import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.entity.Employee;
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
public class EmployeDaoImpl extends AbstractDao implements EmployeDaoInter {

    private Employee getEmployee(ResultSet rs) throws Exception {

        int id = rs.getInt("id");

        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String address = rs.getString("address");
        String identity_fin = rs.getString("identity_fin");
        String identity_seria = rs.getString("identity_seria");
        String email = rs.getString("email");

        double salary = rs.getDouble("salary");

        Date job_start = rs.getDate("job_start");

        int num_of_day = rs.getInt("num_of_day");

        String full_name = rs.getString("full_name");
        int status = rs.getInt("status");

        int position_id = rs.getInt("position_id");
        String posistion = rs.getString("position");
        Position pos = new Position(position_id, posistion, "");
//------------------------------------------------------------------------------
        int pay_type_id = rs.getInt("pay_type_id");
        int view = rs.getInt("view");
        String value = rs.getString("value");
        String type = rs.getString("type");
        int pt_status = rs.getInt("pt_status");
        PayType py = new PayType(pay_type_id, type, value, view, pt_status);
//------------------------------------------------------------------------------

        Date job_end = rs.getDate("job_end");
        Date send_salary_day = rs.getDate("send_salary_day");

        return new Employee(id, name, surname, phone, address, identity_fin, identity_seria, email, salary, job_start, num_of_day, pos, full_name, status, py, job_end, send_salary_day);

    }

    @Override
    public List<Employee> allList() {
        List<Employee> list = new ArrayList<>();

        String sql = "SELECT\n"
                + " ae.*,\n"
                + "p.`name` AS position,\n"
                + " pt.`view`,\n"
                + " pt.STATUS AS pt_status,\n"
                + "	 pt.`value`,\n"
                + " pt.type\n"
                + "FROM\n"
                + "	 about_employee AS ae \n"
                + "	LEFT JOIN position p ON p.id = ae.position_id \n"
                + "	LEFT JOIN pay_type pt ON pt.id = ae.pay_type_id ";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Employee u = getEmployee(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public boolean AddEmploye(Employee u) {
        System.out.println("Gelen emp: " + u);

        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO about_employee (`name`,surname,phone,"
                    + "address,identity_fin,identity_seria,email,salary,"
                    + "job_start,num_of_day,position_id,full_name,status,pay_type_id,job_end,send_salary_day) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getIdentity_fin());
            ps.setString(6, u.getIdentity_seria());
            ps.setString(7, u.getEmail());
            ps.setDouble(8, u.getSalary());
            ps.setDate(9, u.getJob_start());
            ps.setInt(10, u.getNum_of_day());
            ps.setInt(11, u.getPositionId().getId());
            ps.setString(12, u.getName() + " " + u.getSurname());
            ps.setInt(13, 1);
            ps.setInt(14, u.getPayType().getId());
            ps.setDate(15, u.getJob_end());
            ps.setDate(16, u.getJob_start());

            ps.execute();
        } catch (Exception e) {
            System.out.println("ImplMessages: " + e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean Updateemploye(Employee u) {

        try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update about_employee set name=?,surname=?,phone=?,address=?,identity_fin=?,identity_seria=?,email=?,salary=?,job_start=?,num_of_day=?,position_id=?,full_name=?,status=?,pay_type_id=?,job_end=?,send_salary_day=? where id=?");
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getIdentity_fin());
            ps.setString(6, u.getIdentity_seria());
            ps.setString(7, u.getEmail());
            ps.setDouble(8, u.getSalary());
            ps.setDate(9, u.getJob_start());
            ps.setInt(10, u.getNum_of_day());
            ps.setInt(11, u.getPositionId().getId());
            ps.setString(12, u.getName()+ " "+u.getSurname());
            ps.setInt(13, u.getStatus());
            ps.setInt(14, u.getPayType().getId());
            ps.setDate(15, u.getJob_end());
            ps.setDate(16, u.getSend_salary_day());
            ps.setInt(17, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public Employee SearchByIdentitySeria(String seria) {
        Employee emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT\n"
                    + "	ae.*,\n"
                    + "	p.`name` AS position,\n"
                    + "	pt.`view`,\n"
                    + "	pt.STATUS AS pt_status \n"
                    + "FROM\n"
                    + "	about_employee AS ae\n"
                    + "	LEFT JOIN position p ON p.id = ae.position_id\n"
                    + "	LEFT JOIN pay_type pt ON pt.id = ae.pay_type_id WHERE identity_seria LIKE '%" + seria + "%'");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                emp = getEmployee(rs);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return emp;

    }

    @Override
    public boolean RemoveEmployer(int id) {
        String endJob = Util.getDateNow();
        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("UPDATE about_employee set `status`=0 , job_end='" + endJob + "' WHERE id=" + id);
            ResultSet rs = stm.getResultSet();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public Employee SearchById(int id) {

        Employee emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT\n"
                    + "	ae.*,\n"
                    + "	p.`name` AS position,\n"
                    + "	pt.`view`,\n"
                    + "	pt.STATUS AS pt_status,\n"
                    + "pt.`value`,\n"
                    + "pt.type\n"
                    + "\n"
                    + "FROM\n"
                    + "	about_employee AS ae\n"
                    + "	LEFT JOIN position p ON p.id = ae.position_id\n"
                    + "	LEFT JOIN pay_type pt ON pt.id = ae.pay_type_id \n"
                    + "WHERE\n"
                    + "	ae.id=" + id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                emp = getEmployee(rs);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return emp;

    }

    @Override
    public List<Employee> allListStatus() {
        List<Employee> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "	ae.*,\n"
                + "	p.`name` AS position,\n"
                + "	pt.`view`,\n"
                + "	pt.STATUS AS pt_status,\n"
                + "	pt.`value`,\n"
                + "	pt.type \n"
                + "FROM\n"
                + "	about_employee AS ae\n"
                + "	LEFT JOIN position p ON p.id = ae.position_id\n"
                + "	LEFT JOIN pay_type pt ON pt.id = ae.pay_type_id \n"
                + "WHERE\n"
                + "	ae.`status` = 1;";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Employee u = getEmployee(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public Employee SearchByIdentityFinAndSeria(String fin, String seria) {

        Employee emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT\n"
                    + " ae.*,\n"
                    + "p.`name` AS position,\n"
                    + " pt.`view`,\n"
                    + " pt.STATUS AS pt_status,\n"
                    + "	 pt.`value`,\n"
                    + " pt.type\n"
                    + "FROM\n"
                    + "	 about_employee AS ae \n"
                    + "	LEFT JOIN position p ON p.id = ae.position_id \n"
                    + "	LEFT JOIN pay_type pt ON pt.id = ae.pay_type_id \n"
                    + "WHERE\n"
                    + " ae.`status` = 1 \n"
                    + " AND ae.identity_fin='" + fin + "'\n"
                    + " AND ae.identity_seria='" + seria + "'");
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                emp = getEmployee(rs);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return emp;
    }

    @Override
    public List<Employee> searchFrontEnd(String fullname, String phone, String address, 
            String identity_fin, String identity_seria, String email,
            String salary, String job_start, String position) {
        List<Employee> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "	ae.*,\n"
                + "	p.`name` AS position,\n"
                + "	pt.`view`,\n"
                + "	pt.STATUS AS pt_status,\n"
                + "	pt.`value`,\n"
                + "	pt.type \n"
                + "FROM\n"
                + "	about_employee AS ae\n"
                + "	LEFT JOIN position p ON p.id = ae.position_id\n"
                + "	LEFT JOIN pay_type pt ON pt.id = ae.pay_type_id \n"
                + "WHERE\n"
                + "	ae.`status` = 1 ";
        
         if (!fullname.trim().isEmpty() && fullname != null) {
            String query2 = "AND ae.full_name LIKE '%" + fullname + "%' ";
            sql = sql + query2;

        }
         if (!phone.trim().isEmpty() && phone != null) {
            String query2 = "AND ae.phone LIKE '%" + phone + "%' ";
            sql = sql + query2;

        }
         if (!address.trim().isEmpty() && address != null) {
            String query2 = "AND ae.address LIKE '%" + address + "%' ";
            sql = sql + query2;

        }
         if (!identity_fin.trim().isEmpty() && identity_fin != null) {
            String query2 = "AND ae.identity_fin LIKE '%" + identity_fin + "%' ";
            sql = sql + query2;

        }
         if (!identity_seria.trim().isEmpty() && identity_seria != null) {
            String query2 = "AND ae.identity_seria LIKE '%" + identity_seria + "%' ";
            sql = sql + query2;

        }
         if (!email.trim().isEmpty() && email != null) {
            String query2 = "AND ae.email LIKE '%" + email + "%' ";
            sql = sql + query2;

        }
         if (!salary.trim().isEmpty() && salary != null) {
            String query2 = "AND ae.salary LIKE '%" + salary + "%' ";
            sql = sql + query2;

        }
         if (!job_start.trim().isEmpty() && job_start != null) {
            String query2 = "AND ae.job_start LIKE '%" + job_start + "%' ";
            sql = sql + query2;

        }
         if (!position.trim().isEmpty() && position != null) {
            String query2 = "AND p.`name` LIKE '%" + position + "%' ";
            sql = sql + query2;

        }

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Employee u = getEmployee(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

}
