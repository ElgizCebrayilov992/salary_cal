/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.PayTypeDaoInter;
import com.mycompany.entity.DailySalary;
import com.mycompany.entity.Employee;
import com.mycompany.entity.PayType;
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
public class PayTypeDaoImp extends AbstractDao implements PayTypeDaoInter {

    private PayType getPayType(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String type = rs.getString("type");
        String value = rs.getString("value  ");
        int view = rs.getInt("view");
        int status = rs.getInt("status");

        return new PayType(id, type, value, view, status);
    }

    @Override
    public List<PayType> allList() {
        List<PayType> list = new ArrayList<>();

        String sql = "SELECT * FROM pay_type";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                PayType u = getPayType(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public boolean AddPayType(PayType pt) {

        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO pay_type "
                    + "(type,value,view,status`) "
                    + "VALUES (?,?,?,?)");
            ps.setString(1, pt.getType());
            ps.setString(2, pt.getValue());
            ps.setInt(3, pt.getView());
            ps.setInt(4, pt.getStatus());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean UpdatePayType(PayType pt) {
        try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update pay_type set type=?,"
                    + "value=?,"
                    + "view=?,`status`=?"
                    + " where id=?");
            ps.setString(1, pt.getType());
            ps.setString(2, pt.getValue());
            ps.setInt(3, pt.getView());
            ps.setInt(4, pt.getStatus());
            ps.setInt(5, pt.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public PayType SearchById(int id) {
        PayType emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT * FROM pay_type WHERE id=" + id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                emp = getPayType(rs);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return emp;
    
    }

    @Override
    public boolean RemovePayType(int id) {
        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("UPDATE pay_type set `status`=0 WHERE id=" + id);
            ResultSet rs = stm.getResultSet();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    
    }

}
