package com.xlent.meetingbingo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MeetingBingo extends Application {
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Mötes bingo");
		
		VBox mainPlane = new VBox();
		GamePad gp = GamePad.getInstance("sv");
		GridPane gamePlane = gp.getNewGamePad();
		
		GameMenuBar mb = new GameMenuBar(mainPlane); 
		VBox menu = new VBox(mb.getMenuBar());
			
		mainPlane.getChildren().add(menu);
		mainPlane.getChildren().add(gamePlane);
		
		Scene scene = new Scene(mainPlane, 500, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
