/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dam3.imc;

import android.os.Parcel;

/**
 *
 * @author carlos
 */
public class Mujer extends Persona{

    double ideal;
    
    public Mujer(String nombre, String ape1, int edad, int altura, double peso, String sexo){
        super(nombre, ape1, edad, altura, peso, sexo);
    }


    public Mujer (Parcel in){
        this(in.readString(), in.readString(), Integer.parseInt(in.readString()), Integer.parseInt(in.readString()), Double.parseDouble(in.readString()), in.readString());

    }
    
    @Override
    public double calcularPesoIdeal(){
        // altura - 100 - ( (100 - 150)/k )   
        // siendo k=4 si hombre y k=2 si mujer
        return this.alturaEnCm - 100 - ( (this.alturaEnCm - 150)/(double)2 );
    }


    
    
    @Override
    public String toString(){
        return super.toString() + "\nPeso Ideal: " + calcularPesoIdeal();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {

        parcel.writeString(nombre);
        parcel.writeString(apellido1);
        parcel.writeString(String.valueOf(edad));
        parcel.writeString(String.valueOf(alturaEnCm));
        parcel.writeString(String.valueOf(pesoEnKg));
        parcel.writeString(String.valueOf(sexo));


    }
    public static final Creator<Mujer> CREATOR = new Creator<Mujer>() {
        @Override
        public Mujer createFromParcel(Parcel parcel) {
            return new Mujer(parcel);
        }

        @Override
        public Mujer[] newArray(int size) {
            return new Mujer[0];
        }
    };

    public double getIdeal() {
        ideal = calcularPesoIdeal();
        return ideal;
    }
}
