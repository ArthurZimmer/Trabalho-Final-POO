package UI;

import javax.swing.*;

public class painelPrincipal extends JPanel{
    private JPanel panel1;
    private JLabel OqVoceDeseja;
    private JButton botaoCadastrar;
    private JButton botaoRelatorio;
    private JButton botaoExit;
    private GerenciadorDeJanelas gerenciadorDeJanelas;


    public JPanel getPainel() {
        return panel1;
    }

    public painelPrincipal(GerenciadorDeJanelas gerenciadorDeJanelas) {
        this.gerenciadorDeJanelas = gerenciadorDeJanelas;
        botaoCadastrar.addActionListener(e -> gerenciadorDeJanelas.mudaJanela(1));
        botaoRelatorio.addActionListener(e -> gerenciadorDeJanelas.mudaJanela(2));

        botaoExit.addActionListener(e -> System.exit(0));
    }
}

