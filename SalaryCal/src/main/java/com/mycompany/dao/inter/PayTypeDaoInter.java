/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.PayType;
import java.util.List;

/**
 *
 * @author Virtu
 */
public interface PayTypeDaoInter {

    public List<PayType> allList();

    public boolean AddPayType(PayType ver);

    public boolean UpdatePayType(PayType ver);

    public PayType SearchById(int id);

    public boolean RemovePayType(int id);

}
