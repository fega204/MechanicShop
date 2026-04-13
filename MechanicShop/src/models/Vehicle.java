package models;

public class Vehicle {
    protected int id;
    protected String make;
    protected String model;

    public Vehicle(){}
    public Vehicle(int id,String make,String model){
        this.id=id; this.make=make; this.model=model;
    }
    public int getId(){ return id; }
    public String getMake(){ return make; }
    public String getModel(){ return model; }
}