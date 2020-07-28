/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.Employee;
import java.util.List;

/**
 *
 * @author Virtu
 */
public interface EmployeDaoInter {

    public List<Employee> allList();

    public boolean AddEmploye(Employee emp);

    public boolean Updateemploye(Employee emp);

    public List<Employee> SearchByFullName(String fullName);

    public Employee SearchByIdentityFin(String fin);

    public Employee SearchById(int id);

    public Employee SearchByIdentitySeria(String seria);

    public boolean RemoveEmployer(int id);

}
