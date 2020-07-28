/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.util.Objects;

/**
 *
 * @author Virtu
 */
public class VergiEmp {
   private int id;
   private Employee empId;
   private Vergi vergiId;
   private double gv_200;
   private double ssh_200_gore;
   private double ssh_200dan_yuxari;
   private double ish_200_gore;
   private double itsh_200;
   private double gv_8000;
   private double ssh_8000in200;
   private double ssh_8000dan_qalani;
   private double ish_8000_gore;
   private double itsh_8000_gore;
   private double itsh_8000_elave;
   private double net_salary;
   private int status;

    public VergiEmp() {
    }

    public VergiEmp(int id, Employee empId, Vergi vergiId, double gv_200, double ssh_200_gore, double ssh_200dan_yuxari, double ish_200_gore, double itsh_200, double gv_8000, double ssh_8000in200, double ssh_8000dan_qalani, double ish_8000_gore, double itsh_8000_gore, double itsh_8000_elave, double net_salary, int status) {
        this.id = id;
        this.empId = empId;
        this.vergiId = vergiId;
        this.gv_200 = gv_200;
        this.ssh_200_gore = ssh_200_gore;
        this.ssh_200dan_yuxari = ssh_200dan_yuxari;
        this.ish_200_gore = ish_200_gore;
        this.itsh_200 = itsh_200;
        this.gv_8000 = gv_8000;
        this.ssh_8000in200 = ssh_8000in200;
        this.ssh_8000dan_qalani = ssh_8000dan_qalani;
        this.ish_8000_gore = ish_8000_gore;
        this.itsh_8000_gore = itsh_8000_gore;
        this.itsh_8000_elave = itsh_8000_elave;
        this.net_salary = net_salary;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmpId() {
        return empId;
    }

    public void setEmpId(Employee empId) {
        this.empId = empId;
    }

    public Vergi getVergiId() {
        return vergiId;
    }

    public void setVergiId(Vergi vergiId) {
        this.vergiId = vergiId;
    }

    public double getGv_200() {
        return gv_200;
    }

    public void setGv_200(double gv_200) {
        this.gv_200 = gv_200;
    }

    public double getSsh_200_gore() {
        return ssh_200_gore;
    }

    public void setSsh_200_gore(double ssh_200_gore) {
        this.ssh_200_gore = ssh_200_gore;
    }

    public double getSsh_200dan_yuxari() {
        return ssh_200dan_yuxari;
    }

    public void setSsh_200dan_yuxari(double ssh_200dan_yuxari) {
        this.ssh_200dan_yuxari = ssh_200dan_yuxari;
    }

    public double getIsh_200_gore() {
        return ish_200_gore;
    }

    public void setIsh_200_gore(double ish_200_gore) {
        this.ish_200_gore = ish_200_gore;
    }

    public double getItsh_200() {
        return itsh_200;
    }

    public void setItsh_200(double itsh_200) {
        this.itsh_200 = itsh_200;
    }

    public double getGv_8000() {
        return gv_8000;
    }

    public void setGv_8000(double gv_8000) {
        this.gv_8000 = gv_8000;
    }

    public double getSsh_8000in200() {
        return ssh_8000in200;
    }

    public void setSsh_8000in200(double ssh_8000in200) {
        this.ssh_8000in200 = ssh_8000in200;
    }

    public double getSsh_8000dan_qalani() {
        return ssh_8000dan_qalani;
    }

    public void setSsh_8000dan_qalani(double ssh_8000dan_qalani) {
        this.ssh_8000dan_qalani = ssh_8000dan_qalani;
    }

    public double getIsh_8000_gore() {
        return ish_8000_gore;
    }

    public void setIsh_8000_gore(double ish_8000_gore) {
        this.ish_8000_gore = ish_8000_gore;
    }

    public double getItsh_8000_gore() {
        return itsh_8000_gore;
    }

    public void setItsh_8000_gore(double itsh_8000_gore) {
        this.itsh_8000_gore = itsh_8000_gore;
    }

    public double getItsh_8000_elave() {
        return itsh_8000_elave;
    }

    public void setItsh_8000_elave(double itsh_8000_elave) {
        this.itsh_8000_elave = itsh_8000_elave;
    }

    public double getNet_salary() {
        return net_salary;
    }

    public void setNet_salary(double net_salary) {
        this.net_salary = net_salary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.empId);
        hash = 37 * hash + Objects.hashCode(this.vergiId);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.gv_200) ^ (Double.doubleToLongBits(this.gv_200) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.ssh_200_gore) ^ (Double.doubleToLongBits(this.ssh_200_gore) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.ssh_200dan_yuxari) ^ (Double.doubleToLongBits(this.ssh_200dan_yuxari) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.ish_200_gore) ^ (Double.doubleToLongBits(this.ish_200_gore) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.itsh_200) ^ (Double.doubleToLongBits(this.itsh_200) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.gv_8000) ^ (Double.doubleToLongBits(this.gv_8000) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.ssh_8000in200) ^ (Double.doubleToLongBits(this.ssh_8000in200) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.ssh_8000dan_qalani) ^ (Double.doubleToLongBits(this.ssh_8000dan_qalani) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.ish_8000_gore) ^ (Double.doubleToLongBits(this.ish_8000_gore) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.itsh_8000_gore) ^ (Double.doubleToLongBits(this.itsh_8000_gore) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.itsh_8000_elave) ^ (Double.doubleToLongBits(this.itsh_8000_elave) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.net_salary) ^ (Double.doubleToLongBits(this.net_salary) >>> 32));
        hash = 37 * hash + this.status;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VergiEmp other = (VergiEmp) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.gv_200) != Double.doubleToLongBits(other.gv_200)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ssh_200_gore) != Double.doubleToLongBits(other.ssh_200_gore)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ssh_200dan_yuxari) != Double.doubleToLongBits(other.ssh_200dan_yuxari)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ish_200_gore) != Double.doubleToLongBits(other.ish_200_gore)) {
            return false;
        }
        if (Double.doubleToLongBits(this.itsh_200) != Double.doubleToLongBits(other.itsh_200)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gv_8000) != Double.doubleToLongBits(other.gv_8000)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ssh_8000in200) != Double.doubleToLongBits(other.ssh_8000in200)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ssh_8000dan_qalani) != Double.doubleToLongBits(other.ssh_8000dan_qalani)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ish_8000_gore) != Double.doubleToLongBits(other.ish_8000_gore)) {
            return false;
        }
        if (Double.doubleToLongBits(this.itsh_8000_gore) != Double.doubleToLongBits(other.itsh_8000_gore)) {
            return false;
        }
        if (Double.doubleToLongBits(this.itsh_8000_elave) != Double.doubleToLongBits(other.itsh_8000_elave)) {
            return false;
        }
        if (Double.doubleToLongBits(this.net_salary) != Double.doubleToLongBits(other.net_salary)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.empId, other.empId)) {
            return false;
        }
        if (!Objects.equals(this.vergiId, other.vergiId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VergiEmp{" + "id=" + id + ", empId=" + empId + ", vergiId=" + vergiId + ", gv_200=" + gv_200 + ", ssh_200_gore=" + ssh_200_gore + ", ssh_200dan_yuxari=" + ssh_200dan_yuxari + ", ish_200_gore=" + ish_200_gore + ", itsh_200=" + itsh_200 + ", gv_8000=" + gv_8000 + ", ssh_8000in200=" + ssh_8000in200 + ", ssh_8000dan_qalani=" + ssh_8000dan_qalani + ", ish_8000_gore=" + ish_8000_gore + ", itsh_8000_gore=" + itsh_8000_gore + ", itsh_8000_elave=" + itsh_8000_elave + ", net_salary=" + net_salary + ", status=" + status + '}';
    }
   
   
   
   
}
