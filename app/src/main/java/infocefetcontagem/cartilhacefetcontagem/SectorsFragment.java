package infocefetcontagem.cartilhacefetcontagem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import infocefetcontagem.cartilhacefetcontagem.adapters.SectorRecyclerViewAdapter;
import infocefetcontagem.cartilhacefetcontagem.models.AppData;
import infocefetcontagem.cartilhacefetcontagem.models.Sector;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SectorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectorsFragment extends Fragment implements SectorRecyclerViewAdapter.OnSectorItemListener {

    private List<Sector> mSectorList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SectorsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SectorsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SectorsFragment newInstance(String param1, String param2) {
        SectorsFragment fragment = new SectorsFragment();
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
        View view = inflater.inflate(R.layout.fragment_sectors, container, false);

        RecyclerView recyclerViewSector = (RecyclerView) view.findViewById(R.id.recycler_view_sector);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewSector.setLayoutManager(linearLayoutManager);

        mSectorList = AppData.getSectorArrayList();

        recyclerViewSector.setAdapter(new SectorRecyclerViewAdapter(mSectorList,this));

        return view;
    }

    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "onItemClick: " + position);
    }
}