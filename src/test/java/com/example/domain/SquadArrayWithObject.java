package com.example.domain;

import java.lang.reflect.Array;
import java.util.List;

public class SquadArrayWithObject {
    private String squadName;
    private String homeTown;
    private Integer formed;
    private String secretBase;
    private Boolean active;

    public Array[] getMembers() {
        return members;
    }

    private Array[] members;

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


    public static class Members {
        private String name;
        private Integer age;
        private String secretIdentity;
        private List<String> powers;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getSecretIdentity() {
            return secretIdentity;
        }

        public List<String> getPowers() {
            return powers;
        }
    }


}
