package com.example.dam3.imc;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity implements EscribirFichero.OnFragmentInteractionListener {

    TextView textViewResultado;
    String textoAGuardar;
    Bundle bundle = new Bundle();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textViewResultado = (TextView)findViewById(R.id.textViewResultado);

        Persona persona = (Persona)
        getIntent().getParcelableExtra("Persona");

        bundle.putParcelable("Persona", persona);

        textViewResultado.setText(persona.toString());

        //textoAGuardar = textViewResultado.getText().toString();

        Button buttonRegresar = (Button) findViewById(R.id.buttonRegresar);
        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final Button buttonGrabar = (Button) findViewById(R.id.buttonGrabar);
        buttonGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                buttonGrabar.setVisibility(View.INVISIBLE);





                //Bundle para Strings
                //bundle.putString("Datos", textoAGuardar);




                FragmentManager fragmentManager = getFragmentManager();
                EscribirFichero fragment = new EscribirFichero();

                fragment.setArguments(bundle);

                android.app.FragmentTransaction transaction =
                        fragmentManager.beginTransaction();



                transaction.add(R.id.paraFragment, fragment);
                transaction.commit();


            }
        });




    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



}
