/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Virtu
 */
public class MonthlySalary {
    private int id;
    private Employee employe_id;
    private double total_bonus;
    private double total_advance;
    private double total_penalty;
    private double total_taken_daily_salary;
    private double employee_debit;
    private double company_debit;
    private Date about_date;
    private double net_salary;
    private int status;
    private double give_salary;

    public MonthlySalary() {
    }

    public MonthlySalary(int id, Employee employe_id, double total_bonus, double total_advance, double total_penalty, double total_taken_daily_salary, double employee_debit, double company_debit, Date about_date, double net_salary, int status, double give_salary) {
        this.id = id;
        this.employe_id = employe_id;
        this.total_bonus = total_bonus;
        this.total_advance = total_advance;
        this.total_penalty = total_penalty;
        this.total_taken_daily_salary = total_taken_daily_salary;
        this.employee_debit = employee_debit;
        this.company_debit = company_debit;
        this.about_date = about_date;
        this.net_salary = net_salary;
        this.status = status;
        this.give_salary = give_salary;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmploye_id() {
        return employe_id;
    }

    public void setEmploye_id(Employee employe_id) {
        this.employe_id = employe_id;
    }

    public double getTotal_bonus() {
        return total_bonus;
    }

    public void setTotal_bonus(double total_bonus) {
        this.total_bonus = total_bonus;
    }

    public double getTotal_advance() {
        return total_advance;
    }

    public void setTotal_advance(double total_advance) {
        this.total_advance = total_advance;
    }

    public double getTotal_penalty() {
        return total_penalty;
    }

    public void setTotal_penalty(double total_penalty) {
        this.total_penalty = total_penalty;
    }

    public double getTotal_taken_daily_salary() {
        return total_taken_daily_salary;
    }

    public void setTotal_taken_daily_salary(double total_taken_daily_salary) {
        this.total_taken_daily_salary = total_taken_daily_salary;
    }

    public double getEmployee_debit() {
        return employee_debit;
    }

    public void setEmployee_debit(double employee_debit) {
        this.employee_debit = employee_debit;
    }

    public double getCompany_debit() {
        return company_debit;
    }

    public void setCompany_debit(double company_debit) {
        this.company_debit = company_debit;
    }

    public Date getAbout_date() {
        return about_date;
    }

    public void setAbout_date(Date about_date) {
        this.about_date = about_date;
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

    public double getGive_salary() {
        return give_salary;
    }

    public void setGive_salary(double give_salary) {
        this.give_salary = give_salary;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.employe_id);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.total_bonus) ^ (Double.doubleToLongBits(this.total_bonus) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.total_advance) ^ (Double.doubleToLongBits(this.total_advance) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.total_penalty) ^ (Double.doubleToLongBits(this.total_penalty) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.total_taken_daily_salary) ^ (Double.doubleToLongBits(this.total_taken_daily_salary) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.employee_debit) ^ (Double.doubleToLongBits(this.employee_debit) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.company_debit) ^ (Double.doubleToLongBits(this.company_debit) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.about_date);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.net_salary) ^ (Double.doubleToLongBits(this.net_salary) >>> 32));
        hash = 97 * hash + this.status;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.give_salary) ^ (Double.doubleToLongBits(this.give_salary) >>> 32));
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
        final MonthlySalary other = (MonthlySalary) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.total_bonus) != Double.doubleToLongBits(other.total_bonus)) {
            return false;
        }
        if (Double.doubleToLongBits(this.total_advance) != Double.doubleToLongBits(other.total_advance)) {
            return false;
        }
        if (Double.doubleToLongBits(this.total_penalty) != Double.doubleToLongBits(other.total_penalty)) {
            return false;
        }
        if (Double.doubleToLongBits(this.total_taken_daily_salary) != Double.doubleToLongBits(other.total_taken_daily_salary)) {
            return false;
        }
        if (Double.doubleToLongBits(this.employee_debit) != Double.doubleToLongBits(other.employee_debit)) {
            return false;
        }
        if (Double.doubleToLongBits(this.company_debit) != Double.doubleToLongBits(other.company_debit)) {
            return false;
        }
        if (Double.doubleToLongBits(this.net_salary) != Double.doubleToLongBits(other.net_salary)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (Double.doubleToLongBits(this.give_salary) != Double.doubleToLongBits(other.give_salary)) {
            return false;
        }
        if (!Objects.equals(this.employe_id, other.employe_id)) {
            return false;
        }
        if (!Objects.equals(this.about_date, other.about_date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MonthlySalary{" + "id=" + id + ", employe_id=" + employe_id + ", total_bonus=" + total_bonus + ", total_advance=" + total_advance + ", total_penalty=" + total_penalty + ", total_taken_daily_salary=" + total_taken_daily_salary + ", employee_debit=" + employee_debit + ", company_debit=" + company_debit + ", about_date=" + about_date + ", net_salary=" + net_salary + ", status=" + status + ", give_salary=" + give_salary + '}';
    }


    
    
}
