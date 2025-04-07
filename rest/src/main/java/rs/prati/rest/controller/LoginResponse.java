package rs.prati.rest.controller;

/**
 * DTO класа која представља одговор сервера након успешне пријаве.
 */
public class LoginResponse {
    private String token;
    private String username;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
