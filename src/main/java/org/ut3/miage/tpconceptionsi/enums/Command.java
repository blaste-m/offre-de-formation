package org.ut3.miage.tpconceptionsi.enums;

public enum Command {
    GET, TRACE,
    CREATE, EDIT,
    ASSIGN, SELECT;

    public Keyword[] getKeywords() {
        return switch (this) {
            case TRACE -> new Keyword[]{ Keyword.GRAPH };
            case EDIT, ASSIGN -> new Keyword[]{ Keyword.UE };
            case GET -> new Keyword[]{ Keyword.COVER, Keyword.TOTAL };
            case SELECT -> new Keyword[]{ Keyword.DEGREE, Keyword.YEAR };
            case CREATE -> new Keyword[]{ Keyword.DEGREE, Keyword.TEACHER, Keyword.UE };
        };
    }
}
