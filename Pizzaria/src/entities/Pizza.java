package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pizza<E> {
	private String[] arrayInterna = new String[TAMANHO_INICIAL];
	private int quantidade = 0;
	private E[] array;
	private static final int TAMANHO_INICIAL = 5;
	private int f = 0;

	public Pizza() {
		array = (E[]) new Object[TAMANHO_INICIAL];
	}

	public void enqueue(ArrayList<String> p) {
		int indice = (f + quantidade) % array.length;
		array[indice] = (E) p;

		quantidade++;
	}

	public E denqueue() {
		E temp = array[f];
		array[f] = null;
		quantidade--;
		f = (f + 1) % array.length;
		return temp;
	}

	public E first() {
		return array[f];
	}

	public E pop() throws QuantidadeZeroException {
		if (isEmpity()) {
			throw new QuantidadeZeroException("Você não possui pizzas");
		} else {
			E temp = array[quantidade - 1];
			array[quantidade] = null;
			quantidade--;
			return temp;
		}

	}

	public void push(E e) {
		VerificarTamanhoArray();
		array[quantidade] = e;
		quantidade++;

	}

	public boolean isEmpity() {
		return quantidade == 0;
	}

	public int size() {
		return quantidade;
	}

	public E top() throws QuantidadeZeroException {

		if (isEmpity()) {
			throw new QuantidadeZeroException("Você não possui mais pedidos");
		} else {
			return array[quantidade - 1];
		}

	}

	public String getArray(int numeroEscolhido) {

		String array = arrayInterna[numeroEscolhido];
		return array;

	}

	public void setArray(int numeroEscolhido, String materia) {

		this.arrayInterna[numeroEscolhido] = materia;

	}

	public void clear() {
		arrayInterna = new String[TAMANHO_INICIAL];
		quantidade = 0;

	}

	public boolean contains(String valor) {

		for (int i = 0; i < quantidade; i++) {
			if (arrayInterna[i].equals(valor)) {
				return true;
			}

		}
		return false;
	}

	public String[] getArrayInterna() {
		return arrayInterna;
	}

	public void setArrayInterna(String[] arrayInterna) {
		this.arrayInterna = arrayInterna;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

	private void VerificarTamanhoArray() {
		if (quantidade == arrayInterna.length) {
			String[] temp = arrayInterna;

			for (int i = 0; i < quantidade; i++) {
				arrayInterna[i] = temp[i];
			}

		}
	}

	public void add(String pi) {

		VerificarTamanhoArray();
		arrayInterna[quantidade] = pi;
		quantidade++;

	}

	public String get(int opcaoSabor) {

		return null;
	}

	

}
