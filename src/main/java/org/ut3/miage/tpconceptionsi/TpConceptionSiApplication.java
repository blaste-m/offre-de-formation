package org.ut3.miage.tpconceptionsi;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.ut3.miage.tpconceptionsi.services.CommandService;

import java.util.Scanner;

@RequiredArgsConstructor
@SpringBootApplication
public class TpConceptionSiApplication implements CommandLineRunner {

    private final CommandService commandService;

    public static void main(String[] args) {
        SpringApplication.run(TpConceptionSiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Bienvenue dans Offre de Formation");
        System.out.println("Enter 'help' to display available commands or 'quit' to exit");
        System.out.println("Enter a command:");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equals("quit")) {
                System.out.println("Application exited");
                break;
            }

            String output = commandService.parse(input);
            System.out.println(output);
        }
    }
}
