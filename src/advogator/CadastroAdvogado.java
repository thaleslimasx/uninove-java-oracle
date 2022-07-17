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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author dener
 */
public class CadastroAdvogado {
    
    
    JFrame advogado = new JFrame();
    
    private Conexao Conect = new Conexao();     // instancia do objeto de conexão com a base de dados
    private Connection Cnn;
    
    private final JLabel lbloab;
    private final JTextField txtoab;
    private final JLabel lblnome;
    private final JTextField txtnome;
    private final JLabel lblusuario;
    private final JTextField txtusuario;
    private final JLabel lblsenha;
    private final JPasswordField txtsenha;
    private final JLabel lblstatus;
    private final JTextField txtstatus;
    private final JButton btncadastrar;
    private final JButton btnsair;
    private final JButton btnconsultar;
    private final JButton btnalterar;
   // private final JButton btncancelar;
    private final JTextField txtid_adv;
    private final JLabel lblid;
    
    int OpTipo = 0;
    String PrevCod = "";
    int validacao = 1;
        
    
    public CadastroAdvogado(){
        
        Cnn = Conect.getConexao(); 
      
          
        
        
        this.advogado.setSize(650, 380);
        this.advogado.setTitle("Área dos Advogados");
        advogado.setLocation(0, 0);
        this.advogado.setLayout(null);
        
        lbloab = new JLabel("Número da OAB: ");
        lbloab.setLocation(140, 50);
        lbloab.setSize(200, 20);
        this.advogado.add(lbloab);
        
        txtoab = new JTextField();
        txtoab.setLocation(240, 50);
        txtoab.setSize(200, 20);
        this.advogado.add(txtoab);
        
        lblnome = new JLabel("Nome completo: ");
        lblnome.setLocation(140, 100);
        lblnome.setSize(200, 20);
        this.advogado.add(lblnome);
        
        txtnome = new JTextField();
        txtnome.setLocation(240, 100);
        txtnome.setSize(200, 20);
        this.advogado.add(txtnome);
        
        lblusuario = new JLabel("Login: ");
        lblusuario.setLocation(450, 50);
        lblusuario.setSize(200, 20);
        this.advogado.add(lblusuario);
        
        txtusuario = new JTextField();
        txtusuario.setLocation(500, 50);
        txtusuario.setSize(200, 20);
        this.advogado.add(txtusuario);
        
        lblsenha = new JLabel("Senha: ");
        lblsenha.setLocation(450, 100);
        lblsenha.setSize(200, 20);
        this.advogado.add(lblsenha);
        
        txtsenha = new JPasswordField();
        txtsenha.setLocation(500, 100);
        txtsenha.setSize(200, 20);
        this.advogado.add(txtsenha);
        
        lblstatus = new JLabel("Status: ");
        lblstatus.setLocation(450, 150);
        lblstatus.setSize(200, 20);
        this.advogado.add(lblstatus);
        
        txtstatus = new JTextField("Ativo");
        txtstatus.setLocation(500, 150);
        txtstatus.setSize(200, 20);
        this.advogado.add(txtstatus);
        
        lblid = new JLabel("Sua ID: ");
        lblid.setLocation(450, 180);
        lblid.setSize(200, 20);
        this.advogado.add(lblid);
              
        txtid_adv = new JTextField("");
        txtid_adv.setLocation(500, 180);
        txtid_adv.setSize(100, 20);
        this.advogado.add(txtid_adv);
        
        
        
        btncadastrar = new JButton("Cadastro");
        btncadastrar.setLocation(15, 40);
        btncadastrar.setSize(100, 30);
        
        btncadastrar.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    InserirRegistro();
                      //Limpa_campos();
                }
        });
        this.advogado.add(btncadastrar);
        
  
    
        btnconsultar = new JButton("Consulta");
        btnconsultar.setLocation(15, 85);
        btnconsultar.setSize(100, 30);
        
        btnconsultar.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Consulta();
                   
                }
        });
        this.advogado.add(btnconsultar);
        
        
        btnalterar = new JButton("Alteração");
        btnalterar.setLocation(15, 130);
        btnalterar.setSize(100, 30);
        btnalterar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                AlterarRegistro();
            }
            
        });
        this.advogado.add(btnalterar);
        
        
        btnsair = new JButton("sair");
        btnsair.setLocation(15, 175);
        btnsair.setSize(100, 30);
        
        btnsair.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Finaliza();
                }
        });
        this.advogado.add(btnsair);
        
    
        
   /*     btnsair = new JButton("Sair");
        btnsair.setLocation(15, 220);
        btnsair.setSize(100, 30);
        
        btnsair.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    advogado.dispose();
                }
        });
        this.advogado.add(btnsair);*/
    
        Desable();
    
    }
     
        
 private void Consulta(){
        
       ConsultaAdvogados janela2;
       janela2 = new ConsultaAdvogados(this);
       janela2.setVisible(true);
    }
    
    private void Finaliza(){ //inicio da funação que finaliza o programa 
        this.advogado.dispose(); // finalização do programa
    }
    
    
    private void InserirRegistro(){ //inicio da função que insere o registro
        
        if(OpTipo == 0) { // verifica a operação realizada
            
           //txtCodigo.setEnabled  (true);

            PrevCod = txtid_adv.getText(); // acumula o codigo antirior para caso de cancelamento
            
            int Codigo; //inicia a veriavel que gera o novo codigo
            
            String Cmd = "SELECT id_advogado FROM advogado ORDER BY id_advogado DESC LIMIT 1" ; //localiza o ultimo registro
            PreparedStatement PS; // iniciaza a variavel que controla a execuçao de comandos
            try { // inicia a verificação de erro
                PS = Cnn.prepareStatement(Cmd); //envia o comando a base de dados
                ResultSet RS = PS.executeQuery(); // executga o comando solicitado

                if(RS.next()) { // verifica se houve retorno
                    Codigo = Integer.parseInt(RS.getString(1)); // captura o ultimo codigo inserido
                    txtid_adv.setText(String.format("%06d", Codigo + 1)); // cria o novo codigo
                    
                } else { // caso não haja registros
                    txtid_adv.setText("000001"); // inicia o registro "000001"
                }
                } catch (SQLException ex) { // executa caso haja erro
                Logger.getLogger(CadastroAdvogado.class.getName()).log(Level.SEVERE, "erro da ID", ex); //emite uma mensagem de erro
            }
            
            Habilita(); // chamada da função que habilita os campos

        txtoab.setText(""); //campo de texto cod_processo
        txtnome.setText(""); //campo de texto classe_judicial
        txtusuario.setText(""); //campo de texto orgão_julgador
        txtsenha.setText(""); //campo de texto valor_causa
      

            

            btncadastrar.setText("Gravar"); // altera o texto do botão inserir para gravar
            btnalterar.setText("Cancelar");// altera o texto do botão alterar para cancelar

            
            //btnsair.setEnabled(false);// desabilita o botão sair

            OpTipo = 1; // coloca o programa em inclusão
            
        } else { // Caso o programa esteja realizando uma inclusão/alteração
            

                     if(txtoab.getText().equals("") || txtnome.getText().equals("") || 
                    txtusuario.getText().equals("") || txtsenha.getText().equals("")){
                        
                        JOptionPane.showMessageDialog(null, "Preencha os campos");
                        
                    return;

                     }
                     if(validacao == 1){
                          JOptionPane.showMessageDialog(null,"Número da OAB já cadastrado");
                          validacao = 0;
                          return;
                     }
  
            String Cmd = ""; //inicia a variavel do comando
          
                if(OpTipo == 1){ 
                   CheckUser();
                Cmd = "INSERT INTO advogado (id_advogado, numero_oab, nome, login, senha, status_adv)"; // criação do comando de inclusão
                Cmd += "VALUES (?, ?, ?, ?, ?, ?)"; // criação do comando de inclusão
                JOptionPane.showMessageDialog(null, "Advogado cadastro com sucesso");
                }
               else{ // caso estajamos alterando
                Cmd = "UPDATE advogado SET numero_oab = ?, nome = ?, login = ?, "; // criação do comando de alteração
                Cmd += "senha = ?, status_adv = ? where id_advogado = ?";// criação do comando de alteração
                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
            }
            
            try { // inicia a verificação de erro
                PreparedStatement PS = Cnn.prepareStatement(Cmd); // iniciaza a variavel que controla a execuçao de comandos
                
                int Pos = 1; //indica o parametro inicial
                
               
               
                   
                   if(OpTipo == 1 ) { // verifica se estamos incluindo 
                    PS.setString(1, txtid_adv.getText()); // informa o codigo em caso de inclusão
                    Pos++; // move para o proximo parametro
                }
        
                
                PS.setString(Pos, txtoab.getText());// informa o nome
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtnome.getText());// informa o numero
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtusuario.getText());// informa o Bairro
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtsenha.getText());// informa a cidade
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtstatus.getText());// informa a cidade
                Pos++;// move para o proximo parametro
    
                
                if(OpTipo == 2) {// verifica se estamos alterando
                    PS.setString(Pos, txtid_adv.getText()); // informa o codigo em caso de alteração
                }
                
                PS.execute(); // executa o comando 

            } catch (SQLException ex) { // executa em caso de erro
                Logger.getLogger(CadastroAdvogado.class.getName()).log(Level.SEVERE, null, ex); // mensagem de erro
            }
            
            btncadastrar.setText("Cadastro");  // Altera a descrição do botão gravar para inserir
            btnalterar.setText("Alterar");// Altera a descrição do botão cancelar para alterar

            //btnExcluir.setEnabled(true);  // habilita o  botão excluir
            //btnConsultar.setEnabled(true);// habilita o  botão consultar
            btnsair.setEnabled(true);// habilita o  botão sair

            OpTipo = 0; // retorna a solicitação de operaçao

            Desable(); // chamada da função que desabilita os campos
         
             
         
         }
     
    }
   /* private void Consulta(){
        
        ConsultaProcesso janela2;
       janela2 = new ConsultaProcesso(this);
       janela2.setVisible(true);
    }*/
     private void AlterarRegistro(){ // inicio da função que altera registros
        
        if(OpTipo == 0) { // verifica a operação realizada
            
            Habilita(); // chnamada da fujnção que habilita os campos
            txtid_adv.setEnabled  (true);
            PrevCod = txtid_adv.getText(); // acumula o codigo antirior para caso de cancelamento

            btncadastrar.setText("Gravar"); // altera o texto do botão inserir para gravar
            btnalterar.setText("Cancelar");// altera o texto do botão alterar para cancelar

            //btnExcluir.setEnabled(false); // desabilita o botão excluir
            //btnConsultar.setEnabled(false);// desabilita o botão consultar
           // btnsair.setEnabled(false);// desabilita o botão sair

            OpTipo = 2; // informa que estamos realizando uma alteração
        }else { // caso estajamos realizando uma inclusão ou alteração
            
            SetKey(PrevCod); // localiza o registro anterior a solicitação
            
            btncadastrar.setText("Cadastro");  // Altera a descrição do botão gravar para inserir
            btnalterar.setText("Alterar");// Altera a descrição do botão cancelar para alterar

            //btnExcluir.setEnabled(true);  // habilita o  botão excluir
            //btnConsultar.setEnabled(true);// habilita o  botão consultar
            btnsair.setEnabled(true);// habilita o  botão sair

            OpTipo = 0; // retorna a solicitação de operaçao

            Desable(); // chamada da função que desabilita os campos
            
        }
     
    }
    private void Desable(){ // inicio da função que desabilita os campos
    txtid_adv.setEnabled(false); //campo de texto id
    txtoab.setEnabled(true); //campo de texto cod_processo
    txtnome.setEnabled(false); //campo de texto classe_judicial
    txtusuario.setEnabled(false); //campo de texto orgão_julgador
    txtsenha.setEnabled(false); //campo de texto valor_causa
    txtstatus.setEnabled(false);
    
        /*this.advogado.setSize(400, 180);  // estabelece o tamanho da janela
        txtid_adv.setLocation (10 , 100);//define a localização  do Butão
        btnalterar.setLocation (110 , 100);//define a localização  do Butão
        btnconsultar.setLocation (210 , 100);//define a localização  do Butão*/

        txtid_adv .setVisible(false);
        lblid .setVisible(false); 
        lblnome.setVisible(false);
        txtnome.setVisible(false);
        lbloab.setVisible(false);
        txtoab.setVisible(false); 
        lblusuario.setVisible(false);
        txtusuario.setVisible(false); 
        lblsenha.setVisible(false); 
        txtsenha.setVisible(false); 
        txtstatus.setVisible(false);
        lblstatus.setVisible(false);
        
        
            
    }
    
    private void Habilita(){

    txtnome.setEnabled(true);
    txtoab.setEnabled(true);
    txtusuario.setEnabled(true); 
    txtsenha.setEnabled(true);

    
        this.advogado.setSize(900, 500);  // estabelece o tamanho da janela
       // btncadastrar.setLocation (10 , 360);//define a localização  do Butão
        //btnalterar.setLocation (110 , 360);//define a localização  do Butão
        //btnconsultar.setLocation (210 , 360);//define a localblreclamante.setVisible(true);
       
        txtid_adv.setVisible(true);
        lblid.setVisible(true);
        lblnome.setVisible(true);
        txtnome.setVisible(true); 
        lbloab.setVisible(true);
        txtoab.setVisible(true);
        lblusuario.setVisible(true);
        txtusuario.setVisible(true);
        lblsenha.setVisible(true);
        txtsenha.setVisible(true);
        txtstatus.setVisible(true);
        lblstatus.setVisible(true);
        
     
    }
    public void SetKey(String Keys) { // inicio da função que localiza registros
        
        
        String Cmd; //criação da variavel que cria comandos
        
        if(Keys == "") { // verifica se foi solicitada um chave
            Cmd = "SELECT * FROM advogado ORDER BY id_advogado DESC LIMIT 1"; // comando que localiza o ultimo registro
        } else { // se foi informada uma chave
            Cmd = "SELECT * FROM advogado WHERE id_advogado = '" + Keys + "'"; // comando que localiza um regustro especifico
        }
        PreparedStatement PS; //cria a variavel que controle o envio de comandos
        try { //inicia a verificação  de erro
            PS = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet RS = PS.executeQuery(); // envia o comando e guarda o resultado
            if(RS.next()){ // verifica se retornou o registro
                    txtid_adv.setText(RS.getString(1)); //informa  campo 
                    txtoab.setText(RS.getString(2));//informa  campo 
                    txtnome.setText(RS.getString(4));//informa  campo 
                    txtusuario.setText(RS.getString(5));//informa  campo 
                    txtsenha.setText(RS.getString(6));//informa  campo
                    txtstatus.setText(RS.getString(7));//informa  campo 
                    
                    
                    
            }
        } catch (SQLException ex) { // caso haja erro
            Logger.getLogger(CadastroAdvogado.class.getName()).log(Level.SEVERE, null, ex); // mensagem de erro
        }
    }
    
    public void limpa_campos(){
        txtid_adv.setText("");
        txtnome.setText("");
        txtoab.setText("");
        txtsenha.setText("");
        txtusuario.setText("");
        
        
    }
   
  public List<String []> LogRegs(){ //Inicio da função que retorna os clientes
        
        String Cmd; //criação da variavel que cria comandos
        List<String []> ListDados = new ArrayList(); // criação da lista de dados

        Cmd = "Select * From advogado Order by id_advogado"; // comando que localiza o ultimo registro
        PreparedStatement st; // criação da variavel de envio de comandos
        try { // inicio da verificação de problemas 
            st = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet rs = st.executeQuery("Select * From advogado Order by id_advogado");  // criação do comando SQL para retornar todos os registro

//            CallableStatement stm = Cnn.prepareCall("{call CodigosAgenda()}");
//            ResultSet rs = stm.executeQuery(); 
 
            while(rs.next()) { // Verifica se algum registro foi localizado
                ListDados.add(new String[] {rs.getString("id_advogado"),rs.getString("numero_oab"),rs.getString("nome"),rs.getString("status_adv")}); // inclusão do registro no modo padrão
            }
        } catch (SQLException ex) { // inicio da verificação de erro
            Logger.getLogger(CadastroAdvogado.class.getName()).log(Level.SEVERE, "Erro 000007x1", ex);  // mensagem de erro
        }
        
        return ListDados; // retorno
  }
  
 
  
  
   private void CheckUser() {
                
        String Tmd;
        Tmd = "Select * from advogado Where numero_oab = '" + txtoab.getText() + "'";
        
        try {

            PreparedStatement PS = Cnn.prepareStatement(Tmd);
            ResultSet RS = PS.executeQuery();
        
            if(RS.next()) {
                validacao = 1;
               
                RS.close();
    
            }
    
        } 
         
         catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            
        }
     
    }
    

}       