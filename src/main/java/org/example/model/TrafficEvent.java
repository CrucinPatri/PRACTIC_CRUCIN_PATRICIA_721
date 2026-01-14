package org.example.model;

public class TrafficEvent {
    private int id;
    private int vehicle;
    private EventType type;
    private int severity;
    private int timeSlot;

    public TrafficEvent() {}

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public int getVehicle(){return vehicle;}
    public void setVehicle(int vehicle){this.vehicle=vehicle;}

    public EventType getType(){return type;}
    public void setType(EventType type){this.type=type;}

    public int getSeverity(){return severity;}
    public void setSeverity(int severity){this.severity=severity;}

    public int getTimeSlot(){return timeSlot;}
    public void setTimeSlot(int timeSlot){this.timeSlot=timeSlot;}
}


