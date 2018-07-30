package infocefetcontagem.cartilhacefetcontagem;

import java.util.ArrayList;

public class LoadData {

    private ArrayList<Floor> floorArrayList;
    private ArrayList<Transporte> transporteArrayList;

    public LoadData(ArrayList<String> listAllPlace) {

        floorArrayList = new ArrayList<Floor>();
        ArrayList<Place> placeArrayList = new ArrayList<Place>();
        int floor, previewFloor = 0;

        Floor currentFloor = new Floor(0);

        for (String linha : listAllPlace) {

            String[] dados = linha.split(";");
            floor = Integer.parseInt(dados[0]);

            if (floor != previewFloor) {
                currentFloor.setPlaceList(placeArrayList);

                floorArrayList.add(currentFloor);
                currentFloor = new Floor(floor);

                placeArrayList = new ArrayList<Place>();
                previewFloor = floor;
            }
            placeArrayList.add(new Place(dados[1], dados[2]));

        }

        currentFloor.setPlaceList(placeArrayList);
        floorArrayList.add(currentFloor);


    }

    public ArrayList<Floor> getData(){
        return floorArrayList;

    }


}
