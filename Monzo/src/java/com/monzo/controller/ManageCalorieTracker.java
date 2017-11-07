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
import java.io.Serializable;
import java.util.Date;
import com.monzo.model.Calorietracker;
import com.monzo.model.Persona;
import java.io.IOException;
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
    private static final String CT_PAGE_REDIRECT = "templates/calorieT/user-profile.xhtml?faces-redirect=true";
    
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession sesion = request.getSession(true);
    
    private Calorietracker calT;
    
    public ManageCalorieTracker() {
        calT = new Calorietracker();
    }
    
    public ManageCalorieTracker(Calorietracker calT) {
        this.calT = calT;
    }
    
    public Calorietracker getCalT() {
        return calT;
    }
    
    public void setCalT(Calorietracker calT) {
        this.calT = calT;
    }
    
    //Metodos
    public String CalorieTracker() {
        double fooRemaining;
        fooRemaining = 0;
        fooRemaining = calT.getBudget() - calT.getTotalCal() + calT.getEjercicio();
        calT.setRemaining(fooRemaining);

        return CT_PAGE_REDIRECT;
    }
    
    
    
    public String AddCalorieTracker() throws IOException, ServletException {    
//        Calorietracker ct;
//        ct = new Calorietracker(
//                null,
//                calT.getBudget(),
//                calT.getTotalCal(),
//                calT.getEjercicio(),
//                calT.getRemaining(),
//                calT.getTime24h(),
//                calT.getComidas()
//        );
       // Conexion.getInstancia().agregar(ct);
        return CT_PAGE_REDIRECT;
    }    
    
    public String AddEjercicio() throws IOException, ServletException {
        
        
        return CT_PAGE_REDIRECT;
    }
    
    
    public String ModificarCalorieTracker() {
        
        return CT_PAGE_REDIRECT;
    }
    
    public String AnularCalorieTracker() {
        
        return CT_PAGE_REDIRECT;
    }
}
