package rs.prati.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.OptimisticLockException;
import rs.prati.service.common.MessageService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Глобални handler за све изузетке који се јављају у REST контролерима.
 */
@ControllerAdvice
public class RestExceptionHandler {

    private final MessageService messageService;

    public RestExceptionHandler(MessageService messageService) {
        this.messageService = messageService;
    }
    
    /**
     * Обрада изузетка када refresh токен није пронађен.
     */
    @ExceptionHandler(RefreshTokenNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRefreshTokenNotFoundException(RefreshTokenNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", messageService.getMessage("refresh.notfound"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Обрада изузетка када је refresh токен истекао.
     */
    @ExceptionHandler(RefreshTokenExpiredException.class)
    public ResponseEntity<Map<String, String>> handleRefreshTokenExpiredException(RefreshTokenExpiredException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", messageService.getMessage("refresh.expired"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Обрада изузетка када је refresh токен неважећи.
     */
    @ExceptionHandler(RefreshTokenInvalidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidRefreshTokenException(RefreshTokenInvalidException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", messageService.getMessage("refresh.invalid"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Општи handler за све остале неочекиване изузетке.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", messageService.getMessage("error.unexpected"));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    
    @ExceptionHandler(OptimisticLockException.class)
    public ResponseEntity<Map<String, String>> handleOptimisticLockException(OptimisticLockException ex, Locale locale) {
        Map<String, String> error = new HashMap<>();
        error.put("message", messageService.getMessage("error.optimistic.lock"));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
