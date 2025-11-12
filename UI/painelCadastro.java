package UI;

import javax.swing.*;

public class painelCadastro extends JPanel {
    private JPanel panelCadastro;
    private JLabel texto;
    private JButton cadastrarVenda;
    private JButton cadastrarComprador;
    private JButton cadastrarTecnologia;
    private JButton cadastrarFornecedor;
    private JButton botaoExit;
    GerenciadorDeJanelas gerenciadorDeJanelas;

    public JPanel getPainel() {
        return panelCadastro;
    }

    public painelCadastro(GerenciadorDeJanelas gerenciadorDeJanelas) {

        super();
        this.gerenciadorDeJanelas = gerenciadorDeJanelas;
        cadastrarVenda.addActionListener(e -> gerenciadorDeJanelas.mudaJanela(4));
        botaoExit.addActionListener(e -> gerenciadorDeJanelas.mudaJanela(3));
    }
}

