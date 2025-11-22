package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ut3.miage.tpconceptionsi.enums.Command;
import org.ut3.miage.tpconceptionsi.enums.Keyword;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CommandService {

    private final DegreeService degreeService;

    public String analyze(String s) {

        if (s == null || s.trim().isEmpty())
            return "[ Empty command ] Enter 'help' for available commands, or 'quit' to exit";

        String[] input = s.split("\\s+", -1);

        Command[] commands = Command.values();
        if (!Arrays.toString(commands).contains(input[0])) return "Unknown command " + input[0];
        Command command = Command.valueOf(input[0]);

        if (input.length < 2) return "The command " + command + " must be followed by a keyword";

        Keyword[] keywords = command.getKeywords();
        if (!Arrays.toString(keywords).contains(input[1]))
            return "The command " + command + " must be followed by one of these keywords: " + Arrays.toString(keywords);
        Keyword keyword = Keyword.valueOf(input[1]);

        String[] args = Arrays.copyOfRange(input, 2, input.length);

        switch ( command ) {
            case CREATE :
                switch ( keyword ) {
                    case DEGREE :
                        return degreeService.createDegree(args);
                }

            default :
                return "The command " + command + " " + keyword + " is not yet implemented";
        }
    }

}
