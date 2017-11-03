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

import com.monzoct.model.Persona;
import com.monzoct.model.CalorieTracker;
import java.io.IOException;
import javax.servlet.ServletException;
/**
 *
 * @author M I C I F U S
 */
@Named(value = "managePersona")
@ManagedBean
@SessionScoped
public class ManagePersona implements Serializable {
    public static final String USER_PAGE_REDIRECT = "templates/index.xhtml?faces-redirect=true";
    private Persona user;
    private CalorieTracker calTracker;
    
    public ManagePersona() {
        user = new Persona();
        calTracker = new CalorieTracker();
    }
    
    public ManagePersona(Persona user, CalorieTracker calTracker) {
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
    //se podra hacer void?
    public String AddPersona() throws IOException, ServletException {
        Persona usr;
        usr = new Persona(
                null,
                user.getNick(),
                user.getNombre(),
                user.getPassword(),
                user.getObjetivo(),
                user.getSexo(),
                user.getEdad(),
                user.getPeso(),
                user.getAltura(),
                user.getBmi(),
                user.getBmr()
        );
        Conexion.getInstancia().agregar(usr);
        return USER_PAGE_REDIRECT;
    }
    
    
    public double CalculoBMI() {
        double fooBMI;
        fooBMI = 0;
        fooBMI = user.getPeso() / Math.pow((user.getAltura()/100), 2);
        user.setBmi(fooBMI);
        return fooBMI;
    }  
    
    //se podra hacer void?
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
    
    public String getCategoriaBMI() {
        String categoriaBMI;
        categoriaBMI = "";
        double bmi;
        bmi = CalculoBMI();
        
        if(bmi < 18.5) {
            categoriaBMI = "Bajo Peso / Delgado";
        } else if((bmi >= 18.5) & (bmi <= 24.9)) {
            categoriaBMI = "Peso Adecuado / Aceptable";
        } else if((bmi >= 25) & (bmi <= 29.9)) {
            categoriaBMI = "Sobrepeso";
        } else if((bmi >= 30) & (bmi <= 34.9)) {
            categoriaBMI = "Obesidad Grado 1";
        } else if((bmi >= 35) & (bmi <= 39.9)) {
            categoriaBMI = "Obesidad Grado 2";
        } else if(bmi >= 40) {
            categoriaBMI = "Obesidad Grado 3";
        }
        return categoriaBMI;
    }
    
    //Se puede hacer tipo void este metodo?
    public double BudgetObjetivo() {
        double fooBudget;
        fooBudget = 0;
        if(user.getObjetivo().equals("BajarPeso")) {
             fooBudget = CalculoBMR() - 400;
        } else if(user.getObjetivo().equals("MantenerPeso")) {
            fooBudget = CalculoBMR();
        } else if(user.getObjetivo().equals("GanarPeso")) {
            fooBudget = CalculoBMR() + 300;
        }
        
        calTracker.setBudget(fooBudget);
        /*calTracker.setNickPersona(this);*/
        return fooBudget;
    }
}
