import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssassinMain {
    public static void main(String[] args) {
        List<String> names = readNamesFromFile("names.txt");
        AssassinManager manager = new AssassinManager(names);

        System.out.println("Welcome to Assassin Game!");
        System.out.println("Current kill ring:");
        manager.printKillRing();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        while (!manager.isGameOver()) {
            System.out.print("Enter the name of the person assassinated: ");
            String victim = scanner.nextLine();

            if (manager.killRingContains(victim)) {
                manager.kill(victim);
                System.out.println("Successful assassination!");
                System.out.println("Current kill ring:");
                manager.printKillRing();
                System.out.println("Graveyard:");
                manager.printGraveyard();
                System.out.println();
            } else {
                System.out.println("Invalid name. Please try again.");
            }
        }

        String winner = manager.winner();
        System.out.println("Game over. The winner is: " + winner);
    }

    private static List<String> readNamesFromFile(String fileName) {
        List<String> names = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                if (!name.isEmpty()) {
                    names.add(name);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }

        return names;
    }
}