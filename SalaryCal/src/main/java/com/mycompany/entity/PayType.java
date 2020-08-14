/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.util.Objects;

/**
 *
 * @author Virtu
 */
public class PayType {
    private int id;
    private String type;
    private String value;
    private int view;
    private int status;
    

    public PayType() {
    }

    public PayType(int id, String type, String value, int view, int status) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.view = view;
        this.status = status;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
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
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.type);
        hash = 41 * hash + Objects.hashCode(this.value);
        hash = 41 * hash + this.view;
        hash = 41 * hash + this.status;
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
        final PayType other = (PayType) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.view != other.view) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PayType{" + "id=" + id + ", type=" + type + ", value=" + value + ", view=" + view + ", status=" + status + '}';
    }

    
    
}
