package com.furama.dto;

import com.furama.model.facility.FacilityType;
import com.furama.model.facility.RentType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class FacilityDto {
    private int id;
    @NotEmpty(message = "Tên không đuợc để trống")
    @Pattern(regexp = "^[A-Z][a-z]*([ ][A-Z-Z0-9][a-z-z0-9]*)*$", message = " Tên dịch vụ phải viết hoa chữ cái đầu tiên và phải có số")
    private String name;
    @Positive( message = "Diện tích không được âm")
    private int area;
    @Positive(message = "Giá không được âm")
    private double cost;
    @Positive(message = " Số người là số nguyên dương")
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Positive(message = " Diện tích hồ bơi là số dương")
    private double poolArea;
    @Positive(message = " Số tầng phải là số dương")
    private int numberOfFloor;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;

    public FacilityDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }


}
