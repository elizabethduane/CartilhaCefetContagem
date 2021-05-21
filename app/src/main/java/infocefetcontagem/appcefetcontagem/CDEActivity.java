package infocefetcontagem.appcefetcontagem;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;

public class CDEActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cde);

        getSupportActionBar().hide();

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.primaryDarkColor));

        if (Build.VERSION.SDK_INT >= M) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);//  set status text dark
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        //Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        //startActivityForResult(myIntent, 0);
        finish(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return true;
    }

    public void onBackPressed(View view){ //Botão BACK padrão do android
        finish();
    }

    public void onWhatsappPressed(View view){

        TextView phoneNumber = null;

        switch(view.getId()){
            case R.id.num_phone_clarice:
            case R.id.whatsapp_clarice:
                phoneNumber = (TextView) findViewById(R.id.num_phone_clarice);
                break;
            case R.id.num_phone_luiza:
            case R.id.whatsapp_luiza:
                phoneNumber = (TextView) findViewById(R.id.num_phone_luiza);
                break;
        }



        String contact = "+55 31"+ phoneNumber.getText(); // use country code with your phone number

        String url = "https://api.whatsapp.com/send?phone=" + contact;

        try {
            PackageManager pm = this.getPackageManager();
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "Whatsapp app not installed in your phone", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
/*
    btn.setOnClickListener {
        val phoneNumber = et.text.toString()
        val url = "https://api.whatsapp.com/send?phone=$phoneNumber"
        try {
            packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(this, "Whatsapp is not installed in your phone.", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    private void startSupportChat() {

        try {
            String headerReceiver = "";// Replace with your message.
            String bodyMessageFormal = "";// Replace with your message.
            String whatsappContain = headerReceiver + bodyMessageFormal;
            String trimToNumner = "+910000000000"; //10 digit number
            Intent intent = new Intent ( Intent.ACTION_VIEW );
            intent.setData ( Uri.parse ( "https://wa.me/" + trimToNumner + "/?text=" + "" ) );
            startActivity ( intent );
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }*/
}