package tn.esprit.aerodash.rootlayout.listadapter;

import org.kairos.layouts.RecyclerView.Adapter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class MyAdapter extends Adapter<Holder>{

	private static int COUNTER = 0;
	
	@Override
	public void onBindViewHolder(Holder holder, Object item) {
		
		Item i = (Item) item;
		holder.number.setText(Integer.toString(i.number));
		holder.title.setText(i.name);
		holder.btn.setOnAction((e) -> i.setSelected());
		
		//first item must be bigger than others
		if (COUNTER == 0){
			System.out.println("Hoya");
			((StackPane)holder.getView()).setPrefHeight(48 * 2);
			holder.btn.setPrefHeight(48 * 2);
			COUNTER++;
		}
	}

	@Override
	public Holder onCreateViewHolder(FXMLLoader loader) {
		//first item must be bigger than others
		if (COUNTER == 0){
			
			
			COUNTER++;
		}
				
		loader.setLocation(getClass().getResource("Item.fxml"));
		Holder holder = new Holder(loader);
		return holder;
	}
	
}
