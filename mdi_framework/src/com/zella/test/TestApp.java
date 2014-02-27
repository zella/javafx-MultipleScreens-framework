package com.zella.test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		MyScreenController controller = new MyScreenController();

		Group root = new Group();
		root.getChildren().addAll(controller);
		// set your app dimension
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		// also work with full screen
		// primaryStage.setFullScreen(true);
		primaryStage.show();

		controller.gotoScreen1();
	}

}
