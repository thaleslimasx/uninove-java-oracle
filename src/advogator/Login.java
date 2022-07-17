/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advogator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import jdk.nashorn.internal.scripts.JO;

/**
 *
 * @author dener
 */
public class Login{
    

    
    JFrame login = new JFrame();
    
    public String nome;
    private String Senha;

    private Conexao Connects = new Conexao();
    private Connection Cnn;
    
    private final JTextField txtlogin;
    private final JPasswordField txtsenha;

    public Login(){
        
        Cnn = Connects.getConexao();

        this.login.setSize(450, 250);
        this.login.setTitle("Login");
        login.setLocation(650,380);
        this.login.setLayout(null);
        
        JLabel lblnome = new JLabel("Usuário: ");
        lblnome.setSize(100,20);
        lblnome.setLocation(50,50);
        this.login.add(lblnome);
        
        txtlogin = new JTextField();
        txtlogin.setSize(200, 20);
        txtlogin.setLocation(120, 50);
        this.login.add(txtlogin);
        
        JLabel lblsenha = new JLabel("Senha: ");
        lblsenha.setSize(100,20);
        lblsenha.setLocation(50,80);
        this.login.add(lblsenha);
        
        txtsenha = new JPasswordField();
        txtsenha.setSize(170, 20);
        txtsenha.setLocation(120, 80);
        this.login.add(txtsenha);
        
        
        JButton btnentrar = new JButton("Entrar");
        btnentrar.setSize(100, 30);
        btnentrar.setLocation(110, 130);
          btnentrar.addActionListener(new // adiciona o comando listener
            ActionListener() // Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                    
                    nome = txtlogin.getText();
                    CheckUser();
                }
            }
        );  
        this.login.add(btnentrar);
        
        
        
        
        
        JButton btnsair = new JButton("Sair");
        btnsair.setSize(100, 30);
        btnsair.setLocation(220, 130);
        btnsair.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
        });
        this.login.add(btnsair);
        
        
    }

    private boolean CheckUser() {
                
        String Cmd;
        nome = txtlogin.getText();
        Cmd = "Select * from advogado Where login = '" + txtlogin.getText() + "' and senha = '" + txtsenha.getText() + "'";
        
        try {

            PreparedStatement PS = Cnn.prepareStatement(Cmd);
            ResultSet RS = PS.executeQuery();
        
            if(RS.next()) {
                JOptionPane.showMessageDialog(null,"Acesso permitido");
                Principal principal = new Principal();
                principal.principal.show();
                login.setVisible(false);
                
            }
            else if(txtlogin.getText().equals("") || txtsenha.getText().equals("")){
                if(txtlogin.getText().equals("") && txtsenha.getText().equals("") ){
                    
                    JOptionPane.showMessageDialog(null, "Digite o usuário e a senha");
                    
                    
                }
                else if(txtlogin.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Digite um usuário");
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Digite uma senha");
                }
            }
            else {
                
                JOptionPane.showMessageDialog(null,"Usuário ou Senha incorreto.");
                RS.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
            
        
    }

    
    
}
