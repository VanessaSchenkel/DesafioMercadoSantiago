 import java.util.Scanner;

public class Principal {
	private static final int PAO = 1;
	private static final int CAFE = 2;
	private static final int TRAQUINAS = 3;
	private static final int AGUA = 4;
	private static final int COCA_COLA = 5;
	private static final int TOMATE = 6;
	private static final int PASTEL = 7;
	private static final int PIZZA = 8;
	private static final int ERVA_MATE = 9;
	private static final int QUEIJO = 10;
	private static final int FINALIZAR = 100;

	public static void main(String[] args) {

		int opc = -99999;
		int opcFinalizar = -9999;
		int quantidade = 0;
		Compra[] arrayCompras = new Compra[300];
		Scanner ler = new Scanner(System.in);

		do {
			opc = exibirMenuPrincipal(ler);

			if (opc == PAO) {
				quantidade = lerQuantidade(ler);
				Pao pao = new Pao();
				Compra compra = new Compra(pao, quantidade);
				adicionarNaListaDeCompras(arrayCompras, compra);
			}

			if (opc == CAFE) {
				quantidade = lerQuantidade(ler);
				Cafe cafe = new Cafe();
				Compra compra = new Compra(cafe, quantidade);
				adicionarNaListaDeCompras(arrayCompras, compra);

			}

			if (opc == TRAQUINAS) {
				quantidade = lerQuantidade(ler);
				Traquinas traquinas = new Traquinas();
				Compra compra = new Compra(traquinas, quantidade);
				adicionarNaListaDeCompras(arrayCompras, compra);

			}

			if (opc == AGUA) {
				quantidade = lerQuantidade(ler);
				Agua agua = new Agua();
				Compra compra = new Compra(agua, quantidade);
				adicionarNaListaDeCompras(arrayCompras, compra);
			}

			if (opc == COCA_COLA) {
				quantidade = lerQuantidade(ler);
				CocaCola cocaCola = new CocaCola();
				Compra compra = new Compra(cocaCola, quantidade);
				adicionarNaListaDeCompras(arrayCompras, compra);
			}

			if (opc == TOMATE) {
				quantidade = lerQuantidade(ler);
				Tomate tomate = new Tomate();
				Compra compra = new Compra(tomate, quantidade);
				adicionarNaListaDeCompras(arrayCompras, compra);
			}

			if (opc == PASTEL) {
				quantidade = lerQuantidade(ler);
				Pastel pastel = new Pastel();
				Compra compra = new Compra(pastel, quantidade);
				adicionarNaListaDeCompras(arrayCompras, compra);

			}

			if (opc == PIZZA) {
				quantidade = lerQuantidade(ler);
				Pizza pizza = new Pizza();
				Compra compra = new Compra(pizza, quantidade);
				adicionarNaListaDeCompras(arrayCompras, compra);
			}

			if (opc == ERVA_MATE) {
				quantidade = lerQuantidade(ler);
				ErvaMate ervaMate = new ErvaMate();
				Compra compra = new Compra(ervaMate, quantidade);
				adicionarNaListaDeCompras(arrayCompras, compra);
			}

			if (opc == QUEIJO) {
				quantidade = lerQuantidade(ler);
				Queijo queijo = new Queijo();
				Compra compra = new Compra(queijo, quantidade);
				adicionarNaListaDeCompras(arrayCompras, compra);
			}

			if (opc == FINALIZAR) {

				System.out.println("SEU PEDIDO:");
				double totalCompras = 0;

				for (int i = 0; i < arrayCompras.length; i++) {
					Compra compra = arrayCompras[i];
					if (compra != null) {
						double totalItem = (compra.getProduto().getPreco()) * (compra.getQuantidade());
						totalCompras = totalCompras + totalItem;

						System.out.println("Item: " + compra.getProduto().getNome() + "\nValor unitário: "
								+ compra.getProduto().getPreco() + "\nQuantidade: " + compra.getQuantidade()
								+ "\nTotal item: " + totalItem);

					}

				}
				System.out.println("--------------");
				System.out.println("TOTAL: " + totalCompras);
				System.out.println();

				do {
					opcFinalizar = exibirMenuFinalizar(ler);

					if (opcFinalizar == 1) {
						boolean cartaoValido = false;

						while (!cartaoValido) {
							ler.nextLine();

							System.out.println("Digite o nome como está no cartão: ");
							String nome = ler.nextLine();

							System.out.println("Digite o número do cartão (16 dígitos): ");
							long numeroCartao = ler.nextLong();

							System.out.println("Digite o código de segurança (3 dígitos): ");
							int codigoSeguranca = ler.nextInt();

							System.out.println("Digite o mês de validade (De 1 a 12): ");
							int mes = ler.nextInt();

							System.out.println("Digite o ano de validade (A partir de 2018): ");
							int ano = ler.nextInt();

							ValidadorCartao validador = new ValidadorCartao();
							cartaoValido = validador.validarDadosCartao(numeroCartao, mes, ano, nome, codigoSeguranca);
							if (cartaoValido) {
								System.out.println("Pagamento efetuado com sucesso, " + nome + " :)");
								System.out.println();
								arrayCompras = new Compra[300];
								opcFinalizar = 2;
							} else {
								System.out.println("Dados inválidos, informe novamente.");

							}
						}

					}

				} while (opcFinalizar != 2);

			}

		} while (opc != 0);
		System.out.println("Você saiu. Volte sempre!");

	}

	private static int exibirMenuFinalizar(Scanner ler) {
		int opcFinalizar;
		System.out.println("Você deseja: ");
		System.out.println("1 - Realizar pagamento");
		System.out.println("2 - Voltar");
		System.out.println("Opção: ");
		opcFinalizar = ler.nextInt();
		return opcFinalizar;
	}

	private static void adicionarNaListaDeCompras(Compra[] arrayCompras, Compra compra) {
		for (int i = 0; i < arrayCompras.length; i++) {
			if (arrayCompras[i] == null) {
				arrayCompras[i] = compra;
				break;
			}
		}
	}

	private static int lerQuantidade(Scanner ler) {
		int quantidade;
		System.out.printf("Digite a quantidade desejada:");
		quantidade = ler.nextInt();
		return quantidade;
	}

	private static int exibirMenuPrincipal(Scanner ler) {
		int opc;
		System.out.println("BEM-VINDO AO MERCADO SANTIGO! \n Digite a opção desejada:");
		System.out.println("1 - Pão           |         R$   1,50");
		System.out.println("2 - Café          |         R$   2,00");
		System.out.println("3 - Tranquinas    |         R$   2,40");
		System.out.println("4 - Água          |         R$   3,00");
		System.out.println("5 - Coca-cola     |         R$   3,50");
		System.out.println("6 - Tomate        |         R$   3,60");
		System.out.println("7 - Pastel        |         R$   4,00");
		System.out.println("8 - Pizza         |         R$   5,00");
		System.out.println("9 - Erva-mate     |         R$   8,00");
		System.out.println("10 - Queijo       |         R$  10,00");
		System.out.println();
		System.out.println("100 - Finalizar pedido");
		System.out.println();
		System.out.println("0 - Sair");
		System.out.println();
		System.out.printf("OPÇÃO: ");
		opc = ler.nextInt();
		return opc;
	}

}
