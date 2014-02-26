package com.zella.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.zella.mdiframework.AbstractScreenController;

public class MyScreenController extends AbstractScreenController {

	public void gotoScreen1() {
		try {

			// TODO extra params to controller for initialise
			Screen1Controller login = (Screen1Controller) setScreen("/com/zella/test/screen1.fxml");
			// This we can call controllers methods

		}

		catch (Exception ex) {
			Logger.getLogger(MyScreenController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public void gotoScreen2() {
		try {
			Screen2Controller next = (Screen2Controller) setScreen("/com/zella/test/screen2.fxml");
		}

		catch (Exception ex) {
			Logger.getLogger(MyScreenController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

}
