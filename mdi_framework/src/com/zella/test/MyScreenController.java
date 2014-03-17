package com.zella.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.util.Duration;

import com.zella.mdiframework.AbstractScreenController;

public class MyScreenController extends AbstractScreenController {

	public void gotoScreen1() {
		try {
			Screen1Controller loginCtrl = (Screen1Controller) setScreen("/com/zella/test/screen1.fxml");
		}

		catch (Exception ex) {
			Logger.getLogger(MyScreenController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public void gotoScreen2(String sampleParams) {
		try {
			Screen2Controller nextCtrl = (Screen2Controller) setScreen("/com/zella/test/screen2.fxml");
			nextCtrl.setParams(sampleParams);
		}

		catch (Exception ex) {
			Logger.getLogger(MyScreenController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	// Make custom animation
	@Override
	protected void replacePage(final Parent page) {
		final DoubleProperty opacity = opacityProperty();

		if (!getChildren().isEmpty()) {
			Timeline fade = new Timeline(new KeyFrame(Duration.ZERO,
					new KeyValue(opacity, 1.0)), new KeyFrame(
					new Duration(100), new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent t) {
							getChildren().remove(0); // remove the displayed
														// screen
							getChildren().add(0, page); // add the
														// screen
							Timeline fadeIn = new Timeline(new KeyFrame(
									Duration.ZERO, new KeyValue(opacity, 0.0)),
									new KeyFrame(new Duration(1000),
											new KeyValue(opacity, 1.0)));
							fadeIn.play();
						}
					}, new KeyValue(opacity, 0.0)));
			fade.play();

		} else {
			getChildren().add(page);
			Timeline fadeIn = new Timeline(new KeyFrame(Duration.ZERO,
					new KeyValue(opacity, 0.0)), new KeyFrame(
					new Duration(1000), new KeyValue(opacity, 1.0)));
			fadeIn.play();
		}
	}

}
