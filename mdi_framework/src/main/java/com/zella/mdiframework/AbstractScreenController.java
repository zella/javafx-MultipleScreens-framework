package com.zella.mdiframework;

import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public abstract class AbstractScreenController extends StackPane {

	protected Initializable setScreen(String fxml) {
		FXMLLoader loader = new FXMLLoader();
		InputStream is = AbstractScreenController.class
				.getResourceAsStream(fxml);
		Parent page = null;
		try {
			try {
				page = (Parent) loader.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		replacePage(page);

		Initializable controller = (Initializable) loader.getController();

		((IControlledScreen) controller).setScreenParent(this);

		return controller;
	}

	protected void setScreen(Parent page) {
		if (page instanceof IControlledScreen)
			((IControlledScreen) page).setScreenParent(this);
		else
			throw new ClassCastException(
					"Your screen should implement IControlledScreen interface");
		replacePage(page);
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

}
