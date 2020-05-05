package com.xlent.meetingbingo;

import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MeetingBingo extends Application {
	
	private VBox mainPlane;
	
	
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
		
		GamePad gp = new GamePad();
		GridPane gamePlane = gp.getGamePad();
		
		VBox menu = new VBox(getMenuBar());
		
		mainPlane = new VBox(menu);
		mainPlane.getChildren().add(gamePlane);
		
		Scene scene = new Scene(mainPlane, 500, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	/**
	 * Creates the menu bar.
	 * 
	 * @return A populated menu bar
	 */
	private MenuBar getMenuBar() {
		Menu fileMenu = new Menu("Arkiv");
		
		
		Menu langMenu = new Menu("Nytt spel");
		MenuItem langEn = new MenuItem("Engelska");
		langEn.setOnAction(enGameEventHandler);
		langMenu.getItems().add(langEn);
		MenuItem langSv = new MenuItem("Svenska");
		langSv.setOnAction(svGameEventHandler);
		langMenu.getItems().add(langSv);
		fileMenu.getItems().add(langMenu);
		
		MenuItem quitGame = new MenuItem("Avsluta");
		quitGame.setOnAction(quitEventHandler);
		fileMenu.getItems().add(quitGame);
		
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(fileMenu);
		
		return menuBar;
	}
	
	/**
	 * Handles clicks on the exit menu item.
	 */
	private EventHandler<ActionEvent> quitEventHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			System.exit(0);
		}
	};
	
	/**
	 * Handles clicks on the new game Swedish menu item.
	 */
	private EventHandler<ActionEvent> svGameEventHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			GamePad gp = new GamePad();
			GridPane gamePlane = gp.getGamePad();
			mainPlane.getChildren().remove(1);
			mainPlane.getChildren().add(gamePlane);
			

		}
	};
	
	/**
	 * Handles clicks on the new game English menu item.
	 */
	private EventHandler<ActionEvent> enGameEventHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			GamePad gp = new GamePad("en");
			GridPane gamePlane = gp.getGamePad();
			mainPlane.getChildren().remove(1);
			mainPlane.getChildren().add(gamePlane);
		}
	};
}
