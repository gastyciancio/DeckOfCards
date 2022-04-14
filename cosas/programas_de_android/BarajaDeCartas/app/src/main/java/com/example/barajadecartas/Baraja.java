package com.example.barajadecartas;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Baraja extends AppCompatActivity {

    ArrayList<Integer> cartas = new ArrayList<Integer>();
    ImageView cartaActual;
    TextView mensaje;
    Random numRandom = new Random();
    int posActual;
    RelativeLayout layout;
    Button botonSacar;
    Button boton_mezclar_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baraja);
        rellenarMazo();
        mensaje = findViewById(R.id.cartaTexto);
        cartaActual = findViewById(R.id.carta);
        mensaje.setText(getResources().getString(R.string.mazoNuevo));
        layout = (RelativeLayout) findViewById(R.id.barajaView);
        botonSacar = findViewById(R.id.botonSacar);


    }
    @SuppressLint({"ResourceType", "UseCompatLoadingForDrawables"})
    public void nuevaCarta(View v){
        if(cartas.size() == 0){
            mensaje.setText(getResources().getString(R.string.mazoVacio));
            cartaActual.setImageDrawable(null);
            boton_mezclar_again= new Button(this);
            boton_mezclar_again.setBackground(Drawable.createFromPath("@android:color/transparent"));
            boton_mezclar_again.setText(R.string.volverMezclar);
            boton_mezclar_again.setTextSize(20);
            RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ABOVE, R.id.botonSacar);
            boton_mezclar_again.setLayoutParams(params);
            boton_mezclar_again.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mezclarOtraVez(view);
                }
            });
            boton_mezclar_again.setTextColor(Color.parseColor("#000000"));
            layout.addView(boton_mezclar_again);
            botonSacar.setVisibility(View.GONE);

        }
        else {
            posActual=numRandom.nextInt(cartas.size());

            InputStream is = this.getResources().openRawResource(cartas.get(posActual));

            BitmapFactory.Options options = new BitmapFactory.Options();

            options.inJustDecodeBounds = false;

            options.inSampleSize = 2;

            Bitmap btp = BitmapFactory.decodeStream(is, null, options);

            cartaActual.setImageBitmap(btp);





            //cartaActual.setImageDrawable(getResources().getDrawable(cartas.get(posActual)));
            cartas.remove(posActual);
        }

    }

    public void mezclarOtraVez(View v){
        cartas.removeAll(cartas);
        rellenarMazo();
        mensaje.setText(getResources().getString(R.string.mazoNuevo));
        botonSacar.setVisibility(View.VISIBLE);
        boton_mezclar_again.setVisibility(View.GONE);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void rellenarMazo(){

        cartas.add(R.drawable.basto_1);
        cartas.add((R.drawable.basto_2));
        cartas.add((R.drawable.basto_3));
        cartas.add((R.drawable.basto_4));
        cartas.add((R.drawable.basto_5));
        cartas.add((R.drawable.basto_6));
        cartas.add((R.drawable.basto_7));
        cartas.add((R.drawable.basto_8));
        cartas.add((R.drawable.basto_9));
        cartas.add((R.drawable.basto_10));
        cartas.add((R.drawable.basto_11));
        cartas.add((R.drawable.basto_12));

        cartas.add((R.drawable.oro_1));
        cartas.add((R.drawable.oro_2));
        cartas.add((R.drawable.oro_3));
        cartas.add((R.drawable.oro_4));
        cartas.add((R.drawable.oro_5));
        cartas.add((R.drawable.oro_6));
        cartas.add((R.drawable.oro_7));
        cartas.add((R.drawable.oro_8));
        cartas.add((R.drawable.oro_9));
        cartas.add((R.drawable.oro_10));
        cartas.add((R.drawable.oro_11));
        cartas.add((R.drawable.oro_12));

        cartas.add((R.drawable.espada_1));
        cartas.add((R.drawable.espada_2));
        cartas.add((R.drawable.espada_3));
        cartas.add((R.drawable.espada_4));
        cartas.add((R.drawable.espada_5));
        cartas.add((R.drawable.espada_6));
        cartas.add((R.drawable.espada_7));
        cartas.add((R.drawable.espada_8));
        cartas.add((R.drawable.espada_9));
        cartas.add((R.drawable.espada_10));
        cartas.add((R.drawable.espada_11));
        cartas.add((R.drawable.espada_12));

        cartas.add((R.drawable.copa_1));
        cartas.add((R.drawable.copa_2));
        cartas.add((R.drawable.copa_3));
        cartas.add((R.drawable.copa_4));
        cartas.add((R.drawable.copa_5));
        cartas.add((R.drawable.copa_6));
        cartas.add((R.drawable.copa_7));
        cartas.add((R.drawable.copa_8));
        cartas.add((R.drawable.copa_9));
        cartas.add((R.drawable.copa_10));
        cartas.add((R.drawable.copa_11));
        cartas.add((R.drawable.copa_12));






    }

    public void volver(View view) {
        this.finish();
    }
}