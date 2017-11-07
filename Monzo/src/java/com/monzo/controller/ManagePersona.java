/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzo.controller;

import com.monzo.db.Conexion;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import com.monzo.model.Persona;
import com.monzo.model.Calorietracker;
import java.text.DecimalFormat;
/**
 *
 * @author M I C I F U S
 */
@ManagedBean
public class ManagePersona implements Serializable {
    public static final String USER_PAGE_REDIRECT = "/templates/index.xhtml?faces-redirect=true";
    private Persona user;
    private Calorietracker calTracker;
    private static DecimalFormat df2 = new DecimalFormat(".##");
    
    public ManagePersona() {
        user = new Persona();
        calTracker = new Calorietracker();
        //calTracker = new Calorietracker();
    }
    
    public ManagePersona(Persona user, Calorietracker calTracker) {
        this.user = user;
        this.calTracker = calTracker;
    }
    
    public Persona getUser() {
        return user;
    }
    
    public void setUser(Persona user) {
        this.user = user;
    }
    
    //Metodos
    public String AddPersona(){
        CalculoBMI();
        CalculoBMR();
        Persona usr = new Persona(
                null,
                user.getNick(),
                user.getNombre(),
                user.getContrasena(),
                user.getSexo(),
                user.getObjetivo(),
                user.getEdad(),
                user.getPeso(),
                user.getAltura(),
                user.getBmi(),
                user.getBmr()
        );
        Conexion.getInstancia().agregar(usr);
        System.out.print("Entro");
        return USER_PAGE_REDIRECT;
    }
    
    
    public double CalculoBMI() {
        double fooBMI;
        fooBMI = 0;
        fooBMI = Double.parseDouble(df2.format((double) user.getPeso() / Math.pow((user.getAltura()/100), 2)));
        user.setBmi(fooBMI);
        return fooBMI;
    }  
    
    public double CalculoBMR() {
        double fooBMR;
        fooBMR = 0;
        if(user.getSexo().equals("Hombre")) {
            fooBMR = 66.47 + (13.75 * user.getPeso()) + (5 * user.getAltura()) - (6.75 * user.getEdad());
        } else if(user.getSexo().equals("Mujer")) {
            fooBMR = 665.09 + (9.56 * user.getPeso()) + (1.84 * user.getAltura()) - (4.67 * user.getEdad());
        }  
        user.setBmr(fooBMR);
        return fooBMR;
    }

    public double BudgetObjetivo() {
        Persona p;
        p = (Persona) Conexion.getInstancia().Buscar(Persona.class, user.getCodigoPersona());
        
        
        double fooBudget;
        fooBudget = 0;
        if(p.getObjetivo().equals("BajarPeso")) {
             fooBudget = CalculoBMR() - 400;
        } else if(p.getObjetivo().equals("MantenerPeso")) {
            fooBudget = CalculoBMR();
        } else if(p.getObjetivo().equals("GanarPeso")) {
            fooBudget = CalculoBMR() + 300;
        }
        
        calTracker.setBudget(fooBudget);
        return fooBudget;
    }
}
