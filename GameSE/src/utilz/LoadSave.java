package utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Diese Klasse enthält Methoden zum Laden von Ressourcen, wie Bilder und Level.
 */
public class LoadSave {

	public static final String PLAYER_ATLAS = "player_sprites2.png";
	public static final String LEVEL_ATLAS = "outside_sprites.png";
	public static final String MENU_BUTTONS = "finalH.png";
	public static final String MENU_BACKGROUND = "Menu1.png";
	public static final String USER = "user.png";
	public static final String LOGIN = "login.png";
	public static final String PAUSE_BACKGROUND = "pause.png";
	public static final String SOUND_BUTTONS = "sound_button.png";
	public static final String URM_BUTTONS = "urm_buttons.png";
	public static final String VOLUME_BUTTONS = "volume_buttons.png";
	public static final String MENU_BACKGROUND_IMG = "background_menu (1).jpg";
	public static final String PLAYING_BG_IMG = "nature.jpg";
	//public static final String BIG_CLOUDS = "big_clouds.png";
	//public static final String SMALL_CLOUDS = "small_clouds.png";
	public static final String CRABBY_SPRITE = "final.png";
	public static final String STATUS_BAR = "health_power_bar.png";
	public static final String COMPLETED_IMG = "completed.png";
	public static final String POTION_ATLAS = "potions_sprites.png";
	public static final String CONTAINER_ATLAS = "objects_sprites.png";
	public static final String TRAP_ATLAS = "fire.png";
	public static final String CANNON_ATLAS = "cannon_atlas.png";
	public static final String CANNON_BALL = "cake.png";
	public static final String DEATH_SCREEN = "you_dead.png";
	public static final String OPTIONS_MENU = "options.png";
	public static final String PINKSTAR_ATLAS = "pinkstar_atlas (1).png";
	public static final String QUESTION_ATLAS = "question_atlas.png";
	public static final String EXCLAMATION_ATLAS = "exclamation_atlas.png";
	public static final String SHARK_ATLAS = "shark_atlas (1).png";
	public static final String CREDITS = "credits_list.png";
	public static final String GRASS_ATLAS = "grass_atlas.png";
	public static final String TREE_ONE_ATLAS = "tree_one_atlas copy.png";
	public static final String TREE_TWO_ATLAS = "tree_two_atlas (1).png";
	public static final String GAME_COMPLETED = "Game_completed (1).png";
	public static final String RAIN_PARTICLE = "rain_particle.png";
	public static final String WATER_TOP = "waterblue.png";
	public static final String WATER_BOTTOM = "water1.png";

	
	/**
     * Lädt das Sprite-Atlas für einen gegebenen Dateinamen.
     *
     * @param fileName Der Dateiname des Sprite-Atlas.
     * @return Das geladene BufferedImage.
     */
	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
		try {
			img = ImageIO.read(is);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}

	/**
     * Lädt alle Level-Bilder aus dem "/lvls"-Verzeichnis und gibt sie als Array zurück.
     *
     * @return Ein Array von BufferedImage für alle Level.
     */
	public static BufferedImage[] GetAllLevels() {
		URL url = LoadSave.class.getResource("/lvls");
		File file = null;

		try {
			file = new File(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		File[] files = file.listFiles();
		File[] filesSorted = new File[files.length];

		for (int i = 0; i < filesSorted.length; i++)
			for (int j = 0; j < files.length; j++) {
				if (files[j].getName().equals((i + 1) + ".png"))
					filesSorted[i] = files[j];

			}

		BufferedImage[] imgs = new BufferedImage[filesSorted.length];

		for (int i = 0; i < imgs.length; i++)
			try {
				imgs[i] = ImageIO.read(filesSorted[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}

		return imgs;
	}

}