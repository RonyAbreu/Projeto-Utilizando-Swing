package dcx.ufpb.br.narutoswing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BoaoSaveController implements ActionListener {
    private MetodosNinja metodosNinja;
    private JFrame janelaPrincipal;
    private  GravadorDeDados gravador;

    public BoaoSaveController(MetodosNinja metodosNinja, JanelaGUIV3 janelaPrincipal) {
        this.metodosNinja = metodosNinja;
        this.janelaPrincipal = janelaPrincipal;
        this.gravador = new GravadorDeDados();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            gravador.gravaNinjas(metodosNinja.getNinjas());
            JOptionPane.showMessageDialog(janelaPrincipal,"Ninjas Salvos com sucesso!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Erro! Tente novamente!");
        }
    }
}
