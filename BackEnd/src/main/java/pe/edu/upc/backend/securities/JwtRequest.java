package pe.edu.upc.backend.securities;

import java.io.Serializable;

/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//Clase 4
@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;

    public JwtRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

    public JwtRequest(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}