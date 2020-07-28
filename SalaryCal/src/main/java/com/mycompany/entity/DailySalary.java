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
public class DailySalary {
    private int id;
    private Employee empId;
    private double bonus;
    private double advance;
    private double penalty;
    private double taken_daily_salary;
    private double daily_salary;
    private Date about_date;

    public DailySalary(int id, Employee empId, double bonus, double advance, double penalty, double taken_daily_salary, double daily_salary, Date about_date) {
        this.id = id;
        this.empId = empId;
        this.bonus = bonus;
        this.advance = advance;
        this.penalty = penalty;
        this.taken_daily_salary = taken_daily_salary;
        this.daily_salary = daily_salary;
        this.about_date = about_date;
    }

    public DailySalary() {
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

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public double getTaken_daily_salary() {
        return taken_daily_salary;
    }

    public void setTaken_daily_salary(double taken_daily_salary) {
        this.taken_daily_salary = taken_daily_salary;
    }

    public double getDaily_salary() {
        return daily_salary;
    }

    public void setDaily_salary(double daily_salary) {
        this.daily_salary = daily_salary;
    }

    public Date getAbout_date() {
        return about_date;
    }

    public void setAbout_date(Date about_date) {
        this.about_date = about_date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.empId);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.bonus) ^ (Double.doubleToLongBits(this.bonus) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.advance) ^ (Double.doubleToLongBits(this.advance) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.penalty) ^ (Double.doubleToLongBits(this.penalty) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.taken_daily_salary) ^ (Double.doubleToLongBits(this.taken_daily_salary) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.daily_salary) ^ (Double.doubleToLongBits(this.daily_salary) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.about_date);
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
        final DailySalary other = (DailySalary) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.bonus) != Double.doubleToLongBits(other.bonus)) {
            return false;
        }
        if (Double.doubleToLongBits(this.advance) != Double.doubleToLongBits(other.advance)) {
            return false;
        }
        if (Double.doubleToLongBits(this.penalty) != Double.doubleToLongBits(other.penalty)) {
            return false;
        }
        if (Double.doubleToLongBits(this.taken_daily_salary) != Double.doubleToLongBits(other.taken_daily_salary)) {
            return false;
        }
        if (Double.doubleToLongBits(this.daily_salary) != Double.doubleToLongBits(other.daily_salary)) {
            return false;
        }
        if (!Objects.equals(this.empId, other.empId)) {
            return false;
        }
        if (!Objects.equals(this.about_date, other.about_date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DailySalary{" + "id=" + id + ", empId=" + empId + ", bonus=" + bonus + ", advance=" + advance + ", penalty=" + penalty + ", taken_daily_salary=" + taken_daily_salary + ", daily_salary=" + daily_salary + ", about_date=" + about_date + '}';
    }
    
    
}
