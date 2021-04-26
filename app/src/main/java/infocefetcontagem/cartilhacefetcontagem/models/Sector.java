package infocefetcontagem.cartilhacefetcontagem.models;

import java.io.Serializable;

public class Sector implements Serializable {

    private String cod;
    private String title;
    private String description;
    private String email;
    private String social;
    private String[] phone;
    private String urlSocial;


    public Sector(String cod, String title, String email, String[] contacts){
        this.cod = cod;
        this.title = title;
        this.email = email;
        this.nameContacts = contacts;
    }


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

    public String[] getNameContacts() {
        return nameContacts;
    }

    public void setNameContacts(String[] nameContacts) {
        this.nameContacts = nameContacts;
    }

    private String[] nameContacts;

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }

    public String getUrlSocial() {
        return urlSocial;
    }

    public void setUrlSocial(String urlSocial) {
        this.urlSocial = urlSocial;
    }



}
