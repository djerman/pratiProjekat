package rs.prati.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Глобални handler за све изузетке који се јављају у REST контролерима.
 */
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * Обрада изузетка када refresh токен није пронађен.
     */
    @ExceptionHandler(RefreshTokenNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRefreshTokenNotFoundException(RefreshTokenNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Обрада изузетка када је refresh токен истекао.
     */
    @ExceptionHandler(RefreshTokenExpiredException.class)
    public ResponseEntity<Map<String, String>> handleRefreshTokenExpiredException(RefreshTokenExpiredException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Обрада изузетка када је refresh токен неважећи.
     */
    @ExceptionHandler(RefreshTokenInvalidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidRefreshTokenException(RefreshTokenInvalidException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Општи handler за све остале неочекиване изузетке.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", "Дошло је до неочекиване грешке.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
