/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advogator;

import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author guilh
 */
public class Janela_comprovante {
    
    JFrame janela = new JFrame();
    private final JLabel lblIdComprovante;
    private final JLabel lblValor;
    private final JLabel lblFormaPagamento;
    private final JLabel lblVencimento;
    private final JLabel lblIdCobranca;
    private final JLabel lblIdReclamante;
    private final JButton btnInserir;
    private final JButton btnAlterar;
    private final JButton btnConsultar;
    private final JButton btnExcluir;
    private final JButton btnSair;
    private final JTextField txtIdComprovante;
    private final JTextField txtValor;
    private final JTextField txtFormaPagamento;
    private final JTextField txtVencimento;
    private final JTextField txtIdCobranca;
    private final JTextField txtIdReclamante;
    
    public Janela_comprovante() {
        
        this.janela.setSize(500, 400);
        this.janela.setTitle("Comprovante");
        
        lblIdComprovante = new JLabel("Id Comprovante");
        lblIdComprovante.setSize(100, 30);
        lblIdComprovante.setLocation(10, 10);
        txtIdComprovante = new JTextField();
        txtIdComprovante.setSize(120,20);
        txtIdComprovante.setLocation(110,15);
        
        this.janela.add(txtIdComprovante);
        this.janela.add(lblIdComprovante);
        
        lblValor = new JLabel ("Valor");
        lblValor.setSize(100, 50);
        lblValor.setLocation(10, 120);
        txtValor = new JTextField();
        txtValor.setSize(180, 20);
        txtValor.setLocation(50, 135);
        
        this.janela.add(lblValor);
        this.janela.add(txtValor);
        
        lblIdReclamante = new JLabel ("Id Reclamante");
        lblIdReclamante.setSize(100, 30);
        lblIdReclamante.setLocation(10, 70);
        txtIdReclamante = new JTextField ();
        txtIdReclamante.setSize(130,20);
        txtIdReclamante.setLocation(100,75);
        
        this.janela.add(lblIdReclamante);
        this.janela.add(txtIdReclamante);
        
        lblFormaPagamento = new JLabel ("Forma de Pagamento");
        lblFormaPagamento.setSize(200, 30);
        lblFormaPagamento.setLocation(10,160);
        txtFormaPagamento = new JTextField();
        txtFormaPagamento.setSize(90,20);
        txtFormaPagamento.setLocation(140,165);
        
        this.janela.add(lblFormaPagamento);
        this.janela.add(txtFormaPagamento);
        
        lblIdCobranca = new JLabel ("Id Cobrança");
        lblIdCobranca.setSize(100, 30);
        lblIdCobranca.setLocation(10, 40);
        txtIdCobranca = new JTextField ();
        txtIdCobranca.setSize(145,20);
        txtIdCobranca.setLocation(85,45);
        
        this.janela.add(txtIdCobranca);
        this.janela.add(lblIdCobranca);
        
        lblVencimento = new JLabel ("Vencimento");
        lblVencimento.setSize(100,20);
        lblVencimento.setLocation(10,105);
        txtVencimento = new JTextField ();
        txtVencimento.setSize(145,20);
        txtVencimento.setLocation(85,105);
        
        this.janela.add(lblVencimento);
        this.janela.add(txtVencimento);
        
       
        
        btnInserir = new JButton("Inserir");    
        btnInserir.setSize(95 , 30);
        btnInserir.setLocation (10 , 280);
        
        btnAlterar = new JButton ("Alterar");
        btnAlterar.setSize(95 , 30);
        btnAlterar.setLocation (105 , 280);

        btnExcluir = new JButton ("Excluir");
        btnExcluir.setSize(95 , 30);
        btnExcluir.setLocation (200 , 280);
        
        btnConsultar = new JButton ("Consultar");
        btnConsultar.setSize(95 , 30);
        btnConsultar.setLocation (295 , 280);
        
        btnSair = new JButton ("Sair");
        btnSair.setSize(64 , 30);
        btnSair.setLocation (390, 280);
        
        this.janela.add(btnInserir);
        this.janela.add(btnExcluir);
        this.janela.add(btnAlterar);
        this.janela.add(btnConsultar);
        this.janela.add(btnSair);

        this.janela.setLayout(null);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
}