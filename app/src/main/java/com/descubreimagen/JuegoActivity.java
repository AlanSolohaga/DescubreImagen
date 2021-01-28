package com.descubreimagen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class JuegoActivity extends AppCompatActivity {
    Chronometer cronometro;
    Button btnValidar;
    EditText ingreso;
    TextView txtPuntaje;
    ImageView imageView;
    int puntaje;
    private final int TIEMPO = 10000;
    int contador = 1;

    String[] nombre = {"perro","helado","gioconda","keanu"};
    ArrayList<Drawable> imagen;
    ArrayList<Drawable> imagenBien;
    int[] numero = {0,1,2,3};
    int valor;
    Random random = new Random();
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        cronometro = findViewById(R.id.cronometro);
        btnValidar = findViewById(R.id.btnValidar);
        ingreso = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
        txtPuntaje = findViewById(R.id.txtPuntaje);

        imagen = new ArrayList();
        imagen.add(getDrawable(R.drawable.perrocortado1));
        imagen.add(getDrawable(R.drawable.heladocortado));
        imagen.add(getDrawable(R.drawable.giocondacordado));
        imagen.add(getDrawable(R.drawable.keanurecortado));

        imagenBien = new ArrayList();
        imagenBien.add(getDrawable(R.drawable.perro));
        imagenBien.add(getDrawable(R.drawable.helado));
        imagenBien.add(getDrawable(R.drawable.gioconda));
        imagenBien.add(getDrawable(R.drawable.keanureeves));


        iniciarJuego();


        puntaje=0;
        cronometro.setBackgroundColor(Color.RED);
        cronometro.start();

        iniciarJuego();
        cronometro.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (cronometro.getText().toString().equalsIgnoreCase("01:00")) {
                    cronometro.stop();
                    Toast.makeText(getApplicationContext(),"TIME OUT",Toast.LENGTH_SHORT).show();
                    terminarHandler();
                }
            }
        });



        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if(((BitmapDrawable)imageView.getDrawable()).getBitmap() ==
                  ((BitmapDrawable)getDrawable(R.drawable.perrocortado1)).getBitmap() &&
                        ingreso.getText().toString().equalsIgnoreCase("perro")){

                    imageView.setImageDrawable(getDrawable(R.drawable.perro));
                    Toast.makeText(getApplicationContext(),"CORRECTO!",Toast.LENGTH_SHORT).show();
                    puntaje+=10;
                    txtPuntaje.setText(""+puntaje);
                }else{
                    Toast.makeText(getApplicationContext(),"INCORRECTO!",Toast.LENGTH_SHORT).show();
                    ingreso.setText("");
                }

                 */
                if(ingreso.getText().toString().equalsIgnoreCase(nombre[valor])){
                    Toast.makeText(getApplicationContext(),"CORRECTO",Toast.LENGTH_SHORT).show();
                    puntaje +=10;
                    txtPuntaje.setText(""+puntaje);
                    imageView.setImageDrawable(imagenBien.get(valor));
                    ingreso.setText("");
                }else{
                    Toast.makeText(getApplicationContext(),"INCORRECTO",Toast.LENGTH_SHORT).show();
                    ingreso.setText("");
                }

            }
        });

    }

    private void terminarHandler() {
        handler.removeCallbacksAndMessages(null);
    }

    private void iniciarJuego() {
        imageView.setImageDrawable(imagen.get(0));
        ejecutarHilo();
    }

    private void ejecutarHilo() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //agregarImagen();
                /*
                if(contador == 1){
                    handler.postDelayed(this,TIEMPO);
                    contador++;
                }else{
                    valor = random.nextInt(numero.length);
                    imageView.setImageDrawable(imagen.get(valor));
                    handler.postDelayed(this,TIEMPO);
                }
                 */

                    valor = random.nextInt(numero.length);
                    imageView.setImageDrawable(imagen.get(valor));
                    handler.postDelayed(this, TIEMPO);

            }
        },TIEMPO);



    }

    private void agregarImagen() {
    }

    private void reiniciar() {

        if(cronometro.getText().toString().equalsIgnoreCase("00:05")){
            cronometro.setBackgroundColor(Color.GREEN);
           // long systemCurrTime = SystemClock.elapsedRealtime();
           //cronometro.setBase(systemCurrTime);
        }

    }
}
