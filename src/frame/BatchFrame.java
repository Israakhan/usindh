
import Bean.BatchBean;
import Bean.DatabaseManager;
import Bean.DepartmentBean;
import Bean.FacultyBean;
import Bean.ProgramBean;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isra Khan
 */
public class BatchFrame extends javax.swing.JFrame {

    /**
     * Creates new form BatchFrame
     */
    public BatchFrame() {
        initComponents();
        
          java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
        getFaculty();
    
        
    }
    private void getFaculty(){
        try{
            java.util.Vector v=DatabaseManager.getFaculty();
            FacComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
               FacComboBox.addItem(v.elementAt(i));
                
                }
            
        }//try
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error:"+e.getMessage());
        }
    
    }
    
    
    
    
    private void getDepartments(){
 FacultyBean bean=(FacultyBean)FacComboBox.getSelectedItem();
 if(bean==null) return;
 try{
 java.util.Vector v=DatabaseManager.getDepartment(bean.getFacId());
 DeptComboBox.removeAllItems();
 for(int i=0; i<v.size(); i++){
    this.DeptComboBox.addItem(v.elementAt(i));
 }
 } catch(Exception e){e.printStackTrace();}
 
 }
    
    
   private void getPrograms(){
   DepartmentBean bean=(DepartmentBean) DeptComboBox.getSelectedItem();
    if(bean==null) return;
        try{
        java.util.Vector v=DatabaseManager.getProgram(bean.getDeptId());
        ProgramComboBox.removeAllItems();
        for(int i=0; i<v.size(); i++){
        ProgramComboBox.addItem(v.elementAt(i));
            
       
        }
        }catch(Exception e){e.printStackTrace();}
   }//getprogram
        
        
   
   
           
           
           
         
 private void   getBatchYears(){ 
       ProgramBean bean=(ProgramBean) ProgramComboBox.getSelectedItem();
    if(bean==null) return;
        try{
        java.util.Vector v=DatabaseManager.getBatch(bean.getProgId());
        BatchYearList.setListData(v);
        
        }catch(Exception e){e.printStackTrace();}    
        
 } 
 

 
 private void clear(){
     BatchIdTextField.setText("");
     BatchYearTextField.setText("");
     RemarksTextArea.setText("");
     
 
 
 }
 
            

 private void addBatch(){
 ProgramBean bean=(ProgramBean)ProgramComboBox.getSelectedItem();
 if(bean==null) return;

 String BatchYear = BatchYearTextField.getText();

 String Remarks=RemarksTextArea.getText();
 try{
 int rows=DatabaseManager.addBatch(bean.getProgId(),BatchYear,Remarks);

 if(rows>=1){
 getBatchYears();
 clear();
 JOptionPane.showMessageDialog(null,rows+"Record Saved");

 }//if
 
 }//try
 catch(Exception e){
  JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
 
 }
 
 }//method

 private void deleteBatch(){
 
 
       BatchBean bean=(BatchBean) BatchYearList.getSelectedValue();
       if(bean==null)return;
        try{
            int rows=DatabaseManager.deleteBatch(bean.getBatchId());
                if(rows>=1){
                getBatchYears();
                    clear();
                        JOptionPane.showMessageDialog(this,rows+"Records Deleted");
                }
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
 
 
 }
 
 
 private void updateBatch(){
 
 
       BatchBean bean=(BatchBean) BatchYearList.getSelectedValue();
       if(bean==null)return;
        int batchYear=Integer.parseInt(BatchYearTextField.getText());
        String Remarks=RemarksTextArea.getText();
       
        try{
            int rows=DatabaseManager.updateBatch(bean.getProgId(),bean.getBatchId(),batchYear,Remarks);
                if(rows>=1){
                getBatchYears();
                    clear();
                        JOptionPane.showMessageDialog(this,rows+"Records updated");
                }
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
 }
 
 
   
   
   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BatchLabel = new javax.swing.JLabel();
        BatchYearlLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BatchYearList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        FacultyLabel = new javax.swing.JLabel();
        DeptLabel = new javax.swing.JLabel();
        ProgLabel = new javax.swing.JLabel();
        BatchYearLabel = new javax.swing.JLabel();
        BatchIdLabel = new javax.swing.JLabel();
        FacComboBox = new javax.swing.JComboBox();
        DeptComboBox = new javax.swing.JComboBox();
        ProgramComboBox = new javax.swing.JComboBox();
        BatchIdTextField = new javax.swing.JTextField();
        BatchYearTextField = new javax.swing.JTextField();
        ShiftLabel = new javax.swing.JLabel();
        GroupLabel = new javax.swing.JLabel();
        ShiftComboBox = new javax.swing.JComboBox();
        GroupComboBox = new javax.swing.JComboBox();
        RemarksLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        RemarksTextArea = new javax.swing.JTextArea();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BatchLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        BatchLabel.setText("Batch");
        getContentPane().add(BatchLabel);
        BatchLabel.setBounds(160, 10, 138, 60);

        BatchYearlLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BatchYearlLabel.setText("Batch year");
        getContentPane().add(BatchYearlLabel);
        BatchYearlLabel.setBounds(510, 70, 100, 40);

        BatchYearList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        BatchYearList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                BatchYearListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(BatchYearList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(490, 130, 150, 330);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 90, 0, 0);

        FacultyLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FacultyLabel.setText("Faculty");
        getContentPane().add(FacultyLabel);
        FacultyLabel.setBounds(30, 80, 60, 20);

        DeptLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeptLabel.setText("Department");
        getContentPane().add(DeptLabel);
        DeptLabel.setBounds(0, 126, 90, 50);

        ProgLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ProgLabel.setText("Program");
        getContentPane().add(ProgLabel);
        ProgLabel.setBounds(20, 190, 90, 40);

        BatchYearLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BatchYearLabel.setText("Batch year");
        getContentPane().add(BatchYearLabel);
        BatchYearLabel.setBounds(10, 310, 74, 17);

        BatchIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BatchIdLabel.setText("Batch Id");
        getContentPane().add(BatchIdLabel);
        BatchIdLabel.setBounds(20, 250, 60, 17);

        FacComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        FacComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(FacComboBox);
        FacComboBox.setBounds(90, 80, 290, 30);

        DeptComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DeptComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(DeptComboBox);
        DeptComboBox.setBounds(90, 140, 290, 30);

        ProgramComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProgramComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgramComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(ProgramComboBox);
        ProgramComboBox.setBounds(90, 200, 290, 30);
        getContentPane().add(BatchIdTextField);
        BatchIdTextField.setBounds(90, 250, 100, 30);
        getContentPane().add(BatchYearTextField);
        BatchYearTextField.setBounds(90, 310, 100, 30);

        ShiftLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ShiftLabel.setText("shift");
        getContentPane().add(ShiftLabel);
        ShiftLabel.setBounds(220, 277, 50, 30);

        GroupLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        GroupLabel.setText("Group");
        getContentPane().add(GroupLabel);
        GroupLabel.setBounds(390, 277, 50, 30);

        ShiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "E", "N" }));
        getContentPane().add(ShiftComboBox);
        ShiftComboBox.setBounds(200, 310, 140, 30);

        GroupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "E", "C", "G", " " }));
        GroupComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(GroupComboBox);
        GroupComboBox.setBounds(350, 310, 130, 30);

        RemarksLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RemarksLabel.setText("Remarks");
        getContentPane().add(RemarksLabel);
        RemarksLabel.setBounds(90, 350, 60, 17);

        RemarksTextArea.setColumns(20);
        RemarksTextArea.setRows(5);
        jScrollPane2.setViewportView(RemarksTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(90, 370, 390, 90);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteButton);
        DeleteButton.setBounds(160, 480, 100, 30);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateButton);
        UpdateButton.setBounds(270, 480, 90, 30);

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AddButton);
        AddButton.setBounds(90, 480, 60, 30);

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ClearButton);
        ClearButton.setBounds(370, 480, 110, 30);

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(490, 480, 150, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GroupComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GroupComboBoxActionPerformed

    private void BatchYearListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_BatchYearListValueChanged
        BatchBean bean=(BatchBean)BatchYearList.getSelectedValue();
  if(bean==null)return;
  
        
        
        
        BatchIdTextField.setText(""+bean.getBatchId());
        BatchYearTextField.setText(""+bean.getBatchYear());
        RemarksTextArea.setText(bean.getRemarks());

        ShiftComboBox.setSelectedItem(bean.getShift());  
        GroupComboBox.setSelectedItem(bean.getGroupDesc());
        
            
                
        
    }//GEN-LAST:event_BatchYearListValueChanged

    
    
    private void DeptComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptComboBoxActionPerformed
        getPrograms();
 
 
    }//GEN-LAST:event_DeptComboBoxActionPerformed

    private void FacComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacComboBoxActionPerformed
         getDepartments();
        
    }//GEN-LAST:event_FacComboBoxActionPerformed

    private void ProgramComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgramComboBoxActionPerformed
      getBatchYears();
     
    }//GEN-LAST:event_ProgramComboBoxActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        hide();
        
    }//GEN-LAST:event_BackButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        addBatch();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
      clear();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       deleteBatch();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
    updateBatch();
    }//GEN-LAST:event_UpdateButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatchFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel BatchIdLabel;
    private javax.swing.JTextField BatchIdTextField;
    private javax.swing.JLabel BatchLabel;
    private javax.swing.JLabel BatchYearLabel;
    private javax.swing.JList BatchYearList;
    private javax.swing.JTextField BatchYearTextField;
    private javax.swing.JLabel BatchYearlLabel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JComboBox DeptComboBox;
    private javax.swing.JLabel DeptLabel;
    private javax.swing.JComboBox FacComboBox;
    private javax.swing.JLabel FacultyLabel;
    private javax.swing.JComboBox GroupComboBox;
    private javax.swing.JLabel GroupLabel;
    private javax.swing.JLabel ProgLabel;
    private javax.swing.JComboBox ProgramComboBox;
    private javax.swing.JLabel RemarksLabel;
    private javax.swing.JTextArea RemarksTextArea;
    private javax.swing.JComboBox ShiftComboBox;
    private javax.swing.JLabel ShiftLabel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
