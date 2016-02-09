package tn.esprit.aerodash.rootlayout;

import javafx.stage.StageStyle;
import org.kairos.components.MaterialButton;
import org.kairos.core.ActivityFactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tn.esprit.aerodash.rootlayout.listadapter.Item;

public class Main extends Application {

	public static Root root;
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        initMainStage(stage);
        root.addItem(new Item(1, "Acceuil", LoginController.class), "Content.fxml");
        root.addItem(new Item(2, "Profil", ProfilController.class), "ProfilUI.fxml");
        root.addItem(new Item(3, "Cours", LoginController.class), "Content.fxml");
        root.addItem(new Item(4, "Formations", LoginController.class), "Content.fxml");
        root.addItem(new Item(5, "Organismes", LoginController.class), "Content.fxml");
        root.addItem(new Item(6, "Déconnexion", LoginController.class), "Content.fxml");

        root.addToolbarIconButtons("earth.svg", "person.svg");

        //root.showScreen(ProfilController.class);

    }

    
    
    
    
    
	private void initMainStage(Stage stage) {
        //stage.initStyle(StageStyle.UNDECORATED);

        stage.setMinWidth(800);
        stage.setMinHeight(600);

        StackPane root=new StackPane(); // Create root pane
        stage.setScene(new Scene(root)); // Set the scene in the stage

        // this object represent the stack  of activities  in your application
        ActivityFactory factory=new ActivityFactory(stage);

        // set the material design style in your application
        stage.getScene().getStylesheets().add(MaterialButton.class.getResource("controls.css").toExternalForm());

        factory.startActivity(Root.class); // start the activity
        stage.show();

    }
}