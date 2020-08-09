/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.Vergi;
import java.util.List;

/**
 *
 * @author Virtu
 */
public interface VergiDaoInter {

    public List<Vergi> allList();

    public boolean AddVergi(Vergi ver);

    public boolean UpdateVergi(Vergi ver);

    public Vergi SearchById(int id);

    public boolean RemoveVergi(int id);

}
