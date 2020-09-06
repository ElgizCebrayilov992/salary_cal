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
    private Employee Emp;
    private Double bonus;
    private Double advance;
    private Double penalty;
    private Double taken_daily_salary;
    private Double daily_salary;
    private Date about_date;
    private int status;

    public DailySalary() {
    }

    public DailySalary(int id, Employee Emp, Double bonus, Double advance, Double penalty, Double taken_daily_salary, Double daily_salary, Date about_date, int status) {
        this.id = id;
        this.Emp = Emp;
        this.bonus = bonus;
        this.advance = advance;
        this.penalty = penalty;
        this.taken_daily_salary = taken_daily_salary;
        this.daily_salary = daily_salary;
        this.about_date = about_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmp() {
        return Emp;
    }

    public void setEmp(Employee Emp) {
        this.Emp = Emp;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
        this.advance = advance;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    public Double getTaken_daily_salary() {
        return taken_daily_salary;
    }

    public void setTaken_daily_salary(Double taken_daily_salary) {
        this.taken_daily_salary = taken_daily_salary;
    }

    public Double getDaily_salary() {
        return daily_salary;
    }

    public void setDaily_salary(Double daily_salary) {
        this.daily_salary = daily_salary;
    }

    public Date getAbout_date() {
        return about_date;
    }

    public void setAbout_date(Date about_date) {
        this.about_date = about_date;
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
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.Emp);
        hash = 71 * hash + Objects.hashCode(this.bonus);
        hash = 71 * hash + Objects.hashCode(this.advance);
        hash = 71 * hash + Objects.hashCode(this.penalty);
        hash = 71 * hash + Objects.hashCode(this.taken_daily_salary);
        hash = 71 * hash + Objects.hashCode(this.daily_salary);
        hash = 71 * hash + Objects.hashCode(this.about_date);
        hash = 71 * hash + this.status;
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
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.Emp, other.Emp)) {
            return false;
        }
        if (!Objects.equals(this.bonus, other.bonus)) {
            return false;
        }
        if (!Objects.equals(this.advance, other.advance)) {
            return false;
        }
        if (!Objects.equals(this.penalty, other.penalty)) {
            return false;
        }
        if (!Objects.equals(this.taken_daily_salary, other.taken_daily_salary)) {
            return false;
        }
        if (!Objects.equals(this.daily_salary, other.daily_salary)) {
            return false;
        }
        if (!Objects.equals(this.about_date, other.about_date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DailySalary{" + "id=" + id + ", Emp=" + Emp + ", bonus=" + bonus + ", advance=" + advance + ", penalty=" + penalty + ", taken_daily_salary=" + taken_daily_salary + ", daily_salary=" + daily_salary + ", about_date=" + about_date + ", status=" + status + '}';
    }

  
    
}