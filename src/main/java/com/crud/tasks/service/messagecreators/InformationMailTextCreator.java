package com.crud.tasks.service.messagecreators;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class InformationMailTextCreator implements MailTextCreator {
    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Override
    public String createMailMessage(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "Best regards");
        context.setVariable("company_name", adminConfig.getCompanyName());
        context.setVariable("company_address", adminConfig.getCompanyAddress());
        return templateEngine.process("mail/information-mail", context);
    }
}
