package tn.esprit.aerodash.rootlayout;

import javafx.fxml.FXML;

public class LoginController extends Controller{

	public LoginController(String fxml){
		super(fxml);
	}
	
	@FXML
	public void onButton(){
		System.out.println("HOLA !");
	}

}
