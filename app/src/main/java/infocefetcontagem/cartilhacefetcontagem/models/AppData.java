package infocefetcontagem.cartilhacefetcontagem.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import infocefetcontagem.cartilhacefetcontagem.R;
import infocefetcontagem.cartilhacefetcontagem.models.Floor;
import infocefetcontagem.cartilhacefetcontagem.models.Place;
import infocefetcontagem.cartilhacefetcontagem.models.Transporte;

import static android.content.ContentValues.TAG;
import static infocefetcontagem.cartilhacefetcontagem.models.Photo.PLACE_EXTERNO;
import static infocefetcontagem.cartilhacefetcontagem.models.Photo.PLACE_INTERNO;
import static infocefetcontagem.cartilhacefetcontagem.models.Photo.PLACE_LABS;

public class AppData {

    private static ArrayList<Floor> floorArrayList;
    private static ArrayList<Transporte> transporteArrayList;
    private static List<Photo> photoList;

    public AppData(ArrayList<String> listAllPlace) {

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

    public static List<Photo> getPhotos(){

        if(photoList == null)
            inicializeData();

        return photoList;
    }

    public static List<Photo> getPhotosByPlace(int place){

        if(photoList == null)
            inicializeData();

        //get all photos
        List<Photo> filteredPhotos = new ArrayList<>();

        if(photoList != null){
            for (Photo photo: photoList) {
                if(photo.getPlace() == place)
                    filteredPhotos.add(photo);

            }
        }

        return filteredPhotos;

    }


    private static void inicializeData(){
        photoList = new ArrayList<>();

        photoList.add(new Photo("Entrada", R.drawable.gallery_entrada1, PLACE_EXTERNO));
        photoList.add(new Photo("Entrada", R.drawable.gallery_entrada2,PLACE_EXTERNO));
        photoList.add(new Photo("Rampa de acesso ao prédio", R.drawable.gallery_rampa,PLACE_EXTERNO));
        photoList.add(new Photo("Rampa de acesso ao prédio", R.drawable.visao1,PLACE_EXTERNO));
        photoList.add(new Photo("Escada de acesso ao campo", R.drawable.gallery_escada,PLACE_EXTERNO));
        photoList.add(new Photo("Campo de Futebol", R.drawable.gallery_campo1,PLACE_EXTERNO));
        photoList.add(new Photo("Campo de Futebol", R.drawable.gallery_campo2,PLACE_EXTERNO));
        photoList.add(new Photo("Campo de Futebol", R.drawable.gallery_campo3,PLACE_EXTERNO));
        photoList.add(new Photo("Campo de Futebol", R.drawable.gallery_vista1,PLACE_EXTERNO));
        photoList.add(new Photo("Campo de Futebol", R.drawable.gallery_vista2,PLACE_EXTERNO));

        photoList.add(new Photo("Biblioteca", R.drawable.gallery_biblioteca,PLACE_INTERNO));
        photoList.add(new Photo("Corredor", R.drawable.gallery_corredor,PLACE_INTERNO));
        photoList.add(new Photo("Sala de Aula", R.drawable.gallery_sala,PLACE_INTERNO));
        photoList.add(new Photo("Sala de Artes", R.drawable.gallery_sala_artes1,PLACE_INTERNO));
        photoList.add(new Photo("Sala de Artes", R.drawable.gallery_sala_artes2,PLACE_INTERNO));
        photoList.add(new Photo("Sala de Artes", R.drawable.gallery_sala_artes3,PLACE_INTERNO));

        photoList.add(new Photo("Laboratório de Controle Ambiental", R.drawable.gallery_lab_camb1,PLACE_LABS));
        photoList.add(new Photo("Laboratório de Controle Ambiental", R.drawable.gallery_lab_camb2,PLACE_LABS));
        photoList.add(new Photo("Laboratório de Controle Ambiental", R.drawable.gallery_lab_camb3,PLACE_LABS));
        photoList.add(new Photo("Laboratório de Controle Ambiental", R.drawable.gallery_lab_camb4,PLACE_LABS));
        photoList.add(new Photo("Laboratório de Controle Ambiental", R.drawable.gallery_lab_camb5,PLACE_LABS));

        photoList.add(new Photo("Laboratório de Eletroeletrônica", R.drawable.gallery_lab_elelt1,PLACE_LABS));
        photoList.add(new Photo("Laboratório de Eletroeletrônica", R.drawable.gallery_lab_elelt2,PLACE_LABS));
        photoList.add(new Photo("Laboratório de Eletroeletrônica", R.drawable.gallery_lab_elelt3,PLACE_LABS));

        photoList.add(new Photo("Laboratório de Informática", R.drawable.gallery_lab_info1,PLACE_LABS));
        photoList.add(new Photo("Laboratório de Informática", R.drawable.gallery_lab_info2,PLACE_LABS));
        photoList.add(new Photo("Laboratório de Informática", R.drawable.gallery_lab_info3,PLACE_LABS));
        photoList.add(new Photo("Laboratório de Informática", R.drawable.gallery_lab_info4,PLACE_LABS));

    }



}
