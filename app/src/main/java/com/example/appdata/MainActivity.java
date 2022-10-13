package com.example.appdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nombrePersona;
    private EditText apellidoPersona;
    private EditText edadPersona;
    private EditText estaturaPersona;
    private EditText pesoPersona;
    private EditText dineroPersona;
    private Button buttonEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombrePersona = (EditText) findViewById(R.id.pnombre);
        apellidoPersona = (EditText) findViewById(R.id.Papellido);
        edadPersona = (EditText) findViewById(R.id.edad);
        estaturaPersona = (EditText) findViewById(R.id.estatura);
        pesoPersona = (EditText) findViewById(R.id.peso);
        dineroPersona = (EditText) findViewById(R.id.saldo);
        buttonEnviar = (Button) findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){
                    String nomPersona = nombrePersona.getText().toString();
                    String apellPersona = apellidoPersona.getText().toString();
                    int edaPersona = Integer.parseInt(edadPersona.getText().toString());
                    double estatPersona = Double.parseDouble(estaturaPersona.getText().toString());
                    double pePersona = Double.parseDouble(pesoPersona.getText().toString());
                    double dinePersona = Double.parseDouble(dineroPersona.getText().toString());

                    Usuario u = new Usuario(nomPersona,apellPersona,edaPersona,estatPersona,pePersona,dinePersona);

                    Intent miIntent = new Intent (MainActivity.this,MainActivity2.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("usuario",u);

                    miIntent.putExtras(bundle);
                    startActivity(miIntent);
                }
            }
        });
    }
    public boolean validar() {
        boolean result = true;

        String valor = nombrePersona.getText().toString();
        String valor1 = apellidoPersona.getText().toString();
        String valor2 = edadPersona.getText().toString();
        String valor3 = estaturaPersona.getText().toString();
        String valor4 = pesoPersona.getText().toString();
        String valor5 = dineroPersona.getText().toString();

        if(valor.isEmpty()){
            nombrePersona.setError("Este campo no puede quedar vacio");
            result = false;
        }
        if(valor1.isEmpty()){
            apellidoPersona.setError("Este campo no puede quedar vacio");
            result = false;
        }
        if(valor2.isEmpty()){
            edadPersona.setError("Este campo no puede quedar vacio");
            result = false;
        }
        if(valor3.isEmpty()){
            estaturaPersona.setError("Este campo no puede quedar vacio");
            result = false;
        }
        if(valor4.isEmpty()){
            pesoPersona.setError("Este campo no puede quedar vacio");
            result = false;
        }
        if(valor5.isEmpty()){
            dineroPersona.setError("Este campo no puede quedar vacio");
            result = false;
        }
        return result;
    }

}
