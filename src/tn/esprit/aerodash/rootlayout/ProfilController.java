package tn.esprit.aerodash.rootlayout;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import tn.esprit.aerodash.rootlayout.navheader.RoundImageView;

/**
 * Created by AHMED on 08/02/2016.
 */
public class ProfilController extends Controller{

    @FXML
    private StackPane topPane;

    @FXML
    private HBox bottomPart;

    private HBox profileImageNomContainer;
    private Label nomLabel;
    private RoundImageView profileImage;

    private ImageView coverImage;

    public ProfilController(String fxml) {
        super(fxml);
    }

    @FXML
    public void initialize(){



        //Image de profil arrondie
        profileImage = new RoundImageView();
        profileImage.defaultSizeProperty().set(120);
        profileImage.styleProperty().setValue("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        profileImage.setImage(new Image("/tn/esprit/aerodash/rootlayout/face.jpg"));
        //StackPane.setAlignment(profileImage, Pos.CENTER_LEFT);
        //StackPane.setMargin(profileImage, new Insets(0, 0, 0, 20));
        //profileImage.setTranslateY(75);

        //image de couverture
        coverImage = new ImageView();
        topPane.styleProperty().setValue("-fx-background-image: url(/tn/esprit/aerodash/rootlayout/material.jpg);" +
                "-fx-background-size: cover");

        //Cercle autour de l'image
        Circle c = new Circle(125 / 2);
        c.styleProperty().setValue("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        StackPane.setAlignment(c, Pos.CENTER_LEFT);
        StackPane.setMargin(c, new Insets(0, 0, 0, 20));
        c.setTranslateY(75);
        c.setTranslateX(-2);
        c.fillProperty().setValue(Paint.valueOf("White"));

        //Configuration du label
        nomLabel = new Label();
        nomLabel.setText("Ahmed Moalla");
        nomLabel.setTranslateY(-20);
        nomLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px");

        profileImageNomContainer = new HBox(20);
        profileImageNomContainer.getChildren().addAll(profileImage, nomLabel);
        profileImageNomContainer.setAlignment(Pos.CENTER_LEFT);
        StackPane.setAlignment(profileImageNomContainer, Pos.CENTER_LEFT);
        StackPane.setMargin(profileImageNomContainer, new Insets(0, 0, 0, 20));
        profileImageNomContainer.setTranslateY(75);

        //Ajout du cercle et de l'image de profil
        topPane.getChildren().addAll(c, profileImageNomContainer);


    }
}
