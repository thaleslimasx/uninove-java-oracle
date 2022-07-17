/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advogator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
import javax.swing.JTextField;


/**
 *
 * @author Miguel
 */
public class peticoes extends JFrame{
    
    private Conexao Conect = new Conexao();     // instancia do objeto de conexão com a base de dados
    private Connection Cnn; // inicialização da variavel de conxão
    
    private final JLabel lblid_peticoes;
    private final JTextField txtid_peticoes;
    private final JLabel lblcod_processo;
    private final JTextField txtcod_processo;
    private final JLabel lbltipo_peticao;
    private final JTextField txttipo_peticao;
    private final JLabel lbldata_anexo;
    private final JTextField txtdata_anexo;
    
    private final JButton btnInserir;
    private final JButton btnAlterar;
    private final JButton btnConsultar;
    private final JButton btnSair;
    
    
    
    int OpTipo = 0;
    String PrevCod = "";
    
    public peticoes(){
    
        Cnn = Conect.getConexao();
        
        this.setSize(800, 330);
        this.setLocation(400, 400);  // selecionando o localização da tela
        this.setTitle("Cadastro de Petições"); // define o titulo da tela
        this.setLayout(null); // desativa os layouts padrão
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha a janela
        
        lblid_peticoes = new JLabel("ID");
        lblid_peticoes.setSize(40, 30);
        lblid_peticoes.setLocation(10, 10);
        this.add(lblid_peticoes);
                
        txtid_peticoes = new JTextField();
        txtid_peticoes.setSize(60, 20);
        txtid_peticoes.setLocation(105, 15);
        this.add(txtid_peticoes);        
                
        lblcod_processo = new JLabel("n°processo");
        lblcod_processo.setSize(80, 30);
        lblcod_processo.setLocation(10, 40);
        this.add(lblcod_processo);
                
        txtcod_processo = new JTextField();
        txtcod_processo.setSize(100, 20);
        txtcod_processo.setLocation(105, 45);
        this.add(txtcod_processo);             
                
        lbltipo_peticao = new JLabel("Tipo de Petição");
        lbltipo_peticao.setSize(80, 30);
        lbltipo_peticao.setLocation(10, 70);
        this.add(lbltipo_peticao);
                
        txttipo_peticao = new JTextField();
        txttipo_peticao.setSize(200, 20);
        txttipo_peticao.setLocation(105, 75);
        this.add(txttipo_peticao);    
        
        lbldata_anexo = new JLabel("Data do anexo");
        lbldata_anexo.setSize(80, 30);
        lbldata_anexo.setLocation(10, 100);
        this.add(lbldata_anexo);
                
        txtdata_anexo = new JTextField();
        txtdata_anexo.setSize(100, 20);
        txtdata_anexo.setLocation(105, 105);
        this.add(txtdata_anexo);    
        
        
        
        
        btnInserir = new JButton("inserir");   //inicialização do butão inserir 
        btnInserir.setSize(95 , 20); //define o tamanho do botão
        btnInserir.setLocation (10 , 260); //define a localização  do Butão
        btnInserir.addActionListener(new // adiciona o comando listener
            ActionListener() // Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                    InserirRegistro(); //chama a função inserir
                    
                }

            });
        this.add(btnInserir);
        
        btnAlterar = new JButton ("alterar");//inicialização do butão alterar
        btnAlterar.setSize(95 , 20);//define o tamanho do botão
        btnAlterar.setLocation (110 , 260);//define a localização  do Butão
        btnAlterar.addActionListener(new // adiciona o comando listener
            ActionListener()// Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                    AlterarRegistro(); //chama a função alterar
                    
                }

            });
        this.add(btnAlterar);
        
        btnConsultar = new JButton ("Consultar");//inicialização do butão consultar
        btnConsultar.setSize(95 , 20);//define o tamanho do botão
        btnConsultar.setLocation (210 , 260);//define a localização  do Butão
        btnConsultar.addActionListener(new // adiciona o comando listener
            ActionListener()// Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                   Consulta();
                }

            });
        this.add(btnConsultar);
        
        btnSair = new JButton ("Sair");//inicialização do butão sair
        btnSair.setSize(64 , 20);//define o tamanho do botão
        btnSair.setLocation (700, 260);//define a localização  do Butão
        btnSair.addActionListener(new // adiciona o comando listener
            ActionListener()// Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                    Finaliza(); // chamada da função que finaliza o programa
                }

            });
        this.add(btnSair);        
                
               
       Desable();

        
        
        
        
        
    }
    private void Consulta(){
        
       TabelaP janela2;
       janela2 = new TabelaP(this);
       janela2.setVisible(true);
    }
    private void Finaliza(){ //inicio da funação que finaliza o programa 
        this.dispose(); // finalização do programa
    }
    private void InserirRegistro(){ //inicio da função que insere o registro
        
        if(OpTipo == 0) { // verifica a operação realizada
            
           //txtCodigo.setEnabled  (true);
            
            PrevCod = txtid_peticoes.getText(); // acumula o codigo antirior para caso de cancelamento
            
            int Codigo; //inicia a veriavel que gera o novo codigo
            
            String Cmd = "SELECT id_peticoes FROM peticoes ORDER BY id_peticoes DESC LIMIT 1" ; //localiza o ultimo registro
            PreparedStatement PS; // iniciaza a variavel que controla a execuçao de comandos
            try { // inicia a verificação de erro
                PS = Cnn.prepareStatement(Cmd); //envia o comando a base de dados
                ResultSet RS = PS.executeQuery(); // executga o comando solicitado

                if(RS.next()) { // verifica se houve retorno
                    Codigo = Integer.parseInt(RS.getString(1)); // captura o ultimo codigo inserido
                    txtid_peticoes.setText(String.format("%06d", Codigo + 1)); // cria o novo codigo
                } else { // caso não haja registros
                    txtid_peticoes.setText("000001"); // inicia o registro "000001"
                }
                } catch (SQLException ex) { // executa caso haja erro
                Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE, "erro ao conectar", ex); //emite uma mensagem de erro
            }
            
            Habilita(); // chamada da função que habilita os campos

        txtcod_processo.setText(""); //campo de texto 
        txttipo_peticao.setText(""); //campo de texto 
        txtdata_anexo.setText(""); //campo de texto 

           

            btnInserir.setText("Gravar"); // altera o texto do botão inserir para gravar
            btnAlterar.setText("Cancelar");// altera o texto do botão alterar para cancelar

            //btnExcluir.setEnabled(false); // desabilita o botão excluir
            btnConsultar.setEnabled(false);// desabilita o botão consultar
            btnSair.setEnabled(false);// desabilita o botão sair

            OpTipo = 1; // coloca o programa em inclusão
            
        } else { // Caso o programa esteja realizando uma inclusão/alteração
            
            String Cmd = ""; //inicia a variavel do comando
            
            if(OpTipo == 1) { // verifica se estamos incluindo
                Cmd = "INSERT INTO peticoes (id_peticoes, cod_processo, tipo_peticao, data_anexo)"; // criação do comando de inclusão
                Cmd += "VALUES (?, ?, ?, ?)"; // criação do comando de inclusão
            } else { // caso estajamos alterando
                Cmd = "UPDATE peticoes SET cod_processo = ?, tipo_peticao = ?, data_anexo = ? where id_peticoes = ?"; // criação do comando de alteração
            }
            
            try { // inicia a verificação de erro
                PreparedStatement PS = Cnn.prepareStatement(Cmd); // iniciaza a variavel que controla a execuçao de comandos
                
                int Pos = 1; //indica o parametro inicial
                
                if(OpTipo == 1) { // verifica se estamos incluindo 
                    PS.setString(1, txtid_peticoes.getText()); // informa o codigo em caso de inclusão
                    Pos++; // move para o proximo parametro
                }
                PS.setString(Pos, txtcod_processo.getText());// informa o nome
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txttipo_peticao.getText());// informa o numero
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtdata_anexo.getText());// informa o numero
                Pos++;// move para o proximo parametro
                

                if(OpTipo == 2) {// verifica se estamos alterando
                    PS.setString(Pos, txtid_peticoes.getText()); // informa o codigo em caso de alteração
                }
                
                PS.execute(); // executa o comando 

            } catch (SQLException ex) { // executa em caso de erro
                Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE,"erro ao gravar dados", ex); // mensagem de erro
            }
            
            btnInserir.setText("Inserir");  // Altera a descrição do botão gravar para inserir
            btnAlterar.setText("Alterar");// Altera a descrição do botão cancelar para alterar

            //btnExcluir.setEnabled(true);  // habilita o  botão excluir
            btnConsultar.setEnabled(true);// habilita o  botão consultar
            btnSair.setEnabled(true);// habilita o  botão sair

            OpTipo = 0; // retorna a solicitação de operaçao

            Desable(); // chamada da função que desabilita os campos
            
        }
    }
        private void AlterarRegistro(){ // inicio da função que altera registros
        
        if(OpTipo == 0) { // verifica a operação realizada
            
            Habilita(); // chnamada da fujnção que habilita os campos
            //txtid_peticoes.setEnabled  (true);
            PrevCod = txtid_peticoes.getText(); // acumula o codigo antirior para caso de cancelamento

            btnInserir.setText("Gravar"); // altera o texto do botão inserir para gravar
            btnAlterar.setText("Cancelar");// altera o texto do botão alterar para cancelar

            //btnExcluir.setEnabled(false); // desabilita o botão excluir
            btnConsultar.setEnabled(false);// desabilita o botão consultar
            btnSair.setEnabled(false);// desabilita o botão sair

            OpTipo = 2; // informa que estamos realizando uma alteração
        }else { // caso estajamos realizando uma inclusão ou alteração
            
            SetKey(PrevCod); // localiza o registro anterior a solicitação
            
            btnInserir.setText("Inserir");  // Altera a descrição do botão gravar para inserir
            btnAlterar.setText("Alterar");// Altera a descrição do botão cancelar para alterar

            //btnExcluir.setEnabled(true);  // habilita o  botão excluir
            btnConsultar.setEnabled(true);// habilita o  botão consultar
            btnSair.setEnabled(true);// habilita o  botão sair

            OpTipo = 0; // retorna a solicitação de operaçao

            Desable(); // chamada da função que desabilita os campos
            
        }
     
    
    }
        private void Desable(){
            
        txtid_peticoes.setEnabled(false); 
        txtcod_processo.setEnabled(false); 
        txttipo_peticao.setEnabled(false); 
        txtdata_anexo.setEnabled(false); 
        }
        private void Habilita(){

        txtcod_processo.setEnabled(true); //campo de texto 
        txttipo_peticao.setEnabled(true); //campo de texto 
        txtdata_anexo.setEnabled(true); 
        }
        public void SetKey(String Keys) { // inicio da função que localiza registros
        
        
        String Cmd; //criação da variavel que cria comandos
        
        if(Keys == "") { // verifica se foi solicitada um chave
            Cmd = "SELECT * FROM peticoes ORDER BY id_peticoes DESC LIMIT 1"; // comando que localiza o ultimo registro
        } else { // se foi informada uma chave
            Cmd = "SELECT * FROM peticoes WHERE id_peticoes = '" + Keys + "'"; // comando que localiza um regustro especifico
        }
        PreparedStatement PS; //cria a variavel que controle o envio de comandos
        try { //inicia a verificação  de erro
            PS = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet RS = PS.executeQuery(); // envia o comando e guarda o resultado
            if(RS.next()){ // verifica se retornou o registro
                    txtid_peticoes.setText(RS.getString(1)); //informa o campo 
                    txtcod_processo.setText(RS.getString(2));//informa o campo 
                    txtdata_anexo.setText(RS.getString(3));//informa o campo 
                    txttipo_peticao.setText(RS.getString(4));//informa o campo 
                   
            }
        } catch (SQLException ex) { // caso haja erro
            Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE, "erro no setkey", ex); // mensagem de erro
        }
        }
        public List<String []> LogRegs(){ //Inicio da função que retorna os clientes
        
        String Cmd; //criação da variavel que cria comandos
        List<String []> ListDados = new ArrayList(); // criação da lista de dados

        Cmd = "Select * From peticoes Order by id_peticoes"; // comando que localiza o ultimo registro
        PreparedStatement st; // criação da variavel de envio de comandos
        try { // inicio da verificação de problemas 
            st = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet rs = st.executeQuery("Select * From peticoes Order by id_peticoes");  // criação do comando SQL para retornar todos os registro

//            CallableStatement stm = Cnn.prepareCall("{call CodigosAgenda()}");
//            ResultSet rs = stm.executeQuery(); 
 
            while(rs.next()) { // Verifica se algum registro foi localizado
                ListDados.add(new String[] {rs.getString("id_peticoes"),rs.getString("cod_processo"),rs.getString("tipo_peticao"),rs.getString("data_anexo")}); // inclusão do registro no modo padrão
            }
        } catch (SQLException ex) { // inicio da verificação de erro
            Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE, "erro no logregs", ex);  // mensagem de erro
        }
        
        return ListDados; // retorno
        
    }    
     

    
}
