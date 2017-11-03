/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzoct.managedBeans;

import com.monzoct.db.Conexion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.monzoct.managedBeans.ManagePersona;
import com.monzoct.managedBeans.ManageComida;
import java.io.Serializable;
import java.util.Date;
import com.monzoct.model.CalorieTracker;
import com.monzoct.model.Persona;
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
    public String CalorieTracker() {
        double fooRemaining;
        fooRemaining = 0;
        fooRemaining = calT.getBudget() - calT.getTotalCal() + calT.getEjercicio();
        calT.setRemaining(fooRemaining);

        return CT_PAGE_REDIRECT;
    }
    
    public String AddCalorieTracker() throws IOException, ServletException {
        CalorieTracker ct;
        ct = new CalorieTracker(
                null,
                calT.getBudget(),
                calT.getTotalCal(),
                calT.getEjercicio(),
                calT.getRemaining(),
                calT.getTime24h(),
                calT.getCodigoP()
        );
        Conexion.getInstancia().agregar(ct);
        return CT_PAGE_REDIRECT;
    }    
}
