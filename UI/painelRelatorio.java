package UI;

import javax.swing.*;

public class painelRelatorio extends JPanel {

    private JPanel PainelRelatorio;
    private JButton relatórioDeFornecedoresButton;
    private JButton relatorioDeCompradoresButton;
    private JButton relatorioDeVendasButton;
    private JButton relatórioDeTecnologiasButton;
    private JButton botaoExit;
    private GerenciadorDeJanelas gerenciadorDeJanelas;




    public JPanel getPainel() {
        return PainelRelatorio;
    }

   public painelRelatorio(GerenciadorDeJanelas gerenciadorDeJanelas) {
        super();
        this.gerenciadorDeJanelas = gerenciadorDeJanelas;
       botaoExit.addActionListener(e -> gerenciadorDeJanelas.mudaJanela(3));
   }
}
