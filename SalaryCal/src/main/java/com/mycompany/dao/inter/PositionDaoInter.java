/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.Position;
import java.util.List;

/**
 *
 * @author Virtu
 */
public interface PositionDaoInter {
    public List<Position> allList();
    
    public boolean AddPosition(Position ver);
    
    public boolean UpdatePosition(Position ver);
          
    public boolean  RemovePosition(int id);
}
