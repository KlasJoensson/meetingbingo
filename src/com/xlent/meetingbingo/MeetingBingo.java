package com.xlent.meetingbingo;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MeetingBingo extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Just for testing...
	 */
	private static void writeTexts() {
		TileTextGenerator tileTexts = new TileTextGenerator();
		
		ArrayList<String> textStrList = tileTexts.getRandomizeList();
		
		for(int r=0;r<25;r++) {
			if (r%5 == 0 && r != 0)
				System.out.println();
			
			System.out.print(textStrList.get(r) + " - ");
			
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Mötes bingo");
		
		GamePad gp = new GamePad("en");
		
		GridPane mainPlane = gp.getGamePad();
		Scene scene = new Scene(mainPlane, 500, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
