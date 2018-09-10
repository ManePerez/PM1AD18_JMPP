package perez.manuel.loginpasodeargumentos.models;

import java.io.Serializable;

public class Usuario implements Serializable{
    private String usuario;
    private String password;
    private String apellidoP;
    private String apellidoM;
    private String email;

    public Usuario(String usuario, String password, String apellidoP, String apellidoM, String email) {
        this.usuario = usuario;
        this.password = password;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
    }

    public Usuario() {
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
