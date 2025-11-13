package UI;

import javax.swing.*;

public class painelRelatorio extends JPanel {

    private JPanel PainelRelatorio;
    private JButton relatorioDeFornecedoresButton;
    private JButton relatorioDeCompradoresButton;
    private JButton relatorioDeVendasButton;
    private JButton relatorioDeTecnologiasButton;
    private JButton botaoExit;
    private GerenciadorDeJanelas gerenciadorDeJanelas;




    public JPanel getPainel() {
        return PainelRelatorio;
    }

   public painelRelatorio(GerenciadorDeJanelas gerenciadorDeJanelas) {
        super();
        this.gerenciadorDeJanelas = gerenciadorDeJanelas;
       botaoExit.addActionListener(e -> gerenciadorDeJanelas.mudaJanela(3));
       relatorioDeCompradoresButton.addActionListener(e -> {});
       relatorioDeFornecedoresButton.addActionListener(e -> {});
       relatorioDeVendasButton.addActionListener(e -> {});
       relatorioDeTecnologiasButton.addActionListener(e -> {});


   }
}
