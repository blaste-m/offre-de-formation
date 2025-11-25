package org.ut3.miage.tpconceptionsi.parsers;

import org.springframework.stereotype.Component;
import org.ut3.miage.tpconceptionsi.requests.UECreationRequest;

@Component
public class UEArgumentParser {

    public UECreationRequest parseCreateUE(String... args) throws IllegalArgumentException {

        if (args.length != 5)
            throw new IllegalArgumentException(
                    "Wrong number of arguments for command CREATE UE"
                            + "\nExpected 5 arguments but got " + (args.length)
                            + "\nUsage : CREATE UE <name> <ects> <cm> <td> <tp>"
            );

        String name = args[0];
        int ects = getIntArg("ects", 1, args);
        int cm = getIntArg("cm", 2, args);
        int td = getIntArg("td", 3, args);
        int tp = getIntArg("tp", 4, args);


        return new UECreationRequest(
                name,
                ects,
                cm,
                td,
                tp
        );

    }

    private int getIntArg(String name, int pos, String... args) {
        try { return Integer.parseInt(args[pos]); }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid argument <" + name + ">"
                    + "\n<" + name + "> must be an integer"
            );
        }
    }
}
