package infocefetcontagem.cartilhacefetcontagem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandableListAdapter extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<Floor> floorList;
    private ArrayList<Floor> originalList;

    public ExpandableListAdapter(Context context, ArrayList<Floor> floorList){

        this.context = context;
        this.floorList = new ArrayList<Floor>();
        this.floorList.addAll(floorList);

        this.originalList = new ArrayList<Floor>();
        this.originalList.addAll(floorList);

    }


    @Override
    public int getGroupCount() {
        return floorList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return floorList.get(groupPosition).getPlaceList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return floorList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return floorList.get(groupPosition).getPlaceList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {

        Floor floor = (Floor)getGroup(groupPosition);

        if(view == null){

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.group_row, null);

        }

        TextView tvFloor = view.findViewById(R.id.textView_floor);
        tvFloor.setText(floor.getNameFloor().trim());

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        Place place = (Place)getChild(groupPosition,childPosition);

        if(view == null){

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_row, null);

        }

        TextView tvNumSala = view.findViewById(R.id.textView_sala);
        TextView tvDescricao  = view.findViewById(R.id.textView_descricao);

        tvNumSala.setText(place.getNumeroSala().trim());
        tvDescricao.setText(place.getDescricao().trim());


        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query){

        query = query.toLowerCase().trim();
        floorList.clear();

        if(query.isEmpty()){
            floorList.addAll(originalList);
        }
        else {

            for(Floor floor: originalList){

                ArrayList<Place> placeList = floor.getPlaceList();

                ArrayList<Place> newList = new ArrayList<Place>();
                for(Place place: placeList){
                    if(place.getNumeroSala().toLowerCase().contains(query) ||
                            place.getDescricao().toLowerCase().contains(query)){
                        newList.add(place);
                    }
                }
                if(newList.size() > 0){
                    Floor nFloor = new Floor(floor.getNumberFloor(),newList);
                    floorList.add(nFloor);
                }
            }
        }

        notifyDataSetChanged();
    }

}
