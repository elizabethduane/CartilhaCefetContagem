package infocefetcontagem.cartilhacefetcontagem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import infocefetcontagem.cartilhacefetcontagem.adapters.CardViewAdapter;
import infocefetcontagem.cartilhacefetcontagem.adapters.MyPhotoRecyclerViewAdapter;
import infocefetcontagem.cartilhacefetcontagem.models.AppData;
import infocefetcontagem.cartilhacefetcontagem.models.Photo;
import infocefetcontagem.cartilhacefetcontagem.models.PlaceHeader;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlacesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlacesFragment extends Fragment implements CardViewAdapter.OnCardListener, MyPhotoRecyclerViewAdapter.OnItemListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String TAG = "PlacesFragment" ;
    // TODO: Customize parameters
    private int mColumnCount = 3;
    private List<Photo> mPhotoList;

    public PlacesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlacesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlacesFragment newInstance(String param1, String param2) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_places, container, false);

        RecyclerView recyclerViewPlaces = (RecyclerView) view.findViewById(R.id.recycler_view_places);
        RecyclerView recyclerViewGrid = (RecyclerView) view.findViewById(R.id.recycler_view_grid);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewPlaces.setLayoutManager(linearLayoutManager);

        PlaceHeader placeHeader = new PlaceHeader();

        CardViewAdapter adapter = new CardViewAdapter(placeHeader.getHeaders(),this);
        recyclerViewPlaces.setAdapter(adapter);

        if (mColumnCount <= 1) {
            recyclerViewGrid.setLayoutManager(new LinearLayoutManager(container.getContext()));
        } else {
            recyclerViewGrid.setLayoutManager(new GridLayoutManager(container.getContext(), mColumnCount));
        }


        mPhotoList = AppData.getPhotos();
        recyclerViewGrid.setAdapter(new MyPhotoRecyclerViewAdapter(mPhotoList,this));



        return view;
    }

    @Override
    public void onCardClick(int position) {
        Intent intent = new Intent(this.getContext(), GalleryActivity.class);

        intent.putExtra("place", position);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this.getContext(), SliderImageActivity.class);

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