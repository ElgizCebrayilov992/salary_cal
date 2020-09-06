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

    public List<Employee> allListStatus();

    public boolean AddEmploye(Employee emp);

    public boolean Updateemploye(Employee emp);

    public Employee SearchByIdentityFinAndSeria(String fin, String seria);

    public Employee SearchById(int id);

    public Employee SearchByIdentitySeria(String seria);

    public boolean RemoveEmployer(int id);

    public List<Employee> searchFrontEnd(String fullname,String phone,String address,String identity_fin,
            String identity_seria,String email,String salary,String job_start,String position);
}
