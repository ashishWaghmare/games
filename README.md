# Problem Statement

Write a program that lets two players play tic-tac-toe against each other. Here's the sequence of things that happen when the program executes:
1. Program starts, prints out an empty grid.
1. The program then prompts for Player 1 name, followed by their preferred symbol; assigns a default 'X'.
1. Same for Player 2 name, followed by their preferred symbol; assigns a default 'O'.
1. Players take turns making their move. If a step is illegal or invalid, the program prints out the error and asks them to enter again.
1. The game continues until it's over, when the game is over, it announces the result.

## Build

You need Java 8 installed on machine.

On windows
 
    gradlew.bat clean jar
On linux
 
    gradlew clean jar

## Run

    java -jar build/libs/tic-tac-toe-1.0-SNAPSHOT.jar 

## Implementation
Based on GRASP principals below could be classes

Nouns

Game : tic-tac-toe
Methods:
      over

Grid:
   empty

Players:
    name
    preferred-symbol: (X : 0)
Verbs:

## Testing

Horizontal and Vertical cases are passing. But diagonal check for winner has failed 

### Known Issues
Diagonal grid check will not present winner
