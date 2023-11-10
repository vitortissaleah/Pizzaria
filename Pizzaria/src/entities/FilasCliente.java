package entities;

public class FilasCliente<E> {

	private static final int TAMANHO = 5;
	private int quantidade = 0;
	private E[] array;
	private int f = 0;

	public FilasCliente() {
		array = (E[]) new Object[TAMANHO];
	}

	public void enqueue(E mesas) {
		int indice = (f + quantidade) % array.length;
		array[indice]= mesas;
		
		
		quantidade++;
		}

	public E denqueue() {
		E temp = array[f];
		array[f]=null;
		quantidade--;
		f = (f+1)% array.length;
		return temp;
	}

	public E first() {
		return array[f];
	}
}
