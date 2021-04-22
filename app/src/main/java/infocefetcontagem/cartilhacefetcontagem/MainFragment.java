package infocefetcontagem.cartilhacefetcontagem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Arrays;

import infocefetcontagem.cartilhacefetcontagem.adapters.ExpandableListAdapter;
import infocefetcontagem.cartilhacefetcontagem.models.Floor;
import infocefetcontagem.cartilhacefetcontagem.models.LoadData;

public class MainFragment extends Fragment {

    ArrayList<Floor> floorList;
    ExpandableListAdapter adapter;
    ExpandableListView listView;
    ViewFlipper viewFlipper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        ArrayList<String> placeArrayListAll = new ArrayList<String>();
        placeArrayListAll.addAll(Arrays.asList(getResources().getStringArray(R.array.array_place)));

        LoadData ld = new LoadData(placeArrayListAll);
        floorList = ld.getData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        listView = (ExpandableListView) view.findViewById(R.id.listViewFloor);

        adapter = new ExpandableListAdapter(container.getContext(),floorList);
        listView.setAdapter(adapter);

        //start the first floor expanded
        listView.expandGroup(0);


        /*int images[] = {R.drawable.visao1, R.drawable.portaria_campus2, R.drawable.predio2};

        viewFlipper = view.findViewById(R.id.view_flipper);

        for(int image:images){
            flipperImages(image, container);
        }*/


        return view;

    }

    public  void flipperImages(int image, ViewGroup container){
        ImageView imageView = new ImageView(container.getContext());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

       // viewFlipper.setInAnimation(container.getContext(), R.anim.transicao_fade_in);
       // viewFlipper.setOutAnimation(container.getContext(), R.anim.transicao_fade_in);

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView =  (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.filterData(newText);
                expandAll();
                return false;
            }
        });
    }

    private void expandAll() {
        int count = adapter.getGroupCount();
        for (int i = 0; i < count; i++){
            listView.expandGroup(i);
        }
    }
}