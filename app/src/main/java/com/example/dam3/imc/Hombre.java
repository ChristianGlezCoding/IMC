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
public  class Hombre extends Persona{

    double ideal;

    public Hombre(String nombre, String ape1, int edad, int altura, double peso, String sexo){
        super(nombre, ape1, edad, altura, peso, sexo);
    }
    public Hombre (Parcel in){
        this(in.readString(), in.readString(), Integer.parseInt(in.readString()), Integer.parseInt(in.readString()), Double.parseDouble(in.readString()), in.readString());

    }
     /**
     *
     * @return índice masa corporal
     */
    @Override
    public double calcularPesoIdeal(){
        // altura - 100 - ( (100 - 150)/k )   
        // siendo k=4 si hombre y k=2 si mujer
        return this.alturaEnCm - 100 - ( (this.alturaEnCm  - 150)/(double)4 );
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
        parcel.writeString(sexo);


    }

    public static final Creator<Hombre> CREATOR = new Creator<Hombre>() {
        @Override
        public Hombre createFromParcel(Parcel parcel) {
            return new Hombre(parcel);
        }

        @Override
        public Hombre[] newArray(int size) {
            return new Hombre[0];
        }
    };


}
