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
import javax.swing.JTextField;

/**
 *
 * @author Internet
 */
public class Excluir {
    
    JFrame excluir = new JFrame();
    private final JLabel lblid;
    private final JTextField txtid;
    private final JButton btnexcluir;
    private final JButton btnsair;
    int joption = 0;
    int joption2 = 0;
    public String id;
    Principal principal = new Principal();
    private Conexao Connects = new Conexao();
    private Connection Cnn;
    
    
    public Excluir(){
       
        Cnn = Connects.getConexao();
        
        this.excluir.setSize(450 , 250);
        this.excluir.setTitle("Excluir Advogado");
        this.excluir.setLocation(500, 300);
        this.excluir.setLayout(null);
        
        lblid = new JLabel("ID do Advogado");
        lblid.setSize(100, 20);
        lblid.setLocation(80, 10);
        this.excluir.add(lblid);
        
        txtid = new JTextField();
        txtid.setLocation(190, 10);
        txtid.setSize(130,20);
        this.excluir.add(txtid);
        
      
        
        btnexcluir = new JButton("Desligar advogado");
        btnexcluir.setSize(160, 30);
        btnexcluir.setLocation(80, 50);
        
        btnexcluir.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                joption = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja desligar este advogado?", "Desligar advogado",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                
                if(joption == JOptionPane.YES_OPTION){
      
                   CheckUser();
                    joption2 = JOptionPane.showConfirmDialog(null, "Deseja Desligar outro advogado?", "AVISO", JOptionPane.YES_NO_OPTION);
                    txtid.setText("");
                    if(joption2 == JOptionPane.NO_OPTION){
                     principal.principal.setEnabled(true);
                     excluir.setEnabled(false);
                    excluir.dispose();
                    }
                    
                          
                           
                    
                }
            }
        });
        this.excluir.add(btnexcluir);
        
       btnsair = new JButton("Sair");
       btnsair.setSize(100,30);
       btnsair.setLocation(250, 50);
       btnsair.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent ae) {
                   
                   principal.principal.setEnabled(true);
                   excluir.setEnabled(false);
                   excluir.dispose();
                   
                    
            }
       });
       
       this.excluir.add(btnsair);
        
        
        
    }  

               String cmd;
                     
   private boolean CheckUser() {
                
        String Cmd;
        id = txtid.getText();
        Cmd = "select * from advogado where id_advogado = '"+txtid.getText()+"'";
        
        try {

            PreparedStatement PS = Cnn.prepareStatement(Cmd);
            ResultSet RS = PS.executeQuery();
            Cmd ="";
            if(RS.next()) {
                
                Cmd = "UPDATE advogado SET status_adv = 'Desligado' where id_advogado = "+txtid.getText();
                //PS.setString(6, txtidd.getText()); // informa o codigo em caso de inclusão
                  PS = Cnn.prepareStatement(Cmd);
                  PS.execute();
                
                JOptionPane.showMessageDialog(null,"Advogado Desligado com sucesso");
 
            }

            else {
                
                JOptionPane.showMessageDialog(null,"ID advogado incorreta");
                RS.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
}
}
