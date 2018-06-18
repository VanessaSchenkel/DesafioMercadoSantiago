
public class ValidadorCartao {

	public boolean validarNumero(long numeroCartao) {
		String numeroString = String.valueOf(numeroCartao);

		if (numeroString.length() == 16) {
			return true;
		} else {
			System.out.println("Número deve conter 16 dígitos.");
			return false;
		}
	}

	public boolean validarDataVencimento(int mes, int ano) {

		if (mes < 1 || mes > 12) {
			System.out.println("Mês inválido. Informe valor entre 1 e 12.");
			return false;
		}
		if (ano < 2018) {
			System.out.println("Deve ter validade superior a 2018.");
			return false;

		}
		return true;
	}

	public boolean validarNome(String nome) {
		if (nome == null || nome.isEmpty()) {
			System.out.println("Deve informar nome.");
			return false;
		}
		return true;
	}

	public boolean validarCVV(int numeroCVV) {
		String numeroSeguranca = String.valueOf(numeroCVV);

		if (numeroSeguranca.length() == 3) {
			return true;
		} else {
			System.out.println("Código de segurança deve conter 3 dígitos.");
			return false;
		}

	}

	public boolean validarDadosCartao(long numeroCartao, int mes, int ano, String nome, int numeroCVV) {

		boolean numeroCartaoValido = validarNumero(numeroCartao);
		boolean vencimentoValido = validarDataVencimento(mes, ano);
		boolean nomeValido = validarNome(nome);
		boolean cvvValido = validarCVV(numeroCVV);

		boolean cartaoValido = numeroCartaoValido && vencimentoValido && nomeValido && cvvValido;
		return cartaoValido;

	}

}
