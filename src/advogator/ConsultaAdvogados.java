/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advogator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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

/**
 *
 * @author Thales
 */
public class ConsultaAdvogados extends JFrame {
    
    JFrame consulta = new JFrame();
    
    private final JLabel lblid;
    private final JLabel lbloab;
    private final JLabel lblnome;
    private final JLabel lbladvogado;
    
    private final JTextField txtid;
    private final JTextField txtoab;
    private final JTextField txtnome;
    
    private final JButton btnCancelar;
    private final JButton btnConsultar;
    private final JButton btnExcluir;
    private final JButton btnSair;
    
    private Conexao Conect = new Conexao();
    int oProcesso;
    
    CadastroAdvogado FrmAdvogado;
    
    public ConsultaAdvogados(CadastroAdvogado pAdvogado){
    
    List<String []> ListDados = new ArrayList();
    
    FrmAdvogado = pAdvogado;   
        
    this.setSize(600, 400);
    this.setTitle("Consulta de Advogados");
    this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblid = new JLabel("ID");
        lblid.setSize(40, 30);
        lblid.setLocation(20, 10);
        this.add(lblid);
        
        lbloab = new JLabel("Número da OAB");
        lbloab.setSize(120, 30);
        lbloab.setLocation(20, 40);
        this.add(lbloab);
        
        lblnome = new JLabel("Nome");
        lblnome.setSize(80, 30);
        lblnome.setLocation(20, 70);
        this.add(lblnome);
        
        lbladvogado = new JLabel("Advogados"); 
        lbladvogado.setSize(80, 30);
        lbladvogado.setLocation(250, 110);
        this.add(lbladvogado);
       
        txtid = new JTextField();
        txtid.setSize(150,20);
        txtid.setLocation(135,15);
        this.add(txtid);
    
        txtoab = new JTextField();
        txtoab.setSize(150,20);
        txtoab.setLocation(135,45);
        this.add(txtoab);
        
        txtnome = new JTextField();
        txtnome.setSize(150,20);
        txtnome.setLocation(135,75);
        this.add(txtnome);
       
        
        JTable tblConsulta;
        
         DefaultTableModel drmModo = new DefaultTableModel();
         String Headers[] = {"ID", "Número da OAB", "Nome","Status do Advogado"};  // Inicialização do headers da tabela
        
        drmModo = new DefaultTableModel(Headers,0); // inicialização do modo padrão da tela
        tblConsulta = new JTable(drmModo); // inicialização da tabela com o modo padrão
        
        this.add(tblConsulta);
        
        tblConsulta.setLocation(0, 0);  // selecionando o localização da tabela
        tblConsulta.setSize(20, 30); // selecionando o tamanho da tabela
        
        tblConsulta.getColumnModel().getColumn(0).setMaxWidth(50); // seleciona tamanho maximo da coluna 0
        tblConsulta.getColumnModel().getColumn(0).setMinWidth(50); // seleciona tamanho minimo da coluna 0

        tblConsulta.getColumnModel().getColumn(1).setMaxWidth(165); // seleciona tamanho maximo da coluna 1
        tblConsulta.getColumnModel().getColumn(1).setMinWidth(165); // seleciona tamanho minimo da coluna 1
        
        tblConsulta.getColumnModel().getColumn(2).setMaxWidth(280); // seleciona tamanho maximo da coluna 1
        tblConsulta.getColumnModel().getColumn(2).setMinWidth(280); // seleciona tamanho minimo da coluna 1
        
        tblConsulta.getColumnModel().getColumn(3).setMaxWidth(70); // seleciona tamanho maximo da coluna 1
        tblConsulta.getColumnModel().getColumn(3).setMinWidth(70); // seleciona tamanho minimo da coluna 1
        
        JScrollPane scrollPane = new JScrollPane(tblConsulta); // inicialização do painel com a tabela
        
        scrollPane.setLocation(10, 140);  // selecionando o localização da painel
        scrollPane.setSize(560, 150); // selecionando o tamanho da painel
         
        add(scrollPane); // adiciona o painel a tela

        ListDados = (List<String[]>) FrmAdvogado.LogRegs();

        for(int Pos = 0; Pos < ListDados.size(); Pos++) {
        
            drmModo.addRow(ListDados.get(Pos));
            
        }
        
        btnCancelar = new JButton ("Cancelar");
        btnCancelar.setSize(95 , 30);
        btnCancelar.setLocation (130 , 315);
        btnCancelar.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                   dispose();                
                }

            });
        this.add(btnCancelar);

        btnExcluir = new JButton ("Desligar Advogado");
        btnExcluir.setSize(130 , 30);
        btnExcluir.setLocation (240 , 315);
        btnExcluir.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    Excluir excluir= new Excluir();
                    excluir.excluir.show();
                }

            });
        this.add(btnExcluir);
        
        btnConsultar = new JButton ("Consultar");
        btnConsultar.setSize(95 , 30);
        btnConsultar.setLocation (20 , 315);
        btnConsultar.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                }

            });
        this.add(btnConsultar);
        
        btnSair = new JButton ("Sair");
        btnSair.setSize(64 , 30);
        btnSair.setLocation (500, 315);
        btnSair.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    dispose();
                }
            });
        this.add(btnSair);
        
        
    }    
}