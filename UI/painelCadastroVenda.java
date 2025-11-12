package UI;

import javax.swing.*;

public class painelCadastroVenda extends JPanel{
    private JPanel panel1;
    private JTextField campoID;
    private JTextField textField1;
    private JButton botaoExit;


    public JPanel getPanel() {
        return panel1;
    }

    public painelCadastroVenda(GerenciadorDeJanelas gerenciadorDeJanelas) {
        super();
        botaoExit.addActionListener(e -> gerenciadorDeJanelas.mudaJanela(1));
    }
}
