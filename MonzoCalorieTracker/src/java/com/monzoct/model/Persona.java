/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monzoct.model;


/**
 *
 * @author M I C I F U S
 */
public class Persona {
    //vic
    private Integer codigoPersona;
    private String nick;
    private String nombre;
    private String password;
    private String objetivo; 
    private String sexo;
    private int edad;
    private double peso;
    private double altura;
    private double bmi;
    private double bmr;
    
    //Constructores
    public Persona() {
        codigoPersona = 0;
        nick = "";
        nombre = "";
        password = "";
        objetivo = "";
        sexo = "";
        edad = 0;
        peso = 0;
        altura = 0;
        bmi = 0;
        bmr = 0;
    }
    
    public Persona(Integer CodigoPersona, String nick, String nombre, String password, String objetivo, String sexo, int edad, double peso, double altura, double bmi, double bmr) {
        this.codigoPersona = CodigoPersona;
        this.nick = nick;
        this.nombre = nombre;
        this.password = password;
        this.objetivo = objetivo;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.bmi = bmi;
        this.bmr = bmr;
    }
    
    //Getters
    public Integer getCodigoPersona() {
        return codigoPersona;
    }
    
    public String getNick() {
        return nick;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public double getBmi() {
        return bmi;
    }

    public double getBmr() {
        return bmr;
    }
    
    //Setters
    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }
}
