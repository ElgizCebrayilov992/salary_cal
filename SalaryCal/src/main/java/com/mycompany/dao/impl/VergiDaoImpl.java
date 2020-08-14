/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.entity.Employee;
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
public class VergiDaoImpl extends AbstractDao implements VergiDaoInter {

    private Vergi getVergi(ResultSet rs) throws Exception {

        int id = rs.getInt("id");
        String name = rs.getString("name");
        double gv_200 = rs.getDouble("gv_200");
        double ssh_200_gore = rs.getDouble("ssh_200_gore");
        double ssh_200dan_yuxari = rs.getDouble("ssh_200dan_yuxari");
        double ish_200_gore = rs.getDouble("ish_200_gore");
        double itsh_200 = rs.getDouble("itsh_200");
        double gv_8000 = rs.getDouble("gv_8000");
        double ssh_8000in200 = rs.getDouble("ssh_8000in200");
        double ssh_8000qalani = rs.getDouble("ssh_8000qalani");
        double ish_8000 = rs.getDouble("ish_8000");
        double itsh_8000_gore = rs.getDouble("itsh_8000_gore");
        int status = rs.getInt("status");
        double salary_max = rs.getDouble("salary_max");
        double salary_min = rs.getDouble("salary_min");
        double gelmediyi_is_gunun_cermesi = rs.getDouble("gelmediyi_is_gunun_cermesi");

        return new Vergi(id, name, gv_200, ssh_200_gore, ssh_200dan_yuxari, ish_200_gore, itsh_200, gv_8000,
                ssh_8000in200, ssh_8000qalani, itsh_8000_gore, itsh_8000_gore, itsh_8000_gore,status,salary_max,salary_min,gelmediyi_is_gunun_cermesi);

    }

    @Override
    public List<Vergi> allList() {
        List<Vergi> list = new ArrayList<>();

        String sql = "SELECT * FROM vergi";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                Vergi u = getVergi(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public boolean AddVergi(Vergi u) {
       try(Connection c=connection()) {
            PreparedStatement ps=c.prepareStatement("INSERT INTO vergi (`name`,gv_200,ssh_200_gore,"
                    + "ssh_200dan_yuxari,ish_200_gore,itsh_200,gv_8000,ssh_8000in200,"
                    + "ssh_8000qalani,ish_8000,itsh_8000_gore,itsh_8000_elave,status,salary_max,salary_min,gelmediyi_is_gunun_cermesi) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getName());         
            ps.setDouble(2, u.getGv_200());
            ps.setDouble(3, u.getSsh_200_gore());
            ps.setDouble(4, u.getSsh_200dan_yuxari());
            ps.setDouble(5, u.getIsh_200_gore());
            ps.setDouble(6, u.getItsh_200());
            ps.setDouble(7, u.getGv_8000());
            ps.setDouble(8, u.getSsh_8000in200());
            ps.setDouble(9, u.getSsh_8000dan_qalani());
            ps.setDouble(10, u.getIsh_8000_gore());
            ps.setDouble(11, u.getItsh_8000_elave());
            ps.setDouble(12, u.getItsh_8000_elave());
            ps.setInt(13, u.getStatus());         
            ps.setDouble(14, u.getSalary_max());
            ps.setDouble(15, u.getSalary_min());
            ps.setDouble(16, u.getGelmediyi_is_gunun_cermesi());
 
            
             ps.execute();
        } catch (Exception e) {
            System.out.println( e.getMessage());
            return false;
        }
        return true;
    
    
    }

    @Override
    public boolean UpdateVergi(Vergi u) {
        try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update vergi set "
                    + "`name`=?,gv_200=?,ssh_200_gore=?,"
                    + "ssh_200dan_yuxari=?,ish_200_gore=?,itsh_200=?,gv_8000=?,ssh_8000in200=?,"
                    + "ssh_8000qalani=?,ish_8000=?,itsh_8000_gore=?,itsh_8000_elave=?,status=?,salary_max=?,salary_min=?,gelmediyi_is_gunun_cermesi=? where id=?");
            ps.setString(1, u.getName());
            ps.setDouble(2, u.getGv_200());
            ps.setDouble(3, u.getSsh_200_gore());
            ps.setDouble(4, u.getSsh_200dan_yuxari());
            ps.setDouble(5, u.getIsh_200_gore());
            ps.setDouble(6, u.getItsh_200());
            ps.setDouble(7, u.getGv_8000());
            ps.setDouble(8, u.getSsh_8000in200());
            ps.setDouble(9, u.getSsh_8000dan_qalani());
            ps.setDouble(10, u.getIsh_8000_gore());
            ps.setDouble(11, u.getItsh_8000_elave());
            ps.setDouble(12, u.getItsh_8000_elave());
            ps.setInt(13, u.getStatus());
            ps.setDouble(14, u.getSalary_max());
            ps.setDouble(15, u.getSalary_min());
            ps.setDouble(16, u.getGelmediyi_is_gunun_cermesi());
            ps.setInt(17, u.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean RemoveVergi(int id) {
        try(Connection c=connection()) {
             Statement stm = c.createStatement();
             stm.execute("UPDATE vergi set `status`=0 WHERE id="+id);
            ResultSet rs = stm.getResultSet();
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    
    
   }

    @Override
    public Vergi SearchById(int id) {
        Vergi emp = null;

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("SELECT * FROM vergi WHERE id="+id);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                emp = getVergi(rs);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return emp;
    
    
    }

}
