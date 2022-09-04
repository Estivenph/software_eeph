package com.example.actividad_2;

import androidx.appcompat.app.AppCompatActivity;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TextView s_factorial,s_fibonicci;
    private EditText v_entrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s_factorial = findViewById(R.id.s_factorial);
        s_fibonicci = findViewById(R.id.s_fibonicci);
        v_entrada = findViewById(R.id.v_entrada);
    }

    public void factorial (View view)
    {
        int valor = Integer.parseInt(v_entrada.getText().toString());
        int factorial = 1;

        for (int i = 1; i <= valor; i++)
        {
            factorial= factorial * i;
        }
        s_factorial.setText(factorial+ " ");
    }

    public void fibonicci (View view)
    {
        int valor = Integer.parseInt(v_entrada.getText().toString());
        int fibonicci = 1;
        int num1=0;
        int num2=1;

        for (int i = 0; i < valor; i++)
        {
            fibonicci= num1 + num2;
            num1 = num2;
            num2= fibonicci;
        }
        s_fibonicci.setText(fibonicci+ " ");
    }
}
