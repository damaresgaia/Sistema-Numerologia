package entidades;

import java.util.HashMap;

import java.util.Map;

public class Alfabeto {


		public Map<String, Integer> mapa = new HashMap<String, Integer>();
		
		
		
		
		// DETALHE: Y É VOGAL / K E W SEMPRE SÃO CONSOANTES
		//TRANSFORMANDO AS VOGAIS
		public Alfabeto() {

			int valorA = 1;
			mapa.put("A", valorA); //A vale 1
			mapa.put("Á", valorA + 2); //Acento agudo + 2
			mapa.put("A'", valorA + 2); //Apóstrofo +2 
			mapa.put("Ã", valorA + 3); //Til + 3
			mapa.put("Â", valorA + 7); //Acento circuflêxo + 7
			mapa.put("Aº", valorA + 7); // Bolinha + 7
			mapa.put("Aª", valorA + 7);	// Bolinha + 7
			mapa.put("À", valorA * 2); // Crase * 2
			mapa.put("Ä", valorA * 2); // Trema * 2
			int valorE = 5;
			mapa.put("E", valorE); // E vale 5
			mapa.put("É", valorE + 2); // Acento agudo + 2
			mapa.put("E'", valorE + 2); // Apóstrofo + 2
			mapa.put("Ẽ", valorE + 3); // Til + 3
			mapa.put("Ê", valorE + 7); // Acento circunflexo + 7
			mapa.put("Eº", valorE + 7); // Bolinha + 7
			mapa.put("Eª", valorE + 7); // Bolinha + 7
			mapa.put("È", valorE * 2); // Crase * 2
			mapa.put("Ë", valorE * 2); // Trema * 2
			int valorI = 1;
			mapa.put("I", valorI); // I vale 1
			mapa.put("Í", valorI + 2); // Acento agudo + 2
			mapa.put("I'", valorI + 2); // Apóstrofo + 2
			mapa.put("Ĩ", valorI + 3); // Til + 3
			mapa.put("Î", valorI + 7); // Acento circunflexo + 7
			mapa.put("Iº", valorI + 7); // Bolinha + 7
			mapa.put("Iª", valorI + 7); // Bolinha + 7
			mapa.put("Ì", valorI * 2); // Crase * 2
			mapa.put("Ï", valorI * 2); // Trema * 2
			int valorO = 7;
			mapa.put("O", valorO); // O vale 7
			mapa.put("Ó", valorO + 2); // Acento agudo + 2
			mapa.put("O'", valorO + 2); // Apóstrofo + 2
			mapa.put("Õ", valorO + 3); // Til + 3
			mapa.put("Ô", valorO + 7); // Acento circunflexo + 7
			mapa.put("Oº", valorO + 7); // Bolinha + 7
			mapa.put("Oª", valorO + 7); // Bolinha + 7
			mapa.put("Ò", valorO * 2); // Crase * 2
			mapa.put("Ö", valorO * 2); // Trema * 2
			int valorU = 6;
			mapa.put("U", valorU); // U vale 6
			mapa.put("Ú", valorU + 2); // Acento agudo + 2
			mapa.put("U'", valorU + 2); // Apóstrofo + 2
			mapa.put("Ũ", valorU + 3); // Til + 3
			mapa.put("Û", valorU + 7); // Acento circunflexo + 7
			mapa.put("Uº", valorU + 7); // Bolinha + 7
			mapa.put("Uª", valorU + 7); // Bolinha + 7
			mapa.put("Ù", valorU * 2); // Crase * 2
			mapa.put("Ü", valorU * 2); // Trema * 2
			int valorY = 1;
			mapa.put("Y", valorY); // Y vale 1
			mapa.put("Ý", valorY + 2); // Acento agudo + 2
			mapa.put("Y'", valorY + 2); // Apóstrofo + 2
			mapa.put("Ÿ", valorY * 2); // Trema * 2
			mapa.put("Yº", valorY + 7); // Bolinha + 7
			mapa.put("Yª", valorY + 7); // Bolinha + 7

			//TRANSFORMANDO AS CONSOANTES
			int valorB = 2;
			mapa.put("B", valorB); // B vale 2
			mapa.put("B'", valorB + 2); // Apóstrofo + 2
			mapa.put("Bº", valorB + 7); // Bolinha + 7
			mapa.put("Bª", valorB + 7); // Bolinha + 7
			int valorC = 3;
			mapa.put("C", valorC); // C vale 3
			mapa.put("C'", valorC + 2); // Apóstrofo + 2
			mapa.put("Cº", valorC + 7); // Bolinha + 7
			mapa.put("Cª", valorC + 7); // Bolinha + 7
			mapa.put("Ç", valorC + 3); // Cedilha vale 6
			int valorD = 4;
			mapa.put("D", valorD); // D vale 4
			mapa.put("D'", valorD + 2); // Apóstrofo + 2
			mapa.put("Dº", valorD + 7); // Bolinha + 7
			mapa.put("Dª", valorD + 7); // Bolinha + 7
			int valorF = 8;
			mapa.put("F", valorF); // F vale 8
			mapa.put("F'", valorF + 2); // Apóstrofo + 2
			mapa.put("Fº", valorF + 7); // Bolinha + 7
			mapa.put("Fª", valorF + 7); // Bolinha + 7
			int valorG = 3;
			mapa.put("G", valorG); // G vale 3
			mapa.put("G'", valorG + 2); // Apóstrofo + 2
			mapa.put("Gº", valorG + 7); // Bolinha + 7
			mapa.put("Gª", valorG + 7); // Bolinha + 7
			int valorH = 5;
			mapa.put("H", valorH); // H vale 5
			mapa.put("H'", valorH + 2); // Apóstrofo + 2
			mapa.put("Hº", valorH + 7); // Bolinha + 7
			mapa.put("Hª", valorH + 7); // Bolinha + 7
			int valorJ = 1;
			mapa.put("J", valorJ); // J vale 1
			mapa.put("J'", valorJ + 2); // Apóstrofo + 2
			mapa.put("Jº", valorJ + 7); // Bolinha + 7
			mapa.put("Jª", valorJ + 7); // Bolinha + 7
			int valorK = 2;
			mapa.put("K", valorK); // K vale 2
			mapa.put("K'", valorK + 2); // Apóstrofo + 2
			mapa.put("Kº", valorK + 7); // Bolinha + 7
			mapa.put("Kª", valorK + 7); // Bolinha + 7
			int valorL = 3;
			mapa.put("L", valorL); // L vale 3
			mapa.put("L'", valorL + 2); // Apóstrofo + 2
			mapa.put("Lº", valorL + 7); // Bolinha + 7
			mapa.put("Lª", valorL + 7); // Bolinha + 7
			int valorM = 4;
			mapa.put("M", valorM); // M vale 4
			mapa.put("M'", valorM + 2); // Apóstrofo + 2
			mapa.put("Mº", valorM + 7); // Bolinha + 7
			mapa.put("Mª", valorM + 7); // Bolinha + 7
			int valorN = 5;
			mapa.put("N", valorN); // N vale 5
			mapa.put("N'", valorN + 2); // Apóstrofo + 2
			mapa.put("Nº", valorN + 7); // Bolinha + 7
			mapa.put("Nª", valorN + 7); // Bolinha + 7
			mapa.put("Ñ", valorN + 3); // Til vale 8
			int valorP = 8;
			mapa.put("P", valorP); // P vale 8
			mapa.put("P'", valorP + 2); // Apóstrofo + 2
			mapa.put("Pº", valorP + 7); // Bolinha + 7
			mapa.put("Pª", valorP + 7); // Bolinha + 7
			int valorQ = 1;
			mapa.put("Q", valorQ); // Q vale 1
			mapa.put("Q'", valorQ + 2); // Apóstrofo + 2
			mapa.put("Qº", valorQ + 7); // Bolinha + 7
			mapa.put("Qª", valorQ + 7); // Bolinha + 7
			int valorR = 2;
			mapa.put("R", valorR); // R vale 2
			mapa.put("R'", valorR + 2); // Apóstrofo + 2
			mapa.put("Rº", valorR + 7); // Bolinha + 7
			mapa.put("Rª", valorR + 7); // Bolinha + 7
			int valorS = 3;
			mapa.put("S", valorS); // S vale 3
			mapa.put("S'", valorS + 2); // Apóstrofo + 2
			mapa.put("Sº", valorS + 7); // Bolinha + 7
			mapa.put("Sª", valorS + 7); // Bolinha + 7
			int valorT = 4;
			mapa.put("T", valorT); // T vale 4
			mapa.put("T'", valorT + 2); // Apóstrofo + 2
			mapa.put("Tº", valorT + 7); // Bolinha + 7
			mapa.put("Tª", valorT + 7); // Bolinha + 7
			int valorV = 6;
			mapa.put("V", valorV); // V vale 6
			mapa.put("V'", valorV + 2); // Apóstrofo + 2
			mapa.put("Vº", valorV + 7); // Bolinha + 7
			mapa.put("Vª", valorV + 7); // Bolinha + 7
			int valorW = 6;
			mapa.put("W", valorW); // W vale 6
			mapa.put("W'", valorW + 2); // Apóstrofo + 2
			mapa.put("Wº", valorW + 7); // Bolinha + 7
			mapa.put("Wª", valorW + 7); // Bolinha + 7
			int valorX = 6;
			mapa.put("X", valorX); // X vale 6
			mapa.put("X'", valorX + 2); // Apóstrofo + 2
			mapa.put("Xº", valorX + 7); // Bolinha + 7
			mapa.put("Xª", valorX + 7); // Bolinha + 7
			int valorZ = 7;
			mapa.put("Z", valorZ); // Z vale 7
			mapa.put("Z'", valorZ + 2); // Apóstrofo + 2
			mapa.put("Zº", valorZ + 7); // Bolinha + 7
			mapa.put("Zª", valorZ + 7); // Bolinha + 7
			
			
			
			
		}




		public Map<String, Integer> getMapa() {
			return mapa;
		}




		public void setMapa(Map<String, Integer> mapa) {
			this.mapa = mapa;
		}
		
		
		



//        // Itera sobre os símbolos e exibe seus valores
//        for (String symbol : mapa.keySet()) {
//            System.out.println("Símbolo: " + symbol + ", Valor: " + mapa.get(symbol));
//        }
	
}
