package infocefetcontagem.cartilhacefetcontagem.models;

import java.util.ArrayList;
import java.util.List;

import infocefetcontagem.cartilhacefetcontagem.R;

public class PlaceHeader {

    private String description;
    private int photoId;

    private List<PlaceHeader> headers;

    public PlaceHeader(){
        initializeData();
    };

    private PlaceHeader(String description, int photoId){
        this.description = description;
        this.photoId = photoId;
    }

    public String getDescription() {
        return description;
    }

    public int getPhotoId() {
        return photoId;
    }

    public List<PlaceHeader> getHeaders() {
        return headers;
    }

    public void initializeData(){
        headers = new ArrayList<>();
        headers.add(new PlaceHeader("Áreas Externas", R.drawable.visao1));
        headers.add(new PlaceHeader("Laboratórios", R.drawable.gallery_lab_camb1));
        headers.add(new PlaceHeader("Outros Espaços", R.drawable.gallery_corredor));

    }
}
