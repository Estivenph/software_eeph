package com.example.consumir_ws;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText id_text, titulo_text, cuerpo_text;
    Button btn_enviar, btn_leer, btn_actualizar, btn_eliminar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo_text = findViewById(R.id.titulo_text);
        id_text = findViewById(R.id.id_text);
        cuerpo_text = findViewById(R.id.cuerpo_text);
        btn_leer = findViewById(R.id.btn_leer);
        btn_enviar = findViewById(R.id.btn_enviar);
        btn_actualizar = findViewById(R.id.btn_actualizar);
        btn_eliminar = findViewById(R.id.btn_eliminar);

        btn_leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Leer_WS();
            }
        });

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Enviar_WS(id_text.getText().toString(), cuerpo_text.getText().toString(), titulo_text.getText().toString());
            }
        });

        btn_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Actualizar_WS(id_text.getText().toString(), cuerpo_text.getText().toString(), titulo_text.getText().toString());
            }
        });

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Eliminar_Ws(id_text.getText().toString(), cuerpo_text.getText().toString(), titulo_text.getText().toString());
            }
        });

    }

    private void Leer_WS()
    {
        String url = "https://jsonplaceholder.typicode.com/posts/7";
        StringRequest post_req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    id_text.setText(jsonObject.getString("UserId"));
                    titulo_text.setText(jsonObject.getString("title"));
                    cuerpo_text.setText(jsonObject.getString("body"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(post_req);
    }

    private void Enviar_WS( String UserId, String titulo, String cuerpo)
    {
        String url = "https://jsonplaceholder.typicode.com/posts";
        StringRequest post_req = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this, "Enviado =  " + response, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("error", error.getMessage());
            }
        })
        {
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("title", titulo);
                params.put("body", cuerpo);
                params.put("UserId",UserId);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(post_req);
    }

    private void Actualizar_WS( String UserId, String titulo, String cuerpo)
    {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        StringRequest post_req = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this, "Actualizado =  " + response, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("error", error.getMessage());
            }
        })
        {
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("id", "1");
                params.put("title", titulo);
                params.put("body", cuerpo);
                params.put("UserId",UserId);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(post_req);
    }

    private void Eliminar_Ws( String UserId, String titulo, String cuerpo)
    {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        StringRequest post_req = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this, "Eliminado =  " + response, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(post_req);
    }
}