// Main.java

// Name: Dher Ajmera
// PRN: 2307016035
// Dept: SY-AIML-A2

public class Main {
    public static void main(String[] args) {
        // Print header for the Pokémon Battle Simulator
        System.out.println("=== Pokémon Battle Simulator ===");

        // Define Pikachu's moves and damage
        String[] pikachuMoves = {"Thunderbolt", "Wild Charge", "Iron Tail", "Quick Attack"};
        int[] pikachuDamage = {8, 10, 6, 4};

        // Define Snivy's moves and damage
        String[] snivyMoves = {"Leaf Storm", "Vine Whip", "Tackle", "Magical Leaf"};
        int[] snivyDamage = {10, 6, 5, 7};

        // Creating Pokémon objects with their name, type, moves, and damage values
        Pokemon pikachu = new Pokemon("Pikachu", "Electric", pikachuMoves, pikachuDamage);
        Pokemon snivy = new Pokemon("Snivy", "Grass", snivyMoves, snivyDamage);

        // Creating threads to simulate battles for each Pokémon
        PokemonThread pikachuThread = new PokemonThread(pikachu);
        PokemonThread snivyThread = new PokemonThread(snivy);

        // Set the opponent for each thread (to allow Pokémon to battle each other)
        pikachuThread.setOpponent(snivy);
        snivyThread.setOpponent(pikachu);

        // Creating Thread objects and start the battle
        Thread t1 = new Thread(pikachuThread);
        Thread t2 = new Thread(snivyThread);

        t1.start();  // Start Pikachu's battle thread
        t2.start();  // Start Snivy's battle thread

        // Simulate the battle rounds, allowing 10 rounds for the fight
        for (int i = 1; i <= 10; i++) {
            // If any Pokémon's HP reaches 0, stop the battle
            if (pikachu.getHp() == 0 || snivy.getHp() == 0) {
                break;
            }

            // Displaying the current round number
            System.out.println("\n--- Round " + i + " ---");

            try {
                // Pause for 1 second to simulate time between rounds
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle any interruptions in the main thread
                System.out.println("Main thread interrupted.");
            }
        }
    }
}
