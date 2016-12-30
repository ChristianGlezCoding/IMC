package com.example.dam3.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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


                        Hombre = new Hombre("", "", edad, altura, peso);
                        Hombre.calcularIMC();
                        persona = Hombre;

                    } else {


                        Mujer = new Mujer("", "", edad, altura, peso);
                        Mujer.calcularIMC();
                        persona = Mujer;


                    }

                final Intent intent = new Intent(getApplicationContext(), Resultado.class);
                intent.putExtra("Persona", persona);
                startActivity(intent);
            }
        });



    }


    void dates(){






    }


}
