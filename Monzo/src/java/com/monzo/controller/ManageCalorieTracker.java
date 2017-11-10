/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzo.controller;

import com.monzo.db.Conexion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.monzo.controller.ManagePersona;
import com.monzo.controller.ManageComida;
import com.monzo.controller.ManageLogin;
import java.io.Serializable;
import java.util.Date;
import com.monzo.model.Calorietracker;
import com.monzo.model.Comida;
import com.monzo.model.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author M I C I F U S
 */
@Named(value = "manageCalorieTracker")
@ManagedBean
@SessionScoped
public class ManageCalorieTracker implements Serializable {
    private static final String CT_PAGE_REDIRECT = "/templates/calorieT/user-profile.xhtml?faces-redirect=true";
    
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession sesion = request.getSession(true);
    
    private Calorietracker calT;
    private Comida c;
    private Double totalEjercicio;
    
    
    public ManageCalorieTracker() {
        calT = new Calorietracker();
        c = new Comida();
        totalEjercicio = 0.0;
    }
    
    public ManageCalorieTracker(Calorietracker calT, Comida c, double totalEjercicio) {
        this.calT = calT;
        this.c = c;
        this.totalEjercicio = totalEjercicio;
    }
    
    public Calorietracker getCalT() {
        return calT;
    }
    
    public void setCalT(Calorietracker calT) {
        this.calT = calT;
    }

    public Comida getC() {
        return c;
    }

    public void setC(Comida c) {
        this.c = c;
    }

    public Double getTotalEjercicio() {
        return totalEjercicio;
    }

    public void setTotalEjercicio(Double totalEjercicio) {
        this.totalEjercicio = totalEjercicio;
    }
    
    
    
    //M E T O D O S
    public void CaloriasTotales() {
        //Hacer consulta de comida o persona?
        double fooTotalCal;
        fooTotalCal = 0;
        fooTotalCal += c.getCalorias();
        calT.setTotalCal(fooTotalCal);
        sesion.setAttribute("totalCalorias", calT.getTotalCal());
    }
    
    
    public void ObtenerRemainder() {
        double fooRemaining;
        fooRemaining = 0;
        fooRemaining = calT.getBudget() - calT.getTotalCal() + calT.getEjercicio();
        calT.setRemaining(fooRemaining);
    }
    
    public String AddEjercicio() throws IOException, ServletException {
        double fooExercise;
        fooExercise = this.getTotalEjercicio() + ManageLogin.currentTracker.getEjercicio();
        
        ManageLogin.currentTracker.setEjercicio(getTotalEjercicio());
        Conexion.getInstancia().modificar(ManageLogin.currentTracker);
          
//        double fooExercise;
//        fooExercise = 0;
//        fooExercise += ManageLogin.currentTracker.getEjercicio();
//        ManageLogin.currentTracker.setEjercicio(fooExercise);
//        Conexion.getInstancia().modificar(ManageLogin.currentTracker);
        sesion.setAttribute("totalEjercicio", ManageLogin.currentTracker.getEjercicio()); 
        return CT_PAGE_REDIRECT;
    }
    
    
    public String HacerTracker() {
        if(calT.getBudget() > calT.getRemaining()) {  
            sesion.setAttribute("remainder", calT.getRemaining());
        } else {
            sesion.setAttribute("remainder", "Te has pasado");
        }
        return null;
    }
    
    public String AddCalorieTracker() throws IOException, ServletException {  
        
        

        return CT_PAGE_REDIRECT;
    }    
    
    
    public String ModificarCalorieTracker() {
        
        return CT_PAGE_REDIRECT;
    }
    
    public String AnularCalorieTracker() {
        
        return CT_PAGE_REDIRECT;
    }
}
