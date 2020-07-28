/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.PositionDaoInter;
import com.mycompany.entity.Position;
import com.mycompany.entity.Vergi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Virtu
 */
public class PositionDaoImpl extends AbstractDao implements PositionDaoInter {

    private Position getPosition(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String name = rs.getString("name");
        String status = rs.getString("status");

        return new Position(id, name,status);

    }

    @Override
    public List<Position> allList() {
        List<Position> list = new ArrayList<>();

        String sql = "SELECT * FROM position";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Position u = getPosition(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public boolean AddPosition(Position u) {

        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO position (`name`,status) VALUES (?,?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getStatus());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean UpdatePosition(Position u) {
      try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update position set `name`=?,status=? where id=?");
            ps.setString(1, u.getName());           
            ps.setString(2, u.getStatus());           
            ps.setInt(3, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true; 
    
    }

    @Override
    public boolean RemovePosition(int id) {
         try(Connection c=connection()) {
             Statement stm = c.createStatement();
             stm.execute("UPDATE position set `status`=0 WHERE id="+id);
            ResultSet rs = stm.getResultSet();
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    
    
    }

}
