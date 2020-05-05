package com.xlent.meetingbingo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class GamePad {

	private static GamePad gamePad;
	private ArrayList<String> textStrList;
	private GridPane gp;
	private static String myLangCode = "sv";
	private TileTextGenerator tileTexts;
	private Logger log = Logger.getLogger(GamePad.class.getName());
	
	/**
	 * Get the current game pad or creates a new a Swedish game pad if non 
	 * exists.
	 * 
	 * @return The game pad
	 */
	public static GamePad getInstance() {
		if (gamePad == null)
			gamePad = new GamePad(myLangCode);
		
		return gamePad;
	}
	
	/**
	 * Get the current game pad if the language matches else it creates a new 
	 * game pad using the language of choice, using the two letter ISO 639-1 
	 * standard.
	 * 
	 * @param langCode The two letters for the wanted language
	 */
	public static GamePad getInstance(String langCode) {
		if (gamePad == null)
			gamePad = new GamePad(langCode);
		
		if (langCode.equalsIgnoreCase(myLangCode)) {
			return gamePad;
		} else {
			gamePad = new GamePad(langCode);
			return gamePad;
		}
			
	}
	
	/**
	 * Creates a game pad using the language of choice, using the two letter 
	 * ISO 639-1 standard.
	 * 
	 * @param langCode The two letters for the wanted language
	 */
	private GamePad(String langCode) {
		myLangCode = langCode;
		tileTexts = new TileTextGenerator();
		tileTexts.setLanguage(langCode);
		textStrList = tileTexts.getRandomizeList();
		
	}
	
	/**
	 * Get the language used by the game pad.
	 * 
	 * @return The two letter ISO 639-1 standard
	 */
	public String getLanguage() {
		return myLangCode;
	}
	
	/**
	 * To get the game pad, if non exists a new will be created.
	 * 
	 * @return The game pad.
	 */
	public GridPane getGamePad() {
		log.info("Gets the game pad using the language: " + myLangCode);
		
		if (gp == null) {
			return getNewGamePad();
		}
		
		return gp;
	}
	
	/**
	 * Creates and returns a new Game pad in the chosen language.
	 * 
	 * @return A new game pad
	 */
	public GridPane getNewGamePad() {
		log.info("Gets a new game pad using the language: " + myLangCode);
		
		gp = new GridPane();
		
		for(int row=0;row<5;row++) {
			for(int col=0;col<5;col++) {
				gp.add(createButton(textStrList.get(row * 5 + col)), col, row);
			}
			
		}
		
		return gp; 
	}
	
	/**
	 * Creates a new game pad with the language set by the parameter.
	 * 
	 * @param langCode The two letters for the wanted language
	 */
	public void createNewGamePad(String langCode) {
		log.info("Creates a new game pad using the language: " + langCode);
		tileTexts.setLanguage(langCode);
		textStrList = tileTexts.getRandomizeList();
	}
	
	/**
	 * Creates a button with the text defined by the parameter. 
	 * 
	 * @param text The text to be written on the button
	 * @return A button to be used on the Game pad
	 */
	private Button createButton(String text) {

		final Button btn = new Button(text);
		btn.setPrefSize(100, 100);
		btn.setWrapText(true);
		btn.setContentDisplay(ContentDisplay.TEXT_ONLY);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (btn.getContentDisplay() == ContentDisplay.TEXT_ONLY) {
					btn.setContentDisplay(ContentDisplay.CENTER);
					btn.setTextFill(new Color(0.75, 0.75, 0.75, 1));
				}
				else {
					btn.setContentDisplay(ContentDisplay.TEXT_ONLY);
					btn.setTextFill(new Color(0.1, 0.1, 0.1, 1));
				}

			}

		});

		try {
			ImageView xImage = getImage("resources/X.png");
			btn.setGraphic(xImage);
		} catch (FileNotFoundException e) {
			log.warning("Could not load the image: " + e.getMessage());
		}

		return btn;
	}

	/**
	 * Creates an images from the file located at the path.
	 * 
	 * @param path The path to the file
	 * @return An image
	 * @throws FileNotFoundException If no file was found
	 */
	private ImageView getImage(String path) throws FileNotFoundException {
		File xImageFile = new File(path);
		InputStream s = new FileInputStream(xImageFile);
		Image i = new Image(s);
		ImageView xImage = new ImageView(i);
		
		return xImage;
	}
}
