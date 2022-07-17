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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class JanelaProcesso extends JFrame {
    
    private Conexao Conect = new Conexao();     // instancia do objeto de conexão com a base de dados
    private Connection Cnn; // inicialização da variavel de conxão

    
    private final JLabel lblid; //label id
    private final JTextField txtid; //campo de texto id
    private final JLabel lblcod_processo; //label cod_processo
    private final JTextField txtcod_processo; //campo de texto cod_processo
    private final JLabel lbldata_abertura; //label data_abertura
    private final JTextField txtdata_abertura; //campo de texto data_abertura
    private final JLabel lblclasse_judicial; //label classe_judicial
    private final JTextField txtclasse_judicial; //campo de texto classe_judicial
    private final JLabel lblorgão_julgador; //label orgão_julgador
    private final JTextField txtorgão_julgador; //campo de texto orgão_julgador
    private final JLabel lblvalor_causa; //label valor_causa
    private final JTextField txtvalor_causa; //campo de texto valor_causa
    private final JLabel lblreclamante; //label reclamante
    private final JComboBox cmbreclamante; //combobox CPF/CNPJ
    private final JTextField txtreclamante; //campo de texto CPF/CNPJ
    private final JLabel lblid_advogado; //label id_advogado
    private final JTextField txtid_advogado; //campo de texto id_advogado
    private final JLabel lblreclamado; //label reclamado
    private final JTextField txtreclamado; //campo de nome
    private final JComboBox cmbreclamado; //combobox CPF/CNPJ
    private final JTextField txtcpfcnpj; //campo de texto CPF/CNPJ
           
    private final JButton btnInserir; // Criação do botão 
    private final JButton btnAlterar; // Criação do botão 
    private final JButton btnConsultar; // Criação do botão 
    private final JButton btnSair; // Criação do botão 
    
    
    int OpTipo = 0; // variavel de controle de ação
    String PrevCod = ""; // variavel de controle de codigos
    
    public JanelaProcesso(/*JFrame oProcesso*/){ 
        
         Cnn = Conect.getConexao();  // iniciando a conexão
       
        
        this.setSize(800, 440);  // estabelece o tamanho da janela
        this.setLocation(400, 400);  // selecionando o localização da tela
        this.setTitle("Dados do Processo"); // define o titulo da tela
        this.setLayout(null); // desativa os layouts padrão
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha a janela
      
        
        lblid = new JLabel("id"); // define a label do codigo
        lblid.setSize(40, 30); // define o tamanho do label
        lblid.setLocation(10, 10); // define a localização do label
        this.add(lblid); // adiciona o label

        txtid = new JTextField(); //inicialização do campo do codigo
        txtid.setSize(40,20);// define o tamanho do campo
        txtid.setLocation(105,15);// define a localização do campo
        this.add(txtid);// adiciona o Campo
        
        lblcod_processo = new JLabel("n° processo"); // define a label do codigo
        lblcod_processo.setSize(80, 30); // define o tamanho do label
        lblcod_processo.setLocation(10, 40); // define a localização do label
        this.add(lblcod_processo); // adiciona o label

        txtcod_processo = new JTextField(); //inicialização do campo do codigo
        txtcod_processo.setSize(100,20);// define o tamanho do campo
        txtcod_processo.setLocation(105,45);// define a localização do campo
        this.add(txtcod_processo);// adiciona o Campo
        
        lbldata_abertura = new JLabel("abertura"); // define a label do codigo
        lbldata_abertura.setSize(80, 30); // define o tamanho do label
        lbldata_abertura.setLocation(500, 10); // define a localização do label
        this.add(lbldata_abertura); // adiciona o label

        txtdata_abertura = new JTextField(); //inicialização do campo do codigo
        txtdata_abertura.setSize(100,20);// define o tamanho do campo
        txtdata_abertura.setLocation(605,15);// define a localização do campo
        this.add(txtdata_abertura);// adiciona o Campo
        
        lblclasse_judicial = new JLabel("Área judicial"); // define a label do codigo
        lblclasse_judicial.setSize(100, 30); // define o tamanho do label
        lblclasse_judicial.setLocation(500, 40); // define a localização do label
        this.add(lblclasse_judicial); // adiciona o label

        txtclasse_judicial = new JTextField(); //inicialização do campo do codigo
        txtclasse_judicial.setSize(150,20);// define o tamanho do campo
        txtclasse_judicial.setLocation(605,45);// define a localização do campo
        this.add(txtclasse_judicial);// adiciona o Campo
        
        lblvalor_causa = new JLabel("valor inicial"); // define a label do codigo
        lblvalor_causa.setSize(80, 30); // define o tamanho do label
        lblvalor_causa.setLocation(10, 70); // define a localização do label
        this.add(lblvalor_causa); // adiciona o label

        txtvalor_causa = new JTextField(); //inicialização do campo do codigo
        txtvalor_causa.setSize(100,20);// define o tamanho do campo
        txtvalor_causa.setLocation(105,75);// define a localização do campo
        this.add(txtvalor_causa);// adiciona o Campo
        
        lblorgão_julgador = new JLabel("orgão julgador"); // define a label do codigo
        lblorgão_julgador.setSize(100, 30); // define o tamanho do label
        lblorgão_julgador.setLocation(500, 70); // define a localização do label
        this.add(lblorgão_julgador); // adiciona o label

        txtorgão_julgador = new JTextField(); //inicialização do campo do codigo
        txtorgão_julgador.setSize(150,20);// define o tamanho do campo
        txtorgão_julgador.setLocation(605,75);// define a localização do campo
        this.add(txtorgão_julgador);// adiciona o Campo
        
        lblreclamante = new JLabel("Reclamante"); // define a label do codigo
        lblreclamante.setSize(80, 30); // define o tamanho do label
        lblreclamante.setLocation(10, 130); // define a localização do label
        this.add(lblreclamante); // adiciona o label
        
        cmbreclamante = new JComboBox();//inicialização do campo do tipo de reclamante
        cmbreclamante.addItem("  "); // adiciona a primeira opção
        cmbreclamante.addItem("CPF");// adiciona a segunda opção
        cmbreclamante.addItem("CNPJ");// adiciona a terceira opção
        cmbreclamante.setSize(60,20);// define o tamanho do campo
        cmbreclamante.setLocation(10,165);// define a localização do campo
        this.add(cmbreclamante);// adiciona o Campo

        txtreclamante = new JTextField(); //inicialização do campo do codigo
        txtreclamante.setSize(150,20);// define o tamanho do campo
        txtreclamante.setLocation(105,165);// define a localização do campo
        this.add(txtreclamante);// adiciona o Campo
        
        lblid_advogado = new JLabel("n° advogado"); // define a label do codigo
        lblid_advogado.setSize(100, 30); // define o tamanho do label
        lblid_advogado.setLocation(10, 220); // define a localização do label
        this.add(lblid_advogado); // adiciona o label

        txtid_advogado = new JTextField(); //inicialização do campo do codigo
        txtid_advogado.setSize(60,20);// define o tamanho do campo
        txtid_advogado.setLocation(105,225);// define a localização do campo
        this.add(txtid_advogado);// adiciona o Campo
        
        lblreclamado = new JLabel("Reclamado"); // define a label do codigo
        lblreclamado.setSize(80, 30); // define o tamanho do label
        lblreclamado.setLocation(500, 130); // define a localização do label
        this.add(lblreclamado); // adiciona o label
        
        txtreclamado = new JTextField(); //inicialização do campo do codigo
        txtreclamado.setSize(255,20);// define o tamanho do campo
        txtreclamado.setLocation(500,165);// define a localização do campo
        this.add(txtreclamado);// adiciona o Campo
        
        cmbreclamado = new JComboBox();//inicialização do campo do tipo de reclamante
        cmbreclamado.addItem("  "); // adiciona a primeira opção
        cmbreclamado.addItem("CPF");// adiciona a segunda opção
        cmbreclamado.addItem("CNPJ");// adiciona a terceira opção
        cmbreclamado.setSize(60,20);// define o tamanho do campo
        cmbreclamado.setLocation(500,195);// define a localização do campo
        this.add(cmbreclamado);// adiciona o Campo

        txtcpfcnpj = new JTextField(); //inicialização do campo do codigo
        txtcpfcnpj.setSize(150,20);// define o tamanho do campo
        txtcpfcnpj.setLocation(605,195);// define a localização do campo
        this.add(txtcpfcnpj);// adiciona o Campo
        
        
        
        btnInserir = new JButton("inserir");   //inicialização do butão inserir 
        btnInserir.setSize(95 , 20); //define o tamanho do botão
        btnInserir.setLocation (10 , 360); //define a localização  do Butão
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
        btnAlterar.setLocation (110 , 360);//define a localização  do Butão
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
        btnConsultar.setLocation (210 , 360);//define a localização  do Butão
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
        btnSair.setLocation (700, 360);//define a localização  do Butão
        btnSair.addActionListener(new // adiciona o comando listener
            ActionListener()// Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                    Finaliza(); // chamada da função que finaliza o programa
                }

            });
        //this.add(btnSair);
        
        Desable(); // chamada da função que desabilita os campos
        
    }
    
    private void Finaliza(){ //inicio da funação que finaliza o programa 
        this.dispose(); // finalização do programa
    }
    
    
    private void InserirRegistro(){ //inicio da função que insere o registro
        
        if(OpTipo == 0) { // verifica a operação realizada
            
           //txtCodigo.setEnabled  (true);

            PrevCod = txtid.getText(); // acumula o codigo antirior para caso de cancelamento
            
            int Codigo; //inicia a veriavel que gera o novo codigo
            
            String Cmd = "SELECT id_processo FROM processo ORDER BY id_processo DESC LIMIT 1" ; //localiza o ultimo registro
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
                Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE,"erro na definição do ID'InserirRegistro'", ex); //emite uma mensagem de erro
            }
            
            Habilita(); // chamada da função que habilita os campos

        txtcod_processo.setText(""); //campo de texto cod_processo
        txtdata_abertura.setText(""); //campo de texto data_abertura
        txtclasse_judicial.setText(""); //campo de texto classe_judicial
        txtorgão_julgador.setText(""); //campo de texto orgão_julgador
        txtvalor_causa.setText(""); //campo de texto valor_causa
        txtcpfcnpj.setText(""); //campo de texto CPF/CNPJ
        txtreclamante.setText(""); //campo de texto CPF/CNPJ
        txtid_advogado.setText(""); //campo de texto id_advogado
        txtreclamado.setText(""); //campo de nome

            cmbreclamante.setSelectedItem("");
            cmbreclamado.setSelectedItem("");

            btnInserir.setText("Gravar"); // altera o texto do botão inserir para gravar
            btnAlterar.setText("Cancelar");// altera o texto do botão alterar para cancelar

            
            btnSair.setEnabled(false);// desabilita o botão sair

            OpTipo = 1; // coloca o programa em inclusão
            
        } else { // Caso o programa esteja realizando uma inclusão/alteração
            //String Cmd2="";//"select id_advogado, numero_oab from advogado where numero_oab = '"+txtid_advogado.getText()+"'";
            String Cmd = ""; //inicia a variavel do comando
            PreparedStatement st;
            
            
            if(OpTipo == 1) { // verifica se estamos incluindo
                //Cmd2 = "select id_advogado, numero_oab from advogado where numero_oab = '"+txtid_advogado.getText()+"'";
                Cmd = "INSERT INTO processo (id_processo, cod_processo, data_abertura, classe_judicial, orgao_julgador, reclamado, valor_causa, JCBreclamado, JCBreclamante, cpfcnpjreclamado, id_advogado, id_reclamante)"; // criação do comando de inclusão
                Cmd += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // criação do comando de inclusão
                
                //Cmd2 = "insert into processo (id_advogado)valeus('"+rs.getString("id_processo")+"'")";
            } else { // caso estajamos alterando
                Cmd = "UPDATE processo SET cod_processo = ?, data_abertura = ?, classe_judicial = ?, orgao_julgador = ?, "; // criação do comando de alteração
                Cmd += "reclamado = ?, valor_causa = ?,JCBreclamado = ?, JCBreclamante = ?, cpfcnpjreclamado = ?, id_advogado = ?, id_reclamante = ? where id_processo = ?";// criação do comando de alteração
            }//adicionar na tabela SQL = id_reclamante, id_advogado, JCBreclamado, JCBreclamante, cpfcnpjreclamante
            
            try { // inicia a verificação de erro
                PreparedStatement PS = Cnn.prepareStatement(Cmd); // iniciaza a variavel que controla a execuçao de comandos
                
                int Pos = 1; //indica o parametro inicial
                
                if(OpTipo == 1) { // verifica se estamos incluindo 
                    PS.setString(1, txtid.getText()); // informa o codigo em caso de inclusão
                    Pos++; // move para o proximo parametro
                }
                PS.setString(Pos, txtcod_processo.getText());// informa o campo
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtdata_abertura.getText());// informa o campo
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtclasse_judicial.getText());// informa o campo
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtorgão_julgador.getText());// informa o campo
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtreclamado.getText());// informa a campo
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtvalor_causa.getText());// informa o campo
                Pos++;// move para o proximo parametro
                PS.setString(Pos, (String) cmbreclamado.getSelectedItem());// informa o combobox
                Pos++;// move para o proximo parametro
                PS.setString(Pos, (String) cmbreclamante.getSelectedItem());// informa o combobox
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtcpfcnpj.getText());// informa o campo
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtid_advogado.getText());// informa o campo
                Pos++;// move para o proximo parametro
                PS.setString(Pos, txtreclamante.getText());// informa o campo
                Pos++;// move para o proximo parametro
                
                

                if(OpTipo == 2) {// verifica se estamos alterando
                    PS.setString(Pos, txtid.getText()); // informa o codigo em caso de alteração
                }
                
                PS.execute(); // executa o comando 

            } catch (SQLException ex) { // executa em caso de erro
                Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE,"erro no InserirRegistro", ex); // mensagem de erro
            }
            
            btnInserir.setText("Inserir");  // Altera a descrição do botão gravar para inserir
            btnAlterar.setText("Alterar");// Altera a descrição do botão cancelar para alterar

            //btnExcluir.setEnabled(true);  // habilita o  botão excluir
            //btnConsultar.setEnabled(true);// habilita o  botão consultar
            btnSair.setEnabled(true);// habilita o  botão sair

            OpTipo = 0; // retorna a solicitação de operaçao

            Desable(); // chamada da função que desabilita os campos
            
        }
        
    }
    private void Consulta(){
        
        ConsultaProcesso janela2;
       janela2 = new ConsultaProcesso(this);
       janela2.setVisible(true);
    }
     private void AlterarRegistro(){ // inicio da função que altera registros
        
        if(OpTipo == 0) { // verifica a operação realizada
            
            Habilita(); // chnamada da fujnção que habilita os campos
            txtid.setEnabled  (true);
            PrevCod = txtid.getText(); // acumula o codigo antirior para caso de cancelamento

            btnInserir.setText("Gravar"); // altera o texto do botão inserir para gravar
            btnAlterar.setText("Cancelar");// altera o texto do botão alterar para cancelar

            //btnExcluir.setEnabled(false); // desabilita o botão excluir
            //btnConsultar.setEnabled(false);// desabilita o botão consultar
            btnSair.setEnabled(false);// desabilita o botão sair

            OpTipo = 2; // informa que estamos realizando uma alteração
        }else { // caso estajamos realizando uma inclusão ou alteração
            
            SetKey(PrevCod); // localiza o registro anterior a solicitação
            
            btnInserir.setText("Inserir");  // Altera a descrição do botão gravar para inserir
            btnAlterar.setText("Alterar");// Altera a descrição do botão cancelar para alterar

            //btnExcluir.setEnabled(true);  // habilita o  botão excluir
            //btnConsultar.setEnabled(true);// habilita o  botão consultar
            btnSair.setEnabled(true);// habilita o  botão sair

            OpTipo = 0; // retorna a solicitação de operaçao

            Desable(); // chamada da função que desabilita os campos
            
        }
     
    }
    private void Desable(){ // inicio da função que desabilita os campos
    txtid.setEnabled(false); //campo de texto id
    txtcod_processo.setEnabled(true); //campo de texto cod_processo
    txtdata_abertura.setEnabled(false); //campo de texto data_abertura
    txtclasse_judicial.setEnabled(false); //campo de texto classe_judicial
    txtorgão_julgador.setEnabled(false); //campo de texto orgão_julgador
    txtvalor_causa.setEnabled(false); //campo de texto valor_causa
    txtcpfcnpj.setEnabled(false); //campo de texto CPF/CNPJ
    txtreclamante.setEnabled(false); //campo de texto CPF/CNPJ
    txtid_advogado.setEnabled(false); //campo de texto id_advogado
    txtreclamado.setEnabled(false); //campo de nome
    
    cmbreclamado.setEnabled(false); //combobox CPF/CNPJ
    cmbreclamante.setEnabled(false); //combobox CPF/CNPJ
    
    /*this.setSize(400, 180);  // estabelece o tamanho da janela
    btnInserir.setLocation (10 , 100);//define a localização  do Butão
    btnAlterar.setLocation (110 , 100);//define a localização  do Butão
    btnConsultar.setLocation (210 , 100);//define a localização  do Butão
    
    lblreclamante.setVisible(false);
    lblreclamado.setVisible(false);
    
    cmbreclamante.setVisible(false);
    cmbreclamado.setVisible(false);
    lblid.setVisible(false); //campo de texto data_abertura
    txtid.setVisible(false); //campo de texto data_abertura
    lbldata_abertura.setVisible(false); //campo de texto data_abertura
    lblclasse_judicial.setVisible(false); //campo de texto classe_judicial
    txtclasse_judicial.setVisible(false); //campo de texto classe_judicial
    lblorgão_julgador.setVisible(false); //campo de texto orgão_julgador
    txtorgão_julgador.setVisible(false); //campo de texto orgão_julgador
    lblvalor_causa.setVisible(false); //campo de texto valor_causa
    txtvalor_causa.setVisible(false); //campo de texto valor_causa
    
    txtcpfcnpj.setVisible(false); //campo de texto CPF/CNPJ
    txtreclamante.setVisible(false); //campo de texto CPF/CNPJ
    lblid_advogado.setVisible(false); //campo de texto id_advogado
    txtid_advogado.setVisible(false); //campo de texto id_advogado
    txtreclamado.setVisible(false); //campo de nome      */
    }
    
    private void Habilita(){// inicio da função que habilita os campos

    txtcod_processo.setEnabled(true); //campo de texto cod_processo
    txtdata_abertura.setEnabled(true); //campo de texto data_abertura
    txtclasse_judicial.setEnabled(true); //campo de texto classe_judicial
    txtorgão_julgador.setEnabled(true); //campo de texto orgão_julgador
    txtvalor_causa.setEnabled(true); //campo de texto valor_causa
    txtcpfcnpj.setEnabled(true); //campo de texto CPF/CNPJ 
    txtreclamante.setEnabled(true); //campo de texto CPF/CNPJ
    txtid_advogado.setEnabled(true); //campo de texto id_advogado
    txtreclamado.setEnabled(true); //campo de nome
    
    cmbreclamante.setEnabled(true); //combobox CPF/CNPJ
    cmbreclamado.setEnabled(true); //combobox CPF/CNPJ   
    
    /*this.setSize(800, 440);  // estabelece o tamanho da janela
    btnInserir.setLocation (10 , 360);//define a localização  do Butão
    btnAlterar.setLocation (110 , 360);//define a localização  do Butão
    btnConsultar.setLocation (210 , 360);//define a localblreclamante.setVisible(true);
    lblreclamado.setVisible(true);
    lblreclamante.setVisible(true);
    cmbreclamante.setVisible(true);
    cmbreclamado.setVisible(true);
    lblid.setVisible(true); //campo de texto data_abertura
    txtid.setVisible(true); //campo de texto data_abertura
    lbldata_abertura.setVisible(true); //campo de texto data_abertura
    lblclasse_judicial.setVisible(true); //campo de texto classe_judicial
    txtclasse_judicial.setVisible(true); //campo de texto classe_judicial
    lblorgão_julgador.setVisible(true); //campo de texto orgão_julgador
    txtorgão_julgador.setVisible(true); //campo de texto orgão_julgador
    lblvalor_causa.setVisible(true); //campo de texto valor_causa
    txtvalor_causa.setVisible(true); //campo de texto valor_causa
    
    txtcpfcnpj.setVisible(true); //campo de texto CPF/CNPJ
    txtreclamante.setVisible(true); //campo de texto CPF/CNPJ
    lblid_advogado.setVisible(true); //campo de texto id_advogado
    txtid_advogado.setVisible(true); //campo de texto id_advogado
    txtreclamado.setVisible(true); //campo de nomelização  do Butão*/
    }
    public void SetKey(String Keys) { // inicio da função que localiza registros
        
        
        String Cmd; //criação da variavel que cria comandos
        
        if(Keys == "") { // verifica se foi solicitada um chave
            Cmd = "SELECT * FROM processo ORDER BY id_processo DESC LIMIT 1"; // comando que localiza o ultimo registro
        } else { // se foi informada uma chave
            Cmd = "SELECT * FROM processo WHERE id_processo = '" + Keys + "'"; // comando que localiza um regustro especifico
        }
        PreparedStatement PS; //cria a variavel que controle o envio de comandos
        try { //inicia a verificação  de erro
            PS = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet RS = PS.executeQuery(); // envia o comando e guarda o resultado
            if(RS.next()){ // verifica se retornou o registro
                    txtid.setText(RS.getString(1)); //informa  campo 
                    txtcod_processo.setText(RS.getString(2));//informa  campo 
                    txtdata_abertura.setText(RS.getString(3));//informa campo
                    txtclasse_judicial.setText(RS.getString(4));//informa  campo 
                    txtorgão_julgador.setText(RS.getString(5));//informa  campo 
                    txtreclamado.setText(RS.getString(6));//informa  campo 
                    txtvalor_causa.setText(RS.getString(7));//informa  campo 
                    txtreclamante.setText(RS.getString(8));//informa  campo 
                    txtid_advogado.setText(RS.getString(9));//informa  campo 
                    cmbreclamado.setSelectedItem(RS.getString(11));//informa  campo 
                    txtcpfcnpj.setText(RS.getString(10));//informa  campo 
                    cmbreclamante.setSelectedItem(RS.getString(12));//informa  campo 
                    
            }
        } catch (SQLException ex) { // caso haja erro
            Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE, null, ex); // mensagem de erro
        }
    }
   
    public List<String []> LogRegs(){ //Inicio da função que retorna os processos
        
        String Cmd; //criação da variavel que cria comandos
        List<String []> ListDados = new ArrayList(); // criação da lista de dados
        
        Cmd = "Select * From processo Order by id_processo"; // comando que localiza o ultimo registro
        PreparedStatement st; // criação da variavel de envio de comandos
        try { // inicio da verificação de problemas 
            st = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet rs = st.executeQuery("Select * From processo Where cod_processo = '"+txtcod_processo.getText()+"'");  // criação do comando SQL para retornar todos os registro

//            CallableStatement stm = Cnn.prepareCall("{call CodigosAgenda()}");
//            ResultSet rs = stm.executeQuery(); 
 
            while(rs.next()) { // Verifica se algum registro foi localizado
                ListDados.add(new String[] {rs.getString("id_processo"),rs.getString("cod_processo"),rs.getString("data_abertura"),rs.getString("classe_judicial"),rs.getString("orgao_julgador"),rs.getString("valor_causa")}); // inclusão do registro no modo padrão
            }
        } catch (SQLException ex) { // inicio da verificação de erro
            Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE, null, ex);  // mensagem de erro
        }
        
        return ListDados; // retorno
        
    }    
    
    public List<String []> LogRegs2(){ //Inicio da função que retorna os documentos
        
        String Cmd; //criação da variavel que cria comandos
        List<String []> ListDados = new ArrayList(); // criação da lista de dados
        
        Cmd = "SELECT A.*, B.* FROM PROCESSO A, documentos B WHERE A.COD_PROCESSO = B.cOD_processo and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'"; // comando que localiza o ultimo registro
        PreparedStatement st; // criação da variavel de envio de comandos
        try { // inicio da verificação de problemas 
            st = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet rs = st.executeQuery("SELECT A.*, B.* FROM PROCESSO A, documentos B WHERE A.COD_PROCESSO = B.cOD_processo and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'");  // criação do comando SQL para retornar todos os registro

//            CallableStatement stm = Cnn.prepareCall("{call CodigosAgenda()}");
//            ResultSet rs = stm.executeQuery(); 
 
            while(rs.next()) { // Verifica se algum registro foi localizado
                ListDados.add(new String[] {rs.getString("id_documentos"),rs.getString("data_anexo"),rs.getString("descricao")}); // inclusão do registro no modo padrão
            }
        } catch (SQLException ex) { // inicio da verificação de erro
            Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE, "cria a tabela docuymentos noob", ex);  // mensagem de erro
        }
        
        return ListDados; // retorno
        
    }    
    public List<String []> LogRegs3(){ //Inicio da função que retorna os documentos
        
        String Cmd; //criação da variavel que cria comandos
        List<String []> ListDados = new ArrayList(); // criação da lista de dados
        
        Cmd = "SELECT A.*, B.* FROM PROCESSO A, audiencia B WHERE A.COD_PROCESSO = B.cOD_processo and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'"; // comando que localiza o ultimo registro
        PreparedStatement st; // criação da variavel de envio de comandos
        try { // inicio da verificação de problemas 
            st = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet rs = st.executeQuery("SELECT A.*, B.* FROM PROCESSO A, audiencia B WHERE A.COD_PROCESSO = B.cOD_processo and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'");  // criação do comando SQL para retornar todos os registro

//            CallableStatement stm = Cnn.prepareCall("{call CodigosAgenda()}");
//            ResultSet rs = stm.executeQuery(); 
 
            while(rs.next()) { // Verifica se algum registro foi localizado
                ListDados.add(new String[] {rs.getString("id_audiencia"),rs.getString("data"),rs.getString("local")}); // inclusão do registro no modo padrão
            }
        } catch (SQLException ex) { // inicio da verificação de erro
            Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE,"tabela audiencia ta com igor", ex);  // mensagem de erro
        }
        
        return ListDados; // retorno
        
    }    
    public List<String []> LogRegs4(){ //Inicio da função que retorna os documentos
        
        String Cmd; //criação da variavel que cria comandos
        List<String []> ListDados = new ArrayList(); // criação da lista de dados
        
        Cmd = "SELECT A.*, B.* FROM PROCESSO A, peticoes B WHERE A.COD_PROCESSO = B.cOD_processo and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'"; // comando que localiza o ultimo registro
        PreparedStatement st; // criação da variavel de envio de comandos
        try { // inicio da verificação de problemas 
            st = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet rs = st.executeQuery("SELECT A.*, B.* FROM PROCESSO A, peticoes B WHERE A.COD_PROCESSO = B.cOD_processo and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'");  // criação do comando SQL para retornar todos os registro

//            CallableStatement stm = Cnn.prepareCall("{call CodigosAgenda()}");
//            ResultSet rs = stm.executeQuery(); 
 
            while(rs.next()) { // Verifica se algum registro foi localizado
                ListDados.add(new String[] {rs.getString("id_peticoes"),rs.getString("data_anexo"),rs.getString("tipo_peticao")}); // inclusão do registro no modo padrão
            }
        } catch (SQLException ex) { // inicio da verificação de erro
            Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE, null, ex);  // mensagem de erro
        }
        
        return ListDados; // retorno
        
    }    
    public List<String []> LogRegs5(){ //Inicio da função que retorna os documentos
        
        String Cmd; //criação da variavel que cria comandos
        List<String []> ListDados = new ArrayList(); // criação da lista de dados
        
        Cmd = "SELECT A.*, B.* FROM PROCESSO A, advogado B WHERE A.id_advogado = B.numero_oab and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'"; // comando que localiza o ultimo registro
        PreparedStatement st; // criação da variavel de envio de comandos
        try { // inicio da verificação de problemas 
            st = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet rs = st.executeQuery("SELECT A.cod_processo, B.* FROM PROCESSO A, advogado B WHERE A.id_advogado = B.numero_oab and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'");  // criação do comando SQL para retornar todos os registro

//            CallableStatement stm = Cnn.prepareCall("{call CodigosAgenda()}");
//            ResultSet rs = stm.executeQuery(); 
 
            while(rs.next()) { // Verifica se algum registro foi localizado
                ListDados.add(new String[] {rs.getString("id_advogado"),rs.getString("nome")}); // inclusão do registro no modo padrão
            }
        } catch (SQLException ex) { // inicio da verificação de erro
            Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE, "problemas em logregs5", ex);  // mensagem de erro
        }
        
        return ListDados; // retorno
        
    }    public List<String []> LogRegs6(){ //Inicio da função que retorna os documentos
        
        String Cmd; //criação da variavel que cria comandos
        List<String []> ListDados = new ArrayList(); // criação da lista de dados
        
        Cmd = "SELECT A.*, B.* FROM PROCESSO A, reclamante B WHERE A.id_reclamante = B.cpf_cnpj and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'"; // comando que localiza o ultimo registro
        PreparedStatement st; // criação da variavel de envio de comandos
        try { // inicio da verificação de problemas 
            st = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet rs = st.executeQuery("SELECT A.*, B.* FROM PROCESSO A, reclamante B WHERE A.id_reclamante = B.cpf_cnpj and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'");  // criação do comando SQL para retornar todos os registro

//            CallableStatement stm = Cnn.prepareCall("{call CodigosAgenda()}");
//            ResultSet rs = stm.executeQuery(); 
 
            while(rs.next()) { // Verifica se algum registro foi localizado
                String TT = rs.getString("JCBreclamante");// TT significa Tira Teima
                if(TT == "CPF"){
                ListDados.add(new String[] {rs.getString("nome"),rs.getString("reclamado")}); // inclusão do registro no modo padrão
                }else{
                ListDados.add(new String[] {rs.getString("razao_social"),rs.getString("reclamado")}); // inclusão do registro no modo padrão
                }
            }
        } catch (SQLException ex) { // inicio da verificação de erro
            Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE, "problemas em logregs6", ex);  // mensagem de erro
        }
        
        return ListDados; // retorno
        
    }    
    public List<String []> LogRegs7(){ //Inicio da função que retorna os documentos
        
        String Cmd; //criação da variavel que cria comandos
        List<String []> ListDados = new ArrayList(); // criação da lista de dados
        
        Cmd = "SELECT A.*, B.* FROM PROCESSO A, sentenca B WHERE A.cod_processo = B.cod_processo and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'"; // comando que localiza o ultimo registro
        PreparedStatement st; // criação da variavel de envio de comandos
        try { // inicio da verificação de problemas 
            st = Cnn.prepareStatement(Cmd);  //inicia a variavel que controle o envio de comandos
            ResultSet rs = st.executeQuery("SELECT A.*, B.* FROM PROCESSO A, sentenca B WHERE A.cod_processo = B.cod_processo and a.Cod_PROCESSO = '"+txtcod_processo.getText()+"'");  // criação do comando SQL para retornar todos os registro

//            CallableStatement stm = Cnn.prepareCall("{call CodigosAgenda()}");
//            ResultSet rs = stm.executeQuery(); 
 
            while(rs.next()) { // Verifica se algum registro foi localizado
                ListDados.add(new String[] {rs.getString("sentenca")}); // inclusão do registro no modo padrão
              }
        } catch (SQLException ex) { // inicio da verificação de erro
            Logger.getLogger(JanelaProcesso.class.getName()).log(Level.SEVERE, "problemas em logregs7", ex);  // mensagem de erro
        }
        
        return ListDados; // retorno
        
    }    
    
}       