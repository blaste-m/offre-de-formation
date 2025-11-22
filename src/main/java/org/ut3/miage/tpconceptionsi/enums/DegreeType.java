package org.ut3.miage.tpconceptionsi.enums;

public enum DegreeType {
    BUT,
    MASTER,
    LICENCE,
    LICENCE_PRO;

    public int getMaxYear() {
        return switch (this) {
            case BUT, LICENCE -> 3;
            case MASTER -> 2;
            case LICENCE_PRO -> 1;
        };
    }

    public int getMinYear() {
        return 1;
    }
}
