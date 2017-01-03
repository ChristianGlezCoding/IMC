package com.example.dam3.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class VerDatos extends AppCompatActivity {



    TextView res;
    Button filtrar;
    EditText nombre_filtro;
    String nom;
    BDD db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);

        res = (TextView)findViewById(R.id.textViewResultados);
        filtrar = (Button)findViewById(R.id.buttonFiltrar);
        nombre_filtro = (EditText)findViewById(R.id.editTextFiltrar);
        db = new BDD (this);

        mostrarArticulos();

        filtrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nom = nombre_filtro.getText().toString();

                mostrarArticulosFiltrados(nom);

            }
        });




    }

    private void mostrarArticulos(){


        ArrayList<String> articulos;
        articulos = db.obtenerRegistros(db.getReadableDatabase());

        int i = 1;

        res.setText("");
        for(String dato : articulos){
            res.append(dato + "    ");
            if( i % 8 == 0) // como ocho datos conforman una fila entera. cada dos datos hacemos un salto de línea
                res.append("\n\n");
            i++;

        }

    }

    private void mostrarArticulosFiltrados(String nom){


        ArrayList<String> articulos;
        articulos = db.obtenerRegistrosFiltrados(db.getReadableDatabase(), nom);

        int i = 1;

        res.setText("");
        for(String dato : articulos){
            res.append(dato + "    ");
            if( i % 8 == 0) // como ocho datos conforman una fila entera. cada dos datos hacemos un salto de línea
                res.append("\n\n");
            i++;

        }

    }



}
