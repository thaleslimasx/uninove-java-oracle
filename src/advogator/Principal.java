/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advogator;

import java.awt.Component;
import java.awt.Image;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.objects.Global;
import sun.awt.resources.awt;
import static sun.rmi.transport.TransportConstants.Return;

/**
 *
 * @author dener
 */
public class Principal {
     
    
        JFrame principal = new JFrame();
        CadastroAdvogado adv = new CadastroAdvogado();
        
        
        
        private final JButton btncadastraradv;
        private final JButton btncadastrarrecl;
        private final JButton btncadastrarproc;
        //private final JButton btnconsultarproc;
       // private final JButton btnconsultaadv;
        //private final JButton btnconsultarecl;
        
        
        
        
        JMenuBar barra = new JMenuBar();        
        
        JMenu menu1 = new JMenu("Opções");
        JMenuItem item1 = new JMenuItem("Configurações de usuário");
        JMenuItem item12 = new JMenuItem("Excluir advogado");
        
        
        
        JMenu menu2 = new JMenu("Sair");
        JMenuItem item2 = new JMenuItem("Exit");
        
  
     
        
    public Principal(){
        
        principal.setJMenuBar(barra);
        
        //this.barra.setIcon(new javax.swing.ImageIcon (getClass().getResource("pesquisaadvogado.png")).getImage);       
        
        barra.add(menu1);
        
        menu1.add(item1);
        
        item1.addActionListener(new ActionListener() {
     
       
            public void actionPerformed(ActionEvent e) {
                Alterasenha altera = new Alterasenha();
                altera.senha.show();
//JOptionPane.showMessageDialog(null, "Você fez essa clase pode acaso? então como quer abrir ela? babaca");
            }
        });
        
        barra.add(menu1);
        menu1.add(item12);
        item12.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {
               
                         Exclui();
                
            } 
        });
        
        barra.add(menu2);
        
        menu2.add(item2);
        
        item2.addActionListener(new ActionListener() {

       
            public void actionPerformed(ActionEvent e) {
               principal.dispose();
               Login login = new Login();
               login.login.show();
            }
        });
        
       
       
            
        this.principal.setSize(640, 480);
        this.principal.setTitle("Janela Principal");
        principal.setLocation(0,100);  
        this.principal.setLayout(null);
       
             
        
        
                       
        btncadastraradv = new JButton("Advogados");
        btncadastraradv.setLocation(210, 100);
        btncadastraradv.setSize(195, 50);
                btncadastraradv.addActionListener(new // adiciona o comando listener
            ActionListener() // Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                   
                    adv.advogado.setVisible(true);
                }
            });
        this.btncadastraradv.setIcon(new javax.swing.ImageIcon (getClass().getResource("advogado.png")));  
        this.principal.add(btncadastraradv);
        
      /*  btnconsultaadv = new JButton("Consultar Advogados");
        btnconsultaadv.setLocation(415, 210);
        btnconsultaadv.setSize(195, 50);
                btncadastraradv.addActionListener(new // adiciona o comando listener
            ActionListener() // Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                   System.out.print("Sem função");
                }
            });
        this.btnconsultaadv.setIcon(new javax.swing.ImageIcon (getClass().getResource("pesquisaadvogado.png")));        
        this.principal.add(btnconsultaadv);*/
        
        btncadastrarrecl = new JButton("Reclamantes");
        btncadastrarrecl.setLocation(210, 170);
        btncadastrarrecl.setSize(195, 50);
        btncadastrarrecl.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) 
            {
               System.out.print("Sem função \n");
            }
        });
        this.btncadastrarrecl.setIcon(new javax.swing.ImageIcon (getClass().getResource("icon_reclamante.png")));   
        this.principal.add(btncadastrarrecl);
        
        /*btnconsultarecl = new JButton("Consultar Reclamantes");
        btnconsultarecl.setLocation(815, 210);
        btnconsultarecl.setSize(200, 50);
        btnconsultarecl.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                System.out.print("Sem função");
            }
        });
        this.btnconsultarecl.setIcon(new javax.swing.ImageIcon (getClass().getResource("icon_pesquisa_reclamante.png")));   
        this.principal.add(btnconsultarecl);*/
        
        
        btncadastrarproc = new JButton("Processos");
        btncadastrarproc.setLocation(210, 240);
        btncadastrarproc.setSize(195, 50);
        btncadastrarproc.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
              System.out.print("Sem função");
            }
        });
        this.btncadastrarproc.setIcon(new javax.swing.ImageIcon (getClass().getResource("icon_processo.png")));   
        this.principal.add(btncadastrarproc);
        
       /* btnconsultarproc = new JButton("consultar Processo");
        btnconsultarproc.setLocation(415, 270);
        btnconsultarproc.setSize(195, 50);
        btnconsultarproc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.print("Sem função");
            }
        });
        this.btnconsultarproc.setIcon(new javax.swing.ImageIcon (getClass().getResource("icon_pesquisa_processo.png")));   
        this.principal.add(btnconsultarproc);*/
        
    }
        
             private void Exclui(){
            
        
                
                Excluir excluir = new Excluir();
                
                excluir.excluir.setVisible(true); 
                excluir.excluir.setEnabled(true);
                
                for(int teste = 1; teste >= 1; teste ++){
                 
                  
                
                if(excluir.excluir.isEnabled()){
                    btncadastraradv.setEnabled(false);
                    
                }else{
                    excluir.excluir.setEnabled(false);
                    btncadastraradv.setEnabled(true);
                                      teste = 1;
                }
                } 
            
        
 
        
    }

    
            
            
    
}
