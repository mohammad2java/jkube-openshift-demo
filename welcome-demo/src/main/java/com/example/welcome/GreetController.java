package com.example.welcome;

import jakarta.ws.rs.core.MultivaluedMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greet")
public class GreetController {

    @Value("${app.cloud.provider.name:notfound}")
    private String provideName;

    @GetMapping("/info")
    public Map<String, Object> greetWithOtherInfo(@RequestHeader HttpHeaders headers) {
        HashMap<String, Object> ret = new HashMap<>();

        ret.put("provider",provideName);
        ret.put("new field","new field val");
        ret.putAll(headers.asSingleValueMap());

        return ret;
    }


}
