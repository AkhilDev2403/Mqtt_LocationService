package com.example.Mqtt;

public class Model {
    private String Uuid;
    private String Major;
    private String Mayor;

    public Model() {
    }

    public Model(String uuid, String major, String mayor) {
        Uuid = uuid;
        Major = major;
        Mayor = mayor;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getMayor() {
        return Mayor;
    }

    public void setMayor(String mayor) {
        Mayor = mayor;
    }
}
