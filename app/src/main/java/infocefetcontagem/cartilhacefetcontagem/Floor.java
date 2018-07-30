package infocefetcontagem.cartilhacefetcontagem;

import java.util.ArrayList;

public class Floor {

    private int numberFloor;
    private ArrayList<Place> placeList = new ArrayList<Place>();
    private final String[] nameFloor = {"TÉRREO","1˚ ANDAR","2˚ ANDAR","3˚ ANDAR","4˚ ANDAR","5˚ ANDAR"};

    public Floor(int numberFloor){
        this.numberFloor = numberFloor;
    }

    public Floor(int numberFloor, ArrayList<Place> placeList){
        this.numberFloor = numberFloor;
        this.placeList = placeList;

    }

    public String getNameFloor() {
        return nameFloor[numberFloor];
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }


    public void setPlaceList(ArrayList<Place> placeList) {
        this.placeList = placeList;
    }

    public ArrayList<Place> getPlaceList() {
        return placeList;
    }

}
