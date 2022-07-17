/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advogator;

import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author dener
 */
public class Alterasenha {
    
        JFrame senha = new JFrame();
        private Conexao Connects = new Conexao();
        private Connection Cnn;
        Login login = new Login();
        
        private JTextField txtlogin;
        private JPasswordField txtsenha;
        private JPasswordField txtsenhaantiga;
        private JPasswordField txtsenha2;
        private JPasswordField txtsenha3;
        
    public Alterasenha(){
    
    Cnn = Connects.getConexao();

        this.senha.setSize(450, 550);
        this.senha.setTitle("Login");
        senha.setLocation(650,380);
        this.senha.setLayout(null);
        
        JLabel lblusario = new JLabel("Usuário: ");
        lblusario.setSize(100,20);
        lblusario.setLocation(50,50);
        this.senha.add(lblusario);
        
        txtlogin = new JTextField("");
        txtlogin.setSize(200, 20);
        txtlogin.setLocation(120, 50);
        txtlogin.setText(login.nome);
        this.senha.add(txtlogin);
        
        JLabel lblsenha = new JLabel("Digite a antiga senha: ");
        lblsenha.setSize(150,20);
        lblsenha.setLocation(50,80);
        this.senha.add(lblsenha);
        
        txtsenhaantiga = new JPasswordField();
        txtsenhaantiga.setSize(200, 20);
        txtsenhaantiga.setLocation(190, 80);
        this.senha.add(txtsenhaantiga);
        
        
        JLabel lblsenha2 = new JLabel("Digite a nova senha: ");
        lblsenha2.setSize(100,20);
        lblsenha2.setLocation(50,110);
        this.senha.add(lblsenha2);
        
        txtsenha2 = new JPasswordField();
        txtsenha2.setSize(170, 20);
        txtsenha2.setLocation(170, 130);
        this.senha.add(txtsenha2);
        
        
        JLabel lblsenha3 = new JLabel("Digite a nova senha novamente: ");
        lblsenha3.setSize(100,20);
        lblsenha3.setLocation(50,140);
        this.senha.add(lblsenha3);
        
        txtsenha3 = new JPasswordField();
        txtsenha3.setSize(170, 20);
        txtsenha3.setLocation(220, 140);
        this.senha.add(txtsenha3);
}
    
    
}
