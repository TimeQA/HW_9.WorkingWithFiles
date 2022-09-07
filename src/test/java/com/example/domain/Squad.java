package com.example.domain;

import java.lang.reflect.Array;
import java.util.List;

public class Squad {
    private String squadName;
    private String homeTown;
    private Integer formed;
    private String secretBase;
    private Boolean active;

    public String[] getPowers() {
        return powers;
    }

    private String[] powers;
    public String getSquadName() {
        return squadName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public Integer getFormed() {
        return formed;
    }

    public String getSecretBase() {
        return secretBase;
    }

    public Boolean getActive() {
        return active;
    }
}
