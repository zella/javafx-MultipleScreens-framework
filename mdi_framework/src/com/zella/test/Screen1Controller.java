package com.zella.test;

import java.net.URL;
import java.util.ResourceBundle;

import com.zella.mdiframework.AbstractScreenController;
import com.zella.mdiframework.IControlledScreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Screen1Controller implements Initializable, IControlledScreen {

	MyScreenController myController;

	@FXML
	TextField label;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private void goToScreen2(ActionEvent event) {
		myController.gotoScreen2(label.getText());
	}

	@Override
	public void setScreenParent(AbstractScreenController screenController) {
		myController = (MyScreenController) screenController;

	}

}
