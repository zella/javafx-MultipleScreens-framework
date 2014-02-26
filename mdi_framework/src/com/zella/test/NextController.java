package com.zella.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.MinimizeIcon;
import jfxtras.labs.scene.control.window.Window;

import com.zella.mdiframework.AbstractScreenController;
import com.zella.mdiframework.IControlledScreen;

public class NextController implements Initializable, IControlledScreen {

	MyScreenController myController;

	@FXML
	private Pane pane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private void goToLogin(ActionEvent event) {
		myController.gotoLogin();
	}

	@FXML
	private void openInternalWindow(ActionEvent event) {

		Window w = new Window("My MDI Window");
		// define the initial window size
		w.setPrefSize(300, 200);
		// either to the left
		w.getLeftIcons().add(new CloseIcon(w));
		// .. or to the right
		w.getRightIcons().add(new MinimizeIcon(w));
		// add some content
		w.getContentPane().getChildren()
				.add(new Label("Content... \nof the window"));
		w.getContentPane().getChildren().add(w);
		// add the window to the canvas
		pane.getChildren().add(w);
	}

	@Override
	public void setScreenParent(AbstractScreenController screenController) {
		myController = (MyScreenController) screenController;

	}

}
