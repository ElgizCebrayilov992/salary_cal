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
    private Double total_bonus;
    private Double total_advance;
    private Double total_penalty;
    private Double total_taken_daily_salary;
    private Double employee_debit;
    private Double company_debit;
    private Date about_date;
    private Double net_salary;
    private int status;
    private Double give_salary;
    private Double send_salary;
    private Date send_date;

    public MonthlySalary() {
    }

    public MonthlySalary(int id, Employee employe_id, Double total_bonus, Double total_advance, Double total_penalty, Double total_taken_daily_salary, Double employee_debit, Double company_debit, Date about_date, Double net_salary, int status, Double give_salary, Double send_salary, Date send_date) {
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
        this.send_salary = send_salary;
        this.send_date = send_date;
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

    public Double getTotal_bonus() {
        return total_bonus;
    }

    public void setTotal_bonus(Double total_bonus) {
        this.total_bonus = total_bonus;
    }

    public Double getTotal_advance() {
        return total_advance;
    }

    public void setTotal_advance(Double total_advance) {
        this.total_advance = total_advance;
    }

    public Double getTotal_penalty() {
        return total_penalty;
    }

    public void setTotal_penalty(Double total_penalty) {
        this.total_penalty = total_penalty;
    }

    public Double getTotal_taken_daily_salary() {
        return total_taken_daily_salary;
    }

    public void setTotal_taken_daily_salary(Double total_taken_daily_salary) {
        this.total_taken_daily_salary = total_taken_daily_salary;
    }

    public Double getEmployee_debit() {
        return employee_debit;
    }

    public void setEmployee_debit(Double employee_debit) {
        this.employee_debit = employee_debit;
    }

    public Double getCompany_debit() {
        return company_debit;
    }

    public void setCompany_debit(Double company_debit) {
        this.company_debit = company_debit;
    }

    public Date getAbout_date() {
        return about_date;
    }

    public void setAbout_date(Date about_date) {
        this.about_date = about_date;
    }

    public Double getNet_salary() {
        return net_salary;
    }

    public void setNet_salary(Double net_salary) {
        this.net_salary = net_salary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getGive_salary() {
        return give_salary;
    }

    public void setGive_salary(Double give_salary) {
        this.give_salary = give_salary;
    }

    public Double getSend_salary() {
        return send_salary;
    }

    public void setSend_salary(Double send_salary) {
        this.send_salary = send_salary;
    }

    public Date getSend_date() {
        return send_date;
    }

    public void setSend_date(Date send_date) {
        this.send_date = send_date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.employe_id);
        hash = 97 * hash + Objects.hashCode(this.total_bonus);
        hash = 97 * hash + Objects.hashCode(this.total_advance);
        hash = 97 * hash + Objects.hashCode(this.total_penalty);
        hash = 97 * hash + Objects.hashCode(this.total_taken_daily_salary);
        hash = 97 * hash + Objects.hashCode(this.employee_debit);
        hash = 97 * hash + Objects.hashCode(this.company_debit);
        hash = 97 * hash + Objects.hashCode(this.about_date);
        hash = 97 * hash + Objects.hashCode(this.net_salary);
        hash = 97 * hash + this.status;
        hash = 97 * hash + Objects.hashCode(this.give_salary);
        hash = 97 * hash + Objects.hashCode(this.send_salary);
        hash = 97 * hash + Objects.hashCode(this.send_date);
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
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.employe_id, other.employe_id)) {
            return false;
        }
        if (!Objects.equals(this.total_bonus, other.total_bonus)) {
            return false;
        }
        if (!Objects.equals(this.total_advance, other.total_advance)) {
            return false;
        }
        if (!Objects.equals(this.total_penalty, other.total_penalty)) {
            return false;
        }
        if (!Objects.equals(this.total_taken_daily_salary, other.total_taken_daily_salary)) {
            return false;
        }
        if (!Objects.equals(this.employee_debit, other.employee_debit)) {
            return false;
        }
        if (!Objects.equals(this.company_debit, other.company_debit)) {
            return false;
        }
        if (!Objects.equals(this.about_date, other.about_date)) {
            return false;
        }
        if (!Objects.equals(this.net_salary, other.net_salary)) {
            return false;
        }
        if (!Objects.equals(this.give_salary, other.give_salary)) {
            return false;
        }
        if (!Objects.equals(this.send_salary, other.send_salary)) {
            return false;
        }
        if (!Objects.equals(this.send_date, other.send_date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MonthlySalary{" + "id=" + id + ", employe_id=" + employe_id + ", total_bonus=" + total_bonus + ", total_advance=" + total_advance + ", total_penalty=" + total_penalty + ", total_taken_daily_salary=" + total_taken_daily_salary + ", employee_debit=" + employee_debit + ", company_debit=" + company_debit + ", about_date=" + about_date + ", net_salary=" + net_salary + ", status=" + status + ", give_salary=" + give_salary + ", send_salary=" + send_salary + ", send_date=" + send_date + '}';
    }
    
    

  
  
  
    
    
}
