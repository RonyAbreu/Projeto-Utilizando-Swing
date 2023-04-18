package dcx.ufpb.br.narutoswing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BotaoPesqController implements ActionListener {
    private MetodosNinja metodosNinja;
    private JFrame janelaPrincipal;

    public BotaoPesqController(MetodosNinja metodosNinja, JanelaGUIV3 janelaPrincipal){
        this.metodosNinja = metodosNinja;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nome = JOptionPane.showInputDialog(janelaPrincipal,"Qual o Nome do Ninja a pesquisar? ");
            ArrayList<Ninja> ninjas = metodosNinja.pesquisaNinja(nome);
                for (Ninja c : ninjas) {
                    JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
                }

        } catch (NinjaInexistenteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Ninja não encontrado! "+ex.getMessage());
        }

    }
}
