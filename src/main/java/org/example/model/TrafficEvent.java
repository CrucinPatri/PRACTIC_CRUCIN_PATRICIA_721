package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrafficEvent {
    private int id;

    @JsonProperty("vehicleId") // Asta rezolvă eroarea din consolă!
    private int vehicleId;

    private EventType type;
    private int severity;
    private int timeSlot;

    public TrafficEvent() {}

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public int getVehicleId(){return vehicleId;}
    public void setVehicleId(int vehicleId){this.vehicleId=vehicleId;}

    public EventType getType(){return type;}
    public void setType(EventType type){this.type=type;}

    public int getSeverity(){return severity;}
    public void setSeverity(int severity){this.severity=severity;}

    public int getTimeSlot(){return timeSlot;}
    public void setTimeSlot(int timeSlot){this.timeSlot=timeSlot;}

    public int calculateRiskScore() {
        return switch (this.type) {
            case SPEEDING -> severity * 2;
            case RED_LIGHT -> severity * 3;
            case ACCIDENT -> severity * 5;
            case PRIORITY_PASS -> severity * 1;
        };
    }
}


