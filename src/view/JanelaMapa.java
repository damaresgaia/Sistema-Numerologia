package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import entidades.PessoaMapa;

public class JanelaMapa extends JFrame {

    private static final long serialVersionUID = 1L;
    private BufferedImage img;

    public JanelaMapa(int idPessoa, PessoaMapa pessoaBuscada) {

        setTitle("Mapa Numerológico");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
        gbc.insets = new Insets(10, 10, 10, 10);

        if (pessoaBuscada != null) {
            JLabel tituloLabel = new JLabel("Mapa Numerológico de " + pessoaBuscada.getNomeCompleto(), SwingConstants.CENTER);
            tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(tituloLabel, gbc);

            JTextPane descricaoTextPane = new JTextPane();
            descricaoTextPane.setText("O Mapa Numerológico Cabalístico Pessoal é um instrumento\n"
                    + "personalizado que serve para orientar o ser humano a\n"
                    + "planejar a sua vida de uma maneira prática e mais inteligente,\n"
                    + "revelando-lhes fatos a respeito de sua existência que possam\n"
                    + "contribuir para despertar todas as suas potencialidades e, dessa\n"
                    + "maneira, tirar o máximo proveito da vida.\n"
                    + "Clique nos botões ao lado para saber os detalhes do seu mapa:");
            descricaoTextPane.setFont(new Font("Arial", Font.PLAIN, 14));
            descricaoTextPane.setOpaque(false);
            descricaoTextPane.setEditable(false);
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.BOTH;
            panel.add(descricaoTextPane, gbc);

            JPanel buttonPanel = new JPanel(new GridBagLayout());
            GridBagConstraints buttonGbc = new GridBagConstraints();
            buttonGbc.insets = new Insets(5, 5, 5, 5);
            buttonGbc.fill = GridBagConstraints.HORIZONTAL;
            buttonGbc.weightx = 1.0;

            criarBotao(buttonPanel, "Número de Motivação", pessoaBuscada.obterTextoMotivacao(), 0, 0);
            criarBotao(buttonPanel, "Número de Impressão", pessoaBuscada.obterTextoNumeroImpressao(), 0, 1);
            criarBotao(buttonPanel, "Número de Expressão", pessoaBuscada.obterTextoExpressao(), 0, 2);
            criarBotao(buttonPanel, "Lições Cármicas", pessoaBuscada.obterTextoLicoesCarmicas(), 0, 3);
            criarBotao(buttonPanel, "Tendências Ocultas", pessoaBuscada.obterTextoTendenciasOcultas(), 0, 4);
            criarBotao(buttonPanel, "Resposta Subconsciente", pessoaBuscada.obterTextoRespostaSubconsciente(), 0, 5);
            criarBotao(buttonPanel, "Número de Destino", pessoaBuscada.obterTextoDestino(), 0, 6);
            criarBotao(buttonPanel, "Dívidas Cármicas", pessoaBuscada.obterTextoDividasCarmicas(), 0, 7);
            criarBotao(buttonPanel, "Missão", pessoaBuscada.obterTextoMissao(), 0, 8);
            criarBotao(buttonPanel, "Ano Pessoal", pessoaBuscada.obterTextoAnoPessoal(), 0, 9);

            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            panel.add(buttonPanel, gbc);
        } else {
            JOptionPane.showMessageDialog(this, "Pessoa não encontrada no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void criarBotao(JPanel panel, String titulo, String texto, int x, int y) {
        JButton button = new JButton(titulo);
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, texto, titulo, JOptionPane.INFORMATION_MESSAGE);
            }
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(button, gbc);
    }
}
