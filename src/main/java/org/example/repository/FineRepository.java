package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Fine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FineRepository {
    private final ObjectMapper mapper = new ObjectMapper();
    public List<Fine> loadFines(String filePath){
        try{
            return mapper.readValue(new File(filePath), new TypeReference<List<Fine>>(){});
        }catch(IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
