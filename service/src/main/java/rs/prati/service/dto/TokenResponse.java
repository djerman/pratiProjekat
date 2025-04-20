package rs.prati.service.dto;

/**
 * DTO који представља одговор након успешног освежавања access токена.
 */
public class TokenResponse {

    private String accessToken;
    private String refreshToken;

    public TokenResponse() {
    }

    public TokenResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
