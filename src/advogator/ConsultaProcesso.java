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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class ConsultaProcesso extends JFrame {
    
    
    private DefaultTableModel drmModo; // criação da variavel de Modo de tabelas padrão
    private DefaultTableModel drmModo1; // criação da variavel de Modo de tabelas padrão
    private DefaultTableModel drmModo2; // criação da variavel de Modo de tabelas padrão
    private DefaultTableModel drmModo3; // criação da variavel de Modo de tabelas padrão
    private DefaultTableModel drmModo4; // criação da variavel de Modo de tabelas padrão
    private DefaultTableModel drmModo5; // criação da variavel de Modo de tabelas padrão
    private DefaultTableModel drmModoX; // criação da variavel de Modo de tabelas padrão
    private JTable tbl1; // ceriação da tabela de consulta
    private JTable tbl2; // ceriação da tabela de consulta
    private JTable tbl3; // ceriação da tabela de consulta
    private JTable tbl3b; // ceriação da tabela de consulta 
    private JTable tbl4; // ceriação da tabela de consulta
    private JTable tblConsulta; // ceriação da tabela de consulta
    private JTable tblX; // ceriação da tabela de consulta
    private final JLabel lblstatus; //label cod_processo
    private final JTextField txtstatus; //campo de texto cod_processo
    private final JLabel lbladvogado; //label advogado
    private final JLabel lblpeticoes; //label petições
    private final JLabel lblaudiencia; //label audiencia
    private final JLabel lbldocumentos; //label documendto
    
    
    private final JButton btnInserir; // Criação do botão inserir/gravar
    private final JButton btnAlterar; // Criação do botão Altereção/cancelamento
    private final JButton btnSair; // Criação do botão sair
    private final JButton btnVer; // Criação do botão sair
    
    
    
    
    
    
    String LogStatus;
    
    JanelaProcesso FrmProcesso; // criação da variavel do objeto Cliente
    
    public ConsultaProcesso(JFrame pProcesso){
    
      FrmProcesso = (JanelaProcesso) pProcesso; // inicialização do objeto Cliente   
      
        
    this.setSize(800, 700);  // estabelece o tamanho da janela
    this.setLocation(400, 300);  // selecionando o localização da tela
    this.setTitle("Monitor de Processos"); // define o titulo da tela
    this.setLayout(null); // desativa os layouts padrão
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define que quando esta janela for fechada o programa sera encerrado
    
        
        
        
        lblstatus = new JLabel("Status"); // define a label do codigo
        lblstatus.setSize(80, 30); // define o tamanho do label
        lblstatus.setLocation(10, 70); // define a localização do label
        this.add(lblstatus); // adiciona o label

        txtstatus = new JTextField(); //inicialização do campo do codigo
        txtstatus.setSize(100,20);// define o tamanho do campo
        txtstatus.setLocation(105,75);// define a localização do campo
        this.add(txtstatus);// adiciona o Campo
        
        lblpeticoes = new JLabel("Petições"); // define a label 
        lblpeticoes.setSize(80, 30); // define o tamanho do label
        lblpeticoes.setLocation(550, 230); // define a localização do label
        this.add(lblpeticoes); // adiciona o label
        
        lbladvogado = new JLabel("Advogados"); // define a label 
        lbladvogado.setSize(80, 30); // define o tamanho do label
        lbladvogado.setLocation(160, 230); // define a localização do label
        this.add(lbladvogado); // adiciona o label
        
        lblaudiencia = new JLabel("Audiência"); // define a label 
        lblaudiencia.setSize(80, 30); // define o tamanho do label
        lblaudiencia.setLocation(160, 430); // define a localização do label
        this.add(lblaudiencia); // adiciona o label
        
        lbldocumentos = new JLabel("Documentos"); // define a label 
        lbldocumentos.setSize(80, 30); // define o tamanho do label
        lbldocumentos.setLocation(550, 430); // define a localização do label
        this.add(lbldocumentos); // adiciona o label
        
        
        
       
        
        btnInserir = new JButton("editar");   //inicialização do butão inserir 
        btnInserir.setSize(95 , 20); //define o tamanho do botão
        btnInserir.setLocation (10 , 605); //define a localização  do Butão
        btnInserir.addActionListener(new // adiciona o comando listener
            ActionListener() // Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                    if(tblConsulta.isRowSelected(0)){
                    FrmProcesso.SetKey(drmModo5.getValueAt(tblConsulta.getSelectedRow(), 0).toString()); // chama a funcoa se seleção de registro com o registro selecionado
                    }if(tbl3b.isRowSelected(tbl3b.getSelectedRow() )){
                 
                    documentos janela ;
                    janela = new documentos();
                    janela.setVisible(true);
                    janela.SetKey(drmModo2.getValueAt(tbl3b.getSelectedRow(), 0).toString()); // chama a funcoa se seleção de registro com o registro selecionado

                }
                    if(tbl4.isRowSelected(tbl4.getSelectedRow() )){
                 
                    peticoes janela ;
                    janela = new peticoes();
                    janela.setVisible(true);
                    janela.SetKey(drmModo3.getValueAt(tbl4.getSelectedRow(), 0).toString()); // chama a funcoa se seleção de registro com o registro selecionado

                }
                    if(tbl2.isRowSelected(tbl2.getSelectedRow() )){
                 
                    /*CadastroAdvogado janela ;
                    janela = new CadastroAdvogado();
                    janela.setVisible(true);
                    janela.SetKey(drmModo4.getValueAt(tbl2.getSelectedRow(), 0).toString()); // chama a funcoa se seleção de registro com o registro selecionado*/

                }
                    dispose(); // fecha a tela
                }

            });
        this.add(btnInserir);
        
        btnAlterar = new JButton ("cancelar");//inicialização do butão alterar
        btnAlterar.setSize(95 , 20);//define o tamanho do botão
        btnAlterar.setLocation (135 , 605);//define a localização  do Butão
        btnAlterar.addActionListener(new // adiciona o comando listener
            ActionListener()// Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                   dispose();  // fecha a tela                
                   
                    
                }

            });
        this.add(btnAlterar);

        btnVer = new JButton ("Ver");//inicialização do butão alterar
        btnVer.setSize(95 , 20);//define o tamanho do botão
        btnVer.setLocation (210 , 75);//define a localização  do Butão
        btnVer.addActionListener(new // adiciona o comando listener
            ActionListener()// Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                   //dispose();  // fecha a tela    
                    JanelaSentenca janela ;
                    janela = new JanelaSentenca();
                    janela.setVisible(true);
                    //janela.SetKey(drmModoX.getValueAt(tblX.getSelectedRow(), 0).toString()); // chama a funcoa se seleção de registro com o registro selecionado
                    //janela.SetKey(FrmProcesso.LogRegs7()); // chama a funcoa se seleção de registro com o registro selecionado*/
                }

            });
        this.add(btnVer);
        
        
        btnSair = new JButton ("Sair");//inicialização do butão sair
        btnSair.setSize(64 , 20);//define o tamanho do botão
        btnSair.setLocation (135, 605);//define a localização  do Butão
        btnSair.addActionListener(new // adiciona o comando listener
            ActionListener()// Adiciona um comando
            {
                public void actionPerformed(ActionEvent e)//adiciona uma função
                {
                    Finaliza(); // chamada da função que finaliza o programa
                }

            });
        this.add(btnSair);
        
        
        //Desable(); // Solicita a desabilitação dos campos
        

    
        
    //drmModo = new DefaultTableModel();
    
    List<String []> ListDados = new ArrayList(); // criação da lista de dados
    String HeadersX[] = {"Sentenca"};  // Inicialização do headers da tabela
    String Headers[] = {"Reclamante", "Reclamado"};  // Inicialização do headers da tabela
    String Headers2[] = {"ID","Data","Descrição"};  // Inicialização do headers da tabela
    String Headers3[] = {"ID","Data","Tipo"};  // Inicialização do headers da tabela
    String Headers4[] = {"ID","Nome"};  // Inicialização do headers da tabela
    String Headers5[] = {"id", "nºprocesso","abertura","Área judicial","orgão julgador","valor causa"};  // Inicialização do headers da tabela
    
    drmModoX = new DefaultTableModel(HeadersX,0); // inicialização do modo padrão da tela
    drmModo = new DefaultTableModel(Headers,0); // inicialização do modo padrão da tela
    drmModo1 = new DefaultTableModel(Headers2,0); // inicialização do modo padrão da tela
    drmModo2 = new DefaultTableModel(Headers2,0); // inicialização do modo padrão da tela
    drmModo3 = new DefaultTableModel(Headers3,0); // inicialização do modo padrão da tela
    drmModo4 = new DefaultTableModel(Headers4,0); // inicialização do modo padrão da tela
    drmModo5 = new DefaultTableModel(Headers5,0); // inicialização do modo padrão da tela

    tblX = new JTable(drmModoX); // inicialização da tabela com o modo padrão
    tbl1 = new JTable(drmModo); // inicialização da tabela com o modo padrão
    tbl2 = new JTable(drmModo4); // inicialização da tabela com o modo padrão
    tbl3 = new JTable(drmModo1); // inicialização da tabela com o modo padrão
    tbl3b = new JTable(drmModo2); // inicialização da tabela com o modo padrão
    tbl4 = new JTable(drmModo3); // inicialização da tabela com o modo padrão
    tblConsulta = new JTable(drmModo5); // inicialização da tabela com o modo padrão   
    
        ListDados = (List<String[]>) FrmProcesso.LogRegs();        
        for(int Pos = 0; Pos < ListDados.size(); Pos++) {
        
            drmModo5.addRow(ListDados.get(Pos));
        
    }
        ListDados = (List<String[]>) FrmProcesso.LogRegs2();        
        for(int Pos = 0; Pos < ListDados.size(); Pos++) {
        
            drmModo2.addRow(ListDados.get(Pos));
        
    }
        ListDados = (List<String[]>) FrmProcesso.LogRegs3();        
        for(int Pos = 0; Pos < ListDados.size(); Pos++) {
        
            drmModo1.addRow(ListDados.get(Pos));
        
    }
        ListDados = (List<String[]>) FrmProcesso.LogRegs4();        
        for(int Pos = 0; Pos < ListDados.size(); Pos++) {
        
            drmModo3.addRow(ListDados.get(Pos));
        
    }
        ListDados = (List<String[]>) FrmProcesso.LogRegs5();        
        for(int Pos = 0; Pos < ListDados.size(); Pos++) {
        
            drmModo4.addRow(ListDados.get(Pos));
        
    }
        ListDados = (List<String[]>) FrmProcesso.LogRegs6();        
        for(int Pos = 0; Pos < ListDados.size(); Pos++) {
        
            drmModo.addRow(ListDados.get(Pos));
        
    }
        ListDados = (List<String[]>) FrmProcesso.LogRegs7();        
        for(int Pos = 0; Pos < ListDados.size(); Pos++) {
        
            drmModoX.addRow(ListDados.get(Pos));
           
        
    }
        txtstatus.setText(drmModoX.toString());
        
        tblX.setLocation(0, 0);  // selecionando o localização da tabela
        tblX.setSize(400, 350); // selecionando o tamanho da tabela 
        
        tblX.getColumnModel().getColumn(0).setMaxWidth(80); // seleciona tamanho maximo da coluna 0
        tblX.getColumnModel().getColumn(0).setMinWidth(80); // seleciona tamanho minimo da coluna 0
        
        JScrollPane scrollPane7 = new JScrollPane(tblX); // inicialização do painel com a tabela
        
        scrollPane7.setLocation(10, 10);  // selecionando o localização da painel
        scrollPane7.setSize(80, 80); // selecionando o tamanho da painel
        //add (scrollPane7); 

        tbl1.setLocation(0, 0);  // selecionando o localização da tabela
        tbl1.setSize(400, 350); // selecionando o tamanho da tabela
        
        tbl1.getColumnModel().getColumn(0).setMaxWidth(380); // seleciona tamanho maximo da coluna 0
        tbl1.getColumnModel().getColumn(0).setMinWidth(380); // seleciona tamanho minimo da coluna 0

        tbl1.getColumnModel().getColumn(1).setMaxWidth(380); // seleciona tamanho maximo da coluna 1
        tbl1.getColumnModel().getColumn(1).setMinWidth(380); // seleciona tamanho minimo da coluna 1
        
        

        JScrollPane scrollPane = new JScrollPane(tbl1); // inicialização do painel com a tabela
        
        tbl2.setLocation(0, 0);  // selecionando o localização da tabela
        tbl2.setSize(400, 350); // selecionando o tamanho da tabela
        
        
        tbl2.getColumnModel().getColumn(0).setMaxWidth(60); // seleciona tamanho maximo da coluna 0
        tbl2.getColumnModel().getColumn(0).setMinWidth(60); // seleciona tamanho minimo da coluna 0

        tbl2.getColumnModel().getColumn(1).setMaxWidth(240); // seleciona tamanho maximo da coluna 1
        tbl2.getColumnModel().getColumn(1).setMinWidth(240); // seleciona tamanho minimo da coluna 1
                
        JScrollPane scrollPane5 = new JScrollPane(tbl2); // inicialização do painel com a tabela
        
        tbl3.setLocation(0, 0);  // selecionando o localização da tabela
        tbl3.setSize(400, 350); // selecionando o tamanho da tabela
        
        tbl3.getColumnModel().getColumn(0).setMaxWidth(60); // seleciona tamanho maximo da coluna 0
        tbl3.getColumnModel().getColumn(0).setMinWidth(60); // seleciona tamanho minimo da coluna 0
        
        tbl3.getColumnModel().getColumn(1).setMaxWidth(80); // seleciona tamanho maximo da coluna 1
        tbl3.getColumnModel().getColumn(1).setMinWidth(80); // seleciona tamanho minimo da coluna 1

        tbl3.getColumnModel().getColumn(2).setMaxWidth(230); // seleciona tamanho maximo da coluna 2
        tbl3.getColumnModel().getColumn(2).setMinWidth(230); // seleciona tamanho minimo da coluna 2
        
        JScrollPane scrollPane2 = new JScrollPane(tbl3); // inicialização do painel com a tabela
        
        tbl3b.getColumnModel().getColumn(0).setMaxWidth(60); // seleciona tamanho maximo da coluna 0
        tbl3b.getColumnModel().getColumn(0).setMinWidth(60); // seleciona tamanho minimo da coluna 0
        
        tbl3b.getColumnModel().getColumn(1).setMaxWidth(80); // seleciona tamanho maximo da coluna 1
        tbl3b.getColumnModel().getColumn(1).setMinWidth(80); // seleciona tamanho minimo da coluna 1

        tbl3b.getColumnModel().getColumn(2).setMaxWidth(230); // seleciona tamanho maximo da coluna 2
        tbl3b.getColumnModel().getColumn(2).setMinWidth(230); // seleciona tamanho minimo da coluna 2
        
        JScrollPane scrollPane3 = new JScrollPane(tbl3b); // inicialização do painel com a tabela
        
        tbl4.setLocation(0, 0);  // selecionando o localização da tabela
        tbl4.setSize(400, 350); // selecionando o tamanho da tabela
        
        tbl4.getColumnModel().getColumn(0).setMaxWidth(60); // seleciona tamanho maximo da coluna 0
        tbl4.getColumnModel().getColumn(0).setMinWidth(60); // seleciona tamanho minimo da coluna 0

        tbl4.getColumnModel().getColumn(1).setMaxWidth(80); // seleciona tamanho maximo da coluna 1
        tbl4.getColumnModel().getColumn(1).setMinWidth(80); // seleciona tamanho minimo da coluna 1
        
        tbl4.getColumnModel().getColumn(2).setMaxWidth(160); // seleciona tamanho maximo da coluna 2
        tbl4.getColumnModel().getColumn(2).setMinWidth(160); // seleciona tamanho minimo da coluna 2
        
        
        
        JScrollPane scrollPane4 = new JScrollPane(tbl4); // inicialização do painel com a tabela
        
        tblConsulta.setLocation(0, 0);  // selecionando o localização da tabela
        tblConsulta.setSize(360, 350); // selecionando o tamanho da tabela
        
        tblConsulta.getColumnModel().getColumn(0).setMaxWidth(50); // seleciona tamanho maximo da coluna 0
        tblConsulta.getColumnModel().getColumn(0).setMinWidth(50); // seleciona tamanho minimo da coluna 0
        
        JScrollPane scrollPane6 = new JScrollPane(tblConsulta); // inicialização do painel com a tabela
                            
        scrollPane.setLocation(10, 345);  // selecionando o localização da painel
        scrollPane.setSize(760, 80); // selecionando o tamanho da painel
        
        add(scrollPane); // adiciona o painel a tela
        
        scrollPane2.setLocation(10, 465);  // selecionando o localização da painel
        scrollPane2.setSize(370, 120); // selecionando o tamanho da painel
        
        add (scrollPane2);
        
        scrollPane3.setLocation(400, 465);  // selecionando o localização da painel
        scrollPane3.setSize(370, 120); // selecionando o tamanho da painel
        
        add(scrollPane3); // adiciona o painel a tela
        
        scrollPane4.setLocation(470, 265);  // selecionando o localização da painel
        scrollPane4.setSize(300, 60); // selecionando o tamanho da painel
        
        add(scrollPane4); // adiciona o painel a tela
        
        scrollPane5.setLocation(10, 265);  // selecionando o localização da painel
        scrollPane5.setSize(300, 60); // selecionando o tamanho da painel
        
        add(scrollPane5); // adiciona o painel a tela
        
        
        
        scrollPane6.setLocation(10, 165);  // selecionando o localização da painel
        scrollPane6.setSize(760, 39); // selecionando o tamanho da painel
         
        add(scrollPane6); // adiciona o painel a tela

        
        
}

    

    
    private void Finaliza(){ //inicio da funação que finaliza o programa 
        this.dispose(); // finalização do programa
    }
    
    
    
    private void Desable(){ // inicio da função que desabilita os campos

        
        txtstatus.setEnabled(false);// desabilita a orgão status
}
     
     
   
      
    }
    

