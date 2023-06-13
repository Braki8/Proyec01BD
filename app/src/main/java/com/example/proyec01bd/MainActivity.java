package com.example.proyec01bd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    TextView tv;
    EditText editText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv1);
        editText = findViewById(R.id.editText1);

        BaseDatos con = new BaseDatos(this, "Usuarios1", null, 2);
        db = con.getWritableDatabase();
/*
      //Ejemplo para que se ejecute 10 veces
       if(db!=null) {

           for (int i = 0; i <= 10; i++) {

               db.execSQL("insert into cliente(nombre, edad) values('freidy " + i + "', " + (20 + 1) + ")");
           }
       }*/
       String [] x = new String[]{editText.getText().toString(), };

        //Ejemplo para ver los datos de mi tabla en texview
            Cursor c= db.rawQuery("select id, nombre, edad from cliente where id=?", x);
            if(c.moveToFirst()){
                tv.append("\n\n");
                do {
                    tv.append("ID" + c.getInt(0) + "NOMBRE" + c.getString(1) + "EDAD" + c.getString(2) + "\n");
                }while (c.moveToNext());
                tv.append("\n Ya termino! \n" );

                }
            }




        }

