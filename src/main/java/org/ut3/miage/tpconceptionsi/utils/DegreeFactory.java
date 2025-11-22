package org.ut3.miage.tpconceptionsi.utils;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;

import java.util.Arrays;

public class DegreeFactory implements AbstractFactory<Degree> {

    public static final int ECTS_VALUE = 60;

    @Override
    public Degree create(String... args) throws IllegalArgumentException {

        if (args.length != 5)
            throw new IllegalArgumentException(
                    "Wrong number of arguments for command CREATE DEGREE"
                            + "\nExpected 5 arguments but got " + (args.length)
                            + "\nUsage : CREATE DEGREE <name> <type> <year> <max etu> <ects>"
            );
        
        String name = args[0];
        DegreeType type = getType(args);
        int year = getYear(type, args);
        int maxEtu = getMaxEtu(args);
        int ects = getEctsForDegreeType(type, args);

        return new Degree(name, type, year, maxEtu, ects);

    }



    private DegreeType getType(String[] args) {
        try { return DegreeType.valueOf(args[1]); }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid argument <type>"
                    + "\n<type> must be either one of the following values: "
                    + Arrays.toString(DegreeType.values())
            );
        }
    }

    private int getYear(DegreeType type, String... args) {
        try {
            int year = Integer.parseInt(args[2]);
            if (!validYearForDegreeType(year, type))
                throw new IllegalArgumentException("Invalid argument <year> for " + type + " degree"
                        + "\n<year> must be a positive integer between " + type.getMinYear() + " and " + type.getMaxYear()
                );
            return year;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid argument <year>"
                    + "\n<year> must be an integer"
            );
        }
    }

    private boolean validYearForDegreeType(int year, DegreeType type) {
        return switch (type) {
            case BUT, LICENCE -> year >= 1 && year <= 3;
            case MASTER -> year == 1 || year == 2;
            case LICENCE_PRO -> year == 1;
        };
    }

    private int getMaxEtu(String... args) {
        try { return Integer.parseInt(args[3]); }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid argument <max etu>"
                    + "\n<max etu> must be a positive integer"
            );
        }
    }

    private int getEctsForDegreeType(DegreeType type, String... args) {
        try {
            int ects = Integer.parseInt(args[4]);
            if (ects != ECTS_VALUE)
                throw new IllegalArgumentException("Invalid argument <ects> for " + type + " degree"
                        + "\n<ects> value must be " + ECTS_VALUE + " for a year of study"
                );
            return ects;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid argument <ects>"
                    + "\n<ects> must be an integer"
            );
        }

    }
}
