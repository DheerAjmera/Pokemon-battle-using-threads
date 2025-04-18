// PokemonThread.java

public class PokemonThread implements Runnable {
    // Declare the Pokémon object and its opponent
    private Pokemon pokemon;
    private Pokemon opponent;

    // Constructor to initialize the Pokémon
    public PokemonThread(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    // Method to set the opponent for the Pokémon
    public void setOpponent(Pokemon opponent) {
        this.opponent = opponent;
    }

    @Override
    public void run() {
        // Print a message when a Pokémon enters the battle
        System.out.println(pokemon.getName() + " (" + pokemon.getType() + " type) enters the battle!");

        // Simulate the battle for up to 10 rounds
        for (int round = 1; round <= 10; round++) {
            // If either Pokémon's HP reaches 0, end the battle early
            if (pokemon.getHp() == 0 || opponent.getHp() == 0) {
                break;
            }

            // Perform a round of actions (attack, defend, etc.)
            performRound();
        }
        // After the battle ends, display the final HP of the Pokémon
        System.out.println("\n== Battle Summary for " + pokemon.getName() + " ==");
        System.out.println(pokemon.getName() + " Final HP: " + pokemon.getHp());
    }

    // Method to simulate the actions taken during a round of battle
    private void performRound() {
        try {
            // Pokémon attacks the opponent
            pokemon.attack(opponent);
            Thread.sleep(400);  // Simulate time for attack action

            // If the opponent is still alive, it defends and Pokémon runs
            if (opponent.getHp() > 0) {
                pokemon.defend();
                Thread.sleep(300);  // Simulate time for defending

                pokemon.run();  // Pokémon attempts to run away
                Thread.sleep(300);  // Simulate time for running
            }
        } catch (InterruptedException e) {
            // Handle interruptions during the battle round
            System.out.println(pokemon.getName() + "'s round was interrupted.");
        }
    }
}
