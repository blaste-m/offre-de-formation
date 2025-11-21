package org.ut3.miage.tpconceptionsi;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Component;
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
        System.out.println("Entrer 'help' pour afficher la liste de commandes ou 'quit' pour quitter");
        System.out.println("Entrer votre commande");

        while (true) {
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();

            if (input.equals("quit")) {
                System.out.println("Application exited");
                break;
            }

            String output = commandService.analyze(input);
            System.out.println(output);

        }

    }
}
