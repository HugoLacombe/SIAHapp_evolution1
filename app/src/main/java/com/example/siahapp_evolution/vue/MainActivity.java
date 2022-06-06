package com.example.siahapp_evolution.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.siahapp_evolution.R;
public class MainActivity extends AppCompatActivity {
    Boolean connexion1 = true;
    TextView Titre;
    ImageView logo;
    Button co1;
    TextView textco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        co1 = findViewById(R.id.co1);
        co1.setEnabled(false);
        textco = findViewById(R.id.textco1);

        Titre = findViewById(R.id.title);
        logo = findViewById(R.id.logo);

        if(connexion1 == true){
            textco.setVisibility(View.VISIBLE);
            animationtext(Titre);
            animationtext(textco);
            animationImage(logo);
            co1.setEnabled(true);

        }
        else{
            animationImage(logo);
            animationtext(Titre);
        }

        co1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_info();
            }
        });


    }

    private void visualiser_info() {
        Intent intent = new Intent(this,inscription.class );
        startActivity(intent);
    }

    public void animationtext( TextView text){
        text.setAlpha(0f);
        text.setTranslationY(50);
        text.animate().alpha(1f).translationYBy(-50).setDuration(1500);
    }

    public void animationImage( ImageView image){
        image.setAlpha(0f);
        image.setTranslationY(50);
        image.animate().alpha(1f).translationYBy(-50).setDuration(1500);
    }
}