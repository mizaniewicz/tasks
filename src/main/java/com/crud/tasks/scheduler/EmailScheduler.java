package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.service.messagecreators.InformationMailTextCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    InformationMailTextCreator informationMailTextCreator;

    @Scheduled(cron = "0 0 15 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String  message = null;
        if (size == 1) {
            message = "Currently in database you got " + size + " task";
        } else {
            message = "Currently in database you got " + size + " tasks";
        }
        simpleEmailService.send(new Mail(adminConfig.getAdminMail(), null, SUBJECT, message), informationMailTextCreator);
    }
}
