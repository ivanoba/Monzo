/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzoct.managedBeans;

import com.monzoct.db.Conexion;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.monzoct.model.Persona;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author M I C I F U S
 */
@Named(value = "manageLogin")
@ManagedBean
@SessionScoped
public class ManageLogin implements Serializable {
    private static final long serialVersionUID = -9107952969237527819L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ManagePersona.class);
    public static final String DASHBOARD_PAGE_REDIRECT = "templates/calorieT/user-profile.xhtml?faces-redirect=true";
    public static final String LOGIN_PAGE_REDIRECT = "templates/index.xhtml?faces-redirect=true"; 
    
    private String userId;
    private String userPassword;
    private Persona currentUser;;
    
    public ManageLogin() {
        userId = "";
        userPassword = "";
        currentUser = new Persona();
    }
    
    public ManageLogin(String userId, String userPassword, Persona currentUser) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.currentUser = currentUser;
    }
    
    public Persona getCurrentUser() {
        return currentUser;
    }
    
    public void setCurrentUser(Persona currentUser) {
        this.currentUser = currentUser;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    
    //Metodos
    public String Login() {
        currentUser = find(userId, userPassword);
        String foo;
        foo = "";
        
        if(currentUser != null) {
            LOGGER.info("Login successfull for '{}'", userId);
            foo = DASHBOARD_PAGE_REDIRECT;
        } else {
            LOGGER.info("Login failed for '{}'", userId);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Login fallido", "Usuario y/o contraseña incorrecta."));
            foo = null;
        }
        return foo;
    }
    
    public String Logout() {
        String identifier = userId;
        
        LOGGER.debug("invalidating session for '{}'", identifier);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    
        LOGGER.info("Logout successfull for '{}'", identifier);
        return LOGIN_PAGE_REDIRECT;
    }
    
    public boolean IsLoggedIn() {
        return currentUser != null;
    }
    
    public String IsLoggedInForwardHome() {
        if(IsLoggedIn()) {
            return DASHBOARD_PAGE_REDIRECT;
        }
        return null;
    }
    
    private Persona find(String userId, String password) {
        Persona result;
        result = Conexion.getInstancia().autenticarPersona(userId, password);
        return result;
    }
}