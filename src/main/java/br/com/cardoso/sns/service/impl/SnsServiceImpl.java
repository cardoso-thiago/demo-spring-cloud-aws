package br.com.cardoso.sns.service.impl;

import br.com.cardoso.sns.model.Person;
import br.com.cardoso.sns.service.SnsService;
import io.awspring.cloud.sns.core.SnsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SnsServiceImpl implements SnsService {

    private final SnsTemplate snsTemplate;

    public SnsServiceImpl(SnsTemplate snsTemplate) {
        this.snsTemplate = snsTemplate;
    }

    public void sendHttpNotification() {
        snsTemplate.sendNotification("person-notification", new Person("Isis", 1), "New Person");
    }
}
