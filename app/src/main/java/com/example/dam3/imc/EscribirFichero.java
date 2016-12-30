package com.example.dam3.imc;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.*;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EscribirFichero.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EscribirFichero#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EscribirFichero extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Button buttonEscribir;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters



    String nombre;
    String apellido;
    String datos;
    String textoGrabar;
    TextView textviewApellido;
    TextView textviewNombre;
    Persona persona;




    private OnFragmentInteractionListener mListener;

    public EscribirFichero() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EscribirFichero.
     */
    // TODO: Rename and change types and number of parameters
    public static EscribirFichero newInstance(Persona persona) {
        EscribirFichero fragment = new EscribirFichero();
        Bundle args = new Bundle();
        //En caso de querer pasar un String
        //args.putString(ARG_PARAM1, param1);

        //Pasando como objeto
        args.putParcelable("Persona", persona);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {





        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v;
        v = inflater.inflate(R.layout.fragment_escribir_fichero, container, false);
        persona = (Persona)getArguments().getParcelable("Persona");
        //Para pasar como String
        //datos = getArguments().getString("Datos");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_escribir_fichero, container, false);


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        textviewNombre = (TextView)view.findViewById(R.id.editTextNombre);
        textviewApellido = (TextView)view.findViewById(R.id.editTextApellidos);
        buttonEscribir = (Button)view.findViewById(R.id.buttonEscribirEnFichero);









        buttonEscribir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                persona.nombre = textviewNombre.getText().toString();
                persona.apellido1 = textviewApellido.getText().toString();
                textoGrabar = nombre + " " + apellido + "\n" + persona;
                //Para pasar String
                //textoGrabar = nombre + " " + apellido + "\n" + datos ;
                grabar(textoGrabar);

            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void grabar(String textoGrabar) {
        try {
            OutputStreamWriter archivo = new
                    OutputStreamWriter(getActivity().openFileOutput("ficheroPersonas.log",
                    Activity.MODE_PRIVATE));
            archivo.write(textoGrabar);
            archivo.flush();
            archivo.close();
            Toast t = Toast.makeText(getActivity(), "Los datos fueron grabados",Toast.LENGTH_SHORT);
            t.show();
            t = Toast.makeText(getActivity(), textoGrabar ,Toast.LENGTH_SHORT);
            t.show();



            getActivity().finish();
        } catch (IOException e) {
            Toast t = Toast.makeText(getActivity(), "Los datos no fueron grabados",Toast.LENGTH_SHORT);
            t.show();
        }


    }




}