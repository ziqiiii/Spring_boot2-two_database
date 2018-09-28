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

    @Column(name = "iccid")
    private String iccid;

    @Column(name = "msisdn")
    private String msisdn;

    public  VehicleProfileInfo(){

    }

    public VehicleProfileInfo(String vehicleId,String vin, String iccid, String msisdn){
        this.id = vehicleId;
        this.vin = vin;
        this.iccid = iccid;
        this.msisdn = msisdn;
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

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Override
    public String toString() {
        return "VehicleProfileInfo{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", iccid='" + iccid + '\'' +
                ", msisdn='" + msisdn + '\'' +
                '}';
    }
}