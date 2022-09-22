package com.example.Mqtt.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ble_config")
public class BleConfigEntity {

    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy HH:mm:ss", timezone = "UTC")
    private Date created;

    @Column(name = "modified")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy HH:mm:ss", timezone = "UTC")
    private Date modified;

    @Column(name = "name")
    private String name;

    @Column(name = "i_beacon_major",length = 20)
    private int iBeaconMajor;

    @Column(name = "i_beacon_minor", length = 20)
    private int ibeaconMinor;

    @Column(name = "ble_status")
    private int bleStatus;

    @Column(name = "i_beacon_Uuid", length = 120)
    private String ibeaconUuid;

    @Column(name = "site_Id", length = 20)
    private int siteId;

}
