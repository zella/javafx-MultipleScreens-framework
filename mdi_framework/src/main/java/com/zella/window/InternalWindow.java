package com.zella.window;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class InternalWindow extends Parent {

	private double mX;
	private double mY;

	/**
	 * Creates fully customizable window.
	 * 
	 * You need customize window with setWindow() and setXY() methods
	 */
	public InternalWindow() {

	}

	/**
	 * Window with default title bar and behavior
	 * 
	 * @param content
	 *            under title bar
	 * @param title
	 * @param x
	 *            x layout coord
	 * @param y
	 *            y layout coord
	 */
	public InternalWindow(Node content, String title, double x, double y) {
		mX = x;
		mY = y;
		initDefaultWindow(content, title);
	}

	private void initDefaultWindow(Node content, String title) {
		BorderPane pane = makeDefaultBorderPane(title);
		pane.setCenter(content);
		getChildren().add(pane);
		// all focusable
		makeFocusable(this, true);
	}

	public void setXY(double x, double y) {
		mX = x;
		mY = y;
	}

	/**
	 * Set node for window
	 * 
	 * @param node
	 */
	public void setWindow(Node node) {
		getChildren().add(node);
	}

	private BorderPane makeDefaultBorderPane(String title) {
		BorderPane pane = new BorderPane();
		// pane.setPrefSize(500, 600); TODO
		pane.setStyle("-fx-border-width: 1; -fx-border-color: burlywood");
		pane.setTop(buildDefaultTitleBar(title));
		this.setLayoutX(mX);
		this.setLayoutY(mY);
		return pane;
	}

	private Node buildDefaultTitleBar(String title) {
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: burlywood; -fx-padding: 5");
		Label label = new Label(title);
		label.setStyle("-fx-text-fill: midnightblue;");
		pane.setLeft(label);

		Button closeButton = new Button("X");
		closeButton.setOnAction(new DefaultWindowCloseEventHandler(this));
		pane.setRight(closeButton);
		makeDragable(pane, true);
		return pane;
	}

	/**
	 * Make node draggable by mouse
	 * 
	 * @param what
	 * @param isMovable
	 */
	public void makeDragable(Node what, boolean isMovable) {
		final Delta dragDelta = new Delta();
		what.setOnMousePressed(mouseEvent -> {
			if (isMovable) {
				dragDelta.x = getLayoutX() - mouseEvent.getScreenX();
				dragDelta.y = getLayoutY() - mouseEvent.getScreenY();
			}
			toFront();
		});
		what.setOnMouseDragged(mouseEvent -> {
			if (isMovable) {
				setLayoutX(mouseEvent.getScreenX() + dragDelta.x);
				setLayoutY(mouseEvent.getScreenY() + dragDelta.y);
			}
		});
	}

	/**
	 * Make node focusable by mouse
	 * 
	 * @param what
	 * @param isFocusable
	 */
	public void makeFocusable(Node what, boolean isFocusable) {

		what.setOnMouseClicked(mouseEvent -> {
			toFront();
		});

	}
	
	//TODO make resizable

	public static class DefaultWindowCloseEventHandler implements
			EventHandler<ActionEvent> {

		InternalWindow mWindow;

		public DefaultWindowCloseEventHandler(InternalWindow window) {
			mWindow = window;
		}

		@Override
		public void handle(ActionEvent event) {
			Parent p = mWindow.getParent();
			if (!(p instanceof Pane)) // TODO seems bad
				throw new ClassCastException(
						"You need implement setOnClose themselves");
			Pane parentPane = (Pane) p;
			parentPane.getChildren().remove(mWindow);

		}
	}

	private static class Delta {
		double x, y;
	}

}
