package entidades;

import java.util.Calendar;

public class PessoaMapa extends Pessoa {

	public PessoaMapa(String nome, Calendar dataNascimento) {
		super(nome, dataNascimento);
	}

	public PessoaMapa(int id, String nomeCompleto, Calendar dataNascimento, String numeroMotivacao,
			String numeroImpressao, String numeroExpressao, String licoesCarmicas, String tendenciasOcultas,
			String respostaSubconciente, String numeroDeDestino, String dividasCarmicas, String missao,
			String anoPessoal) {
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
	}

	public PessoaMapa(String numeroMotivacao, String numeroImpressao, String numeroExpressao, String licoesCarmicas,
			String tendenciasOcultas, String respostaSubconciente, String numeroDeDestino, String dividasCarmicas,
			String missao, String anoPessoal) {

	}

	public int getId() {
		return id;
	}

	public String obterTextoMotivacao() {
		Calculadora calculadora = new Calculadora(this);
		return calculadora.obterTextoMotivacao();
	}

	public String obterTextoNumeroImpressao() {
		Calculadora calculadora = new Calculadora(this);
		return calculadora.obterTextoNumeroImpressao();
	}

	public String obterTextoExpressao() {
		Calculadora calculadora = new Calculadora(this);
		return calculadora.obterTextoExpressao();
	}

	public String obterTextoLicoesCarmicas() {
		Calculadora calculadora = new Calculadora(this);
		return calculadora.obterTextoLicoesCarmicas();
	}

	public String obterTextoTendenciasOcultas() {
		Calculadora calculadora = new Calculadora(this);
		return calculadora.obterTextoTendenciasOcultas();
	}

	public String obterTextoRespostaSubconsciente() {
		Calculadora calculadora = new Calculadora(this);
		return calculadora.obterTextoRespostaSubconsciente();
	}

	public String obterTextoDestino() {
		Calculadora calculadora = new Calculadora(this);
		return calculadora.obterTextoDestino();
	}

	public String obterTextoDividasCarmicas() {
		Calculadora calculadora = new Calculadora(this);
		return calculadora.obterTextoDividasCarmicas();
	}

	public String obterTextoMissao() {
		Calculadora calculadora = new Calculadora(this);
		return calculadora.obterTextoMissao();
	}

	public String obterTextoAnoPessoal() {
		Calculadora calculadora = new Calculadora(this);
		return calculadora.obterTextoAnoPessoal();
	}

}
