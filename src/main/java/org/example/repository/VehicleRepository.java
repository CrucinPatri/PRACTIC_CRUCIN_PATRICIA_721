package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Fine;
import org.example.model.TrafficEvent;
import org.example.model.Vehicle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VehicleRepository {
    private final ObjectMapper mapper = new ObjectMapper();
    public List<Vehicle > loadVehicles(String filePath){
        try{
            return mapper.readValue(new File(filePath), new TypeReference<List<Vehicle>>(){});
        }catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
