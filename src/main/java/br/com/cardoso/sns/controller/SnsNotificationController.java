package br.com.cardoso.sns.controller;

import br.com.cardoso.sns.service.SnsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnsNotificationController {

    private final SnsService snsService;

    public SnsNotificationController(SnsService snsService) {
        this.snsService = snsService;
    }

    @GetMapping("send/http/notification")
    public String sendNotification() {
        snsService.sendHttpNotification();
        return "ok";
    }
}
