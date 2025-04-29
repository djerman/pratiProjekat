package rs.prati.service.common;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * Помоћни сервис за интернационализацију порука.
 */
@Service
public class MessageService {

    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }
}
