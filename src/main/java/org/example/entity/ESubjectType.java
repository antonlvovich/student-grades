package org.example.entity;

import java.util.HashMap;
import java.util.Map;

public enum ESubjectType {
    MATH("math"), PHYS("phys"), RUS("rus"),
    LIT("lit"), GEOM("geom"), INF("inf");
    private final String name;

    static final Map<String, ESubjectType> typeMap = new HashMap<>();

    static {
        for (ESubjectType type : ESubjectType.values()) {
            typeMap.put(type.name, type);
        }
    }

    public static ESubjectType getType(String type) {
        return typeMap.get(type);
    }

    ESubjectType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
