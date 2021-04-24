package infocefetcontagem.cartilhacefetcontagem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import infocefetcontagem.cartilhacefetcontagem.models.Sector;
import infocefetcontagem.cartilhacefetcontagem.R;
import infocefetcontagem.cartilhacefetcontagem.models.Place;

public class ExpandableListAdapter extends BaseExpandableListAdapter{
    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

   /* private Context context;
    private ArrayList<Sector> sectorList;
    private ArrayList<Sector> originalList;

    public ExpandableListAdapter(Context context, ArrayList<Sector> sectorList){

        this.context = context;
        this.sectorList = new ArrayList<Sector>();
        this.sectorList.addAll(sectorList);

        this.originalList = new ArrayList<Sector>();
        this.originalList.addAll(sectorList);

    }


    @Override
    public int getGroupCount() {
        return sectorList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return sectorList.get(groupPosition).getPlaceList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return sectorList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return sectorList.get(groupPosition).getPlaceList().get(childPosition);
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

        Sector sector = (Sector)getGroup(groupPosition);

        if(view == null){

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.group_row, null);

        }

        TextView tvFloor = view.findViewById(R.id.textView_floor);
        tvFloor.setText(sector.getNameFloor().trim());

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
        sectorList.clear();

        if(query.isEmpty()){
            sectorList.addAll(originalList);
        }
        else {

            for(Sector sector : originalList){

                ArrayList<Place> placeList = sector.getPlaceList();

                ArrayList<Place> newList = new ArrayList<Place>();
                for(Place place: placeList){
                    if(place.getNumeroSala().toLowerCase().contains(query) ||
                            place.getDescricao().toLowerCase().contains(query)){
                        newList.add(place);
                    }
                }
                if(newList.size() > 0){
                    Sector nSector = new Sector(sector.getNumberFloor(),newList);
                    sectorList.add(nSector);
                }
            }
        }

        notifyDataSetChanged();
    }
*/
}
