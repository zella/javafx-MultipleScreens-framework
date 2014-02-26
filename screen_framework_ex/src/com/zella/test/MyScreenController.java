package com.zella.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.zella.mdiframework.AbstractScreenController;

public class MyScreenController extends AbstractScreenController {

	public void gotoLogin() {
		try {

			// TODO extra params to controller for initialise
			LoginController login = (LoginController) setScreen("/com/zella/test/loginctrl.fxml");
			// This we can call controllers methods

		}

		catch (Exception ex) {
			Logger.getLogger(MyScreenController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public void gotoNext() {
		try {
			NextController next = (NextController) setScreen("/com/zella/test/nextctrl.fxml");
		}

		catch (Exception ex) {
			Logger.getLogger(MyScreenController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

}
