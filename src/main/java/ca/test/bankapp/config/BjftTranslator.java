package ca.test.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BjftTranslator {

    private static MessageSource messageSource;

    @Autowired
    BjftTranslator(@Qualifier("messageSource") MessageSource msgSource) {
        BjftTranslator.messageSource = msgSource;
    }

    public static String toLocale(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, null, locale);
    }

    public static String toLocale(String key, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, args, locale);
    }

}