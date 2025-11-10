package UI;

import javax.swing.*;

public class painelPrincipal extends JPanel{
    private JPanel panel1;
    private JLabel OqVoceDeseja;
    private JButton botaoCadastrar;
    private JButton botaoRelatorio;
    private JButton botaoExit;
    private GerenciadorDeJanelas gj;


    public JPanel getPainel() {
        return panel1;
    }

    public painelPrincipal(GerenciadorDeJanelas gj) {
        this.gj = gj;
        botaoCadastrar.addActionListener(e -> gj.mudaJanela(1));
    }
}

