package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.TrafficEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrafficEventRepository {
    private final ObjectMapper mapper = new ObjectMapper();

    public List<TrafficEvent> loadTrafficEvents(String filePath) {
        try {
            return mapper.readValue(new File(filePath), new TypeReference<>() {});
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
