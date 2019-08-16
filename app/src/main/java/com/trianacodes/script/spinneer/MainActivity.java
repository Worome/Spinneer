package com.trianacodes.script.spinneer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner seleccion;
    private EditText et_valor1, et_valor2;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valor1 = findViewById(R.id.et_valor1);
        et_valor2 = findViewById(R.id.et_valor2);
        tv_resultado = findViewById(R.id.tv_resultado);
        seleccion = findViewById(R.id.seleccion);

        // Creo matriz con las opciones que va a tener el spinner
        String [] opciones = {"Sumar","Restar","Multiplicar", "Dividir"};

        // Creo la conexión entre la matriz y el spinner
        /* ArrayAdapter creado usando uno de los spinner por defecto ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);*/
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.spinner_item_proyecto_spinner, opciones);//Spinner personalizado

        // Relleno el spinner con el adaptador
        seleccion.setAdapter(adaptador);

    }

    public void Calcular(View view){

        int valor1 = Integer.parseInt(et_valor1.getText().toString());
        int valor2 = Integer.parseInt(et_valor2.getText().toString());

        String opcion = seleccion.getSelectedItem().toString();
        tv_resultado.setText(R.string.Resultado);

        if (opcion.equals("Sumar")){
            tv_resultado.setText(tv_resultado.getText().toString() + " " + Suma(valor1, valor2));
        } else if(opcion.equals("Restar")){
            tv_resultado.setText(tv_resultado.getText().toString() + " " + Resta(valor1, valor2));
        } else if(opcion.equals("Multiplicar")){
            tv_resultado.setText(tv_resultado.getText().toString() + " " + Multiplica(valor1, valor2));
        } else {
            if (valor2 !=0){
                tv_resultado.setText(tv_resultado.getText().toString() + " " + Divide(valor1, valor2));
            } else {
                Toast.makeText(this,"El segundo valor no puede ser 0",Toast.LENGTH_LONG).show();
            }

        }

    }

    public int Suma (int v1, int v2){

        // Devuelve el resultado de la operación
        return v1 + v2;

    }

    public int Resta (int v1, int v2){

        // Devuelve el resultado de la operación
        return v1 - v2;

    }

    public int Multiplica (int v1, int v2){

        // Devuelve el resultado de la operación
        return v1 * v2;

    }

    public int Divide (int v1, int v2){

        // Devuelve el resultado de la operación
        return v1 / v2;

    }

}
