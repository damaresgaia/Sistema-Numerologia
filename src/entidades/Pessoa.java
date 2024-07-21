package entidades;

import java.util.Calendar;


public class Pessoa {
	protected int id;
	protected String nomeCompleto;
	protected Calendar dataNascimento;

	public Pessoa(String nomeCompleto, Calendar dataNascimento) {
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
	}
	

	public Pessoa() {
		super();

	}

	public Pessoa(String nomeCompleto, Calendar dataNascimento, String numeroMotivacao, String numeroImpressao,
			String numeroExpressao, String licoesCarmicas, String tendenciasOcultas, String respostaSubconciente,
			String numeroDeDestino, String dividasCarmicas, String missao, String anoPessoal) {
		    this.nomeCompleto = nomeCompleto;
		    this.dataNascimento = dataNascimento;
	}

	public Pessoa(String nomeCompleto2) {
		// TODO Auto-generated constructor stub
	}	
	
	public String obterTextoMotivacao() {
		return null;
		
	}

	public String obterTextoNumeroImpressao() {
		return null;
	}

	public String obterTextoExpressao() {
		return null;
	}

	public String obterTextoLicoesCarmicas() {
		return null;
	}

	public String obterTextoTendenciasOcultas() {
		return null;
	}

	public String obterTextoRespostaSubconsciente() {
		return null;
	}

	public String obterTextoDestino() {
		return null;
	}

	public String obterTextoDividasCarmicas() {
		return null;
	}

	public String obterTextoMissao() {
		return null;
	}

	public String obterTextoAnoPessoal() {
		return null;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	// Método para obter o ano de nascimento como int
	public int getAnoNascimento() {
		return dataNascimento.get(Calendar.YEAR);
	}

	// Método para obter o mês de nascimento como int
	public int getMesNascimento() {
		return dataNascimento.get(Calendar.MONTH) + 1; // Calendar.MONTH é base 0
	}

	// Método para obter o dia de nascimento como int
	public int getDiaNascimento() {
		return dataNascimento.get(Calendar.DAY_OF_MONTH);
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;

	}
	
	// Método para definir o ano de nascimento
	public void setAnoNascimento(int ano) {
	    dataNascimento.set(Calendar.YEAR, ano);
	}

	// Método para definir o mês de nascimento
	public void setMesNascimento(int mes) {
	    dataNascimento.set(Calendar.MONTH, mes - 1); // Calendar.MONTH é base 0
	}

	// Método para definir o dia de nascimento
	public void setDiaNascimento(int dia) {
	    dataNascimento.set(Calendar.DAY_OF_MONTH, dia);
	}


	public void setId(int chaveGerada) {
		// TODO Auto-generated method stub
		
	}	
	
}
