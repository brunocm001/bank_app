package ca.test.bankapp.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
@Slf4j
public class BjftLocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    @Value("${app.resources.path}")
    private String resourcesPath;

    private final List<Locale> locales = Arrays.asList(
            new Locale("fr"),
            new Locale("en"));

    @SuppressWarnings("NullableProblems")
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        return headerLang == null || headerLang.isEmpty()
                ? Locale.getDefault()
                : Locale.lookup(Locale.LanguageRange.parse(
                        headerLang.replaceAll("[^a-zA-Z]*", "")), this.locales);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource rs = new ReloadableResourceBundleMessageSource();
        rs.setBasenames("messages", "file:" + this.resourcesPath + "/messages");
        log.info("\n\n{}\n", rs.getBasenameSet());
        rs.setCacheSeconds(600);
        rs.setDefaultEncoding("UTF-8");
        rs.setUseCodeAsDefaultMessage(true);
        return rs;
    }

}