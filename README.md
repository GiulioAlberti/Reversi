# Reversi (Othello) - SDM project
Repository for the project of the exam "Software Development Methods" @Units.

I worked on a command-line version of the game Reversi, in particular the modern and famous variation called Othello, using Java, Gradle and Sonarcloud.


# Rules

Reversi is a two players strategy board game, played on an 8×8 board. 

There are sixty-four identical game pieces called disks, which are white on one side and black on the other.
For the specific game of Othello, the game begins with four disks placed in a square in the middle of the grid, two facing white-side-up, two black-side-up, so that the same-colored disks are on a diagonal.

Players take turns placing disks on the board with their assigned color facing up.
During a play, any disks of the opponent's color that are in a straight line and bounded by the disk just placed and another disk of the current player's color are turned over to the current player's color.
If one player cannot make a valid move, play passes back to the other player. When neither player can move, the game ends.

The objective of the game is to have the majority of disks turned to display one's color when the last playable empty square is filled.
