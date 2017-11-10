/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzo.controller;

import com.monzo.db.Conexion;
import com.monzo.model.Calorietracker;
import com.monzo.model.Comida;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.monzo.model.Persona;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author M I C I F U S
 */
@ManagedBean
@SessionScoped
public class ManageLogin implements Serializable {
    private static final long serialVersionUID = -9107952969237527819L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ManageLogin.class);
    public static final String DASHBOARD_PAGE_REDIRECT = "/templates/calorieT/user-profile.xhtml?faces-redirect=true";
    public static final String LOGIN_PAGE_REDIRECT = "/templates/index.xhtml?faces-redirect=true"; 
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd") ;
    public static String userId;
    private String userPassword;
    private Comida currentComida;
    private Persona currentUser;
    public  static Calorietracker currentTracker;
    private List<Object> food = Conexion.getInstancia().hacerConsulta("From Comida");
    private List<Object> exercise = Conexion.getInstancia().hacerConsulta("From Calorietracker");
    private double caloriasTot;
    private double ejercicioTot;
    
    
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession sesion = request.getSession(true);

    public String login() {
        currentUser = find(userId, userPassword);

        if (currentUser != null) {
            LOGGER.info("login successful for '{}'", userId);
            List<Object> lista;  
            lista = Conexion.getInstancia().hacerConsulta("From Calorietracker WHERE codigoP ="+currentUser.getCodigoPersona());
            if(!lista.isEmpty()) {
                currentTracker = (Calorietracker)lista.get(0);
            }
            return DASHBOARD_PAGE_REDIRECT;
        } else {
            LOGGER.info("login failed for '{}'", userId);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Login fallido", "Usuario y/o contraseña incorrecta."));
            return null;
        }
    }

    public String logout() {
        String identifier = userId;

        LOGGER.debug("invalidating session for '{}'", identifier);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        LOGGER.info("logout successful for '{}'", identifier);
        return LOGIN_PAGE_REDIRECT;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public String isLoggedInForwardHome() {
        if (isLoggedIn()) {
            return DASHBOARD_PAGE_REDIRECT;
        }
        return null;
    }
    
    public void cargarListas() throws IOException {
        
        ArrayList<Comida> f = (ArrayList) food;
        ArrayList<Calorietracker> ej = (ArrayList) exercise;
        caloriasTot = 0;
        ejercicioTot = 0;
        for(int i = 0; i < food.size(); i++) {
            caloriasTot += f.get(i).getCalorias();
            ejercicioTot += ej.get(i).getEjercicio();
        }
        sesion.setAttribute("listaComida", caloriasTot);
    }

    private Persona find(String userId, String password) {
        Persona result;
        result = Conexion.getInstancia().autenticarPersona(userId, password);
        return result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Persona getCurrentUser() {
        return currentUser;
    }

    public Comida getCurrentComida() {
        return currentComida;
    }

    public void setCurrentComida(Comida currentComida) {
        this.currentComida = currentComida;
    }

    public Calorietracker getCurrentTracker() {
        return currentTracker;
    }

    public void setCurrentTracker(Calorietracker currentTracker) {
        this.currentTracker = currentTracker;
    }
    
    
}