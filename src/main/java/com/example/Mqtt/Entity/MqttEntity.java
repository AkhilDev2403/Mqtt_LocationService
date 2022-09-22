package com.example.Mqtt.Entity;

import javax.persistence.*;

@Entity
@Table
public class MqttEntity {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false, length = 150)
    public String Uuid;

    @Column(nullable = false, length = 20)
    public int Major;

    @Column(nullable = false, length = 20)
    public int Minor;

    public MqttEntity() {
    }


    public MqttEntity(Long id, String uuid, int major, int minor) {
        this.id = id;
        Uuid = uuid;
        Major = major;
        Minor = minor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }

    public int getMajor() {
        return Major;
    }

    public void setMajor(int major) {
        Major = major;
    }

    public int getMinor() {
        return Minor;
    }

    public void setMinor(int minor) {
        Minor = minor;
    }
}
