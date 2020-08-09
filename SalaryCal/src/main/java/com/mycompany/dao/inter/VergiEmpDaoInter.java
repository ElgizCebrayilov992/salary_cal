/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.Employee;
import com.mycompany.entity.Vergi;
import com.mycompany.entity.VergiEmp;
import java.util.List;

/**
 *
 * @author Virtu
 */
public interface VergiEmpDaoInter {

    public List<VergiEmp> allList();

    public boolean AddVergiEmp(VergiEmp ver);

    public boolean UpdateVergiEmp(VergiEmp ver);

    public boolean RemoveVergiEmp(int id);
    
    public VergiEmp SearchById(int id);
    
    public VergiEmp SearchEmployeById(int id);

    public List<VergiEmp> SearchByFullName(String fullName);

}
