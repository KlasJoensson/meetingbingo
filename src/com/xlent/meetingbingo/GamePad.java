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

	private ArrayList<String> textStrList;
	private Logger log = Logger.getLogger(GamePad.class.getName());
	
	public GamePad(String langCode) {
		TileTextGenerator tileTexts = new TileTextGenerator();
		tileTexts.setLanguage(langCode);
		textStrList = tileTexts.getRandomizeList();
	}
	
	public GamePad() {
		TileTextGenerator tileTexts = new TileTextGenerator();
		textStrList = tileTexts.getRandomizeList();
	}
	
	public GridPane getGamePad() {
		GridPane gp = new GridPane();
		
		for(int row=0;row<5;row++) {
			for(int col=0;col<5;col++) {
				gp.add(createButton(textStrList.get(row * 5 + col)), col, row);
			}
			
		}
		
		return gp;
	}
	
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

	private ImageView getImage(String path) throws FileNotFoundException {
		File xImageFile = new File(path);
		InputStream s = new FileInputStream(xImageFile);
		Image i = new Image(s);
		ImageView xImage = new ImageView(i);
		
		return xImage;
	}
}
