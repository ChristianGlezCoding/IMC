package com.example.dam3.imc;

/**
 * Created by Christian on 02/01/2017.
 */import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class BDD extends SQLiteOpenHelper {




        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "imc.db";
        private final Context contexto;

    public BDD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.contexto = context;
    }



        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            String CREATE_IMC_TABLE = "CREATE TABLE IF NOT EXISTS"
                    + " IMC" + " ("
                    + "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "Nombre" + " TEXT,"
                    + "Edad" + " INTEGER,"
                    + "Altura" + " INT,"
                    + "Peso" + " DOUBLE,"
                    + "IMC" + " DOUBLE,"
                    + "Sexo" + " TEXT,"
                    + "Ideal" + " DOUBLE);";

            sqLiteDatabase.execSQL(CREATE_IMC_TABLE);

        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if( i1 > i){
            db.execSQL("DROP TABLE IF EXISTS " + "IMC");
            onCreate(db);
        }
    }


    public long insertarRegistro(SQLiteDatabase db, String nombre, int edad, int altura, double peso, double imc, String sexo, double ideal){

            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("Nombre", nombre);
            nuevoRegistro.put("Edad", edad);
            nuevoRegistro.put("Altura", altura);
            nuevoRegistro.put("Peso", peso);
            nuevoRegistro.put("IMC", imc);
            nuevoRegistro.put("Sexo", sexo);
            nuevoRegistro.put("Ideal", ideal);
            return db.insert("IMC", null , nuevoRegistro);
        }
        public boolean checkDataBase() {
            SQLiteDatabase checkDB = null;
            try {
                checkDB = SQLiteDatabase.openDatabase(DATABASE_NAME, null,SQLiteDatabase.OPEN_READONLY);
                checkDB.close();
            } catch (SQLiteException e) {

            }
            return checkDB != null;
        }

        public ArrayList<String> obtenerRegistros(SQLiteDatabase db){

            String nombre, edad, altura, peso, imc, sexo, ideal;
            String filtroWhereLike = "%";

            String where = "Nombre LIKE ?";
            String[] whereArgs = {filtroWhereLike};

            Cursor c = null;
            c = db.query("IMC", null, where, whereArgs, null, null, null);
            ArrayList <String> anotaciones = new ArrayList<>();
            if( c != null && c.moveToFirst() ){
                do {
                    nombre = "Nombre: " + c.getString(1);
                    edad = " Edad: " + c.getString(2) + " ";
                    altura = "Altura: " +c.getString(3);
                    peso = "Peso: " + c.getString(4);
                    imc = "IMC: " + c.getString(5);
                    sexo = "Sexo: " + c.getString(6);
                    ideal = "Ideal: " + c.getString(7);
                    anotaciones.add(nombre);
                    anotaciones.add(edad);
                    anotaciones.add(altura);
                    anotaciones.add(peso);
                    anotaciones.add(imc);
                    anotaciones.add(altura);
                    anotaciones.add(sexo);
                    anotaciones.add(ideal);
                }while( c.moveToNext());
            }
            c.close();
            return anotaciones;
        }



        public void borrar (SQLiteDatabase db){

            db.execSQL("DROP DATABASE IMC;");

        }

    public ArrayList<String> obtenerRegistrosFiltrados(SQLiteDatabase db, String nom){

        String nombre, edad, altura, peso, imc, sexo, ideal;


        String where = "Nombre LIKE ?";


        Cursor c = null;
        c = db.query("IMC", null, where,
                new String[] {"%"+ nom + "%" }, null, null, null,
                null);


        ArrayList <String> anotaciones = new ArrayList<>();
        if( c != null && c.moveToFirst() ){
            do {
                nombre = "Nombre: " + c.getString(1);
                edad = " Edad: " + c.getString(2) + " ";
                altura = "Altura: " +c.getString(3);
                peso = "Peso: " + c.getString(4);
                imc = "IMC: " + c.getString(5);
                sexo = "Sexo: " + c.getString(6);
                ideal = "Ideal: " + c.getString(7);
                anotaciones.add(nombre);
                anotaciones.add(edad);
                anotaciones.add(altura);
                anotaciones.add(peso);
                anotaciones.add(imc);
                anotaciones.add(sexo);
                anotaciones.add(ideal);
            }while( c.moveToNext());
        }
        c.close();
        return anotaciones;
    }







    }

