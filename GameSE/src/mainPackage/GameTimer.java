package mainPackage;

/**
 * Die Klasse GameTimer dient dazu, die Gesamtspielzeit zu messen, indem der Startzeitpunkt gespeichert wird
 * und dann die Differenz zur Endzeit gemessen wird.
 */

public class GameTimer {
    private long gameStart;

    // Call this method when the game starts
    public void startGame() {
        gameStart = System.currentTimeMillis();
    }

    // Call this method when the game ends
    public void endGame() {
        long totalTime = System.currentTimeMillis() - gameStart;
        System.out.println("Total game time: " + totalTime + " ms");
    }
}


