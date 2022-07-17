/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advogator;

import java.awt.event.ActionEvent; //Importação da classe que responde a eventos
import java.awt.event.ActionListener; //Importação da classe que espera pelos eventos
import java.sql.Connection; //Importação da classe que cria Conexões SQL
import java.sql.ResultSet; //Importação da classe que cria cursores
import java.sql.SQLException; //Importação da classe que cria excessões
import java.sql.Statement; //Importação da classe que cria comandos
import java.util.ArrayList;  //Importação da classe que controla ArrayList
import java.util.List; //Importação da classe que controla listas
import java.util.logging.Level;  //Importação da classe que cria log de nivel
import java.util.logging.Logger; //Importação da classe que cria log
import javax.swing.JButton; //Importação da classe de Botão
import javax.swing.JFrame; //Importação da classe de janela
import javax.swing.JScrollPane; //Importação da classe de painel
import javax.swing.JTable; //Importação da classe de tabela
import javax.swing.table.DefaultTableModel; //Importação da classe de Modo de tabelas padrão

/**
 *
 * @author TARDIS
 */
public class TabelaD extends JFrame{

    private DefaultTableModel drmModo; // criação da variavel de Modo de tabelas padrão
    private JTable tblConsulta; // ceriação da tabela de consulta
    JButton btnSelecao, btnCancela; // criação dos botões
    
    documentos FrmProcesso; // criação da variavel do objeto Cliente

    public TabelaD(JFrame pDocumentos) {
        
        List<String []> ListDados = new ArrayList(); // criação da lista de dados

        FrmProcesso = (documentos) pDocumentos; // inicialização do objeto Cliente
        drmModo = new DefaultTableModel();
        
        setLayout(null); // selecionando o layout da tela
        setLocation(400, 400);  // selecionando o localização da tela
        setTitle("Consulta"); // selecionando o titulo da tela
        setSize(800, 400); // selecionando o tamanho da tela
        
    
        String Headers[] = {"id", "nºprocesso","Descrição","Data"};  // Inicialização do headers da tabela
        
        drmModo = new DefaultTableModel(Headers,0); // inicialização do modo padrão da tela
        tblConsulta = new JTable(drmModo); // inicialização da tabela com o modo padrão

        ListDados = (List<String[]>) FrmProcesso.LogRegs();

        for(int Pos = 0; Pos < ListDados.size(); Pos++) {
        
            drmModo.addRow(ListDados.get(Pos));
            
        }
        
        tblConsulta.setLocation(0, 0);  // selecionando o localização da tabela
        tblConsulta.setSize(360, 350); // selecionando o tamanho da tabela
        
        tblConsulta.getColumnModel().getColumn(0).setMaxWidth(50); // seleciona tamanho maximo da coluna 0
        tblConsulta.getColumnModel().getColumn(0).setMinWidth(50); // seleciona tamanho minimo da coluna 0

        //tblConsulta.getColumnModel().getColumn(1).setMaxWidth(290); // seleciona tamanho maximo da coluna 1
        //tblConsulta.getColumnModel().getColumn(1).setMinWidth(290); // seleciona tamanho minimo da coluna 1

        JScrollPane scrollPane = new JScrollPane(tblConsulta); // inicialização do painel com a tabela
        
        scrollPane.setLocation(10, 10);  // selecionando o localização da painel
        scrollPane.setSize(760, 290); // selecionando o tamanho da painel
         
        add(scrollPane); // adiciona o painel a tela

        btnSelecao = new JButton("Seleciona");  // inicia o botão Seleciona
        btnSelecao.setLocation(10,315); // selecioinando da localização do botão Seleciona
        btnSelecao.setSize(90,30); // selecionando do tamanho do texto do botão Seleciona
        
        btnSelecao.addActionListener( // inclusão da função que verifica se o botão Seleciona foi precionado
            new ActionListener(){ // inicio do objeto que verifica se o botão Seleciona  foi precionado
                public void actionPerformed(ActionEvent e) { // função que realiza a ação quando o botão Seleciona é precionado
                    FrmProcesso.SetKey(drmModo.getValueAt(tblConsulta.getSelectedRow(), 0).toString()); // chama a funcoa se seleção de registro com o registro selecionado
                    dispose(); // fecha a tela                   
                }
            }
        );

        add(btnSelecao); // Inclusão do botão Seleciona na tela
        
        btnCancela = new JButton("Cancelar"); // inicia o botão Cancelar
        btnCancela.setLocation(280,315); // selecioinando da localização do botão Cancelar
        btnCancela.setSize(90,30); // selecionando do tamanho do texto do botão Cancelar

        btnCancela.addActionListener( // inclusão da função que verifica se o botão Cancelar foi precionado
            new ActionListener(){ // inicio do objeto que verifica se o botão Cancelar  foi precionado
                public void actionPerformed(ActionEvent e) { // função que realiza a ação quando o botão Cancelar é precionado
                    dispose();  // fecha a tela                   
                }
            }
        );

        add(btnCancela); // Inclusão do botão Cancelar na tela
                
    }
    
}
