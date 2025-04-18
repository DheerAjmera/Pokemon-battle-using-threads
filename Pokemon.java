// Pokemon.java

import java.util.Random;

public class Pokemon {
    // Declare attributes for the Pokémon's name, type, health, moves, and damage values
    private String name;
    private String type;
    private int hp;
    private String[] moves;
    private int[] damageValues;
    private Random rand = new Random();  // Random object for selecting moves

    // Constructor to initialize Pokémon with name, type, moves, and damage values
    public Pokemon(String name, String type, String[] moves, int[] damageValues) {
        this.name = name;
        this.type = type;
        this.hp = 30;  
        this.moves = moves;
        this.damageValues = damageValues;
    }

    // Method to simulate an attack by the Pokémon on an opponent
    public void attack(Pokemon opponent) {
        // If the Pokémon has fainted, it cannot attack
        if (hp == 0) {
            System.out.println(name + " has fainted and cannot attack.");
            return;
        }
        // Randomly select a move from the available moves
        int index = rand.nextInt(moves.length);
        String selectedMove = moves[index];
        int damage = damageValues[index];

        // Output the selected move and apply damage to the opponent
        System.out.println(name + " uses " + selectedMove + "!");
        opponent.takeDamage(damage);
    }

    // Method to reduce the Pokémon's HP when it takes damage
    public void takeDamage(int damage) {
        // If the Pokémon has fainted, it cannot take more damage
        if (hp == 0) return;

        // Subtract the damage from the Pokémon's HP
        hp -= damage;
        if (hp < 0) hp = 0;  // Ensure HP doesn't go below 0

        // Output the damage and the current HP after the attack
        System.out.println(name + " takes " + damage + " damage! [HP: " + hp + "]");

        // If HP reaches 0, the Pokémon faints
        if (hp == 0) {
            System.out.println(name + " has fainted!");
        }
    }

    // Method to simulate defending against an attack
    public void defend() {
        // If the Pokémon is still alive, it can defend
        if (hp > 0)
            System.out.println(name + " defends against the attack!");
    }

    // Method to simulate the Pokémon running away from danger
    public void run() {
        // If the Pokémon is still alive, it can attempt to run
        if (hp > 0)
            System.out.println(name + " dodges and runs to safety!");
    }

    // Getter method for HP
    public int getHp() {
        return hp;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for type
    public String getType() {
        return type;
    }
}
