package com.example.dam3.imc;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    BDD db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new BDD(this);

        db.onCreate(db.getReadableDatabase());


        final String[] array = new String[] {
                "Calcular IMC"
                ,"Ver Datos Guardados"
        };

        ListAdapter adaptador = new ArrayAdapter<String>(this, R.layout.textview_for_list, array);

        final ListView listView = (ListView) findViewById(R.id.activity_main2);
        listView.setAdapter(adaptador);

        final HashMap activities = new HashMap<String, Class<? extends Activity>>();
        activities.put(array[0],Calcular.class);
        activities.put(array[1],VerDatos.class);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long
                    id) {

                int posicion = position;

                String itemValue = (String) listView.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), (Class<Activity>)
                        activities.get(itemValue));
                db.onCreate(db.getReadableDatabase());
                startActivity(intent);
            }
        });




    }
}
