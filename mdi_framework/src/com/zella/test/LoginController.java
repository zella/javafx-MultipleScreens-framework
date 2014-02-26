package com.zella.test;

import java.net.URL;
import java.util.ResourceBundle;

import com.zella.mdiframework.AbstractScreenController;
import com.zella.mdiframework.IControlledScreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoginController implements Initializable, IControlledScreen {

	MyScreenController myController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private void goToNext(ActionEvent event) {
		myController.gotoNext();
	}

	@Override
	public void setScreenParent(AbstractScreenController screenController) {
		myController = (MyScreenController) screenController;

	}

}
