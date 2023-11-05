package org.example.commands;

import java.util.HashMap;
import java.util.Map;

public enum ECommandType {
    MEANGRADECOMMAND("-1"), GRADEACOMMAND("-2"), SEARCHCOMMAND("-3"),
    DBMEANGRADE("-4"), DBGRADEA("-5"), DBSEARCH("-6");
    private final String title;

    static final Map<String, ECommandType> typeMap = new HashMap<>();

    static {
        for (ECommandType type : ECommandType.values()) {
            typeMap.put(type.title, type);
        }
    }

    public static ECommandType getType(String type) {
        return typeMap.get(type);
    }

    ECommandType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
