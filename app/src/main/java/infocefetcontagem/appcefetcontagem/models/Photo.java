package infocefetcontagem.appcefetcontagem.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import infocefetcontagem.appcefetcontagem.R;

public class Photo implements Serializable {

    private String description;
    private int photoId;
    private int place;

    private static List<Photo> photos;

    //define the photo's group
    public static final int PLACE_EXTERNO = 0;
    public static final int PLACE_LABS = 1;
    public static final int PLACE_INTERNO = 2;

    public Photo(){
        //inicializeData();
    }

    public Photo(String description, int photoId, int place){
        this.description = description;
        this.photoId = photoId;
        this.place = place;
    }
    //get and set
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public static List<Photo> getPhotos() {
        return photos;
    }

    public static Photo getPosition(int i){
        return photos.get(i);
    }

    public static List<Photo> getPhotosByPlace(int place){
        //get all photos
        List<Photo> filteredPhotos = new ArrayList<>();

        if(photos != null){
            for (Photo photo: photos) {
                if(photo.getPlace() == place)
                    filteredPhotos.add(photo);

            }
        }


        //remove which ones that are different from the required place

        return filteredPhotos;

    }

    private void inicializeData(){
        photos = new ArrayList<>();

        photos.add(new Photo("Entrada", R.drawable.gallery_entrada1,PLACE_EXTERNO));
        photos.add(new Photo("Entrada", R.drawable.gallery_entrada2,PLACE_EXTERNO));
        photos.add(new Photo("Rampa de acesso ao prédio", R.drawable.gallery_rampa,PLACE_EXTERNO));
        photos.add(new Photo("Rampa de acesso ao prédio", R.drawable.visao1,PLACE_EXTERNO));
        photos.add(new Photo("Escada de acesso ao campo", R.drawable.gallery_escada,PLACE_EXTERNO));
        photos.add(new Photo("Campo de Futebol", R.drawable.gallery_campo1,PLACE_EXTERNO));
        photos.add(new Photo("Campo de Futebol", R.drawable.gallery_campo2,PLACE_EXTERNO));
        photos.add(new Photo("Campo de Futebol", R.drawable.gallery_campo3,PLACE_EXTERNO));
        photos.add(new Photo("Campo de Futebol", R.drawable.gallery_vista1,PLACE_EXTERNO));
        photos.add(new Photo("Campo de Futebol", R.drawable.gallery_vista2,PLACE_EXTERNO));

        photos.add(new Photo("Biblioteca", R.drawable.gallery_biblioteca,PLACE_INTERNO));
        photos.add(new Photo("Corredor", R.drawable.gallery_corredor,PLACE_INTERNO));
        photos.add(new Photo("Sala de Aula", R.drawable.gallery_sala,PLACE_INTERNO));
        photos.add(new Photo("Sala de Artes", R.drawable.gallery_sala_artes1,PLACE_INTERNO));
        photos.add(new Photo("Sala de Artes", R.drawable.gallery_sala_artes2,PLACE_INTERNO));
        photos.add(new Photo("Sala de Artes", R.drawable.gallery_sala_artes3,PLACE_INTERNO));

        photos.add(new Photo("Laboratório de Controle Ambiental", R.drawable.gallery_lab_camb1,PLACE_LABS));
        photos.add(new Photo("Laboratório de Controle Ambiental", R.drawable.gallery_lab_camb2,PLACE_LABS));
        photos.add(new Photo("Laboratório de Controle Ambiental", R.drawable.gallery_lab_camb3,PLACE_LABS));
        photos.add(new Photo("Laboratório de Controle Ambiental", R.drawable.gallery_lab_camb4,PLACE_LABS));
        photos.add(new Photo("Laboratório de Controle Ambiental", R.drawable.gallery_lab_camb5,PLACE_LABS));

        photos.add(new Photo("Laboratório de Eletroeletrônica", R.drawable.gallery_lab_elelt1,PLACE_LABS));
        photos.add(new Photo("Laboratório de Eletroeletrônica", R.drawable.gallery_lab_elelt2,PLACE_LABS));
        photos.add(new Photo("Laboratório de Eletroeletrônica", R.drawable.gallery_lab_elelt3,PLACE_LABS));

        photos.add(new Photo("Laboratório de Informática", R.drawable.gallery_lab_info1,PLACE_LABS));
        photos.add(new Photo("Laboratório de Informática", R.drawable.gallery_lab_info2,PLACE_LABS));
        photos.add(new Photo("Laboratório de Informática", R.drawable.gallery_lab_info3,PLACE_LABS));
        photos.add(new Photo("Laboratório de Informática", R.drawable.gallery_lab_info4,PLACE_LABS));

    }

}
