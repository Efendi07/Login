package com.mnurulefendi202102256.login;

public class CuacaWeatherModel {
    private String main;
    private String description;
    private String icon;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public CuacaWeatherModel(){}

}
