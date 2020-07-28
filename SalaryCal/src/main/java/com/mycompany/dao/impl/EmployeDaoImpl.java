/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.entity.Employee;
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
        String salary_day = rs.getString("salary_day");
        int num_of_day = rs.getInt("num_of_day");
        String full_name = rs.getString("full_name");
        int status = rs.getInt("status");

        int position_id = rs.getInt("position_id");
        String posistion = rs.getString("position");

        Position pos = new Position(position_id, posistion, "");

        return new Employee(id, name, surname, phone, address, identity_fin, identity_seria, email, salary, salary_day, num_of_day, pos, full_name, status);

    }

    @Override
    public List<Employee> allList() {
        List<Employee> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "	ae.*,\n"
                + "	p.`name` as \"position\"\n"
                + "FROM\n"
                + "	about_employee as ae\n"
                + "	LEFT JOIN position p ON p.id=ae.position_id;";

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

        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO about_employee (`name`,surname,phone,"
                    + "address,identity_fin,identity_seria,email,salary,"
                    + "salary_day,num_of_day,position_id,full_name,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getIdentity_fin());
            ps.setString(6, u.getIdentity_seria());
            ps.setString(7, u.getEmail());
            ps.setDouble(8, u.getSalary());
            ps.setString(9, u.getSalary_day());
            ps.setInt(10, u.getNum_of_day());
            ps.setInt(11, u.getPositionId().getId());
            ps.setString(12, u.getFullname());
            ps.setInt(13, 1);

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean Updateemploye(Employee u) {

        try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update about_employee set name=?,surname=?,phone=?,address=?,identity_fin=?,identity_seria=?,email=?,salary=?,salary_day=?,num_of_day=?,position_id=?,full_name=?,status=? where id=?");
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getIdentity_fin());
            ps.setString(6, u.getIdentity_seria());
            ps.setString(7, u.getEmail());
            ps.setDouble(8, u.getSalary());
            ps.setString(9, u.getSalary_day());
            ps.setInt(10, u.getNum_of_day());
            ps.setInt(11, u.getPositionId().getId());
            ps.setString(12, u.getFullname());
            ps.setInt(13, u.getStatus());
            ps.setInt(14, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public List<Employee> SearchByFullName(String fullName) {
        List<Employee> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";
            if (fullName != null && !fullName.trim().isEmpty()) {
//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
                Statement stm = connection().createStatement();
                stm.execute("SELECT ae.*,p.`name` AS \"position\" FROM about_employee ae\n"
                        + "LEFT JOIN position p ON p.id=ae.position_id WHERE full_name LIKE '%" + fullName + "%'");
                ResultSet rs = stm.getResultSet();
                while (rs.next()) {
                    Employee result = getEmployee(rs);
                    list.add(result);
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public Employee SearchByIdentityFin(String fin) {
        Employee emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT ae.*,p.`name` AS \"position\" FROM about_employee ae\n"
                    + "LEFT JOIN position p ON p.id=ae.position_id WHERE identity_fin LIKE '%" + fin + "%'");
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
    public Employee SearchByIdentitySeria(String seria) {
        Employee emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT ae.*,p.`name` AS \"position\" FROM about_employee ae\n"
                    + "LEFT JOIN position p ON p.id=ae.position_id WHERE identity_seria LIKE '%" + seria + "%'");
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
        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("UPDATE about_employee set `status`=0 WHERE id=" + id);
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
            stm.execute("SELECT ae.*,p.`name` AS \"position\" FROM about_employee ae\n"
                    + "LEFT JOIN position p ON p.id=ae.position_id WHERE ae.id=" + id);
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

}
