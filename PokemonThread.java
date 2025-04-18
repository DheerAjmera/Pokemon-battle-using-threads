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
