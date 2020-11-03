package com.epam.tasks.dto;

public class AirportInfo {

    private String name;
    private String shortName;
    private String someName;

    public AirportInfo() {
    }

    public AirportInfo(String name, String shortName, String someName) {
        this.name = name;
        this.shortName = shortName;
        this.someName = someName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSomeName() {
        return someName;
    }

    public void setSomeName(String someName) {
        this.someName = someName;
    }
}
