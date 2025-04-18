# Pokemon-Battle-using-Threading
This Pokémon Battle Simulator project allows two Pokémon to battle each other using threading to simulate actions in real time. Each Pokémon has its own set of moves with corresponding damage values. The battle includes attacking, defending, and running. The program tracks HP and ends when one Pokémon faints.

## Features
- Multithreading: Each Pokémon runs in its own thread, alternating turns in a synchronized manner.
- Turn-Based Battle Logic: Each Pokémon uses one of its 4 unique moves randomly during its turn.
- Damage Calculation: Every move inflicts random damage (e.g., 5–10 HP).
- HP System: Both Pokémon start with 30 HP, and the battle continues until one faints.
- Fair Turn Order: Each battle randomly decides who goes first.
- Proper Thread Exit: Threads exit gracefully after the battle ends — no hanging or deadlocks.
- Final HP Summary: Displays final HP of both Pokémon after the battle ends.

## Project Structure
- Main.java             : Entry point of the program
- Pokemon.java          : Defines the Pokémon class with attributes and methods
- PokemonThread.java    : Runnable class that controls each Pokémon's actions in a thread
- BattleManager.java    : Shared lock, turn, and battleOver flag for thread coordination

## Technologies Used
- Java (JDK 8+)
- Core Java Threads (Runnable, synchronized, wait/notifyAll)

## How to Run
- Clone the repository: https://github.com/Ameya2137/Pokemon-Battle-using-Threading.git
- Navigate to the project directory: cd Pokemon-Battle-using-Threading
- Compile the Java files: javac *.java
- Run the program: java Main
