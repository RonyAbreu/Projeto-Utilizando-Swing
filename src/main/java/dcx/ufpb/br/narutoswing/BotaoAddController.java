package dcx.ufpb.br.narutoswing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoAddController implements ActionListener {
    private MetodosNinja metodosNinja;
    private JFrame janelaPrincipal;
    public BotaoAddController(MetodosNinja metodosNinja, JanelaGUIV3 janelaGUIV3) {
        this.metodosNinja = metodosNinja;
        this.janelaPrincipal = janelaGUIV3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do Ninja?");
            String cla = JOptionPane.showInputDialog(janelaPrincipal,"A qual Clã o Ninja Pertence?");
            int poder = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,"Digite o total de Poder desse Ninja: "));
            metodosNinja.cadastrarNinja(nome, cla, poder);
            JOptionPane.showMessageDialog(janelaPrincipal,"Ninja cadastrado!");
        } catch (NinjaJaExisteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Não foi possível fazer o cadastro, Esse ninja Já Existe!");
        }
    }
}
