package infocefetcontagem.cartilhacefetcontagem;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class TransportFragment extends Fragment {

    ArrayList<Transporte> transportList = new ArrayList<Transporte>();
    TransportArrayAdapter adapter;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        Resources res = getResources();
        String[] transportString = res.getStringArray(R.array.array_transport);

        for(int i=0;i<5;i++){


            transportList.add(
                    new Transporte(transportString[0 + 4*i],
                    transportString[1 + 4*i],
                    transportString[2 + 4*i],
                    transportString[3 + 4*i])
            );

        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.transport_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.list_view_transport);

        adapter = new TransportArrayAdapter(container.getContext(),transportList);
        listView.setAdapter(adapter);

        return view;

    }



}