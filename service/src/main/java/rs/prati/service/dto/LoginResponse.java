package rs.prati.service.dto;

/**
 * DTO одговор након успешне пријаве.
 * Враћа access и refresh токене, као и основне податке о кориснику.
 */
public class LoginResponse {

    private String accessToken;
    private String refreshToken;
    private UserDto user;

    public LoginResponse() {}

    public LoginResponse(String accessToken, String refreshToken, UserDto user) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.user = user;
    }

    public String getAccessToken() { return accessToken; }

    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

    public String getRefreshToken() { return refreshToken; }

    public void setRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }

    public UserDto getUser() { return user; }

    public void setUser(UserDto user) { this.user = user; }
}

