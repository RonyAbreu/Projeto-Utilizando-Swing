package dcx.ufpb.br.narutoswing;

import javax.swing.*;
import java.awt.*;
public class JanelaGUIV3 extends JFrame{
    JLabel titulo, naruto, itachi, sasuke,aldeiaFolha, aldeiaCeu, aldeiaTrovao;
    ImageIcon imgNaruto = new ImageIcon("src/main/resources/narutoKun.png");
    ImageIcon imgSasuke = new ImageIcon("src/main/resources/sasukeKun.png");
    ImageIcon imgItachi = new ImageIcon("src/main/resources/itachiKun.png");
    ImageIcon imgAldeidaFolha = new ImageIcon("src/main/resources/aldeiaDaFolha.png");
    ImageIcon imgAldeidaCeu = new ImageIcon("src/main/resources/aldeiaDoCeu.png");
    ImageIcon imgAldeidaTrovao = new ImageIcon("src/main/resources/aldeiaDoRelampago.png");
    ImageIcon addImg = new ImageIcon("src/main/resources/addUsuario.png");
    ImageIcon pesqImg = new ImageIcon("src/main/resources/pesqUsuario.png");
    ImageIcon removeImg = new ImageIcon("src/main/resources/removeUsuario.png");
    JButton botaoAdd, botaoPesq, botaoRemove;
    JMenuBar barraDeMenu = new JMenuBar();
    MetodosNinja metodosNinja ;

    public JanelaGUIV3(MetodosNinja aldeia){
        // PERSONALIZAÇÃO DA JANELA
        this.metodosNinja = aldeia;
        setTitle("Aldeia da Folha");
        setSize(1200,1000);
        setResizable(false);
        setLocation(0,0);
        getContentPane().setBackground(Color.white);
        // PERSONALIZAÇÃO DA LINHA 1

        titulo = new JLabel("Crie seu clã",JLabel.CENTER);
        titulo.setForeground(Color.black);
        titulo.setFont(new Font("Serif",Font.BOLD,40));
        // IMAGENS

        naruto = new JLabel(imgNaruto, JLabel.CENTER);
        itachi = new JLabel(imgItachi, JLabel.CENTER);
        sasuke = new JLabel(imgSasuke, JLabel.CENTER);
        aldeiaFolha = new JLabel(imgAldeidaFolha, JLabel.CENTER);
        aldeiaCeu = new JLabel(imgAldeidaCeu, JLabel.CENTER);
        aldeiaTrovao = new JLabel(imgAldeidaTrovao, JLabel.CENTER);
        // PERSONALIZAÇÃO DO BOTÃO ADICIONAR

        botaoAdd = new JButton("Adicionar", addImg);
        botaoAdd.setBackground(Color.green);
        botaoAdd.setFont(new Font("Serif",Font.BOLD,24));
        botaoAdd.addActionListener(new BotaoAddController(metodosNinja, this));
        // PERSONALIZAÇÃO DO BOTÃO PESQUISAR

        botaoPesq = new JButton("Pesquisar", pesqImg);
        botaoPesq.setBackground(Color.yellow);
        botaoPesq.setFont(new Font("Serif",Font.BOLD,24));
        botaoPesq.addActionListener(new BotaoPesqController(metodosNinja,this));
        // PERSONALIZAÇÃO DO BOTÃO REMOVER

        botaoRemove = new JButton("Remover", removeImg);
        botaoRemove.setBackground(Color.red);
        botaoRemove.setFont(new Font("Serif",Font.BOLD,24));
        botaoRemove.addActionListener(new BotaoRemoveController(metodosNinja,this));
        // PASSANDO O LAYOUT E ADICIONANDO OS ELEMENTOS A TELA

        setLayout(new GridLayout(3,3));
        add(aldeiaFolha);
        add(titulo);
        add(aldeiaCeu);
        add(itachi);
        add(naruto);
        add(sasuke);
        add(botaoAdd);
        add(botaoPesq);
        add(botaoRemove);
        // ADICIONANDO A BARRA DE MENU
        //MENU CADASTRAR

        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarNinja = new JMenuItem("Cadastrar Ninja");
        menuCadastrar.add(menuCadastrarNinja);
        //MENU PESQUISAR

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarNinja = new JMenuItem("Pesquisar Ninja");
        menuPesquisar.add(menuPesquisarNinja);
        //MENU REMOVER

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverNinja = new JMenuItem("Remover Ninja");
        menuRemover.add(menuRemoverNinja);
        //MENU SALVAR

        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarNinja = new JMenuItem("Salvar Ninja");
        menuSalvar.add(menuSalvarNinja);
        //ADICIONANDO A FUNCIONALIDADE DO MENU
        //USANDO LAMBDA NA FUNCIONALIDADE DO BOTÃO ADICIONAR

        menuCadastrarNinja.addActionListener((ae) -> {
            try {
                String nome = JOptionPane.showInputDialog(this,"Qual o nome do Ninja?");
                String cla = JOptionPane.showInputDialog(this,"Qual o Clã do Ninja?");
                int poder = Integer.parseInt(JOptionPane.showInputDialog(this,"Qual o poder do Ninja?"));
                metodosNinja.cadastrarNinja(nome,cla,poder);
            } catch (NinjaJaExisteException e) {
                JOptionPane.showMessageDialog(this,"Esse Ninja já foi cadastrado! Tente novamente com outro Ninja.");
            }
        });
        menuPesquisarNinja.addActionListener(new BotaoPesqController(metodosNinja,this));
        menuRemoverNinja.addActionListener(new BotaoRemoveController(metodosNinja,this));
        menuSalvarNinja.addActionListener(new BoaoSaveController(metodosNinja,this));
        //ADICIONANDO OS BOTÕES DA BARRA DE MENU NA TELA

        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuSalvar);
        setJMenuBar(barraDeMenu);
    }
}