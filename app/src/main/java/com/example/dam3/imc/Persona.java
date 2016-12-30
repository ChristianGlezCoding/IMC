/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dam3.imc;

import android.app.Fragment;
import android.os.Parcel;

import android.os.Parcelable;

/**
 *
 * @author carlos
 */
public abstract class Persona implements Parcelable {
    protected String nombre;
    protected String apellido1;

    protected int edad;
    protected int alturaEnCm;
    protected double pesoEnKg;


    
    public Persona(String nombre, String ape1, int edad, int altura, double peso){
        this.nombre = nombre;
        this.apellido1 = ape1;

        this.edad = edad;
        this.alturaEnCm = altura;
        this.pesoEnKg = peso;
    }
    
    
    protected double calcularIMC(){
        return pesoEnKg/(Math.pow(alturaEnCm/(double)100,2));
    }
    protected abstract double calcularPesoIdeal();
    @Override
    public String toString(){
        return  "Nombre: " + nombre + " Apellido: " + apellido1 +"\nEdad: " + edad + "  Altura: " + alturaEnCm + "\nPeso: " + pesoEnKg + "\nIMC: " + calcularIMC();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public int getEdad() {
        return edad;
    }

    public int getAlturaEnCm() {
        return alturaEnCm;
    }

    public double getPesoEnKg() {
        return pesoEnKg;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
}


