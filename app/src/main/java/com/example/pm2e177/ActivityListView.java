package com.example.pm2e177;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.pm2e177.configuracion.SQLiteConexion;
import com.example.pm2e177.transacciones.Contactos;
import com.example.pm2e177.transacciones.Transacciones;

import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listView;
    ArrayList<Contactos> listacontactos;
    ArrayList<String> Arreglocontactos;

    Button btnregresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        btnregresar = (Button) findViewById(R.id.btnregresar);


        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(intent);
            }
        });

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listView = (ListView) findViewById(R.id.listview);

        ObtenerListaContactos();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Arreglocontactos);
        listView.setAdapter(adp);

    }

    private void ObtenerListaContactos() {

        SQLiteDatabase db = conexion.getReadableDatabase();
        Contactos contacto = null;
        listacontactos = new ArrayList<Contactos>();

        //Cursor
        Cursor cursor = db.rawQuery("SELECT * FROM contactos", null );

        while (cursor.moveToNext())
        {
            contacto = new Contactos();
            contacto.setId(cursor.getInt(0));
            contacto.setNombres(cursor.getString(1));
            contacto.setTelefono(cursor.getInt(2));
            contacto.setNota(cursor.getString(3));

            listacontactos.add(contacto);

        }
        cursor.close();
        FillList();

    }

    private void FillList() {
        Arreglocontactos = new ArrayList<String>();
        for(int i=0; i<listacontactos.size(); i++){
            Arreglocontactos.add(listacontactos.get(i).getId()+ " | "+
                    listacontactos.get(i).getNombres()+ " | "+
                    listacontactos.get(i).getTelefono()+ " | ");
        }
    }
}