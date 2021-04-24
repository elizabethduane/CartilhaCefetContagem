package infocefetcontagem.cartilhacefetcontagem.models;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import infocefetcontagem.cartilhacefetcontagem.R;

public class AppData {

    //define the photo's group
    public static final int PLACE_ALL = -1;
    public static final int PLACE_EXTERNO = 0;
    public static final int PLACE_LABS = 1;
    public static final int PLACE_INTERNO = 2;

    private static ArrayList<Sector> sectorArrayList;
    private static ArrayList<Transporte> transporteArrayList;
    private static List<Photo> photoList;

    public static void inicializeData(){
        inicializePhotoData();
        inicializeSectorData();

    }
    public AppData(ArrayList<String> listAllPlace) {

      /*  sectorArrayList = new ArrayList<Sector>();
        ArrayList<Place> placeArrayList = new ArrayList<Place>();
        int floor, previewFloor = 0;

        Sector currentSector = new Sector(0);

        for (String linha : listAllPlace) {

            String[] dados = linha.split(";");
            floor = Integer.parseInt(dados[0]);

            if (floor != previewFloor) {
                currentSector.setPlaceList(placeArrayList);

                sectorArrayList.add(currentSector);
                currentSector = new Sector(floor);

                placeArrayList = new ArrayList<Place>();
                previewFloor = floor;
            }
            placeArrayList.add(new Place(dados[1], dados[2]));

        }

        //currentSector.setPlaceList(placeArrayList);
        sectorArrayList.add(currentSector);
*/

    }

    public ArrayList<Sector> getData(){
        return sectorArrayList;

    }

    public static List<Photo> getPhotos(){

        if(photoList == null)
            inicializePhotoData();

        return photoList;
    }

    public static List<Photo> getPhotosByPlace(int place){

        if(photoList == null)
            inicializePhotoData();

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



    private static void inicializePhotoData(){
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

    private static void inicializeSectorData(){

        //Resources res = getResources();
        //String[] transportString = res.getStringArray(R.array.array_transport);
        sectorArrayList = new ArrayList<Sector>();

      /*  String[] dataSplit;
        for(String row: sectorStringArray){
            dataSplit = row.split(";");

            sectorArrayList.add(new Sector(dataSplit[1],dataSplit[2],dataSplit[3], dataSplit[4],dataSplit[5]));
        }
*/
        sectorArrayList.add(new Sector(null,"Comissão Local do Ensino Remoto",
                "Profa. Glenda Aparecida de Carvalho (Presidente)","caa-cn@cefetmg.br",null));
        sectorArrayList.add(new Sector(null,"Diretoria do Campus Contagem",
                null,"dc-cn@cefetmg.br",null));
        sectorArrayList.add(new Sector("CAA","Coordenação de Assuntos Acadêmicos",
                "Profa. Glenda Aparecida de Carvalho","caa-cn@cefetmg.br",null));
        sectorArrayList.add(new Sector("BIBCON","Biblioteca",
                "Questões referentes a: empréstimo e devolução de livros didáticos " +
                "e livros do acervo em geral, orientações sobre acesso à Biblioteca Virtual e às " +
                        "bases eletrônicas assinadas pelo CEFET- MG, orientações sobre " +
                "consulta e reserva no sistema da biblioteca (Sophia).","bibcon@cefetmg.br","@bibliotecacefetcontagem"));

        sectorArrayList.add(new Sector("CDE","Coordenação de Desenvolvimento Estudantil",
                null,"cde-cn@cefetmg.br",null));
        sectorArrayList.add(new Sector("CRA","Coordenação de Registro Acadêmico",
                null,"cra-cn@cefetmg.br",null));
        sectorArrayList.add(new Sector(null,"Coordenação do Curso Técnico em Controle Ambiental",
                "Prof. Roberto Meireles Glória (Coordenador)","meirelles@cefetmg.br",null));
        sectorArrayList.add(new Sector(null,"Coordenação do Curso Técnico em Eletroeletrônica",
                "Prof. Emerson Alves da Silva (Coordenador)","emersonalves@cefetmg.br",null));
        sectorArrayList.add(new Sector(null,"Coordenação do Curso Técnico em Informática",
                "Alisson Rodrigo dos Santos (Coordenador)","alissonrs@cefetmg.br",null));
        sectorArrayList.add(new Sector(null,"Secretaria / Recepção",
                null,"caa-cn@cefetmg.br",null));

    }

    public static ArrayList<Sector> getSectorArrayList() {
        return sectorArrayList;
    }


}
