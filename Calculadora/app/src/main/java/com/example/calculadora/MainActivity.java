package com.example.calculadora;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.SparseIntArray;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView resultado, operacion;
    private EditText valor_1, valor_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.resultado);
        valor_1 = findViewById(R.id.valor_1);
        valor_2 = findViewById(R.id.valor_2);
    }
    public void sumar (View view)
    {
        int res = Integer.parseInt(valor_1.getText().toString())+ Integer.parseInt(valor_2.getText().toString());
        resultado.setText(res + "");
    }
    public void restar (View view)
    {
        int res = Integer.parseInt(valor_1.getText().toString())- Integer.parseInt(valor_2.getText().toString());
        resultado.setText(res + "");
    }
    public void multiplicar (View view)
    {
        int res = Integer.parseInt(valor_1.getText().toString())* Integer.parseInt(valor_2.getText().toString());
        resultado.setText(res + "");
    }
    public void dividir (View view)
    {
        int res = Integer.parseInt(valor_1.getText().toString())/ Integer.parseInt(valor_2.getText().toString());
        resultado.setText(res + "");
    }
}