package dcx.ufpb.br.narutoswing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
public class BotaoRemoveController implements ActionListener{
    private MetodosNinja metodosNinja;
    private JFrame janelaPincipal;

    public BotaoRemoveController(MetodosNinja metodosNinja, JanelaGUIV3 janelaPincipal){
        this.metodosNinja = metodosNinja;
        this.janelaPincipal = janelaPincipal;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nome = JOptionPane.showInputDialog("Qual o nome do Ninja que deseja Remover?");
            metodosNinja.removeNinja(nome);
            JOptionPane.showMessageDialog(janelaPincipal,"Ninja removido com sucesso!");
        } catch (NinjaInexistenteException ex) {
            JOptionPane.showMessageDialog(janelaPincipal,"Ninja não encontrado!");
        }
    }
}
