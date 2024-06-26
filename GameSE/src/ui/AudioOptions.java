package ui;

import static utilz.Constants.UI.PauseButtons.SOUND_SIZE;
import static utilz.Constants.UI.VolumeButtons.SLIDER_WIDTH;
import static utilz.Constants.UI.VolumeButtons.VOLUME_HEIGHT;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import mainPackage.Game;

/**
 * Die Klasse AudioOptions repräsentiert die Optionen für Audioeinstellungen im Spiel.
 */
public class AudioOptions {

    private VolumeButton volumeButton;
    private SoundButton musicButton, sfxButton;

    private Game game;

    /**
     * Konstruktor für die AudioOptions-Klasse.
     *
     * @param game Die Instanz des Game-Objekts.
     */
    public AudioOptions(Game game) {
        this.game = game;
        createSoundButtons();
        createVolumeButton();
    }

    private void createVolumeButton() {
        int vX = (int) (309 * Game.SCALE);
        int vY = (int) (278 * Game.SCALE);
        volumeButton = new VolumeButton(vX, vY, SLIDER_WIDTH, VOLUME_HEIGHT);
    }

    private void createSoundButtons() {
        int soundX = (int) (450 * Game.SCALE);
        int musicY = (int) (140 * Game.SCALE);
        int sfxY = (int) (186 * Game.SCALE);
        musicButton = new SoundButton(soundX, musicY, SOUND_SIZE, SOUND_SIZE);
        sfxButton = new SoundButton(soundX, sfxY, SOUND_SIZE, SOUND_SIZE);
    }

    /**
     * Aktualisiert die Audiooptionen.
     */
    public void update() {
        musicButton.update();
        sfxButton.update();
        volumeButton.update();
    }

    /**
     * Zeichnet die Audiooptionen.
     *
     * @param g Die Graphics-Instanz zum Zeichnen.
     */
    public void draw(Graphics g) {
        // Sound buttons
        musicButton.draw(g);
        sfxButton.draw(g);

        // Volume Button
        volumeButton.draw(g);
    }

    /**
     * Behandelt das Ziehen der Maus.
     *
     * @param e Das MouseEvent-Objekt.
     */
    public void mouseDragged(MouseEvent e) {
        if (volumeButton.isMousePressed()) {
            float valueBefore = volumeButton.getFloatValue();
            volumeButton.changeX(e.getX());
            float valueAfter = volumeButton.getFloatValue();
            if (valueBefore != valueAfter)
                game.getAudioPlayer().setVolume(valueAfter);
        }
    }

    /**
     * Behandelt das Drücken der Maus.
     *
     * @param e Das MouseEvent-Objekt.
     */
    public void mousePressed(MouseEvent e) {
        if (isIn(e, musicButton))
            musicButton.setMousePressed(true);
        else if (isIn(e, sfxButton))
            sfxButton.setMousePressed(true);
        else if (isIn(e, volumeButton))
            volumeButton.setMousePressed(true);
    }

    /**
     * Behandelt das Loslassen der Maus.
     *
     * @param e Das MouseEvent-Objekt.
     */
    public void mouseReleased(MouseEvent e) {
        if (isIn(e, musicButton)) {
            if (musicButton.isMousePressed()) {
                musicButton.setMuted(!musicButton.isMuted());
                game.getAudioPlayer().toggleSongMute();
            }
        } else if (isIn(e, sfxButton)) {
            if (sfxButton.isMousePressed()) {
                sfxButton.setMuted(!sfxButton.isMuted());
                game.getAudioPlayer().toggleEffectMute();
            }
        }

        musicButton.resetBools();
        sfxButton.resetBools();
        volumeButton.resetBools();
    }

    /**
     * Behandelt die Bewegung der Maus.
     *
     * @param e Das MouseEvent-Objekt.
     */
    public void mouseMoved(MouseEvent e) {
        musicButton.setMouseOver(false);
        sfxButton.setMouseOver(false);
        volumeButton.setMouseOver(false);

        if (isIn(e, musicButton))
            musicButton.setMouseOver(true);
        else if (isIn(e, sfxButton))
            sfxButton.setMouseOver(true);
        else if (isIn(e, volumeButton))
            volumeButton.setMouseOver(true);
    }

    private boolean isIn(MouseEvent e, PauseButton b) {
        return b.getBounds().contains(e.getX(), e.getY());
    }
}
