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
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.show();

		controller.gotoLogin();
	}

}
