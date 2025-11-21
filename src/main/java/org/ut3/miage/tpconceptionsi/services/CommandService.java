package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandService {

    private final DegreeService degreeService;

    public String analyze(String command) {

        String message;

        String[] args = command.split("\\s", -1);

        switch (args[0]) {
            case "CREATE" :
                switch (args[1]) {
                    case "DEGREE" :
                        message = createDegree(args[2], args[3], args[4], args[5], args[6]);
                        break;

                    default :
                        message = "The command CREATE must be followed either by the keyword DEGREE, TEACHER or UE";
                }
                break;

            default :
                message = "Unknown command " + args[0];
        }

        return message;
    }

    private String createDegree(String... args) {
        return degreeService.createDegree(args);
    }

}
