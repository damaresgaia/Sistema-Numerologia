package entidades;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Calculadora {
	private Pessoa pessoa;

	public Calculadora(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String obterTextoMotivacao() {
		Alfabeto alfabeto = new Alfabeto();
		Map<String, Integer> mapa = alfabeto.getMapa();
		Textos textos = new Textos();
		Map<Integer, String> mapaMotivacao = textos.getMapaMotivacao();
	
		int totalReduzido = 0;
		int somaNome = somaVogais();		

		int reducao = reduzir1122(somaNome);		

		String texto = mapaMotivacao.get(reducao);		

		if (reducao == 2 || reducao == 4) {
			String nome = pessoa.getNomeCompleto().toUpperCase();
			String[] nomeSeparado = nome.split(" ");

			int tamanho = nomeSeparado.length;
			int[] somaReduzida = new int[tamanho];

			for (int i = 0; i < tamanho; i++) {
				int soma = 0;
				String name = nomeSeparado[i];

				for (int j = 0; j < name.length(); j++) {
					if (isVogal(name.charAt(j))) {
						int valor = mapa.get(String.valueOf(name.charAt(j)));
						soma += valor;
					}
				}

				somaReduzida[i] = reduzir1122(soma);
			}

			for (int i = 0; i < tamanho; i++) {
				totalReduzido += somaReduzida[i];
			}

			totalReduzido = reduzir1122(totalReduzido);
			texto = mapaMotivacao.get(totalReduzido);
			return texto;
		} else {
			return texto;
		}

	}
	
	public String obterTextoNumeroImpressao() {
		Alfabeto alfabeto = new Alfabeto();
		Map<String, Integer> mapa = alfabeto.getMapa();
		Textos textos = new Textos();
		Map<Integer, String> mapaImpressao = textos.getMapaImpressao();
		
		int soma = 0;
		for (char c : pessoa.getNomeCompleto().toUpperCase().toCharArray()) {
			String chave = String.valueOf(c);
			if (mapa.containsKey(chave)) {
				if (isConsoante(c)) {					
					soma += mapa.get(chave);
				}
			}
		}		
		soma = reduzir(soma);
		String texto = mapaImpressao.get(soma);
		return texto;
	}

	public String obterTextoExpressao() {
		Alfabeto alfabeto = new Alfabeto();
		Map<String, Integer> mapa = alfabeto.getMapa();
		Textos textos = new Textos();
		Map<Integer, String> mapaExpressao = textos.getMapaExpressao();

		int totalReduzido = 0;
		int somaNome = calcularValorNome(mapa, pessoa.getNomeCompleto());
		int reducao = reduzir1122(somaNome);
		String texto = mapaExpressao.get(reducao);

		if (reducao == 2 || reducao == 4) {
			String nome = pessoa.getNomeCompleto().toUpperCase();
			String[] nomeSeparado = nome.split(" ");
			int tamanho = nomeSeparado.length;
			int[] somaReduzida = new int[tamanho];
			for (int i = 0; i < tamanho; i++) {
				int soma = 0;
				String name = nomeSeparado[i];
				for (int j = 0; j < name.length(); j++) {
					if (isVogal(name.charAt(j))) {
						int valor = mapa.get(String.valueOf(name.charAt(j)));
						soma += valor;
					}
				}
				somaReduzida[i] = reduzir1122(soma);
			}
			for (int i = 0; i < tamanho; i++) {
				totalReduzido += somaReduzida[i];
			}
			totalReduzido = reduzir1122(totalReduzido);

			texto = mapaExpressao.get(totalReduzido);

			return texto;
		} else {
			return texto;
		}
	}

	public String obterTextoLicoesCarmicas() {
	    Alfabeto alfabeto = new Alfabeto();
	    Map<String, Integer> mapa = alfabeto.getMapa();
	    Textos textos = new Textos();
	    Map<Integer, String> mapaLicoesCarmicas = textos.getMapaLicoesCarmicas();
	    
	    Set<Integer> valoresPresentes = new HashSet<>();
	    for (char c : pessoa.getNomeCompleto().toUpperCase().toCharArray()) {
	        String chave = String.valueOf(c);
	        if (mapa.containsKey(chave)) {
	            valoresPresentes.add(mapa.get(chave));
	        }
	    }
	    Set<Integer> licoesCarmicas = new HashSet<>();
	    for (int i = 1; i <= 9; i++) {
	        if (!valoresPresentes.contains(i)) {
	            licoesCarmicas.add(i);
	        }
	    }
	    StringBuilder texto = new StringBuilder();
	    if (!licoesCarmicas.isEmpty()) {
	        for (int licao : licoesCarmicas) {
	            texto.append(mapaLicoesCarmicas.get(licao)).append(" \n\n ");
	        }
	    } else {
	        texto.append("Não possui lições cármicas");
	    }
	    return texto.toString();
	}

	public String obterTextoTendenciasOcultas() {
	    Alfabeto alfabeto = new Alfabeto();
	    Map<String, Integer> mapa = alfabeto.getMapa();
	    Textos textos = new Textos();
	    Map<Integer, String> mapaTendenciasOcultas = textos.getMapaTendenciasOcultas();
	    
	    Map<Integer, Integer> frequencias = new HashMap<>();

	    // Contar a frequência de cada valor numérico no nome completo
	    for (char c : pessoa.getNomeCompleto().toUpperCase().toCharArray()) {
	        String chave = String.valueOf(c);
	        if (mapa.containsKey(chave)) {
	            int valor = mapa.get(chave);
	            frequencias.put(valor, frequencias.getOrDefault(valor, 0) + 1);
	        }
	    }

	    // Encontrar os valores que aparecem mais de três vezes
	    Set<Integer> tendenciasOcultas = new HashSet<>();
	    for (Map.Entry<Integer, Integer> entry : frequencias.entrySet()) {
	        if (entry.getValue() > 3) {
	            tendenciasOcultas.add(entry.getKey());
	        }
	    }
	    
	    StringBuilder texto = new StringBuilder();
	    if (!tendenciasOcultas.isEmpty()) {
	        for (int licao : tendenciasOcultas) {
	            texto.append(mapaTendenciasOcultas.get(licao)).append("\n");
	        }
	    } else {
	        texto.append("Não possui tendências ocultas");
	    }
	    return texto.toString();
	}
	
	public String obterTextoRespostaSubconsciente() {
		Textos textos = new Textos();
		Map<Integer, String> mapaRespostaSubconsciente = textos.getMapaRespostaSubconsciente();
		
		Set<Integer> licoesCarmicas = calcularLicoesCarmicas(pessoa.getNomeCompleto());
		int respostaSub = 9 - licoesCarmicas.size();
		String texto = mapaRespostaSubconsciente.get(respostaSub);
		
		return texto;
	}
	
	
	public String obterTextoDestino() {
		Textos textos = new Textos();
		Map<Integer, String> mapaDestino = textos.getMapaDestino();
		
		int somaTotal = somarDigitos(pessoa.getAnoNascimento()) + somarDigitos(pessoa.getMesNascimento())
				+ somarDigitos(pessoa.getAnoNascimento());
		somaTotal = reduzir1122(somaTotal);
		String texto = "";
		if (somaTotal == 11 || somaTotal == 22) {
			texto = mapaDestino.get(somaTotal);
			return texto;
		}

		if (somaTotal == 2 || somaTotal == 4) {
			int diaSoma = somarDigitos(pessoa.getDiaNascimento());
			int mesSoma = somarDigitos(pessoa.getMesNascimento());
			int anoSoma = somarDigitos(pessoa.getAnoNascimento());

			if (diaSoma == 11 || diaSoma == 22) {
				diaSoma = diaSoma;
			} else {
				diaSoma = reduzir1122(diaSoma);
			}

			if (mesSoma == 11 || mesSoma == 22) {
				mesSoma = mesSoma;
			} else {
				mesSoma = reduzir1122(mesSoma);
			}

			if (anoSoma == 11 || anoSoma == 22) {
				anoSoma = anoSoma;
			} else {
				anoSoma = reduzir1122(anoSoma);
			}

			somaTotal = diaSoma + mesSoma + anoSoma;

			if (somaTotal == 11 || somaTotal == 22) {
				texto = mapaDestino.get(somaTotal);
				return texto;
			} else {
				int destino = reduzir1122(somaTotal);
				texto = mapaDestino.get(destino);
				return texto;
			}
		}
		int destino = reduzir1122(somaTotal);
		texto = mapaDestino.get(destino);
		return texto;
	}
	
	public String obterTextoDividasCarmicas() {
	    Textos textos = new Textos();
	    Map<Integer, String> mapaDividasCarmicas = textos.getMapaDividasCarmicas();
	    
	    List<Integer> dividasCarmicas = new ArrayList<>();

	    int numeroDestino = calcularNumeroDestino();
	    int numeroMotivacao = calcularNumeroMotivação();
	    int numeroExpressao = calcularNumeroExpressao();

	    // Verifica se o dia de nascimento é 13, 14, 16 ou 19
	    if (pessoa.getDiaNascimento() == 13) {
	        dividasCarmicas.add(13);
	    } else if (pessoa.getDiaNascimento() == 14) {
	        dividasCarmicas.add(14);
	    } else if (pessoa.getDiaNascimento() == 16) {
	        dividasCarmicas.add(16);
	    } else if (pessoa.getDiaNascimento() == 19) {
	        dividasCarmicas.add(19);
	    }

	    // Verifica se os números de Destino, Motivação ou Expressão são 4, 5, 7 ou 1, indicando dívidas cármicas
	    if (numeroDestino == 4) {
	        dividasCarmicas.add(13);
	    } else if (numeroDestino == 5) {
	        dividasCarmicas.add(14);
	    } else if (numeroDestino == 7) {
	        dividasCarmicas.add(16);
	    } else if (numeroDestino == 1) {
	        dividasCarmicas.add(19);
	    }

	    if (numeroMotivacao == 4) {
	        dividasCarmicas.add(13);
	    } else if (numeroMotivacao == 5) {
	        dividasCarmicas.add(14);
	    } else if (numeroMotivacao == 7) {
	        dividasCarmicas.add(16);
	    } else if (numeroMotivacao == 1) {
	        dividasCarmicas.add(19);
	    }

	    if (numeroExpressao == 4) {
	        dividasCarmicas.add(13);
	    } else if (numeroExpressao == 5) {
	        dividasCarmicas.add(14);
	    } else if (numeroExpressao == 7) {
	        dividasCarmicas.add(16);
	    } else if (numeroExpressao == 1) {
	        dividasCarmicas.add(19);
	    }
	    
	    StringBuilder texto = new StringBuilder();
	    if (!dividasCarmicas.isEmpty()) {
	        for (int licao : dividasCarmicas) {
	            texto.append(mapaDividasCarmicas.get(licao)).append("\n");
	        }
	    } else {
	        texto.append("Não possui dívidas cármicas");
	    }
	    return texto.toString();
	}
	
	
	
	public String obterTextoMissao() {
		Textos textos = new Textos();
		Map<Integer, String> mapaMissao = textos.getMapaMissao();
		
		int numeroDestino = calcularNumeroDestino();
		int numeroExpressao = calcularNumeroExpressao();
		int soma = numeroDestino + numeroExpressao;
		soma = reduzir1122(soma);
		String texto = mapaMissao.get(soma);
		return texto;
	}
	
	public String obterTextoAnoPessoal() {
		Textos textos = new Textos();
		Map<Integer, String> mapaAnoPessoal = textos.getMapaAnoPessoal();
		
		LocalDate dataAtual = LocalDate.now();
		int anoAtual = dataAtual.getYear();

		// Verifica se a data de nascimento já passou no ano atual
		LocalDate aniversario = LocalDate.of(anoAtual, pessoa.getMesNascimento(), 
				pessoa.getDiaNascimento());
		if (dataAtual.isBefore(aniversario)) {
			anoAtual -= 1;
		}

		// Soma o dia e mês de nascimento ao ano em curso ou ano anterior
		int dia = pessoa.getDiaNascimento();
		int mes = pessoa.getMesNascimento();
		int soma = dia + mes + anoAtual;
		int numAnoPessoal = reduzir1122(soma);
		String texto = mapaAnoPessoal.get(numAnoPessoal);			
		return texto;
	}


	//// -----FUNÇÕES QUE SE REPETEM-----////

	// CALCULANDO A SOMA DO NOME COMPLETO (VOGAIS E CONSOANTES)
	public int calcularValorNome(Map<String, Integer> mapa, String nomeCompleto) {
		String[] nomes = nomeCompleto.split(" ");
		int somaTotal = 0;

		for (String nome : nomes) {
			for (char c : nome.toUpperCase().toCharArray()) {
				String chave = String.valueOf(c);
				somaTotal += mapa.getOrDefault(chave, 0);
			}
		}

		return somaTotal;
	}

	// SOMAR VOGAIS
	public int somaVogais() {
		Alfabeto alfabeto = new Alfabeto();
		Map<String, Integer> mapa = alfabeto.getMapa();
		String nome = pessoa.getNomeCompleto().toUpperCase();
		int soma = 0;
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if (isVogal(c)) {
				soma += mapa.get(String.valueOf(c));
			}
		}
		return soma;
	}

//		int soma = 0;
//		for (char c : nomeCompleto.toUpperCase().toCharArray()) {
//			if (isVogal(c)) {
//				soma += mapa.get(String.valueOf(c));
//			}
//
//		}
//		return soma;

	// REDUZIR PARA UM ALGARISMO
	public static int reduzir(int numero) {
		while (numero > 9) {
			numero = somarDigitos(numero);
		}
		return numero;
	}

	// REDUZINDO PARA UM ALGARISMO EXCETO 11 E 22
	public static int reduzir1122(int numero) {
		while (numero > 9 && numero != 11 && numero != 22) {
			numero = somarDigitos(numero);
		}
		return numero;
	}

	// SOMAR DIGITOS
	public static int somarDigitos(int numero) {
		int soma = 0;
		while (numero > 0) {
			soma += numero % 10;
			numero /= 10;
		}
		return soma;
	}

	// DESCOBRINDO SE É CONSOANTE
	private static boolean isConsoante(char c) {
		return "BCDFGHJKLMNPQRSTVWXYZÇÑ".indexOf(c) >= 0;
	}

	// DESCOBRINDO SE É VOGAL
	private static boolean isVogal(char c) {
		return "AEIOUYÁÃÂÀÄÉẼÊÈËÍĨÎÌÏÓÕÔÒÖÚŨÛÙÜÝŸ".indexOf(c) >= 0;
	}
	
	public Set<Integer> calcularLicoesCarmicas(String nomeCompleto) {
		Alfabeto alfabeto = new Alfabeto();
		Map<String, Integer> mapa = alfabeto.getMapa();
		Set<Integer> valoresPresentes = new HashSet<>();
		for (char c : nomeCompleto.toUpperCase().toCharArray()) {
			String chave = String.valueOf(c);
			if (mapa.containsKey(chave)) {
				valoresPresentes.add(mapa.get(chave));
			}
		}
		Set<Integer> licoesCarmicas = new HashSet<>();
		for (int i = 1; i <= 9; i++) {
			if (!valoresPresentes.contains(i)) {
				licoesCarmicas.add(i);
			}
		}
		return licoesCarmicas;
	}
	
	public int calcularNumeroMotivação() {
		Alfabeto alfabeto = new Alfabeto();
		Map<String, Integer> mapa = alfabeto.getMapa();
		int totalReduzido = 0;

		int somaNome = somaVogais();
		int reducao = reduzir1122(somaNome);

		if (reducao == 2 || reducao == 4) {
			String nome = pessoa.getNomeCompleto().toUpperCase();
			String[] nomeSeparado = nome.split(" ");

			int tamanho = nomeSeparado.length;
			int[] somaReduzida = new int[tamanho];

			for (int i = 0; i < tamanho; i++) {
				int soma = 0;
				String name = nomeSeparado[i];

				for (int j = 0; j < name.length(); j++) {
					if (isVogal(name.charAt(j))) {
						int valor = mapa.get(String.valueOf(name.charAt(j)));
						soma += valor;
					}
				}

				somaReduzida[i] = reduzir1122(soma);
			}

			for (int i = 0; i < tamanho; i++) {
				totalReduzido += somaReduzida[i];
			}

			totalReduzido = reduzir1122(totalReduzido);

			return totalReduzido;
		} else {
			return reducao;
		}
	}

	public  int calcularNumeroDestino() {
		int somaTotal = somarDigitos(pessoa.getDiaNascimento()) + somarDigitos(pessoa.getMesNascimento())
				+ somarDigitos(pessoa.getAnoNascimento());

		if (somaTotal == 11 || somaTotal == 22) {
			return somaTotal;
		}

		if (somaTotal == 2 || somaTotal == 4) {
			int diaSoma = somarDigitos(pessoa.getDiaNascimento());
			int mesSoma = somarDigitos(pessoa.getMesNascimento());
			int anoSoma = somarDigitos(pessoa.getAnoNascimento());

			if (diaSoma == 11 || diaSoma == 22) {
				diaSoma = diaSoma;
			} else {
				diaSoma = reduzir1122(diaSoma);
			}

			if (mesSoma == 11 || mesSoma == 22) {
				mesSoma = mesSoma;
			} else {
				mesSoma = reduzir1122(mesSoma);
			}

			if (anoSoma == 11 || anoSoma == 22) {
				anoSoma = anoSoma;
			} else {
				anoSoma = reduzir1122(anoSoma);
			}

			somaTotal = diaSoma + mesSoma + anoSoma;

			if (somaTotal == 11 || somaTotal == 22) {
				return somaTotal;
			} else {
				return reduzir1122(somaTotal);
			}
		}

		return reduzir1122(somaTotal);
	}

	public int calcularNumeroExpressao() {		
		Alfabeto alfabeto = new Alfabeto();
		Map<String, Integer> mapa = alfabeto.getMapa();
		
		int totalReduzido = 0;

		int somaNome = calcularValorNome(mapa, pessoa.getNomeCompleto());
		int reducao = reduzir1122(somaNome);

		if (reducao == 2 || reducao == 4) {
			String nome = pessoa.getNomeCompleto().toUpperCase();
			String[] nomeSeparado = nome.split(" ");

			int tamanho = nomeSeparado.length;
			int[] somaReduzida = new int[tamanho];

			for (int i = 0; i < tamanho; i++) {
				int soma = 0;
				String name = nomeSeparado[i];

				for (int j = 0; j < name.length(); j++) {
					if (isVogal(name.charAt(j))) {
						int valor = mapa.get(String.valueOf(name.charAt(j)));
						soma += valor;
					}
				}

				somaReduzida[i] = reduzir1122(soma);
			}

			for (int i = 0; i < tamanho; i++) {
				totalReduzido += somaReduzida[i];
			}

			totalReduzido = reduzir1122(totalReduzido);

			return totalReduzido;
		} else {
			return reducao;
		}
	}
}
