package com.example.dam3.imc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final String[] array = new String[] {
                "Calcular IMC"
                ,"Ver Datos Guardados"
        };

        ListAdapter adaptador = new ArrayAdapter<String>(
                this, R.layout.simple_list_view_activities, array);

        final ListView listView = (ListView) findViewById(R.id.activity_main2);
        listView.setAdapter(adaptador);

        final HashMap activities = new HashMap<String, Class<? extends Activity>>();
        activities.put(array[0],Calcular.class);
        activities.put(array[1],Resultado.class);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long
                    id) {
                // La posición donde se hace clic en el elemento de lista
                int posicion = position;
                //obtener el valor del string del elemento donde se hizo clic
                String itemValue = (String) listView.getItemAtPosition(position);
                //Con el fin de empezar a mostrar una nueva actividad lo que necesitamos
                //es un intent
                Intent intent = new Intent(getApplicationContext(), (Class<Activity>)
                        activities.get(itemValue));
                startActivity(intent);
            }
        });




    }
}
