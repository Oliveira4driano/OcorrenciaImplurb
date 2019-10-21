/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Servidor;
import relatorio.Relatorio;

/**
 *
 * @author Adriano
 */
public final class TelaPrincipal extends javax.swing.JFrame {

       
    private final List<Servidor> lista = new ArrayList<>();
    
    public void salvar(){
        
        Servidor servidor = new Servidor();
        
            if(!(campoNome.getText().trim().isEmpty())&& !campoMatricula.getText().trim().isEmpty() && !campoJustificativa.getText().trim().isEmpty()){
             servidor.setNome(campoNome.getText().toUpperCase());
        
        
             servidor.setMatricula(campoMatricula.getText());
        
            servidor.setVinculo((String) comboVinculo.getSelectedItem());
        
             servidor.setJustificativa(campoJustificativa.getText());
            
            if(radioData.isSelected()){
                if(!(jDateChooser1.getDate()==null)){
                  
                Date data = jDateChooser1.getDate();
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                String novaData = formatador.format(data);
                servidor.setDataOcorrencia(novaData);
                 lista.add(servidor);
                           
                  relatorio(); 
                }else{
                    JOptionPane.showMessageDialog(null, "Preencha o campo Data");   
                }
                
            }else{
                comboMes.setEnabled(true);
                if(!campoMascaraData.getText().trim().isEmpty()){
                    servidor.setDataOcorrencia(campoMascaraData.getText()+"  - "+comboMes.getSelectedItem());
                 lista.add(servidor);
            
                 relatorio(); 
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Preencha o campo dias"); 
                }
                
            }
           
            }else{
                JOptionPane.showMessageDialog(null, "preencha os campos em branco");
            }
             
    }
    
    public void mascara(){
        if(radioData.isSelected()){
            jDateChooser1.setEnabled(true);
            campoMascaraData.setEnabled(false); 
            campoMascaraData.setText("");
            comboMes.setEnabled(false);
           // comboMes.setVisible(false);
           
        }else{
            jDateChooser1.setDate(null);
            campoMascaraData.setEnabled(true);  
            jDateChooser1.setEnabled(false);
           comboMes.setEnabled(true);
           // comboMes.setVisible(true);
            
        }
    }
    
    
    public void relatorio(){
        Relatorio relatorio = new Relatorio();
        relatorio.gerarRelatorio(lista);
    
    }
    
    public void imprimir(){
        if(botaoImprimir.getText().equals("Imprimir")){
           
                 salvar();
        lista.clear();
        botaoImprimir.setText("Alterar");
                
   

        }
        else{
           
           salvar();
         
           lista.clear();
           botaoImprimir.setText("Imprimir");
        }
    }
    
     private void limpaCampos() {
       campoNome.setText("");
       campoMatricula.setText("");
       jDateChooser1.setDate(null);
       campoMascaraData.setText("");
       campoJustificativa.setText("");
    }
     
    
     
     public TelaPrincipal() throws ParseException {
      
        initComponents();
        this.setLocationRelativeTo(null);   
        mascara();
        campoJustificativa.setLineWrap(true);
        
      
        
    }
    
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupobotoes = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoMatricula = new javax.swing.JTextField();
        comboVinculo = new javax.swing.JComboBox<>();
        campoMascaraData = new javax.swing.JFormattedTextField();
        radioData = new javax.swing.JRadioButton();
        radioDia = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoJustificativa = new javax.swing.JTextArea();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        comboMes = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        botaoSair = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        botaoImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IMPLURB Ocorrência");
        setResizable(false);

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Comunicação de Ocorrencia de Frequência"));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Servidor:");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 36, -1, -1));

        jLabel2.setText("Matricula:");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel3.setText("Vinculo:");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setText("Justificativa:");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));
        panel.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 247, -1));
        panel.add(campoMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 180, -1));

        comboVinculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARGO COMISSIONADO", "ESTATUTARIO","ESTAGIARIO", "RDA","OUTRO _____________" }));
        panel.add(comboVinculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 180, -1));
        panel.add(campoMascaraData, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 120, -1));

        grupobotoes.add(radioData);
        radioData.setSelected(true);
        radioData.setText("Data da Ocorrencia");
        radioData.setAutoscrolls(true);
        radioData.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioDataItemStateChanged(evt);
            }
        });
        panel.add(radioData, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        grupobotoes.add(radioDia);
        radioDia.setText("Dias");
        radioDia.setAutoscrolls(true);
        radioDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDiaActionPerformed(evt);
            }
        });
        panel.add(radioDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        campoJustificativa.setColumns(20);
        campoJustificativa.setRows(5);
        campoJustificativa.setToolTipText("Preencha a justificativa");
        campoJustificativa.setAutoscrolls(false);
        campoJustificativa.setName("tesate"); // NOI18N
        jScrollPane1.setViewportView(campoJustificativa);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 340, -1));
        panel.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 150, -1));

        comboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" }));
        panel.add(comboMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 180, 90, -1));

        jLabel6.setText("2019 GINF - Gerencia de informatica v.1.9");

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        jButton1.setText("Limpa ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botaoImprimir.setText("Imprimir");
        botaoImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(botaoSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoImprimir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoImprimir, botaoSair, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSair)
                    .addComponent(jButton1)
                    .addComponent(botaoImprimir))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoImprimir, botaoSair, jButton1});

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImprimirActionPerformed
       imprimir();   
    }//GEN-LAST:event_botaoImprimirActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
       dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        limpaCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radioDataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioDataItemStateChanged
       mascara();
        
    }//GEN-LAST:event_radioDataItemStateChanged

    private void radioDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDiaActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new TelaPrincipal().setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoImprimir;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextArea campoJustificativa;
    private javax.swing.JFormattedTextField campoMascaraData;
    private javax.swing.JTextField campoMatricula;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JComboBox<String> comboVinculo;
    private javax.swing.ButtonGroup grupobotoes;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JRadioButton radioData;
    private javax.swing.JRadioButton radioDia;
    // End of variables declaration//GEN-END:variables

   

 
}
