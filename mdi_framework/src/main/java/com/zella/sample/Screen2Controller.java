package com.zella.sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.MinimizeIcon;
import jfxtras.labs.scene.control.window.Window;

import com.zella.mdiframework.AbstractScreenController;
import com.zella.mdiframework.IControlledScreen;
import com.zella.mdiframework.IDestroyable;
import com.zella.window.InternalWindow;
import com.zella.window.InternalWindow.DefaultWindowCloseEventHandler;

public class Screen2Controller implements Initializable, IControlledScreen,
		IDestroyable {

	MyScreenController myController;

	String paramsFromFirstScreen;

	@FXML
	private Pane pane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void setParams(String params) {
		this.paramsFromFirstScreen = params;
	}

	@FXML
	private void goToScreen1(ActionEvent event) {
		myController.gotoScreen1();
	}

	@FXML
	private void openZellaWindow(ActionEvent event) {
		// Window content
		ImageView imageView = new ImageView("/assets/stub.png");

		// Custom window
		InternalWindow w = new InternalWindow();

		// Build custom title bar
		BorderPane titleBar = new BorderPane();
		titleBar.setStyle("-fx-background-color: red; -fx-padding: 3");
		Label label = new Label(paramsFromFirstScreen);
		label.setStyle("-fx-text-fill: green;");
		titleBar.setLeft(label);
		Button closeButton = new Button("close");
		closeButton.setOnAction(new DefaultWindowCloseEventHandler(w));
		titleBar.setRight(closeButton);

		// Build custom window
		BorderPane windowPane = new BorderPane();
		windowPane.setStyle("-fx-border-width: 1; -fx-border-color: black");
		windowPane.setTop(titleBar);
		// set contnet
		windowPane.setCenter(imageView);

		w.setRoot(windowPane);
		w.makeDragable(titleBar, true);
		w.makeFocusable(windowPane, true);
		w.setResizable(true, 10, true);
		w.setMultitouch(false, true);
		w.setDestroyable(() -> {
			System.out.println("destroy resourses on close");
		});
		w.setXY(50, 50);
		pane.getChildren().add(w);

	}

	@FXML
	private void openDefaultZellaWindow(ActionEvent event) {
		ImageView imageView = new ImageView("/assets/stub.png");
		InternalWindow w = new InternalWindow(imageView, paramsFromFirstScreen,
				200, 100);
		pane.getChildren().add(w);

	}

	@FXML
	private void openJfxtrasWindow(ActionEvent event) {

		Window w = new Window("My MDI Window");
		// define the initial window size
		w.setPrefSize(300, 200);
		// either to the left
		w.getLeftIcons().add(new CloseIcon(w));
		// .. or to the right
		w.getRightIcons().add(new MinimizeIcon(w));
		// add some content
		w.getContentPane().getChildren().add(new Label(paramsFromFirstScreen));
		w.getContentPane().getChildren().add(w);
		// add the window to the canvas
		pane.getChildren().add(w);
	}

	@FXML
	private void openNewStageWindow(ActionEvent event) {
		Stage myDialog = new Stage();
		myDialog.initModality(Modality.APPLICATION_MODAL);
		myDialog.setWidth(300);
		myDialog.setHeight(200);
		Scene myDialogScene = new Scene(VBoxBuilder.create()
				.children(new Label(paramsFromFirstScreen))
				.alignment(Pos.CENTER).padding(new Insets(10)).build());

		myDialog.setScene(myDialogScene);
		myDialog.show();
	}

	@Override
	public void setScreenParent(AbstractScreenController screenController) {
		myController = (MyScreenController) screenController;

	}

	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
	}

}
