package infocefetcontagem.cartilhacefetcontagem.models;

import java.io.Serializable;
import java.util.ArrayList;

import infocefetcontagem.cartilhacefetcontagem.R;

public class Sector implements Serializable {

    private String cod;
    private String title;
    private String description;
    private String email;
    private String social;

   // private int idImg;

   // private final int[] images = new int[]{R.drawable.};
   // private final ArrayList<Place> placeList = new ArrayList<Place>();
    //private ArrayList<Contact> placeList = new ArrayList<Place>();

    public Sector(String cod, String title, String description, String email, String social){
        this.cod = cod;
        this.title = title;
        this.description = description;
        this.email = email;
        this.social = social;
    }

   /* public void setPlaceList(ArrayList<Place> placeList) {
        this.placeList = placeList;
    }*/

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

}
