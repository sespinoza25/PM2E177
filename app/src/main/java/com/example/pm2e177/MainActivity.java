package com.example.pm2e177;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm2e177.configuracion.SQLiteConexion;
import com.example.pm2e177.transacciones.Transacciones;

public class MainActivity extends AppCompatActivity {

    EditText nombres, telefono, nota;

    Button btnagregar;
    Button btn_lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.nombres);
        telefono = (EditText) findViewById(R.id.telefono);
        nota = (EditText) findViewById(R.id.nota);

        btnagregar = (Button) findViewById(R.id.btnagregar);
        btn_lista = (Button) findViewById(R.id.btn_lista);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MostrarCliente();
                AgregarContacto();


            }
        });

        btn_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        ActivityListView.class);
                startActivity(intent);
            }
        });
    }

    private void AgregarContacto() {

        if(validar())
        {
            try {
                SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
                SQLiteDatabase db = conexion.getWritableDatabase();

                ContentValues valores = new ContentValues();
                valores.put("nombres", nombres.getText().toString());
                valores.put("telefono", telefono.getText().toString());
                valores.put("nota", nota.getText().toString());

                Long Resultado = db.insert(Transacciones.tablacontactos,"id", valores);
                Toast.makeText(this, Resultado.toString(), Toast.LENGTH_SHORT).show();

                ClearScreen();

            }catch (Exception ex){
                Toast.makeText(this, "No se pudo insertar el dato", Toast.LENGTH_SHORT).show();
            }

        }


    }

    private void ClearScreen()
    {
        nombres.setText(Transacciones.Empty);
        telefono.setText(Transacciones.Empty);
        nota.setText(Transacciones.Empty);
    }

    private void MostrarCliente() {
        String mensaje = nombres.getText().toString() +
                " | " + telefono.getText().toString() +
                " | " + nota.getText().toString() ;

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private boolean validar()
    {
        boolean retorno=true;

        String c1= nombres.getText().toString();
        String c2= telefono.getText().toString();
        String c3= nota.getText().toString();

        if(c1.isEmpty())
        {
            nombres.setError("debe escribir un nombre");
            retorno=false;
        }
        if(c2.isEmpty())
        {
            telefono.setError("debe escribir un telefono");
            retorno=false;
        }
        if(c3.isEmpty())
        {
            nota.setError("debe escribir una nota");
            retorno=false;
        }


        return retorno;
    }


}