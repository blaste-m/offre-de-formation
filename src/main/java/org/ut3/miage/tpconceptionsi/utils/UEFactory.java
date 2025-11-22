package org.ut3.miage.tpconceptionsi.utils;

import org.ut3.miage.tpconceptionsi.models.UE;

public class UEFactory implements AbstractFactory<UE> {

    @Override
    public UE create(String... args) {

        if (args.length != 5) {
            throw new IllegalArgumentException(
                    "Wrong number of arguments for command CREATE UE"
                            + "\nExpected 5 arguments but got " + (args.length)
                            + "\nUsage : CREATE UE <name> <ects> <cm> <td> <tp>"
            );
        }

        String nom = args[0];
        int ects = getEcts(args);
        int cm = getCm(args);
        int td = getTd(args);
        int tp = getTp(args);

        return new UE(nom, ects, cm, td, tp);
    }


    private int getEcts(String... args) {
        try {
            int ects = Integer.parseInt(args[1]);
            if (ects <= 0) throw new IllegalArgumentException("Invalid argument <ects>"
                        + "\n<ects> must be a positive integer"
                );

            return ects;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid argument <ects>"
                    + "\n<ects> must be an integer"
            );
        }

    }

    private int getCm(String... args) {
        try {
            int cm = Integer.parseInt(args[2]);
            if (cm < 0) throw new IllegalArgumentException("Invalid argument <cm>"
                        + "\n<cm> must be a non-negative integer"
                );
            return cm;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid argument <cm>"
                    + "\n<cm> must be an integer"
            );
        }

    }

    private int getTd(String... args) {
        try {
            int td = Integer.parseInt(args[3]);
            if (td < 0) throw new IllegalArgumentException("Invalid argument <td>"
                        + "\n<td> must be a non-negative integer"
                );
            return td;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid argument <td>"
                    + "\n<td> must be an integer"
            );
        }
    }

    private int getTp(String... args) {
        try {
            int tp = Integer.parseInt(args[4]);
            if (tp < 0) throw new IllegalArgumentException("Invalid argument <tp>"
                        + "\n<tp> must be a non-negative integer"
                );
            return tp;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid argument <tp>"
                    + "\n<tp> must be an integer"
            );
        }
    }



}
