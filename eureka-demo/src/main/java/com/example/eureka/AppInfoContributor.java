package com.example.eureka;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class AppInfoContributor implements InfoContributor {

    @Value("${spring.application.name:NA}")
    private String appName;
    private String nodeId;
    private String uptime;

    @PostConstruct
    public void init() {
        this.nodeId = UUID.randomUUID().toString();
        this.uptime = LocalDateTime.now().toString();
    }

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> updateDetails = new LinkedHashMap<>();
        updateDetails.put("AppName", appName);
        updateDetails.put("NodeId", nodeId);
        updateDetails.put("Uptime", uptime);
        builder.withDetails(updateDetails);
    }
}
