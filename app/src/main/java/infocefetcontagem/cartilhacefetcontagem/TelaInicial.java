package infocefetcontagem.cartilhacefetcontagem;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        Animation animacaoFundo = AnimationUtils.loadAnimation(this,R.anim.transicao_quick_fade_in);
        ImageView img_fundo = (ImageView) findViewById(R.id.img_fundo);
        img_fundo.startAnimation(animacaoFundo);


        Animation animacao = AnimationUtils.loadAnimation(this,R.anim.transicao_fade_in);
        TextView tv_welcome = (TextView)findViewById(R.id.textView_welcome);
        tv_welcome.startAnimation(animacao);


        Handler handle = new Handler();

        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMain();
            }
        }, 5000);

    }

    private void mostrarMain(){

        //call new screen
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }


}
