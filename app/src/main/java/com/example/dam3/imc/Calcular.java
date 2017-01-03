package com.example.dam3.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Calcular extends AppCompatActivity {

    EditText editTextPeso;
    EditText editTextAltura;
    EditText editTextEdad;
    Persona persona;
    Persona Hombre;
    Persona Mujer;
    Button calcular;
    RadioButton botonHombre, botonMujer;

    double peso;
    int altura;
    int edad;
    String sexo;
    //Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);


        editTextEdad = (EditText) findViewById(R.id.editTextEdad);
        editTextAltura = (EditText) findViewById(R.id.editTextAltura);
        editTextPeso = (EditText) findViewById(R.id.editTextPeso);
        botonHombre = (RadioButton) findViewById(R.id.radioButtonHombre);
        botonMujer = (RadioButton) findViewById(R.id.radioButtonMujer);
        calcular = (Button) findViewById((R.id.buttonCalcular));










        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edad = Integer.parseInt(editTextEdad.getText().toString());
                peso = Double.parseDouble(editTextPeso.getText().toString());
                altura = Integer.parseInt(editTextAltura.getText().toString());




                    if (botonHombre.isSelected()) {

                        sexo = "Hombre";
                        Hombre = new Hombre("", "", edad, altura, peso, sexo);
                        Hombre.calcularIMC();

                        //bundle = new Bundle();
                        //bundle.putString("Sexo", sexo);
                        persona = Hombre;
                        //intent.putExtras(bundle);

                    } else {

                        sexo = "Mujer";
                        Mujer = new Mujer("", "", edad, altura, peso, sexo);
                        Mujer.calcularIMC();

                        //bundle = new Bundle();
                        //bundle.putString("Sexo", sexo);
                        persona = Mujer;
                        //intent.putExtras(bundle);

                    }


                final Intent intent = new Intent(getApplicationContext(), Resultado.class);

                intent.putExtra("Persona", persona);

                startActivity(intent);
            }
        });



    }


}
