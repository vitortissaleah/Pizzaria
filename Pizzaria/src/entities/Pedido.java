package entities;

import java.util.LinkedList;

public class Pedido {
	
	private LinkedList<String> ingredientes;
	
	public Pedido(LinkedList<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public LinkedList<String> getIngredientes(){
		return ingredientes;
	}

	@Override
	public String toString() {
		return "Pizza com: " + ingredientes ;
	}
	
	
}
