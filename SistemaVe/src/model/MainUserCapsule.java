
package model;

public class MainUserCapsule {
    private int idPriv;
    private String namePriv;
    private String emailPriv;
    private String passwordPriv;

    public MainUserCapsule(){
        
    }
    
    public MainUserCapsule(int id, String name, String email, String password) {
        this.idPriv = id;
        this.namePriv = name;
        this.emailPriv = email;
        this.passwordPriv = password;
    }

    public int getId_user() {
        return idPriv;
    }

    public void setId_user(int id) {
        this.idPriv = id;
    }

    public String getName_user() {
        return namePriv;
    }

    public void setName_user(String name) {
        this.namePriv = name;
    }

    public String getEmail_user() {
        return emailPriv;
    }

    public void setEmail_user(String email) {
        this.emailPriv = email;
    }

    public String getPassword_user() {
        return passwordPriv;
    }

    public void setPassword_user(String password) {
        this.passwordPriv = password;
    }
    
    
    
}
