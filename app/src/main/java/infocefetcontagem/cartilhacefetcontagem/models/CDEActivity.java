package infocefetcontagem.cartilhacefetcontagem.models;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import infocefetcontagem.cartilhacefetcontagem.MainActivity;
import infocefetcontagem.cartilhacefetcontagem.R;

public class CDEActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cde);

        ActionBar actionBar = (ActionBar)getSupportActionBar();
       // actionBar.setSubtitle("CDE");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
       // getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().hide();

    }


    public void onBackPressed(View view){ //Botão BACK padrão do android
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("sector","cde");
        startActivity(intent); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
}