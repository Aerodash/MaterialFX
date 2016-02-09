package tn.esprit.aerodash.rootlayout;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import tn.esprit.aerodash.rootlayout.listadapter.Item;

public abstract class Controller extends StackPane {

	Item i;
    Node gp;
	public Controller(String fxml){
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource(fxml));
		if (l.getController() == null) {
			l.setController(this);
		}
		try {
			gp = l.load();
			getChildren().add(gp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Node getPane() {
		return gp;
	}

	public void setPane(Pane gp) {
		this.gp = gp;
	}

	public Item getItem() {
		return i;
	}

	public void setItem(Item i) {
		this.i = i;
	}
}
