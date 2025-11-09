package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class janelaPrincipal {
    private JPanel panel1;
    private JLabel OqVoceDeseja;
    private JButton botaoCadastrar;
    private JButton botaoRelatorio;


    public JPanel getPainel() {
        return panel1;
    }

    public janelaPrincipal() {
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                janelaCadastro dialog = new janelaCadastro(frame);
                dialog.setVisible(true);
            }
        });
    }
}

