package infocefetcontagem.cartilhacefetcontagem;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.util.List;

import infocefetcontagem.cartilhacefetcontagem.adapters.SliderImageAdapter;
import infocefetcontagem.cartilhacefetcontagem.models.AppData;
import infocefetcontagem.cartilhacefetcontagem.models.Photo;

public class SliderImageActivity extends AppCompatActivity {

    private View mContentView;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static List<Photo> photoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_image);

        mContentView = findViewById(R.id.fullscreen_content);
        int place_filter = AppData.PLACE_ALL;

        final ViewPager viewPager = (ViewPager)findViewById(R.id.slider_view_pager);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.gray05));
        getSupportActionBar().hide();

        if(getIntent().hasExtra("place")) {
            place_filter = getIntent().getIntExtra("place", -1);
        }

        if(place_filter == AppData.PLACE_ALL)
            photoList = AppData.getPhotos();
        else
            photoList = AppData.getPhotosByPlace(place_filter);

        viewPager.setAdapter(new SliderImageAdapter(this, photoList));

        NUM_PAGES = photoList.size();

        if(getIntent().hasExtra("position")){
            currentPage = getIntent().getIntExtra("position",0);
        }

        //set the current photo
        viewPager.setCurrentItem(currentPage, true);
    }




    public void onClickClose(View view){
        finish();
    }
}