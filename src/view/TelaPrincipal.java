package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dao.PessoaDao;
import entidades.Calculadora;
import entidades.Pessoa;
import entidades.PessoaMapa;

public class TelaPrincipal {

    private JFrame frame;
    private JTextField txtNome;
    private JLabel lblDataNascimento;
    private JFormattedTextField dataFormatada;
    private BufferedImage img;


    /**
     * Inicia a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaPrincipal window = new TelaPrincipal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Cria a aplicação.
     */
    public TelaPrincipal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            img = ImageIO.read(new File("numerologia.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (img != null) {
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets.top = 10;
        gbc.insets.bottom = 10;
        gbc.insets.left = 10;
        gbc.insets.right = 10;

        JLabel lblApresentacao = new JLabel(
                "Preencha as informações abaixo para gerar o seu Mapa Numerológico Cabalístico");
        lblApresentacao.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblApresentacao, gbc);

        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.gridwidth = GridBagConstraints.REMAINDER;
        gbcLabel.anchor = GridBagConstraints.WEST;
        gbcLabel.insets.top = 10;

        JLabel lblNome = new JLabel("Seu nome completo");
        lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(lblNome, gbc);

        GridBagConstraints gbcTxtNome = new GridBagConstraints();
        gbcTxtNome.gridwidth = GridBagConstraints.REMAINDER;
        gbcTxtNome.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtNome.insets.top = 5;
        txtNome = new JTextField(20);
        txtNome.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(txtNome, gbc);

        lblDataNascimento = new JLabel("Sua data de nascimento (dd/MM/yyyy)");
        lblDataNascimento.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(lblDataNascimento, gbc);

        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            dateFormatter.setPlaceholderCharacter('_');
            dataFormatada = new JFormattedTextField(dateFormatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dataFormatada.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(dataFormatada, gbc);

        JButton btnMostrar = new JButton("Gerar mapa");
        btnMostrar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeCompleto = txtNome.getText();
                String data = dataFormatada.getText();

                if (isValidDate(data)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date dn = null;

                    try {
                        dn = sdf.parse(data);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(frame, "Erro: Formato de data inválido.");
                        return;
                    }

                    Calendar dataNascimento = Calendar.getInstance();
                    dataNascimento.setTime(dn);        
                    
                    Pessoa pessoa = new Pessoa(nomeCompleto, dataNascimento);
                    Calculadora calculadora = new Calculadora(pessoa);
                    
                    
                    String numeroMotivacao = calculadora.obterTextoMotivacao();
					String numeroImpressao = calculadora.obterTextoNumeroImpressao();
					String numeroExpressao = calculadora.obterTextoExpressao();
					String licoesCarmicas = calculadora.obterTextoLicoesCarmicas();
					String tendenciasOcultas = calculadora.obterTextoTendenciasOcultas();
					String respostaSubconciente = calculadora.obterTextoRespostaSubconsciente();
					String numeroDeDestino = calculadora.obterTextoDestino();
					String dividasCarmicas = calculadora.obterTextoDividasCarmicas();
					String missao = calculadora.obterTextoMissao();
					String anoPessoal = calculadora.obterTextoAnoPessoal();
					
					// Talvez seja necessario criar uma classe nova
					PessoaMapa pessoaMapa = new PessoaMapa(0, nomeCompleto,dataNascimento, numeroMotivacao, numeroImpressao,
							numeroExpressao, licoesCarmicas, tendenciasOcultas, respostaSubconciente,
							numeroDeDestino, dividasCarmicas, missao, anoPessoal);
				    
					PessoaDao dao = new PessoaDao();
                                      
                    // Após inserir no banco de dados, obtenha o ID da pessoa salva
                    int idPessoaSalva = dao.inserirPessoa(pessoaMapa);

                    // Verifica se o ID foi atribuído corretamente
                    if (idPessoaSalva > 0) {
                    	PessoaMapa pessoaBuscada = dao.buscarPessoaPorId(idPessoaSalva);
                        new JanelaMapa(idPessoaSalva, pessoaBuscada);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Erro ao inserir pessoa no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                
                } else {
                    JOptionPane.showMessageDialog(frame, "Erro: Formato de data inválido. Use dd/MM/yyyy.");
                }
            }
        });

        panel.add(btnMostrar, gbc);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private static boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
