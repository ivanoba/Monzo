/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzoct.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import com.monzoct.model.CalorieTracker;
import com.monzoct.model.Comida;
/**
 *
 * @author M I C I F U S
 */
@Named(value = "manageComida")
@ManagedBean
@RequestScoped
public class ManageComida {
    private Comida comida;
    private CalorieTracker calT;
    
    public ManageComida() {
        comida = new Comida();
        calT = new CalorieTracker();
    }
    
    public ManageComida(Comida comida, CalorieTracker calT) {
        this.comida = comida;
        this.calT = calT;
    }
    
    public Comida getComida() {
        return comida;
    }
    
    public void setComida(Comida comida) {
        this.comida = comida;
    }
    
    //Metodos
 
    /*CRUD
    public double AgregarComida() {
        //AGREGAR A BD
    
    }
      
    public void ModificarComida() {
        //MODIFICAR BD
        
    }
    
    public double AnularComida() {
        //anular de bd
        
    } */
}
