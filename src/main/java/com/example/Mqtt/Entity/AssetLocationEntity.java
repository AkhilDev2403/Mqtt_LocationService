package com.example.Mqtt.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "assets_location")
public class AssetLocationEntity {

    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy HH:mm:ss", timezone = "UTC")
    private Date created;

    @Column(name = "modified")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy HH:mm:ss", timezone = "UTC")
    private Date modified;

    @Column(name = "mesh_name", length = 100)
    private String meshName;

    @Column(length = 200)
    private float valueX;

    @Column(length = 200)
    private float valueY;

    @Column(name = "lastSeen")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy HH:mm:ss", timezone = "UTC")
    private Date lastSeen;

    @Column(length = 20)
    private int assetId;

    @Column(length = 20)
    private int floorId;

}
