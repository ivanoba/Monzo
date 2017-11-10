/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzo.controller;

import static com.monzo.controller.ManagePersona.USER_PAGE_REDIRECT;
import com.monzo.db.Conexion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import com.monzo.model.Calorietracker;
import com.monzo.model.Comida;
import com.monzo.model.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 *
 * @author M I C I F U S
 */
@Named(value = "manageComida")
@ManagedBean
@RequestScoped
public class ManageComida {
    private static final String COMIDA_PAGE_REDIRECT = "/templates/calorieT/user-profile.xhtml?face-redirect=true";
    public static ArrayList<Comida> listaComida;
    public static ArrayList listaC;
    //public static List<Object> fchead;
    //public static List<Object> fcbody;
    
    private Comida comida;
    private Calorietracker calT;
    private Persona person;
    
    public ManageComida() {
        comida = new Comida();
        calT = new Calorietracker();
        person = new Persona();
    }
    
    public ManageComida(Comida comida, Calorietracker calT) {
        this.comida = comida;
        this.calT = calT;
    }
    
    public Comida getComida() {
        return comida;
    }
    
    public void setComida(Comida comida) {
        this.comida = comida;
    }
    
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession sesion = request.getSession(true);
    
    //Metodos

    public String AgregarComida(){
        //List <Object> tracker = Conexion.getInstancia().hacerConsulta("From CalorieTracker");// where  Time24h = "+ ManageLogin.dateFormat);
        //Calorietracker ct;
        //ct = (Calorietracker) tracker.get(0);
        comida.setCalorietracker(ManageLogin.currentTracker);
        Conexion.getInstancia().agregar(comida);
        return COMIDA_PAGE_REDIRECT;
    }
     
    //tambien en vez de void String
    public void ModificarComida() {
        //MODIFICAR BD
        
    }
    
    public void AnularComida() {
        //anular de bd
        
   }
}
