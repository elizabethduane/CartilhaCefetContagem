package infocefetcontagem.cartilhacefetcontagem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import infocefetcontagem.cartilhacefetcontagem.adapters.MyPhotoRecyclerViewAdapter;
import infocefetcontagem.cartilhacefetcontagem.models.Photo;

public class GalleryActivity extends AppCompatActivity implements MyPhotoRecyclerViewAdapter.OnItemListener {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String TAG = "GalleryActivity" ;
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private List<Photo> mPhotoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.grid);

        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, mColumnCount));
        }

        Photo photo = new Photo();

        if(getIntent().hasExtra("place")) {
            int place_filter = getIntent().getIntExtra("place",0);
            Log.d(TAG, "onCreate:" + place_filter);
            mPhotoList = photo.getPhotosByPlace(place_filter);
            recyclerView.setAdapter(new MyPhotoRecyclerViewAdapter(mPhotoList,this));
        }else{

            Log.d(TAG, "onCreate: No extra");
        }

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, SliderImageActivity.class);

        Log.d(TAG, "onItemClick: place " +mPhotoList.get(position).getPlace());
        Log.d(TAG, "onItemClick: position "+position);

        intent.putExtra("place", mPhotoList.get(position).getPlace());
        intent.putExtra("position", position);
        startActivity(intent);

        /*Photo photo = new Photo();
        List<Photo> photos = photo.getPhotosByPlace(0);
        photo = photos.get(position);

        intent.putExtra("photoId", photo.getPhotoId());
        startActivity(intent);*/
    }
}