package UI;

import javax.swing.*;

public class painelCadastroTecnologia extends JPanel {
    private JTextField campoValorBase;
    private JTextField campoID;
    private JTextField campoModelo;
    private JTextField campoDescricao;
    private JTextField campoPeso;
    private JPanel Jpanel;
    private JComboBox comboFornecedor;
    private JButton botaoExit;
    GerenciadorDeJanelas gerenciadorDeJanelas;


    public JPanel getPanel() {
        return Jpanel;
    }

    public painelCadastroTecnologia (GerenciadorDeJanelas gerenciadorDeJanelas) {
        super();
        this.gerenciadorDeJanelas = gerenciadorDeJanelas;


        botaoExit.addActionListener(e -> gerenciadorDeJanelas.mudaJanela(4));
    }

}

