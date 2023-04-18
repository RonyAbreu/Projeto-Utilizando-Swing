package dcx.ufpb.br.narutoswing;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;


public class ProgramaNaruto{
    public static void main(String[] args) {

        GravadorDeDados gravador = new GravadorDeDados();
        MetodosNinja aldeiaDeNinjas = null;
        try {
            ArrayList<Ninja> ninjasRecuperados = gravador.leitorDeNinjas();
            JOptionPane.showMessageDialog(null,"Ninjas Recuperados com sucesso");
            aldeiaDeNinjas = new AldeiaDeNinjas(ninjasRecuperados);
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Sistema iniciado sem dados!");
            aldeiaDeNinjas = new AldeiaDeNinjas(new ArrayList<>());
        }

        JFrame janela = new JanelaGUIV3(aldeiaDeNinjas);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int fechar = JOptionPane.showConfirmDialog(janela,"Deseja sair?");
                if(fechar == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

    }
}
