package units.exam;
import units.exam.logical.GameLogic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic(sin);
        gameLogic.initializeGame();
        sin.close();
    }
}
