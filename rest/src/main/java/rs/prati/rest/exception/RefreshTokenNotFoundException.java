package rs.prati.rest.exception;

/**
 * Изузетак који се баца када refresh токен не постоји.
 */
public class RefreshTokenNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public RefreshTokenNotFoundException(String message) {
        super(message);
    }
}
