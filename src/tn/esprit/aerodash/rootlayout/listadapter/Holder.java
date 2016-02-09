package tn.esprit.aerodash.rootlayout.listadapter;

import org.kairos.components.MaterialButton;
import org.kairos.layouts.RecyclerView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

public class Holder extends RecyclerView.ViewHolder {
    
	@FXML
	Label title;
	
	@FXML
	Label number;
	
	@FXML
	MaterialButton btn;
	
	public Holder(FXMLLoader loader) {
		super(loader);
	}

}