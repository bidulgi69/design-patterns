package org.example.singleflightpattern.configuration;

import org.example.singleflightpattern.domain.MessageService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private final MessageService messageService;

    @Autowired
    public DatabaseInitializer(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClassPathResource resource = new ClassPathResource("data.json");
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(resource.getFile())) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                messageService.saveMessage(
                    (long) jsonObject.get("channel_id"),
                    (long) jsonObject.get("user_id"),
                    (String) jsonObject.get("content")
                ).subscribe();
            }
        }

    }
}
