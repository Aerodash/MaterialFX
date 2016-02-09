package tn.esprit.aerodash.rootlayout.listadapter;

import org.kairos.layouts.RecyclerView;

import tn.esprit.aerodash.rootlayout.Controller;

public class Item {
	
	public int number;
	public String name;
	public Class<? extends Controller> controller;
	private RecyclerView<Item> parent;
	
	public Item(int number, String name, Class<? extends Controller> fragment){
		this.name = name;
		this.number = number;
		this.controller = fragment;
	}

	public RecyclerView<Item> getParent() {
		return parent;
	}

	public void setParent(RecyclerView<Item> parent) {
		this.parent = parent;
	}

	public void setSelected() {
		parent.getSelectionModel().select(this);
	}
	
}
