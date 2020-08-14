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
public class Employee {

    private int id;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String identity_fin;
    private String identity_seria;
    private String email;
    private double salary;
    private Date job_start;
    private int num_of_day;
    private Position positionId;
    private String fullname;
    private int status;
    private PayType payType;
    private Date job_end;
    private Date send_salary_day;

    public Employee() {
    }

    public Employee(int id, String name, String surname, String phone, String address, String identity_fin, String identity_seria, String email, double salary, Date job_start, int num_of_day, Position positionId, String fullname, int status, PayType payType, Date job_end, Date send_salary_day) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.identity_fin = identity_fin;
        this.identity_seria = identity_seria;
        this.email = email;
        this.salary = salary;
        this.job_start = job_start;
        this.num_of_day = num_of_day;
        this.positionId = positionId;
        this.fullname = fullname;
        this.status = status;
       
        this.payType = payType;
        this.job_end = job_end;
        this.send_salary_day = send_salary_day;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentity_fin() {
        return identity_fin;
    }

    public void setIdentity_fin(String identity_fin) {
        this.identity_fin = identity_fin;
    }

    public String getIdentity_seria() {
        return identity_seria;
    }

    public void setIdentity_seria(String identity_seria) {
        this.identity_seria = identity_seria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getJob_start() {
        return job_start;
    }

    public void setJob_start(Date job_start) {
        this.job_start = job_start;
    }

    public int getNum_of_day() {
        return num_of_day;
    }

    public void setNum_of_day(int num_of_day) {
        this.num_of_day = num_of_day;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public Date getJob_end() {
        return job_end;
    }

    public void setJob_end(Date job_end) {
        this.job_end = job_end;
    }

    public Date getSend_salary_day() {
        return send_salary_day;
    }

    public void setSend_salary_day(Date send_salary_day) {
        this.send_salary_day = send_salary_day;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.id;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.surname);
        hash = 43 * hash + Objects.hashCode(this.phone);
        hash = 43 * hash + Objects.hashCode(this.address);
        hash = 43 * hash + Objects.hashCode(this.identity_fin);
        hash = 43 * hash + Objects.hashCode(this.identity_seria);
        hash = 43 * hash + Objects.hashCode(this.email);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.salary) ^ (Double.doubleToLongBits(this.salary) >>> 32));
        hash = 43 * hash + Objects.hashCode(this.job_start);
        hash = 43 * hash + this.num_of_day;
        hash = 43 * hash + Objects.hashCode(this.positionId);
        hash = 43 * hash + Objects.hashCode(this.fullname);
        hash = 43 * hash + this.status;
       
        hash = 43 * hash + Objects.hashCode(this.payType);
        hash = 43 * hash + Objects.hashCode(this.job_end);
        hash = 43 * hash + Objects.hashCode(this.send_salary_day);
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
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.salary)) {
            return false;
        }
        if (this.num_of_day != other.num_of_day) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.identity_fin, other.identity_fin)) {
            return false;
        }
        if (!Objects.equals(this.identity_seria, other.identity_seria)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.fullname, other.fullname)) {
            return false;
        }
        if (!Objects.equals(this.job_start, other.job_start)) {
            return false;
        }
        if (!Objects.equals(this.positionId, other.positionId)) {
            return false;
        }
        if (!Objects.equals(this.payType, other.payType)) {
            return false;
        }
        if (!Objects.equals(this.job_end, other.job_end)) {
            return false;
        }
        if (!Objects.equals(this.send_salary_day, other.send_salary_day)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", address=" + address + ", identity_fin=" + identity_fin + ", identity_seria=" + identity_seria + ", email=" + email + ", salary=" + salary + ", job_start=" + job_start + ", num_of_day=" + num_of_day + ", positionId=" + positionId + ", fullname=" + fullname + ", status=" + status  + ", payType=" + payType + ", job_end=" + job_end + ", send_salary_day=" + send_salary_day + '}';
    }

}
