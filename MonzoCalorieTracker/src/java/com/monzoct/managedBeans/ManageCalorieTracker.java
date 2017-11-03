/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzoct.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.monzoct.managedBeans.ManagePersona;
import com.monzoct.managedBeans.ManageComida;
import java.io.Serializable;
import java.util.Date;
import com.monzoct.model.CalorieTracker;
import com.monzoct.model.Persona;

/**
 *
 * @author M I C I F U S
 */
@Named(value = "manageCalorieTracker")
@ManagedBean
@SessionScoped
public class ManageCalorieTracker implements Serializable {
    private CalorieTracker calT;
    
    public ManageCalorieTracker() {
        calT = new CalorieTracker();
    }
    
    public ManageCalorieTracker(CalorieTracker calT) {
        this.calT = calT;
    }
    
    public CalorieTracker getCalT() {
        return calT;
    }
    
    public void setCalT(CalorieTracker calT) {
        this.calT = calT;
    }
    
    //Metodos

    
    public double CalorieTracker() {
        double fooRemaining;
        fooRemaining = 0;
        fooRemaining = calT.getBudget() - calT.getTotalCal() + calT.getEjercicio();
        


        //la condicion del if es que quiere que cuando el boton de agregar, o eliminar se
        //oprima, entonces fooRemaining sume o reste
        /*double remain;
        remain = 0;
        
        if(manejadorC.equals(manejadorC.AgregarComida())) {
            remain = manejadorP.BudgetObjetivo() - manejadorC.AgregarComida() + exercise;
        } else if(manejadorC.equals(manejadorC.AnularComida())) {
            remain = manejadorP.BudgetObjetivo() + manejadorC.AnularComida() + exercise;
        }
        
        return remain;*/
        return fooRemaining;
    }
    
    
    
}
