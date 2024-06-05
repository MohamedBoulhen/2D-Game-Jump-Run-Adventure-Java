package effects;

import static utilz.Constants.ANI_SPEED;

/**
 * Die Klasse DialogueEffect repräsentiert einen visuellen Effekt für Dialoge im Spiel.
 */
public class DialogueEffect {

    private int x, y, type;
    private int aniIndex, aniTick;
    private boolean active = true;

    /**
     * Konstruktor für ein neues DialogueEffect-Objekt.
     *
     * @param x    Die x-Koordinate des Effekts.
     * @param y    Die y-Koordinate des Effekts.
     * @param type Der Typ des Effekts.
     */
    public DialogueEffect(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * Aktualisiert den Effekt, indem der Animationsindex und die Aktivität basierend auf der Animationsgeschwindigkeit aktualisiert werden.
     */
    public void update() {
        aniTick++;
        if (aniTick >= ANI_SPEED) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(type)) {
                active = false;
                aniIndex = 0;
            }
        }
    }

    /**
     * Gibt die Anzahl der Sprites für einen bestimmten Effekttyp zurück.
     *
     * @param type2 Der Effekttyp.
     * @return Die Anzahl der Sprites für den angegebenen Effekttyp.
     */
    private int GetSpriteAmount(int type2) {
        // TODO: Implementiere diese Methode entsprechend der Spiellogik.
        return 0;
    }

    /**
     * Deaktiviert den Effekt.
     */
    public void deactive() {
        active = false;
    }

    /**
     * Setzt die Position des Effekts zurück und aktiviert ihn.
     *
     * @param x Die neue x-Koordinate.
     * @param y Die neue y-Koordinate.
     */
    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
        active = true;
    }

    /**
     * Gibt den aktuellen Animationsindex des Effekts zurück.
     *
     * @return Der Animationsindex.
     */
    public int getAniIndex() {
        return aniIndex;
    }

    /**
     * Gibt die x-Koordinate des Effekts zurück.
     *
     * @return Die x-Koordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Gibt die y-Koordinate des Effekts zurück.
     *
     * @return Die y-Koordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Gibt den Typ des Effekts zurück.
     *
     * @return Der Typ des Effekts.
     */
    public int getType() {
        return type;
    }

    /**
     * Überprüft, ob der Effekt aktiv ist.
     *
     * @return true, wenn der Effekt aktiv ist, sonst false.
     */
    public boolean isActive() {
        return active;
    }
}
