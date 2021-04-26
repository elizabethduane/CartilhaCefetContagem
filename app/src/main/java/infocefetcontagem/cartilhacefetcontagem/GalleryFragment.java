package infocefetcontagem.cartilhacefetcontagem;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import java.util.List;

import infocefetcontagem.cartilhacefetcontagem.adapters.PhotoRecyclerViewAdapter;
import infocefetcontagem.cartilhacefetcontagem.models.AppData;
import infocefetcontagem.cartilhacefetcontagem.models.Photo;

import static android.os.Build.VERSION_CODES.M;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment implements PhotoRecyclerViewAdapter.OnItemListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final String TAG = "GalleryFragment" ;
    private static final int COLUMN_COUNT = 3;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
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
        final View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        Window window = this.getActivity().getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.primaryColor));

        if (Build.VERSION.SDK_INT >= M) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);//  set status text dark
        }

        RecyclerView recyclerViewGrid = (RecyclerView) view.findViewById(R.id.recycler_view_grid);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerViewGrid.setLayoutManager(new GridLayoutManager(container.getContext(), COLUMN_COUNT));

        List<Photo> mPhotoList = AppData.getPhotos();
        recyclerViewGrid.setAdapter(new PhotoRecyclerViewAdapter(mPhotoList,this));

        ImageView p1 = (ImageView)view.findViewById(R.id.place_externo);

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlaceClick(v);
            }

        });

        ImageView p2 = (ImageView)view.findViewById(R.id.place_labs);

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlaceClick(v);
            }

        });

        ImageView p3 = (ImageView)view.findViewById(R.id.place_interno);

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlaceClick(v);
            }

        });

        return view;
    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(this.getContext(), SliderImageActivity.class);
        intent.putExtra("place", AppData.PLACE_ALL);
        intent.putExtra("position", position);
        startActivity(intent);

    }

    public void onPlaceClick(View view) {
        int  place = -1;

        switch (view.getId()){
            case R.id.place_externo:
                place = AppData.PLACE_EXTERNO;
                        break;
            case R.id.place_interno:
                place = AppData.PLACE_INTERNO;
                break;
            case R.id.place_labs:
                place = AppData.PLACE_LABS;
                break;
        }

        Intent intent = new Intent(this.getContext(), SliderImageActivity.class);
        intent.putExtra("place", place);
        intent.putExtra("position", 0);
        startActivity(intent);
    }
}