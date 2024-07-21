package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import entidades.PessoaMapa;

public class PessoaDao {


	public Connection getConexao() throws ClassNotFoundException {

		// Driver
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		// Banco de dados
		String url = "jdbc:mysql://localhost:3306/sistemanumerologia?useTimezone=true&serverTimezone=UTC";

		// Usuario
		String user = "root";

		// Senha
		String password = "Rg95211612#";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado ao banco de dados");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}
	
	public int inserirPessoa(PessoaMapa novaPessoa) {		
	    String insert = "INSERT INTO pessoas (nomeCompleto, dataNascimento, numeroMotivacao, numeroImpressao, numeroExpressao, licoesCarmicas, "
	            + "tendenciasOcultas, respostaSubconciente, numeroDeDestino, dividasCarmicas, missao, anoPessoal) "
	            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

	    try {
	        Connection con = getConexao();
	        PreparedStatement pst = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
	        java.sql.Date sqlDate = new java.sql.Date(novaPessoa.getDataNascimento().getTimeInMillis());

	        pst.setString(1, novaPessoa.getNomeCompleto());
	        pst.setDate(2, sqlDate);
	        pst.setString(3, novaPessoa.obterTextoMotivacao());
	        pst.setString(4, novaPessoa.obterTextoNumeroImpressao());
	        pst.setString(5, novaPessoa.obterTextoExpressao());
	        pst.setString(6, novaPessoa.obterTextoLicoesCarmicas());
	        pst.setString(7, novaPessoa.obterTextoTendenciasOcultas());
	        pst.setString(8, novaPessoa.obterTextoRespostaSubconsciente());
	        pst.setString(9, novaPessoa.obterTextoDestino());
	        pst.setString(10, novaPessoa.obterTextoDividasCarmicas());
	        pst.setString(11, novaPessoa.obterTextoMissao());
	        pst.setString(12, novaPessoa.obterTextoAnoPessoal());
	        pst.executeUpdate();

	        // Pegando a chave gerada
	        ResultSet rs = pst.getGeneratedKeys();
	        int chaveGerada = 0;
	        if (rs.next()) {
	            chaveGerada = rs.getInt(1);
	            novaPessoa.setId(chaveGerada); // Configura o ID gerado no objeto Pessoa
	        }
	        rs.close();
	        pst.close();
	        con.close();

	        return chaveGerada;

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}

	
	public PessoaMapa buscarPessoaPorId(int id) {
	    // SQL para buscar uma pessoa pelo ID
	    String query = "SELECT * FROM pessoas WHERE id = ?";

	    try {
	        Connection con = getConexao();
	        PreparedStatement pst = con.prepareStatement(query);
	        pst.setInt(1, id);

	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            // Lendo os dados do ResultSet
	            String nomeCompleto = rs.getString("nomeCompleto");
	            java.sql.Date data = rs.getDate("dataNascimento");
	            // Convertendo para Calendar
	            Calendar dataNascimento = Calendar.getInstance();
	            dataNascimento.setTimeInMillis(data.getTime());

	            String numeroMotivacao = rs.getString("numeroMotivacao");
	            String numeroImpressao = rs.getString("numeroImpressao");
	            String numeroExpressao = rs.getString("numeroExpressao");
	            String licoesCarmicas = rs.getString("licoesCarmicas");
	            String tendenciasOcultas = rs.getString("tendenciasOcultas");
	            String respostaSubconsciente = rs.getString("respostaSubconciente");
	            String numeroDeDestino = rs.getString("numeroDeDestino");
	            String dividasCarmicas = rs.getString("dividasCarmicas");
	            String missao = rs.getString("missao");
	            String anoPessoal = rs.getString("anoPessoal");

	            rs.close();
	            pst.close();
	            con.close();

	            // Retornando os dados da pessoa encontrada
	            return new PessoaMapa(id, nomeCompleto, dataNascimento, numeroMotivacao, numeroImpressao, numeroExpressao,
	                              licoesCarmicas, tendenciasOcultas, respostaSubconsciente, numeroDeDestino,
	                              dividasCarmicas, missao, anoPessoal);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return null; // Retorna null se não encontrar a pessoa
	}


	
	
}
