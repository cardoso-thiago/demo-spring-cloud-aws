package br.com.cardoso.sns.controller;

import br.com.cardoso.sns.model.Person;
import io.awspring.cloud.sns.annotation.endpoint.NotificationMessageMapping;
import io.awspring.cloud.sns.annotation.endpoint.NotificationSubscriptionMapping;
import io.awspring.cloud.sns.annotation.handlers.NotificationMessage;
import io.awspring.cloud.sns.annotation.handlers.NotificationSubject;
import io.awspring.cloud.sns.handlers.NotificationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.MessageFormat;

@Controller
@RequestMapping("/sns")
public class SnsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SnsController.class);

    @NotificationSubscriptionMapping
    public void handleSubscriptionMessage(NotificationStatus status) {
        status.confirmSubscription();
    }

    @NotificationMessageMapping
    public void handleNotificationMessage(@NotificationSubject String subject, @NotificationMessage Person person) {
        LOGGER.info(MessageFormat.format("Message received =>  {0} Subject => {1}", person, subject));
    }
}
