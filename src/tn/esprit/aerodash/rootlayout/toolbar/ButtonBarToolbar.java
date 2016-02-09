package tn.esprit.aerodash.rootlayout.toolbar;


import org.kairos.Toolbar;
import org.kairos.components.IconButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * Created by Felipe on 25/10/2015.
 */
public class ButtonBarToolbar extends Toolbar {
	private final static int MAX_BUTTONS = 4;
	private final static int ICON_BUTTONS_SIZE = 48;
    private final BorderPane topPlace=new BorderPane();
    
    private HBox homeTitleContainer = new HBox();
    private final Label title=new Label();
    private final IconButton home=new IconButton();
    private boolean homeAsUp=false;
    
    private HBox buttonBarContainer = new HBox();

    public ButtonBarToolbar(){

    	getStylesheets().add("/tn/esprit/aerodash/rootlayout/style.css");
        getStyleClass().add("toolbar");
        setAlignment(Pos.CENTER_LEFT);
        topPlace.getStyleClass().add("top-place");
        topPlace.setMinHeight(64);
        
        //title and home button
        title.getStyleClass().add("title");
        
        home.getStyleClass().add("home-icon");
        home.setIcon(getClass().getResourceAsStream("menu.svg"));
        home.setIconBackground(getClass().getResourceAsStream("arrow_back.svg"));
        
        homeTitleContainer.getChildren().add(title);
        homeTitleContainer.getStyleClass().add("home-title-container");
        homeTitleContainer.setAlignment(Pos.CENTER_LEFT);
        topPlace.setLeft(homeTitleContainer);
        
        buttonBarContainer.getStyleClass().add("toolbar-button-bar");
        buttonBarContainer.setAlignment(Pos.CENTER);
        topPlace.setRight(buttonBarContainer);
        
        getChildren().clear();
        getChildren().add(topPlace);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }


    @Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        homeAsUp=true;
        home.setIcon(getClass().getResourceAsStream("arrow_back.svg"));
        home.setVisible(false);
        home.setManaged(false);
        if(!homeTitleContainer.getChildren().contains(home)){
        	homeTitleContainer.getChildren().add(0, home);
        }
    }

    @Override
    public void setDisplayShowHomeEnabled(boolean showHome) {
        if(!homeTitleContainer.getChildren().contains(home)){
        	homeTitleContainer.getChildren().add(0,home);
        }

    }

    @Override
    public void showHomeAsUp() {
        home.setVisible(true);
        home.setManaged(true);
    }

    @Override
    public boolean isDisplayHomeAsUpEnabled() {
        return homeAsUp;
    }

    @Override
    public void setOnHomeButtonAction(EventHandler<ActionEvent> handler){
        home.setOnAction(handler);
    }
    
    public void addIconButton(String icon){
    	IconButton btn = new IconButton();
        btn.setIcon(getClass().getResourceAsStream(icon));

        buttonBarContainer.getChildren().add(btn);
        
    	if (buttonBarContainer.getChildren().size() > MAX_BUTTONS) throw new IllegalArgumentException("Maximum number of buttons is " + MAX_BUTTONS);
    }
    
    public void addIconButtons(String... icons){
    	for (String s : icons){
    		addIconButton(s);
    	}
    }


}