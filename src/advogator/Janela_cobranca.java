/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advogator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author internet
 */
public class Janela_cobranca extends JFrame{
    
    JFrame janela = new JFrame();
    private final JLabel lblId;
    private final JLabel lblCodProcesso;
    private final JLabel lblValorDeferido;
    private final JLabel lblDataCredito;
    private final JLabel lblValorEscritorio;
    private final JLabel lblValorReclamante;
    private final JButton btnInserir;
    private final JButton btnAlterar;
    private final JButton btnConsultar;
    private final JButton btnExcluir;
    private final JButton btnSair;
    private final JTextField txtId;
    private final JTextField txtCodProcesso;
    private final JTextField txtValorDeferido;
    private final JTextField txtDataCredito;
    private final JTextField txtValorEscritorio;
    private final JTextField txtValorReclamante;
    
    public Janela_cobranca() {
        
        this.janela.setSize(500, 250);
        this.janela.setTitle("Cobrança");
        
        lblId = new JLabel("Id");
        lblId.setSize(40, 30);
        lblId.setLocation(10, 10);
        txtId = new JTextField();
        txtId.setSize(50,20);
        txtId.setLocation(35,15);
        this.janela.add(txtId);
        this.janela.add(lblId);
        
        lblDataCredito = new JLabel ("Data Crédito");
        lblDataCredito.setSize(100, 30);
        lblDataCredito.setLocation(10, 40);
        txtDataCredito = new JTextField ();
        txtDataCredito.setSize(90,20);
        txtDataCredito.setLocation(90,45);
        
        this.janela.add(lblDataCredito);
        this.janela.add(txtDataCredito);
        
        
        lblValorDeferido = new JLabel ("Valor Deferido");
        lblValorDeferido.setSize(100, 30);
        lblValorDeferido.setLocation(185,40);
        txtValorDeferido = new JTextField();
        txtValorDeferido.setSize(185,20);
        txtValorDeferido.setLocation(270,45);
        
        this.janela.add(lblValorDeferido);
        this.janela.add(txtValorDeferido);
        
        
        lblCodProcesso = new JLabel ("Código Processo");
        lblCodProcesso.setSize(100, 30);
        lblCodProcesso.setLocation(95, 10);
        txtCodProcesso = new JTextField ();
        txtCodProcesso.setSize(250,20);
        txtCodProcesso.setLocation(205,15);
        
        this.janela.add(txtCodProcesso);
        this.janela.add(lblCodProcesso);
        
        
        lblValorEscritorio = new JLabel ("Valor Escritório");
        lblValorEscritorio.setSize(100,20);
        lblValorEscritorio.setLocation(10,75);
        txtValorEscritorio = new JTextField ();
        txtValorEscritorio.setSize(350,20);
        txtValorEscritorio.setLocation(105,75);
        
        this.janela.add(lblValorEscritorio);
        this.janela.add(txtValorEscritorio);
      
        
        lblValorReclamante = new JLabel ("Valor Reclamante");
        lblValorReclamante.setSize(150, 30);
        lblValorReclamante.setLocation(10, 100);
        txtValorReclamante = new JTextField();
        txtValorReclamante.setSize(340, 20);
        txtValorReclamante.setLocation(115, 105);
        
        this.janela.add(lblValorReclamante);
        this.janela.add(txtValorReclamante); 
        
        btnInserir = new JButton("Inserir");    
        btnInserir.setSize(95 , 30);
        btnInserir.setLocation (10 , 165);
        
        btnAlterar = new JButton ("Alterar");
        btnAlterar.setSize(95 , 30);
        btnAlterar.setLocation (105 , 165);

        btnExcluir = new JButton ("Excluir");
        btnExcluir.setSize(95 , 30);
        btnExcluir.setLocation (200 , 165);
        
        btnConsultar = new JButton ("Consultar");
        btnConsultar.setSize(95 , 30);
        btnConsultar.setLocation (295 , 165);
        
        btnSair = new JButton ("Sair");
        btnSair.setSize(64 , 30);
        btnSair.setLocation (390, 165);
        
        this.janela.add(btnInserir);
        this.janela.add(btnExcluir);
        this.janela.add(btnAlterar);
        this.janela.add(btnConsultar);
        this.janela.add(btnSair);

        this.janela.setLayout(null);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
}