package entities;

import java.util.Arrays;



public class Pedidos<E> {
	private String[] arrayInterna = new String[TAMANHO_INICIAL];
	private int quantidade = 0;
	private E[] array;
	private static final int TAMANHO_INICIAL = 5;
	private String sabor;
	private int mesa;

	public Pedidos() {
		array = (E[]) new Object[TAMANHO_INICIAL];
	}

	public E pop() throws QuantidadeZeroException {
		if (isEmpity()) {
			throw new QuantidadeZeroException("Você não possui igredientes na pilha");
		} else {
			E temp = array[quantidade - 1];
			array[quantidade] = null;
			quantidade--;
			return temp;
		}

	}

	public void push(E e, int mesa) {

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
		return "quantidade=" + quantidade + ", array=" + Arrays.toString(array) + "]";
	}

}
