package com.oneusop.cms.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafUtil {
    private static TemplateEngine templateEngine;

    static {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode("XHTML");
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }

    public static TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
}
