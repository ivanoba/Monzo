/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzoct.model;

import java.util.Date;
import com.monzoct.model.Persona;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author M I C I F U S
 */
public class CalorieTracker {
    //VIC
    private Integer codigo;
    private double budget;
    private double totalCal;
    private double ejercicio;
    private double remaining;
    private Date time24h;
    private Persona nickPersona;
    private Set comida = new HashSet(0);
    
    //CONSTRUCTORES
    public CalorieTracker() {
        codigo = 0;
        budget = 0;
        totalCal = 0;
        ejercicio = 0;
        remaining = 0;
        time24h = new Date();
        nickPersona = new Persona();
    }
    
    public CalorieTracker(Integer codigo, double budget, double totalCal, double ejercicio, double remaining, Date datetime, Persona nickPersona, Set comida) {
        this.codigo = codigo;
        this.budget = budget;
        this.totalCal = totalCal;
        this.ejercicio = ejercicio;
        this.remaining = remaining;
        this.time24h = datetime;
        this.nickPersona = nickPersona;
        this.comida = comida;
    }
    
    //Getter
    public Integer getCodigo() {
        return codigo;
    }

    public double getBudget() {
        return budget;
    }

    public double getTotalCal() {
        return totalCal;
    }

    public double getEjercicio() {
        return ejercicio;
    }

    public double getRemaining() {
        return remaining;
    }

    public Date getTime24h() {
        return time24h;
    }

    public Persona getNickPersona() {
        return nickPersona;
    }
    
    //Setter
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setTotalCal(double totalCal) {
        this.totalCal = totalCal;
    }

    public void setEjercicio(double ejercicio) {
        this.ejercicio = ejercicio;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }

    public void setTime24h(Date time24h) {
        this.time24h = time24h;
    }

    public void setNickPersona(Persona nickPersona) {
        this.nickPersona = nickPersona;
    }

    public Set getComida() {
        return comida;
    }

    public void setComida(Set comida) {
        this.comida = comida;
    }
    
    
    
}
