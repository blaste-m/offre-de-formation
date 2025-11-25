package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ut3.miage.tpconceptionsi.enums.Command;
import org.ut3.miage.tpconceptionsi.enums.Keyword;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.UE;
import org.ut3.miage.tpconceptionsi.models.Year;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CommandService {

    private final UEService ueService;
    private final DegreeService degreeService;

    private Degree currentDegree;
    private Year currentYear;

    public String parse(String s) {

        if (s == null || s.trim().isEmpty())
            return "[ Empty command ] Enter 'help' for available commands, or 'quit' to exit";

        String[] input = s.split("\\s+");

        Command[] commands = Command.values();
        if (!Arrays.toString(commands).contains(input[0])) return "Unknown command " + input[0];
        Command command = Command.valueOf(input[0]);

        if (input.length < 2) return "The command " + command + " must be followed by a keyword";

        Keyword[] keywords = command.getKeywords();
        if (!Arrays.toString(keywords).contains(input[1]))
            return "The command " + command + " must be followed by one of these keywords: "
                    + Arrays.toString(keywords);

        Keyword keyword = Keyword.valueOf(input[1]);

        String[] args = Arrays.copyOfRange(input, 2, input.length);

        switch ( command ) {
            case CREATE :
                switch ( keyword ) {
                    case DEGREE :
                        try {
                            Degree degree = degreeService.createDegree(args);
                            return "Degree created: " + degree.getName();
                        } catch (Exception e) {
                            return e.getMessage();
                        }
                    case UE :
                        try {
                            UE ue = ueService.createUE(currentYear, args);
                            return "UE " + ue.getName() + " has been associated with year "
                                    + currentYear.getId().getYear() + " of degree " + currentYear.getDegree().getName();
                        } catch (Exception e) {
                            return e.getMessage();
                        }
                }
            case SELECT :
                switch ( keyword ) {
                    case DEGREE :
                        try {
                            this.currentDegree = degreeService.selectDegree(args);

                            this.currentYear = currentDegree.getYears()
                                    .stream().findFirst()
                                    .orElseThrow(() -> new IllegalStateException("Degree " + currentDegree.getName() + " has no years"));

                            return "Degree selected: " + currentDegree + " [default year:  " + currentYear.getId().getYear() + "]";
                        } catch (Exception e) {
                            return e.getMessage();
                        }
                    case YEAR :
                        try {
                            if (currentDegree == null)
                                return "No degree selected. Please select a degree first";

                            this.currentYear = degreeService.selectYear(currentDegree, args);
                            return "Year " + currentYear.getId().getYear()
                                    + " selected for degree " + currentDegree.getName();
                        } catch (Exception e) {
                            return e.getMessage();
                        }
                }

            default :
                return "The command " + command + " " + keyword + " is not yet implemented";
        }
    }

}
