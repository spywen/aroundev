package com.around.dev.utils.enums;

/**
 * Created by laurent on 27/07/2014.
 */
public enum EnumStoryStatus {
    OPEN ("open"),
    STANDBY ("standby"),
    CLOSE ("close");

    private String name = "";

    //Constructeur
    EnumStoryStatus(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
