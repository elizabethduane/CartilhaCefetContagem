package infocefetcontagem.appcefetcontagem;

import android.os.Build;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import infocefetcontagem.appcefetcontagem.fragments.CalendarFragment;
import infocefetcontagem.appcefetcontagem.fragments.GalleryFragment;
import infocefetcontagem.appcefetcontagem.fragments.MainFragment;
import infocefetcontagem.appcefetcontagem.fragments.SectorsFragment;
import infocefetcontagem.appcefetcontagem.models.AppData;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    // Abre uma transação e adiciona
                    ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_content,new MainFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_contacts:
                    //mTextMessage.setText(R.string.title_notifications);
                    ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_content,new SectorsFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_photos:
                    //mTextMessage.setText(R.string.title_notifications);
                    ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_content,new GalleryFragment());
                    ft.commit();
                    return true;

                case R.id.navigation_calendar:
                    //mTextMessage.setText(R.string.title_notifications);
                    ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_content,new CalendarFragment());
                    ft.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.primaryColor));

        if (Build.VERSION.SDK_INT >= M) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);//  set status text dark
        }
        AppData.inicializeData();

        getSupportActionBar().hide();

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_content,new MainFragment());
        ft.commit();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

}
