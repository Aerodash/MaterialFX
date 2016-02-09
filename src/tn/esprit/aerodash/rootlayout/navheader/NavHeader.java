package tn.esprit.aerodash.rootlayout.navheader;

import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Created by AHMED on 07/02/2016.
 */
public class NavHeader extends HBox {

    RoundImageView profileImage = new RoundImageView();

    VBox labelContainer = new VBox();
    Label username = new Label();
    Label role = new Label();

    public NavHeader(){

        getStylesheets().add("/tn/esprit/aerodash/rootlayout/navheader/navheader.css");
        setAlignment(Pos.CENTER_LEFT);
        getStyleClass().add("nav-header");
        setSpacing(10);
        setPadding(new Insets(0, 0, 0, 20));
        setPrefHeight(120);

        username.getStyleClass().add("nav-header-username");
        setUsername("Ahmed moalla");

        role.getStyleClass().add("nav-header-role");
        setRole("Admin");

        setProfileImage("/tn/esprit/aerodash/rootlayout/navheader/face.jpg");

        profileImage.getStyleClass().add("nav-header-image");
        getChildren().add(profileImage);

        labelContainer.setAlignment(Pos.CENTER_LEFT);
        labelContainer.setPadding(new Insets(0, 0, 30, 0));
        labelContainer.getChildren().add(username);
        labelContainer.getChildren().add(role);
        getChildren().add(labelContainer);

    }

    public void setProfileImage(String url){
        profileImage.setImage(new Image(url, 73, 73, true, true, true));
    }

    public Image getProfileImage(){
        return profileImage.getImage();
    }

    public void setUsername(String username){
        this.username.setText(username);
    }

    public String getUsername(){
        return username.getText();
    }

    public void setRole(String role){
        this.role.setText(role);
    }

    public String getRole(){
        return role.getText();
    }

}
