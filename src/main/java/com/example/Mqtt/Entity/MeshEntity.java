package com.example.Mqtt.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mesh")
public class MeshEntity {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy HH:mm:ss", timezone = "UTC")
    private Date created;

    @Column(name = "modified")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy HH:mm:ss", timezone = "UTC")
    private Date modified;

    @Column(name = "name", length = 100)
    private String name;

    @Column(length = 100)
    private String macAddress;

    @Column(length = 50)
    private String slug;

    @Column(length = 200)
    private float valueX;

    @Column(length = 200)
    private float valueY;

    @Column(length = 20)
    private int floorId;

    @Column(length = 20)
    private int siteId;

    @Column(length = 20)
    private int departmentId;

    @Column(length = 20)
    private int zoneId;


}
