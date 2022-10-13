package com.example.appdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

     private TextView ImcResult;
     private TextView envjResult;
     private TextView valorResult;
     private TextView nombreCliente;
     private Button BtnEnvj;
     private Button BtnImc;
     private Button BtnValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImcResult = (TextView) findViewById(R.id.imc);
        BtnImc = (Button) findViewById(R.id.btnimc);

        envjResult = (TextView) findViewById(R.id.envejecer);
        BtnEnvj = (Button) findViewById(R.id.btnEnvejecer);

        valorResult = (TextView) findViewById(R.id.tributario);
        BtnValor = (Button) findViewById(R.id.btnprestamo);

        nombreCliente = (TextView) findViewById(R.id.Nom_Cliente);

        Bundle objEnviado = getIntent().getExtras();
        Usuario user = null;


        if(objEnviado != null){
            user = (Usuario) objEnviado.getSerializable("usuario");

            double resultImc = user.getpesoPersona()/(user.getestaturaPersona()*user.getestaturaPersona());
            final int[] resulEnvj = {user.getedadPersona()};
            double resulaTributar = user.getdineroPersona()*0.19;
            nombreCliente.setText(user.getnombrePersona()+' '+user.getapellidoPersona());

            BtnImc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImcResult.setText(String.valueOf(resultImc)); ;
                }
            });
            BtnEnvj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    envjResult.setText(String.valueOf(++resulEnvj[0])); ;
                }
            });
            BtnValor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valorResult.setText(String.valueOf(resulaTributar)); ;
                }
            });

        }

    }

    public void regresar(View view){
        finish();
    }
}