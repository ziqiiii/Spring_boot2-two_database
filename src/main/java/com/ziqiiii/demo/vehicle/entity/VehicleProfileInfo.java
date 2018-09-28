package com.ziqiiii.demo.vehicle.entity;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;

/**
 * create by ziqi.zhang on 2018/9/20
 */
@Entity
@Table(name = "vehicle_profile")
public class VehicleProfileInfo {

    @SerializedName("vehicle_id")
    @Id
    @Column(name = "id", updatable = false, unique = true, nullable = false)
//    @GeneratedValue(generator = "idGenerator")
    private String id;

    @SerializedName("vin")
    @Column(name = "vin", nullable = false)
    private String vin;

    public  VehicleProfileInfo(){

    }

    public VehicleProfileInfo(String vehicleId,String vin){
        this.id = vehicleId;
        this.vin = vin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }


    @Override
    public String toString() {
        return "VehicleProfileInfo{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}