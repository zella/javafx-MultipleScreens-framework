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

		// TODO animations in extra protected method

		if (!getChildren().isEmpty())
			getChildren().remove(0); // remove the displayed screen
		getChildren().add(page);

		Initializable controller = (Initializable) loader.getController();

		((IControlledScreen) controller).setScreenParent(this);

		return controller;
	}

}
