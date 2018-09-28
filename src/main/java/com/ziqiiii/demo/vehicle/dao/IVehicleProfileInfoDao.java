package com.ziqiiii.demo.vehicle.dao;

import com.ziqiiii.demo.vehicle.entity.VehicleProfileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * create by ziqi.zhang on 2018/9/20
 */
@Repository
public interface IVehicleProfileInfoDao extends JpaRepository<VehicleProfileInfo, String> {


    @Query("from VehicleProfileInfo where vin = :vin")
    VehicleProfileInfo findByVin(@Param("vin") String vin);

}
