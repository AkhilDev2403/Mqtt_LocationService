package com.example.Mqtt.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "assets")
public class AssetsEntity {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy HH:mm:ss", timezone = "UTC")
    private Date created;

    @Column(name = "modified")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy HH:mm:ss", timezone = "UTC")
    private Date modified;

    @Column(length = 20)
    private int assetId;

    @Column(length = 20)
    private int siteId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(length = 50)
    private String slug;

    @Column(length = 50)
    private String type;

    @Column(length = 20)
    private int patientStatus;

    @Column(length = 50)
    private String patientType;

    @Column(name = "ble_name_id", length = 20)
    private int bleNameId;

    @Column(name = "gda_department", length = 50)
    private String gdaDepartment;

    @Column(length = 20)
    private int gdaStatus;

    @Column(name = "phone_number")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phoneNumber;

    @Column(length = 20)
    private int maintenance;

}
