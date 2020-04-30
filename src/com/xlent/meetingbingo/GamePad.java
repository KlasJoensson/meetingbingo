package com.xlent.meetingbingo;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class GamePad {

	ArrayList<String> textStrList;
	
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
		Button btn = new Button(text);
		btn.setPrefSize(100, 100);
		btn.setWrapText(true);
		
		return btn;
	}
}
