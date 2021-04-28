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
    private static List<Photo> photoList;

    public static void inicializeData(){
        inicializePhotoData();
        inicializeSectorData();

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

        photoList.add(new Photo("Entrada do Campus", R.drawable.gallery_entrada1, PLACE_EXTERNO));
        photoList.add(new Photo("Entrada do Campus", R.drawable.gallery_entrada2,PLACE_EXTERNO));
        photoList.add(new Photo("Rampa de acesso ao prédio", R.drawable.gallery_rampa,PLACE_EXTERNO));
        photoList.add(new Photo("Prédio Principal", R.drawable.visao1,PLACE_EXTERNO));
        photoList.add(new Photo("Prédio Principal e Campo", R.drawable.gallery_predio_campo,PLACE_EXTERNO));
        photoList.add(new Photo("Escada de acesso ao campo", R.drawable.gallery_escada,PLACE_EXTERNO));
        photoList.add(new Photo("Campo de Futebol", R.drawable.gallery_campo1,PLACE_EXTERNO));
        photoList.add(new Photo("Campo de Futebol", R.drawable.gallery_campo2,PLACE_EXTERNO));
        photoList.add(new Photo("Campo de Futebol", R.drawable.gallery_campo3,PLACE_EXTERNO));
        photoList.add(new Photo("Vista do Espaço Externo", R.drawable.gallery_vista1,PLACE_EXTERNO));
        photoList.add(new Photo("Vista Superior do Campus", R.drawable.gallery_vista2,PLACE_EXTERNO));

        photoList.add(new Photo("Biblioteca", R.drawable.gallery_biblioteca,PLACE_INTERNO));
        photoList.add(new Photo("Auditório", R.drawable.gallery_auditorio, PLACE_INTERNO));
        photoList.add(new Photo("Corredor do 5ª andar", R.drawable.gallery_corredor,PLACE_INTERNO));
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

        sectorArrayList = new ArrayList<Sector>();
        Sector sector;

        sectorArrayList.add(new Sector(null,"Comissão Local do Ensino Remoto", "caa-cn@cefetmg.br",
                new String[]{"Profa. Glenda Aparecida de Carvalho (Presidente)" }));

        sectorArrayList.add(
                new Sector(null,"Diretoria do Campus Contagem", "dc-cn@cefetmg.br",
                        new String[]{"Prof. Gustavo Campos Menezes (Diretor)",
                                "Luana Aparecida Barbosa Braga \n(Diretora Adjunta)"}));

        sectorArrayList.add(new Sector("CAA","Coordenação de Assuntos Acadêmicos",
                "caa-cn@cefetmg.br",
                new String[]{"Profa. Glenda Aparecida de Carvalho"}));

        sector = new Sector("BIBCON","Biblioteca",
                "bibcon@cefetmg.br",
                new String[]{"Fabiana Pés do Nascimento",
                        "Francilene Ramos Lourenço Soares (Chefe)",
                        "Webert Júnio Araújo"});
        sector.setSocial("@bibliotecacefetcontagem");
        sector.setUrlSocial("https://www.instagram.com/bibliotecacefetcontagem/");

        sectorArrayList.add(sector);

        sector = new Sector("CDE","Coordenação de Desenvolvimento Estudantil",
                "cde-cn@cefetmg.br",
                new String[]{"Clarice de Paula Gouveia",
                        "Dilene Pinheiro da Silva",
                        "Luiza Moraes Candido (Chefe)"});

        sector.setDescription("more details");

        sectorArrayList.add(sector);

        sectorArrayList.add(new Sector("CRA","Coordenação de Registro Acadêmico",
                "cra-cn@cefetmg.br",
                new String[]{"Cassia Beatriz da Silva",
                "Dheison Ramos de Sousa (Chefe)",
                "Viviane de Paula Zamboni"}));

        sectorArrayList.add(new Sector(null,"Coordenação do Curso Técnico em Controle Ambiental",
                "meirelles@cefetmg.br",
                new String[]{"Prof. Roberto Meireles Glória (Coordenador)" }));

        sectorArrayList.add(new Sector(null,"Coordenação do Curso Técnico em Eletroeletrônica", "emersonalves@cefetmg.br",
                new String[]{"Prof. Emerson Alves da Silva (Coordenador)" }));

        sectorArrayList.add(new Sector(null,"Coordenação do Curso Técnico em Informática",
                "alissonrs@cefetmg.br",
                new String[]{"Prof. Alisson Rodrigo dos Santos (Coordenador)"}));

        sector = new Sector(null,"Secretaria / Recepção","caa-cn@cefetmg.br",
                new String[]{"Clébia Silva", "Luciana de Freitas Setragni"});

        sector.setPhone(new String[]{"(31) 3368-4300 / 3368-4302"});

        sectorArrayList.add(sector);


    }

    public static ArrayList<Sector> getSectorArrayList() {
        return sectorArrayList;
    }


}
