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


    public Sector(String cod, String title, String description, String email, String[] contacts, String social){
        this.cod = cod;
        this.title = title;
        this.description = description;
        this.email = email;
        this.social = social;
        this.contacts = contacts;
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

    public String[] getContacts() {
        return contacts;
    }

    public void setContacts(String[] contacts) {
        this.contacts = contacts;
    }

    private String[] contacts;

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }


}
