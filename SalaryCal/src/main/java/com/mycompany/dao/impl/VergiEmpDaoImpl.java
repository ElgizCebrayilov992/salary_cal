/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.EmployeDaoInter;
import com.mycompany.dao.inter.VergiDaoInter;
import com.mycompany.dao.inter.VergiEmpDaoInter;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Position;
import com.mycompany.entity.Vergi;
import com.mycompany.entity.VergiEmp;
import com.mycompany.main.Contex;
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
public class VergiEmpDaoImpl extends AbstractDao implements VergiEmpDaoInter {

    private VergiEmp getVergiEmp(ResultSet rs) throws Exception {

        int id = rs.getInt("id");

        int employe_id = rs.getInt("employe_id");
        String full_name = rs.getString("full_name");
        double salary = rs.getDouble("salary");
        Employee emp = new Employee();
        emp.setFullname(full_name);
        emp.setId(employe_id);
        emp.setSalary(salary);

        int vergi_id = rs.getInt("vergi_id");
        Vergi ver = new Vergi();
        ver.setId(vergi_id);

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
        double net_salary = rs.getDouble("net_salary");
        int status = rs.getInt("status");

        return new VergiEmp(id, emp, ver, gv_200, ssh_200_gore, ssh_200dan_yuxari, ish_200_gore, itsh_200, gv_8000, ssh_8000in200, ssh_8000qalani, itsh_8000_gore, itsh_8000_gore, itsh_8000_gore, net_salary, status);

    }

