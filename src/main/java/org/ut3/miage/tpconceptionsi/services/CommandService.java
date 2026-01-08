package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ut3.miage.tpconceptionsi.enums.Command;
import org.ut3.miage.tpconceptionsi.enums.Keyword;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.Teacher;
import org.ut3.miage.tpconceptionsi.models.UE;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CommandService {

    private final UEService ueService;
    private final DegreeService degreeService;
    private final TeacherService teacherService;

    private Degree currentDegree;

    public String parse(String s) {

        if (s == null || s.trim().isEmpty())
            return "[ Empty command ] Enter 'help' for available commands, or 'exit' to exit";

        String[] input = s.split("\\s+");

        Command[] commands = Command.values();
        if (!Arrays.toString(commands).contains(input[0].toUpperCase())) return "Unknown command " + input[0];
        Command command = Command.valueOf(input[0].toUpperCase());

        if (input.length < 2) return "The command " + command + " must be followed by a keyword or an argument";

        Keyword[] keywords = command.getKeywords();
        if (!Arrays.toString(keywords).contains(input[1].toUpperCase()))
            return "The command " + command + " must be followed by one of these keywords: "
                    + Arrays.toString(keywords);

        Keyword keyword = Keyword.valueOf(input[1].toUpperCase());

        String[] args = Arrays.copyOfRange(input, 2, input.length);

        switch ( command ) {
            case CREATE :
                switch ( keyword ) {
                    case DEGREE :
                        try {
                            Degree degree = degreeService.createDegree(args);
                            return "Success: created degree " + degree.getName() + " [year: " + degree.getYear() + "]";
                        } catch (Exception e) {
                            return e.getMessage();
                        }
                    case UE :
                        try {
                            UE ue = ueService.createUE(currentDegree, args);
                            return "Success: " + ue.getName() + " has been associated with degree "
                                    + currentDegree.getName() + " [year: " + currentDegree.getYear() + "]";
                        } catch (Exception e) {
                            return e.getMessage();
                        }
                    case TEACHER :
                        try {
                            Teacher teacher = teacherService.createTeacher(args);
                            return "Success: created teacher " + teacher.getPrenom() + " " + teacher.getNom();
                        } catch (Exception e) {
                            return e.getMessage();
                        }
                }
            case SELECT :
                switch ( keyword ) {
                    case DEGREE :
                        try {
                            this.currentDegree = degreeService.selectDegree(args);

                            return "Success: selected degree " + currentDegree.getName()
                                    + " [year: " + currentDegree.getYear() + "]";
                        } catch (Exception e) {
                            return e.getMessage();
                        }

                    case YEAR:
                        try {
                            this.currentDegree = degreeService.selectByYear(currentDegree, args);
                            return "Success: selected degree " + currentDegree.getName()
                                    + " [year: " + currentDegree.getYear() + "]";
                        } catch (Exception e) {
                            return e.getMessage();
                        }
                }

            default :
                return "The command " + command + " " + keyword + " is not yet implemented";
        }
    }

}
