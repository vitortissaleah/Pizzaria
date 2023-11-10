package Program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import entities.*;

public class MainPizzaria {

	public static <E> void main(String[] args) throws QuantidadeZeroException {
		Scanner sc = new Scanner(System.in);

		HashSet<String> ingredientes = new HashSet<String>();
		ingredientes.add("Calabresa");
		ingredientes.add("Frango");
		ingredientes.add("Queijo");
		ingredientes.add("Peperoni");
		ingredientes.add("Presunto");

		FilasPizzaria<String> pizza = new FilasPizzaria<String>();

		FilasCliente<String> mesa = new FilasCliente<String>();
		Queue<Pizza> pizzasCriadas = new LinkedList<Pizza>();
		Queue<Pedido> pe = new LinkedList<Pedido>();
		HashMap<String, Integer> ingredientesDosPedidos = new HashMap<String, Integer>();
		LinkedList<String> ingredientesa = new LinkedList<String>();

		int pizzasServidas = 0;

		boolean opcao = true;
		while (opcao == true) {
			System.out.println("PIZZARIA UNIFACISA");
			
			System.out.println();
			System.out.println("1) Criar uma pizza");
			System.out.println("2) Criar um novo pedido");
			System.out.println("3) Servir um pedido");
			System.out.println("4) Adicionar ingredientes");
			System.out.println("5) Estatísticas dos pedidos");
			System.out.println("6) Sair do programa");
			System.out.println();
			
			System.out.printf("Digite a opção escolhida: ");
			System.out.println();
			int opcaoEscolhida = sc.nextInt();

			switch (opcaoEscolhida) {
			case 1: {

				System.out.println(" Ingredientes disponíveis: ");

				for (String s : ingredientes) {
					System.out.println("- " + s);
				}
				System.out.println("- Sair.  ");
				System.out.println("- Voltar.  ");

				System.out.println();
				System.out.println("| MONTE SUA PIZZA |");
				System.out.println();
				LinkedList<String> ingredientesDaPizza = new LinkedList<String>();

				while (true) {
					System.out.printf("Escolha seu ingrediente: ");

					String item = sc.next();

					if (ingredientes.contains(item) == true) {
						ingredientesDaPizza.add(item);

						System.out.println();
						System.out.println("Ingrediente  " + item + "  salvo com sucesso!");
						System.out.println();

					}

					else if (item.equals("Voltar")) {
						ingredientesDaPizza.remove(ingredientesDaPizza.get(ingredientesDaPizza.size() - 1));
						System.out.println();
						System.out.println("Ingrediente retirado com sucesso, continue da montagem");
						System.out.println();
					} else if (item.equals("Sair")) {

						break;

					} else if (ingredientes.contains(item) == false) {
						System.out.println();
						System.out.println("Não existe esse ingrediente,tente novamente!");
						System.out.println();
					}

				}
				pe.add(new Pedido(ingredientesDaPizza));
				for (String i : ingredientesDaPizza) {
					ingredientesDosPedidos.put(i, ingredientesDosPedidos.getOrDefault(i, 0) + 1);
				}

				break;

			}

			case 2: {
				List<Pedido> listaPedidos = new ArrayList<>(pe);

				int i = 1;
				for (Pedido pedido : listaPedidos) {
					System.out.println("Indice(" + i + ") - " + pedido);
					i++;
				}

				System.out.println("- Escolha o sabor da pizza: ");
				int item = sc.nextInt();
				int sabor = item - 1;
				System.out.println("- Qual é a mesa:");
				String mesas = sc.next();

				if (sabor < listaPedidos.size() && sabor > -1) {
					Pedido pedido = listaPedidos.get(sabor);
					System.out.println("Pedido Criado " + pedido);
					pizza.enqueue(pedido.toString());
					mesa.enqueue(mesas);
				} else {
					System.out.println();
					System.out.println("Não existe essa pizza");
					System.out.println();
				}

				break;
			}
			case 3: {

				if (pizza.isEmpity()) {
					System.out.println();
					System.out.println("Não existem pedidos.");
					System.out.println();
				} else {
					System.out.println();
					System.out.println("Pizza vendida: " + pizza.denqueue() + " para mesa: " + mesa.denqueue());
					System.out.println();

					pizzasServidas++;
				}
				break;
			}
			case 4: {

				System.out.printf("Qual ingrediente você deseja adicionar: ");

				String novoIngrediente = sc.next();
				sc.nextLine();

				if (ingredientes.contains(novoIngrediente) == true) {
					System.out.println();
					System.out.println("Já existe esse ingrediente. ");
					System.out.println();
				} else {
					ingredientes.add(novoIngrediente);
					System.out.println();
					System.out.println("Ingrediente " + novoIngrediente + " salvo com sucesso.");
					System.out.println();

				}

				break;
			}
			case 5: {
				if (pizzasServidas == 0) {
					System.out.println("Não existem pedidos feitos.");
				} else {
					Set<String> ingredientesNaoEscolhidos = new HashSet<>(ingredientes);
					ingredientesNaoEscolhidos.removeAll(ingredientesDosPedidos.keySet());

					double media = ingredientesDosPedidos.values().stream().mapToDouble(Integer::doubleValue).average()
							.orElse(0.0);

					Map.Entry<String, Integer> ingredienteMaisPedidoEntry = ingredientesDosPedidos.entrySet().stream()
							.max(Map.Entry.comparingByValue()).orElse(null);

					String ingredienteMaisPedido = (ingredienteMaisPedidoEntry != null)
							? ingredienteMaisPedidoEntry.getKey()
							: "Nenhum Pedido";
					int quantidadeMaisPedido = (ingredienteMaisPedidoEntry != null)
							? ingredienteMaisPedidoEntry.getValue()
							: 0;

					System.out.println("- Pizzas Servidas: " + pizzasServidas);
					System.out.println("- Quantidade média de ingredientes por pizzas: " + media);
					System.out.println("- Ingrediente mais pedido: " + ingredienteMaisPedido + " (Quantidade: "
							+ quantidadeMaisPedido + ")");
					System.out.println("- Ingredientes não escolhidos: " + ingredientesNaoEscolhidos);
				}
				break;
			}
			case 6: {
				System.out.println("Obrigado, Volte Sempre!");
				opcao = false;
				break;
			}
			default: {
				System.out.println("Tente Novamente");
				System.out.println();
			}

			}
		}
		sc.close();
	}

}