    @Override
    public List<VergiEmp> allList() {
        List<VergiEmp> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "	ve.*,\n"
                + "	ae.full_name,\n"
                + "	ae.salary\n"
                + "FROM\n"
                + "	vergi_emp ve \n"
                + "	LEFT JOIN about_employee ae ON ae.id = ve.employe_id \n"
                + "	LEFT JOIN vergi v ON v.id = ve.id";

        try (Connection con = connection()) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                VergiEmp u = getVergiEmp(rs);
                list.add(u);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    @Override
    public boolean AddVergiEmp(VergiEmp ver) {
        VergiEmp ve = vergiNet(ver);
        System.out.println("BURDA: " + ve.getIsh_200_gore());

        VergiDaoInter vdi = Contex.instanceVergiDao();

        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO vergi_emp (employe_id,vergi_id,gv_200,"
                    + "ssh_200_gore,ssh_200dan_yuxari,ish_200_gore,itsh_200,gv_8000,"
                    + "ssh_8000in200,ssh_8000qalani,ish_8000,itsh_8000_gore,itsh_8000_elave,net_salary,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, ve.getEmpId().getId());
            ps.setInt(2, ve.getVergiId().getId());
            ps.setDouble(3, ve.getGv_200());
            ps.setDouble(4, ve.getSsh_200_gore());
            ps.setDouble(5, ve.getSsh_200dan_yuxari());
            ps.setDouble(6, ve.getIsh_200_gore());
            ps.setDouble(7, ve.getItsh_200());
            ps.setDouble(8, ve.getGv_8000());
            ps.setDouble(9, ve.getSsh_8000in200());
            ps.setDouble(10, ve.getSsh_8000dan_qalani());
            ps.setDouble(11, ve.getIsh_8000_gore());
            ps.setDouble(12, ve.getItsh_8000_gore());
            ps.setDouble(13, ve.getItsh_8000_elave());
            ps.setDouble(14, ve.getNet_salary());
            ps.setInt(15, ve.getStatus());

            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean UpdateVergiEmp(VergiEmp ve) {
        try (Connection c = connection()) {

            PreparedStatement ps = c.prepareStatement("update vergi_emp set "
                    + "employe_id=?,"
                    + "vergi_id=?,"
                    + "gv_200=?,"
                    + "ssh_200_gore=?,"
                    + "ssh_200dan_yuxari=?,"
                    + "ish_200_gore=?,"
                    + "itsh_200=?,"
                    + "gv_8000=?,"
                    + "ssh_8000in200=?,"
                    + "ssh_8000qalani"
                    + "ish_8000=?,"
                    + "itsh_8000_gore=?,"
                    + "itsh_8000_elave=?,"
                    + "net_salary=?,"
                    + "status=?  "
                    + "where id=?");
            ps.setInt(1, ve.getEmpId().getId());
            ps.setInt(2, ve.getVergiId().getId());
            ps.setDouble(3, ve.getGv_200());
            ps.setDouble(4, ve.getSsh_200_gore());
            ps.setDouble(5, ve.getSsh_200dan_yuxari());
            ps.setDouble(6, ve.getIsh_200_gore());
            ps.setDouble(7, ve.getItsh_200());
            ps.setDouble(8, ve.getGv_8000());
            ps.setDouble(9, ve.getSsh_8000in200());
            ps.setDouble(10, ve.getSsh_8000dan_qalani());
            ps.setDouble(11, ve.getIsh_8000_gore());
            ps.setDouble(12, ve.getItsh_8000_gore());
            ps.setDouble(13, ve.getItsh_8000_elave());
            ps.setDouble(14, ve.getNet_salary());
            ps.setInt(15, ve.getStatus());
            ps.setInt(16, ve.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean RemoveVergiEmp(int id) {

        try (Connection c = connection()) {
            Statement stm = c.createStatement();
            stm.execute("UPDATE vergi_emp set `status`=0 WHERE id=" + id);
            ResultSet rs = stm.getResultSet();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    private VergiEmp vergiNet(VergiEmp ver) {

        EmployeDaoInter edi = Contex.instanceEmployeeDao();
        Employee emp = edi.SearchById(ver.getEmpId().getId());
        System.out.println("BURda 2: " + emp);

        VergiDaoInter vgi = Contex.instanceVergiDao();
        Vergi v = vgi.SearchById(ver.getVergiId().getId());
        System.out.println("BURda 3: " + v);

        VergiEmp ve = new VergiEmp();
        ve.setEmpId(emp);
        ve.setVergiId(v);
        ve.setStatus(1);

        double salary = emp.getSalary();
        double max = v.getSalary_max();
        double minSalary = v.getSalary_min();
        if (salary < max) {

            double gv = 0;
            ve.setGv_200(0);

            double min = (v.getSalary_min() * v.getSsh_200_gore()) / 100;
            ve.setSsh_200_gore(min);
            System.out.println("BURDA MIN: " + min);

            double other = ((emp.getSalary() - v.getSalary_min()) * v.getSsh_200dan_yuxari()) / 100;
            ve.setSsh_200dan_yuxari(other);
            //System.out.println(other);
            double ssh = min + other;

            double ish = (emp.getSalary() * v.getIsh_200_gore()) / 100;
            ve.setIsh_200_gore(ish);

            double itsh = (emp.getSalary() * v.getItsh_200()) / 100;
            ve.setItsh_200(itsh);

            ve.setGv_8000(0);
            ve.setSsh_8000in200(0);
            ve.setSsh_8000dan_qalani(0);
            ve.setIsh_8000_gore(0);
            ve.setItsh_8000_gore(0);
            ve.setItsh_8000_elave(0);

            double net_Salary = emp.getSalary() - (gv + min + other + ish + itsh);
            ve.setNet_salary(net_Salary);

        }
        if (salary > max) {

            ve.setGv_200(0);
            ve.setSsh_200_gore(0);
            ve.setSsh_200dan_yuxari(0);
            ve.setIsh_200_gore(0);
            ve.setItsh_200(0);

            double gv = ((emp.getSalary() - v.getSalary_max()) * v.getGv_8000()) / 100;
            ve.setGv_8000(gv);

            double ssh200 = (v.getSalary_min() * v.getSsh_8000in200()) / 100;
            ve.setSsh_8000in200(ssh200);

            double sshQalani = ((emp.getSalary() - v.getSalary_min()) * v.getSsh_8000dan_qalani()) / 100;
            ve.setSsh_8000dan_qalani(sshQalani);

            double ish = (emp.getSalary() * v.getIsh_8000_gore()) / 100;
            ve.setIsh_8000_gore(ish);

            double itsh8000gore = (v.getSalary_max() * v.getItsh_8000_gore()) / 100;
            ve.setItsh_8000_gore(itsh8000gore);

            double itsh_8000_elave = ((emp.getSalary() - v.getSalary_max()) * v.getItsh_8000_elave()) / 100;
            ve.setItsh_8000_elave(itsh_8000_elave);

            double net_Salary = emp.getSalary() - (gv + ssh200 + sshQalani + ish + itsh8000gore + itsh_8000_elave);
            ve.setNet_salary(net_Salary);
        }

        return ve;
    }

    @Override
    public List<VergiEmp> SearchByFullName(String fullName) {

        List<VergiEmp> list = new ArrayList<>();

        try (Connection con = connection()) {
            //String sql="";
            if (fullName != null && !fullName.trim().isEmpty()) {
//                sql+="'%fullName=?"+"%'";
//                //System.out.println(sql+" and fullName="+fullName);
                Statement stm = connection().createStatement();
                stm.execute("SELECT\n"
                        + "	ve.*,\n"
                        + "	ae.full_name,\n"
                        + "	ae.salary \n"
                        + "FROM\n"
                        + "	vergi_emp ve\n"
                        + "	LEFT JOIN about_employee ae ON ae.id = ve.employe_id\n"
                        + "	LEFT JOIN vergi v ON v.id = ve.id WHERE ae.full_name LIKE '%" + fullName + "%'");
                ResultSet rs = stm.getResultSet();
                while (rs.next()) {
                    VergiEmp result = getVergiEmp(rs);
                    list.add(result);
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }
}
