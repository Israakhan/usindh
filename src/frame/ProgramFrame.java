/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import Bean.BatchBean;
import Bean.DatabaseManager;
import Bean.DepartmentBean;
import Bean.FacultyBean;

import Bean.ProgramBean;
import javax.swing.JOptionPane;

/**
 *
 * @author Isra Khan
 */
public class ProgramFrame extends javax.swing.JFrame {

    /**
     * Creates new form ProgramFrame
     */
    public ProgramFrame() {
        initComponents();
        
          java.awt.Toolkit kit=this.getToolkit();
            java.awt.Dimension d=kit.getScreenSize();
            this.setBounds(0,0,d.width,d.height);
            getFaculty();
     
    }

      
 private void getFaculty(){
        try{
            java.util.Vector v=DatabaseManager.getFaculty();
           FacComboBox .removeAllItems();
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
     
     System.out.println(v.elementAt(i));
     DeptComboBox.addItem(v.elementAt(i));
 }
 } catch(Exception e){e.printStackTrace();}
 
 }
 
 
 
  
 private void getPrograms(){
 
     DepartmentBean bean=(DepartmentBean)DeptComboBox.getSelectedItem();
 
     if(bean==null) return;
 try{
 java.util.Vector v=DatabaseManager.getProgram(bean.getDeptId());
this.ProgramsList.setListData(v); 
 } catch(Exception e){e.printStackTrace();}
 
 }
 
 
 
 
  private void clear(){
 
     ProgIdTextField.setText("");
     ProgDurTextField.setText("");
     ProgNameTextField.setText("");
     RemarksTextArea.setText("");
 
 }
  
  
    private void addPrograms(){
            DepartmentBean bean=(DepartmentBean)DeptComboBox.getSelectedItem();
            if(bean==null) return;
            String ProgName=ProgNameTextField.getText();
            String ProgDur=ProgDurTextField.getText();
            String Remarks=RemarksTextArea.getText();
            try{
            
            int rows=DatabaseManager.addProgram(bean.getDeptId(),ProgName,ProgDur,Remarks);
            if(rows>=1){
                getPrograms();
                clear();
                JOptionPane.showMessageDialog(this,rows+"Records Saved");
            }
            } catch(Exception e){
               JOptionPane.showMessageDialog(this,"ERROR"+e.getMessage()); 
                
            }
    }//method add students end here
    
    
    private void deleteProgram(){
    
    
       ProgramBean bean=(ProgramBean) ProgramsList.getSelectedValue();
       if(bean==null)return;
        try{
            int rows=DatabaseManager.deleteProgram(bean.getProgId());
                if(rows>=1){
                getPrograms();
                    clear();
                        JOptionPane.showMessageDialog(this,rows+"Records Deleted");
                }
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
    
    
   
    }//prog
    
    
      private void updateProgram(){
    
    
       ProgramBean bean=(ProgramBean) ProgramsList.getSelectedValue();
       if(bean==null)return;
        String progName=ProgNameTextField.getText();
        String progDur=ProgDurTextField.getText();
        String remarks=RemarksTextArea.getText();
       
        try{
            int rows=DatabaseManager.updateProgram(bean.getDeptId(),bean.getProgId(),progName,progDur,remarks);
                if(rows>=1){
                getPrograms();
                    clear();
                        JOptionPane.showMessageDialog(this,rows+"Records updated");
                }
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
    
    
   
    }//prog
 
 
 
 
 
 
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProgramLabel = new javax.swing.JLabel();
        FacultyLabel = new javax.swing.JLabel();
        FacultyyLabel = new javax.swing.JLabel();
        FacComboBox = new javax.swing.JComboBox();
        DeptLabel = new javax.swing.JLabel();
        DeptComboBox = new javax.swing.JComboBox();
        ProgIdLabel = new javax.swing.JLabel();
        ProgIdTextField = new javax.swing.JTextField();
        ProgNameLabel = new javax.swing.JLabel();
        ProgNameTextField = new javax.swing.JTextField();
        ProgDurTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RemarksTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProgramsList = new javax.swing.JList();
        ProgramsLabel = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        ProgramLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        ProgramLabel.setText("Program");
        getContentPane().add(ProgramLabel);
        ProgramLabel.setBounds(180, 0, 193, 82);
        getContentPane().add(FacultyLabel);
        FacultyLabel.setBounds(205, 208, 0, 0);

        FacultyyLabel.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        FacultyyLabel.setText("Faculty ");
        getContentPane().add(FacultyyLabel);
        FacultyyLabel.setBounds(90, 80, 157, 31);

        FacComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        FacComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(FacComboBox);
        FacComboBox.setBounds(160, 80, 214, 31);

        DeptLabel.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        DeptLabel.setText("Department");
        getContentPane().add(DeptLabel);
        DeptLabel.setBounds(60, 140, 66, 22);

        DeptComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DeptComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(DeptComboBox);
        DeptComboBox.setBounds(160, 140, 214, 36);

        ProgIdLabel.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        ProgIdLabel.setText("Program Id");
        getContentPane().add(ProgIdLabel);
        ProgIdLabel.setBounds(70, 190, 89, 31);
        getContentPane().add(ProgIdTextField);
        ProgIdTextField.setBounds(160, 200, 270, 28);

        ProgNameLabel.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        ProgNameLabel.setText("Program Name");
        getContentPane().add(ProgNameLabel);
        ProgNameLabel.setBounds(50, 260, 89, 22);
        getContentPane().add(ProgNameTextField);
        ProgNameTextField.setBounds(160, 260, 270, 29);

        ProgDurTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgDurTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(ProgDurTextField);
        ProgDurTextField.setBounds(160, 310, 270, 33);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel1.setText("Program Duration");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 310, 199, 22);

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel2.setText("Remarks");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 360, 53, 22);

        RemarksTextArea.setColumns(20);
        RemarksTextArea.setRows(5);
        jScrollPane1.setViewportView(RemarksTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(150, 390, 280, 96);

        ProgramsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ProgramsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ProgramsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ProgramsList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(460, 110, 117, 380);

        ProgramsLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ProgramsLabel.setText("Programs");
        getContentPane().add(ProgramsLabel);
        ProgramsLabel.setBounds(460, 60, 101, 29);

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AddButton);
        AddButton.setBounds(150, 510, 60, 30);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteButton);
        DeleteButton.setBounds(220, 510, 70, 30);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateButton);
        UpdateButton.setBounds(297, 510, 70, 30);

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ClearButton);
        ClearButton.setBounds(370, 510, 57, 30);

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(460, 510, 120, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProgDurTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgDurTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProgDurTextFieldActionPerformed

    private void ProgramsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ProgramsListValueChanged
         ProgramBean bean=(ProgramBean)ProgramsList.getSelectedValue();
         if(bean==null)return;
        ProgIdTextField.setText(""+bean.getProgId());
        ProgNameTextField.setText(bean.getProgName());
        ProgDurTextField.setText(""+bean.getDurationInSem());
        RemarksTextArea.setText(bean.getRemarks());
        
            
    }//GEN-LAST:event_ProgramsListValueChanged

    private void DeptComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptComboBoxActionPerformed
     getPrograms();
      
    }//GEN-LAST:event_DeptComboBoxActionPerformed

    private void FacComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacComboBoxActionPerformed
      getDepartments();
    }//GEN-LAST:event_FacComboBoxActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        hide();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
     clear();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
     addPrograms();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
     deleteProgram();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
      updateProgram();
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
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgramFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JComboBox DeptComboBox;
    private javax.swing.JLabel DeptLabel;
    private javax.swing.JComboBox FacComboBox;
    private javax.swing.JLabel FacultyLabel;
    private javax.swing.JLabel FacultyyLabel;
    private javax.swing.JTextField ProgDurTextField;
    private javax.swing.JLabel ProgIdLabel;
    private javax.swing.JTextField ProgIdTextField;
    private javax.swing.JLabel ProgNameLabel;
    private javax.swing.JTextField ProgNameTextField;
    private javax.swing.JLabel ProgramLabel;
    private javax.swing.JLabel ProgramsLabel;
    private javax.swing.JList ProgramsList;
    private javax.swing.JTextArea RemarksTextArea;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
