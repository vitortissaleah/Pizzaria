package entities;

import java.util.Arrays;

public class FilasPizzaria<E> {

	private static final int TAMANHO = 5;
	private int quantidade = 0;
	private E[] array;
	private int f = 0;

	public FilasPizzaria() {
		array = (E[]) new Object[TAMANHO];
	}

	public void enqueue(E e) {
		int indice = (f + quantidade) % array.length;
		array[indice]= e;
		
		
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

	@Override
	public String toString() {
		return "FilasPizzaria [array=" + Arrays.toString(array) + "]";
	}
	public boolean isEmpity() {
		return quantidade == 0;
	}


}
