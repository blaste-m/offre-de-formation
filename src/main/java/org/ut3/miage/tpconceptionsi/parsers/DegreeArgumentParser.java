package org.ut3.miage.tpconceptionsi.parsers;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.requests.DegreeCreationRequest;

import java.util.Arrays;

public class DegreeArgumentParser {

    public DegreeCreationRequest parse(String... args) throws IllegalArgumentException {
        if (args.length != 3)
            throw new IllegalArgumentException(
                    "Wrong number of arguments for command CREATE DEGREE"
                            + "\nExpected 3 arguments but got " + (args.length)
                            + "\nUsage : CREATE DEGREE <name> <type> <max etu>"
            );

        String name = args[0];
        DegreeType type = getType(args);
        int maxEtu = getMaxEtu(args);

        return new DegreeCreationRequest(
                type,
                name,
                maxEtu
        );
    }

    private DegreeType getType(String[] args) throws IllegalArgumentException {
        try { return DegreeType.valueOf(args[1]); }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid argument <type>"
                    + "\n<type> must be either one of the following values: "
                    + Arrays.toString(DegreeType.values())
            );
        }
    }

    private int getMaxEtu(String... args) throws IllegalArgumentException {
        try { return Integer.parseInt(args[2]); }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid argument <max etu>"
                    + "\n<max etu> must be an integer"
            );
        }
    }
}
