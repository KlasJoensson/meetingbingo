package com.xlent.meetingbingo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameMenuBar {

	private Pane mainPlane;
	
	public GameMenuBar(Pane mainPlane) {
		this.mainPlane = mainPlane;
	}
	
	/**
	 * Creates the menu bar.
	 * 
	 * @return A populated menu bar
	 */
	public MenuBar getMenuBar() {
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
			GamePad gp = GamePad.getInstance("sv");
			GridPane gamePlane = gp.getNewGamePad();
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
			GamePad gp = GamePad.getInstance("en");
			GridPane gamePlane = gp.getNewGamePad();
			mainPlane.getChildren().remove(1);
			mainPlane.getChildren().add(gamePlane);
		}
	};
}
