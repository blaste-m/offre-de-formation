package org.ut3.miage.tpconceptionsi.enums;

public enum Command {
    CREATE,
    UPDATE,
    DELETE,
    SELECT;


    public Keyword[] getKeywords() {
        return switch (this) {
            case CREATE -> new Keyword[]{ Keyword.DEGREE, Keyword.TEACHER, Keyword.UE };
            case UPDATE -> new Keyword[]{ Keyword.UE };
            case DELETE -> new Keyword[]{ Keyword.DEGREE, Keyword.TEACHER };
            case SELECT -> new Keyword[]{ Keyword.DEGREE, Keyword.YEAR };
        };
    }
}
