package com.zella.mdiframework;

import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public abstract class AbstractScreenController extends StackPane {

	protected Initializable setScreen(String fxml) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		InputStream is = AbstractScreenController.class
				.getResourceAsStream(fxml);
		// TODO what is this, DO IT?
		// loader.setBuilderFactory(new JavaFXBuilderFactory());
		// loader.setLocation(MyScreenController.class.getResource(fxml));
		Parent page = null;
		try {
			page = (Parent) loader.load(is);
		}

		finally {
			is.close();
		}

		replacePage(page);

		Initializable controller = (Initializable) loader.getController();

		((IControlledScreen) controller).setScreenParent(this);

		return controller;
	}

	/**
	 * You can make animation in this method
	 * 
	 * @param page
	 */
	protected void replacePage(Parent page) {
		// basicaly no animation
		if (!getChildren().isEmpty())
			getChildren().remove(0);
		getChildren().add(page);
	}

	// TODO refactor
	// TODO different animations on every screen

}
