package com.monzo.model;

import java.util.HashSet;
import java.util.Set;

public class Persona  implements java.io.Serializable {


     private Integer codigoPersona;
     private String nick;
     private String nombre;
     private String contrasena;
     private String sexo;
     private String objetivo;
     private int edad;
     private double peso;
     private double altura;
     private double bmi;
     private double bmr;
     private Set calorietrackers = new HashSet(0);

    public Persona() {
        super();
    }

    public Persona(Integer codigoPersona, String nick, String nombre, String contrasena, String sexo, String objetivo, int edad, double peso, double altura, double bmi, double bmr) {
        this.codigoPersona = codigoPersona;
        this.nick = nick;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.objetivo = objetivo;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.bmi = bmi;
        this.bmr = bmr;
    }

	
    

    public Integer getCodigoPersona() {
        return this.codigoPersona;
    }
    
    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
    public String getNick() {
        return this.nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getObjetivo() {
        return this.objetivo;
    }
    
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getPeso() {
        return this.peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return this.altura;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getBmi() {
        return this.bmi;
    }
    
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
    public double getBmr() {
        return this.bmr;
    }
    
    public void setBmr(double bmr) {
        this.bmr = bmr;
    }
    public Set getCalorietrackers() {
        return this.calorietrackers;
    }
    
    public void setCalorietrackers(Set calorietrackers) {
        this.calorietrackers = calorietrackers;
    }

}


