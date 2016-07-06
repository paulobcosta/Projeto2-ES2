package projeto2.paineis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import projeto2.dao.ContaDAO;
import projeto2.entidades.conta.Conta;
import projeto2.transacoes.Transacao;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
*
* @author paulo
*/
public class PainelOperacao extends javax.swing.JFrame {

   /**
    * Creates new form PainelOperacao
    */
   private Conta conta;
   private ContaDAO dao;
   public PainelOperacao(Conta c) {
       initComponents();
       this.conta = c;
       this.dao = new ContaDAO();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       cOperacao = new javax.swing.JComboBox<>();
       jLabel1 = new javax.swing.JLabel();
       jScrollPane2 = new javax.swing.JScrollPane();
       jTable1 = new javax.swing.JTable();
       jTextField1 = new javax.swing.JTextField();
       jLabel2 = new javax.swing.JLabel();
       jButton1 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       cOperacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Debitar Valor", "Creditar Valor" }));

       jLabel1.setText("Opera��es Financeiras");

       jTable1.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {
               {null, null},
               {null, null},
               {null, null},
               {null, null}
           },
           new String [] {
               "Descri��o", "Valor"
           }
       ) {
           Class[] types = new Class [] {
               java.lang.String.class, java.lang.String.class
           };
           boolean[] canEdit = new boolean [] {
               false, false
           };

           public Class getColumnClass(int columnIndex) {
               return types [columnIndex];
           }

           public boolean isCellEditable(int rowIndex, int columnIndex) {
               return canEdit [columnIndex];
           }
       });
       jScrollPane2.setViewportView(jTable1);

       jTextField1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jTextField1ActionPerformed(evt);
           }
       });

       jLabel2.setText("R$");

       jButton1.setText("Confirmar");
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(109, 109, 109)
                       .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGroup(layout.createSequentialGroup()
                       .addGap(265, 265, 265)
                       .addComponent(jLabel2)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(jTextField1)
                           .addComponent(cOperacao, 0, 147, Short.MAX_VALUE))
                       .addGap(72, 72, 72)
                       .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGroup(layout.createSequentialGroup()
                       .addGap(310, 310, 310)
                       .addComponent(jLabel1)))
               .addContainerGap(114, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jLabel1)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel2))
               .addGap(33, 33, 33)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                   .addComponent(cOperacao))
               .addGap(40, 40, 40)
               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(30, 30, 30))
       );

       pack();
   }// </editor-fold>                        

   private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
       // TODO add your handling code here:
   }                                           

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       // TODO add your handling code here:
	   if(this.jTextField1.getText().matches("[0-9]*\\.[0-9]*")) {
		   if(this.cOperacao.getSelectedItem().toString().equals("Debitar Valor")) {
			   conta.debitaValor(Double.valueOf(this.jTextField1.getText()), "debito");
		   }
		   else {
			   conta.creditaValor(Double.valueOf(this.jTextField1.getText()));
		   }
		   JOptionPane.showMessageDialog(null, "Transa��o adicionada com sucesso", "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
		   dao.persist(conta);
		   String[][] resultado = new String[conta.getTransacoes().size()][2];
		   int i = 0;
		   for(Transacao t : conta.getTransacoes()) {
			   resultado[i][0] = t.getDescricao();
			   resultado[i][1] = t.getValor().toString();
			   i = i + 1;
		   }
		   
		   
		   this.jTable1.setModel(new DefaultTableModel(resultado,new String [] {
	               "Descri��o", "Valor"
	           }));
		   JOptionPane.showMessageDialog(null, "Valor em conta: " + conta.getValorEmConta().toString(), "Valor em conta", JOptionPane.INFORMATION_MESSAGE);
	   }
	   else {
		   JOptionPane.showMessageDialog(null, "Erro no formato da moeda","Erro", JOptionPane.INFORMATION_MESSAGE);
	   }
	   
   }                                        



   // Variables declaration - do not modify                     
   private javax.swing.JComboBox<String> cOperacao;
   private javax.swing.JButton jButton1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTable jTable1;
   private javax.swing.JTextField jTextField1;
   // End of variables declaration                   
}