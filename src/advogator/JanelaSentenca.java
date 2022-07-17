/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advogator;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Matheus
 */
public class JanelaSentenca extends JFrame {
    
    private Conexao Conect = new Conexao();     // instancia do objeto de conexão com a base de dados
    private Connection Cnn; // inicialização da variavel de conxão
    
    private final JLabel lblid;
    private final JLabel lblcod_processo;
    private final JLabel lbldata;
    private final JLabel lbljuiz;
    private final JLabel lblsentenca;
    private final JLabel lblobservacoes;
    
    private final JTextField txtid; //campo de texto id
    private final JTextField txtcod_processo;
    private final JTextField txtdata;
    private final JTextField txtjuiz;
    
    private final JTextArea txasentenca; //campo de area de texto
    private final JTextArea txaobservacoes;
    
    private final JButton btnInserir; // Criação do botão 
    private final JButton btnCancelar; // Criação do botão 
    private final JButton btnConsultarCob; // Criação do botão 
    private final JButton btnSair; // Criação do botão 
            
            
            
    int OpTipo = 0; // variavel de controle de ação
    String PrevCod = ""; // variavel de controle de codigos  
  
    
    public JanelaSentenca() {  
 
       Cnn = Conect.getConexao();  // iniciando a conexão     
        
        this.setSize(600, 550);
        this.setLocation (700, 200);
        this.setLayout (null);
        this.setTitle ("Sentença");
                
                
        lblid = new JLabel("ID Sentença"); // define a label do codigo
        lblid.setSize(70, 90); // define o tamanho do label
        lblid.setLocation(20, 20); // define a localização do label
        this.add (lblid); // adiciona o label
                    
        txtid = new JTextField(); //inicialização do campo do codigo
        txtid.setSize(40,20);// define o tamanho do campo
        txtid.setLocation(118,56);// define a localização do campo
        this.add (txtid);// adiciona o Campo
       
        lblcod_processo = new JLabel("N° processo"); // define a label do codigo
        lblcod_processo.setSize(70, 90); // define o tamanho do label
        lblcod_processo.setLocation(20, 50); // define a localização do label
        this.add(lblcod_processo); // adiciona o label

        txtcod_processo = new JTextField(); //inicialização do campo do codigo
        txtcod_processo.setSize(100,20);// define o tamanho do campo
        txtcod_processo.setLocation(118,85);// define a localização do campo
        this.add(txtcod_processo);// adiciona o Campo
        
        lbldata= new JLabel("Data Julgamento"); // define a label do codigo
        lbldata.setSize(100, 90); // define o tamanho do label
        lbldata.setLocation(20, 80); // define a localização do label
        this.add(lbldata); // adiciona o label

        txtdata = new JTextField(); //inicialização do campo do codigo
        txtdata.setSize(80,20);// define o tamanho do campo
        txtdata.setLocation(118,115);// define a localização do campo
        this.add(txtdata);// adiciona o Campo
             
        lbljuiz = new JLabel("Juiz"); // define a label do codigo
        lbljuiz.setSize(100, 90); // define o tamanho do label
        lbljuiz.setLocation(20, 110); // define a localização do label
        this.add(lbljuiz); // adiciona o label

        txtjuiz = new JTextField(); //inicialização do campo do codigo
        txtjuiz.setSize(180,20);// define o tamanho do campo
        txtjuiz.setLocation(118,145);// define a localização do campo
        this.add(txtjuiz);// adiciona o Campo
        
        lblsentenca = new JLabel("Sentença"); // define a label do codigo
        lblsentenca.setSize(100, 90); // define o tamanho do label
        lblsentenca.setLocation(20, 140); // define a localização do label
        this.add(lblsentenca); // adiciona o label
        
        txasentenca = new JTextArea(); //inicialização do campo do codigo
        txasentenca.setSize(400,100);// define o tamanho do campo
        txasentenca.setLocation(118,180);// define a localização do campo
        txasentenca.setLineWrap(true); //quebra a linha 
        this.add(txasentenca);// adiciona o Campo
        
        
        lblobservacoes = new JLabel("Observaçõs"); // define a label do codigo
        lblobservacoes.setSize(100, 90); // define o tamanho do label
        lblobservacoes.setLocation(20, 250); // define a localização do label
        this.add(lblobservacoes); // adiciona o label
        
        txaobservacoes = new JTextArea();
        txaobservacoes.setSize(400,100);
        txaobservacoes.setLocation(118,300);
        txaobservacoes.setLineWrap(true);//quebra a linha
        this.add(txaobservacoes);
        
        btnInserir = new JButton("Inserir"); 
        btnInserir.setSize(95 , 30); 
        btnInserir.setLocation (118 , 450);
        btnInserir.addActionListener(new                    
            ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                   InserirRegistro();
                }

            });
        
        this.add(btnInserir);
        
        btnCancelar = new JButton ("Cancelar"); 
        btnCancelar.setSize(95, 30);
        btnCancelar.setLocation (218 , 450);
        btnCancelar.addActionListener(new           
            ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
//                    Dispose(); 
                    
                }

            });
        this.add(btnCancelar);
        
        btnConsultarCob = new JButton ("Consultar Cobrança"); 
        btnConsultarCob.setSize(95, 30);
        btnConsultarCob.setLocation (318 , 450);
        btnConsultarCob.addActionListener(new
       
                ActionListener()// Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                   Consulta();                   
                }

            });
                      
        this.add(btnConsultarCob);
     
        btnSair = new JButton("Sair"); 
        btnSair.setSize(95 , 30); 
        btnSair.setLocation (418, 450);
        btnSair.addActionListener(new 
            ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    Finaliza();
                }

            });
        this.add(btnSair);
        Desable();
}     
            
    
    
    private void Finaliza(){ //inicio da funação que finaliza o programa 
        this.dispose(); // finalização do programa
    }

     private void InserirRegistro(){ //inicio da função que insere o registro
        
        if(OpTipo == 0) { // verifica a operação realizada
            
           //txtCodigo.setEnabled  (true);

            PrevCod = txtid.getText(); // acumula o codigo anterior para caso de cancelamento
            
            int Codigo; //inicia a veriavel que gera o novo codigo
            
            String Cmd = "SELECT id_sentenca FROM sentenca ORDER BY id_sentenca DESC LIMIT 1" ; //localiza o ultimo registro
            PreparedStatement PS; // iniciaza a variavel que controla a execuçao de comandos
            try { // inicia a verificação de erro
                PS = Cnn.prepareStatement(Cmd); //envia o comando a base de dados
                ResultSet RS = PS.executeQuery(); // executga o comando solicitado

                if(RS.next()) { // verifica se houve retorno
                    Codigo = Integer.parseInt(RS.getString(1)); // captura o ultimo codigo inserido
                    txtid.setText(String.format("%06d", Codigo + 1)); // cria o novo codigo
                } else { // caso não haja registros
                    txtid.setText("000001"); // inicia o registro "000001"
                }
                } catch (SQLException ex) { // executa caso haja erro
                Logger.getLogger(JanelaSentenca.class.getName()).log(Level.SEVERE, null, ex); //emite uma mensagem de erro
            }
            
            
        Habilita(); // chamada da função que habilita os campos

        txtcod_processo.setText(""); //campo de texto cod_processo
        txtjuiz.setText(""); //campo de texto juiz
        txasentenca.setText(""); //campo de texto sentenca
        txaobservacoes.setText("");//campo de texto observações       
        txtdata.setText(""); 

            

            btnInserir.setText("Gravar"); // altera o texto do botão inserir para gravar
           
            
//            btnSair.setEnabled(false);// desabilita o botão sair

            OpTipo = 1; // coloca o programa em inclusão
            
        } else { // Caso o programa esteja realizando uma inclusão/alteração
            
            String Cmd = ""; //inicia a variavel do comando
            
            if(OpTipo == 1) { // verifica se estamos incluindo
                Cmd = "INSERT INTO sentenca (id_sentenca, cod_processo, data_julgamento, juiz, sentenca, observacoes)"; // criação do comando de inclusão
                Cmd += "VALUES (?, ?, ?, ?, ?, ?)"; // criação do comando de inclusão
            } else { // caso estajamos alterando
                Cmd = "UPDATE sentenca SET cod_processo = ?, data_julgamento = ?, "; // criação do comando de alteração
                Cmd += "juiz = ?, sentenca = ? observacoes where id_sentenca= ?";// criação do comando de alteração
            }
            
            try { // inicia a verificação de erro
                PreparedStatement PS = Cnn.prepareStatement(Cmd); // iniciaza a variavel que controla a execuçao de comandos
                
                int Pos = 1; //indica o parametro inicial
                
                if(OpTipo == 1) { // verifica se estamos incluindo 
                    PS.setString(1, txtid.getText()); // informa o codigo em caso de inclusão
                    Pos++; // move para o proximo parametro
                }
                PS.setString(Pos, txtcod_processo.getText());// informa cod processo
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtdata.getText());// informa data
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtjuiz.getText());// informa o juiz
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txasentenca.getText());// informa a sentenca
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txaobservacoes.getText());// informa as observacoes
                Pos++;// move para o proximo parametro

                if(OpTipo == 2) {// verifica se estamos alterando
                    PS.setString(Pos, txtid.getText()); // informa o codigo em caso de alteração
                }
                
                PS.execute(); // executa o comando 

            } catch (SQLException ex) { // executa em caso de erro
                Logger.getLogger(JanelaSentenca.class.getName()).log(Level.SEVERE, null, ex); // mensagem de erro
            }
            
            btnInserir.setText("Inserir");  // Altera a descrição do botão gravar para inserir
   

            //btnExcluir.setEnabled(true);  // habilita o  botão excluir
            btnConsultarCob.setEnabled(true);// habilita o  botão consultar
            btnSair.setEnabled(true);// habilita o  botão sair

            OpTipo = 0; // retorna a solicitação de operaçao

            Desable(); // chamada da função que desabilita os campos
            
        }
       
    }
     
    private void Consulta(){
        
        Janela_cobranca janela;
        janela = new Janela_cobranca();
        janela.setVisible(true);
    }
      
    private void Desable(){ 
        txtid.setEnabled(false); 
        txtcod_processo.setEnabled(false); 
        txtdata.setEnabled(false); 
        txtjuiz.setEnabled(false); 
        txasentenca.setEnabled(false); 
        txaobservacoes.setEnabled(false); 
    
        /*this.setSize(600, 550);  // estabelece o tamanho da janela
        btnInserir.setLocation (118 , 450);
        btnCancelar.setLocation (218 , 450);
        btnConsultar.setLocation (318 , 450);
        
        lblid.setVisible(false); 
        txtid.setVisible(false); 
        lbldata.setVisible(false); 
        lbldata.setVisible(false); 
        txtjuiz.setVisible(false); 
        lbljuiz.setVisible(false); 
        txasentenca.setVisible(false); 
        lblsentenca.setVisible(false); 
        txaobservacoes.setVisible(false); 
        lblobservacoes.setVisible(false); */
            
    }
    
    private void Habilita(){// inicio da função que habilita os campos

        txtcod_processo.setEnabled(true); 
        txtdata.setEnabled(true); 
        txtjuiz.setEnabled(true); 
        txtid.setEnabled(true);
        txasentenca.setEnabled(true); 
        txaobservacoes.setEnabled(true); 
    
        //this.setSize(600, 550);  
        /*btnInserir.setLocation (118 , 450);
        btnCancelar.setLocation (218 , 450);
        btnSair.setLocation (418, 450);
        btnConsultar.setLocation (318 , 450);
        /*lblid.setVisible(true); 
        txtid.setVisible(true);     
        lblcod_processo.setVisible(true); 
        txtcod_processo.setVisible(true); 
        lbldata.setVisible(true); 
        txtdata.setVisible(true); 
        lbljuiz.setVisible(true); 
        txtjuiz.setVisible(true); 
        lblsentenca.setVisible(true);
        txasentenca.setVisible(true);
        lblobservacoes.setVisible(true);
        txaobservacoes.setVisible(true);*/
        
    }
     
    public void SetKey(String Keys) { // inicio da função que localiza registros
        
        
        String Cmd; //criação da variavel que cria comandos
        
        if(Keys == "") { // verifica se foi solicitada um chave
            Cmd = "SELECT * FROM sentenca ORDER BY id_sentenca DESC LIMIT 1"; // comando que localiza o ultimo registro
        } else { // se foi informada uma chave
            Cmd = "SELECT * FROM sentenca WHERE id_sentenca = '" + Keys + "'"; // comando que localiza um regustro especifico
        }
        PreparedStatement PS; //cria a variavel que controle o envio de comandos
        try { //inicia a verificação  de erro
            PS = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet RS = PS.executeQuery(); // envia o comando e guarda o resultado
            if(RS.next()){ // verifica se retornou o registro
                    txtid.setText(RS.getString(1)); //informa  campo 
                    txtcod_processo.setText(RS.getString(2));//informa  campo 
                    txtdata.setText(RS.getString(3));//informa  campo 
                    txtjuiz.setText(RS.getString(4));//informa  campo 
                    txasentenca.setText(RS.getString(5));
                    txaobservacoes.setText(RS.getString(6));
                       
            }
        } catch (SQLException ex) { // caso haja erro
            Logger.getLogger(JanelaSentenca.class.getName()).log(Level.SEVERE, null, ex); // mensagem de erro
        }
    }
   
    public List<String []> LogRegs(){ //Inicio da função que retorna os processos
        
        String Cmd; //criação da variavel que cria comandos
        List<String []> ListDados = new ArrayList(); // criação da lista de dados
        
        Cmd = "Select * From sentenca Order by id_sentenca"; // comando que localiza o ultimo registro
        PreparedStatement st; // criação da variavel de envio de comandos
        try { // inicio da verificação de problemas 
            st = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet rs = st.executeQuery("Select * From sentenca Where cod_processo = '"+txtcod_processo.getText()+"'");  // criação do comando SQL para retornar todos os registro

//            CallableStatement stm = Cnn.prepareCall("{call CodigosAgenda()}");
//            ResultSet rs = stm.executeQuery(); 
 
            while(rs.next()) { // Verifica se algum registro foi localizado
                ListDados.add(new String[] {rs.getString("id_sentenca"),rs.getString("cod_processo"),rs.getString("data_julgamento"),rs.getString("juiz"),rs.getString("sentenca"),rs.getString("observacoes")}); // inclusão do registro no modo padrão
            }
        } catch (SQLException ex) { // inicio da verificação de erro
            Logger.getLogger(JanelaSentenca.class.getName()).log(Level.SEVERE, null, ex);  // mensagem de erro
        }
        
        return ListDados; // retorn
        
    }    
    
    
}       

