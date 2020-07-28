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
public class Vergi {
   private int id;
   private String name;
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
   private int status;
   private double salary_max;
   private double salary_min;

    public Vergi() {
    }

    public Vergi(int id, String name, double gv_200, double ssh_200_gore, double ssh_200dan_yuxari, double ish_200_gore, double itsh_200, double gv_8000, double ssh_8000in200, double ssh_8000dan_qalani, double ish_8000_gore, double itsh_8000_gore, double itsh_8000_elave, int status, double salary_max, double salary_min) {
        this.id = id;
        this.name = name;
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
        this.status = status;
        this.salary_max = salary_max;
        this.salary_min = salary_min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getSalary_max() {
        return salary_max;
    }

    public void setSalary_max(double salary_max) {
        this.salary_max = salary_max;
    }

    public double getSalary_min() {
        return salary_min;
    }

    public void setSalary_min(double salary_min) {
        this.salary_min = salary_min;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.gv_200) ^ (Double.doubleToLongBits(this.gv_200) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.ssh_200_gore) ^ (Double.doubleToLongBits(this.ssh_200_gore) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.ssh_200dan_yuxari) ^ (Double.doubleToLongBits(this.ssh_200dan_yuxari) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.ish_200_gore) ^ (Double.doubleToLongBits(this.ish_200_gore) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.itsh_200) ^ (Double.doubleToLongBits(this.itsh_200) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.gv_8000) ^ (Double.doubleToLongBits(this.gv_8000) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.ssh_8000in200) ^ (Double.doubleToLongBits(this.ssh_8000in200) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.ssh_8000dan_qalani) ^ (Double.doubleToLongBits(this.ssh_8000dan_qalani) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.ish_8000_gore) ^ (Double.doubleToLongBits(this.ish_8000_gore) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.itsh_8000_gore) ^ (Double.doubleToLongBits(this.itsh_8000_gore) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.itsh_8000_elave) ^ (Double.doubleToLongBits(this.itsh_8000_elave) >>> 32));
        hash = 59 * hash + this.status;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.salary_max) ^ (Double.doubleToLongBits(this.salary_max) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.salary_min) ^ (Double.doubleToLongBits(this.salary_min) >>> 32));
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
        final Vergi other = (Vergi) obj;
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
        if (this.status != other.status) {
            return false;
        }
        if (Double.doubleToLongBits(this.salary_max) != Double.doubleToLongBits(other.salary_max)) {
            return false;
        }
        if (Double.doubleToLongBits(this.salary_min) != Double.doubleToLongBits(other.salary_min)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vergi{" + "id=" + id + ", name=" + name + ", gv_200=" + gv_200 + ", ssh_200_gore=" + ssh_200_gore + ", ssh_200dan_yuxari=" + ssh_200dan_yuxari + ", ish_200_gore=" + ish_200_gore + ", itsh_200=" + itsh_200 + ", gv_8000=" + gv_8000 + ", ssh_8000in200=" + ssh_8000in200 + ", ssh_8000dan_qalani=" + ssh_8000dan_qalani + ", ish_8000_gore=" + ish_8000_gore + ", itsh_8000_gore=" + itsh_8000_gore + ", itsh_8000_elave=" + itsh_8000_elave + ", status=" + status + ", salary_max=" + salary_max + ", salary_min=" + salary_min + '}';
    }

   
   
}
