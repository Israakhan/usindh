
import Bean.DatabaseManager;
import Bean.DepartmentBean;
import Bean.FacultyBean;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isra Khan
 */
public class DepartmentFrame extends javax.swing.JFrame {

    /**
     * Creates new form DepartmentFrame
     */
    public DepartmentFrame() {
        initComponents();
        
            java.awt.Toolkit kit=this.getToolkit();
            java.awt.Dimension d=kit.getScreenSize();
            this.setBounds(0,0,d.width,d.height);
            getFaculty();
            DeptIdTextField.setEditable(false);
                    
          
        
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
this.DepartmentsList.setListData(v); 
 } catch(Exception e){e.printStackTrace();}
 
 }
 
 private void clear(){
 
     DeptIdTextField.setText("");
     DeptNameTextField.setText("");
     RemarksTextArea.setText("");
 
 }

   private void addDepartment(){
           FacultyBean bean=(FacultyBean)FacComboBox.getSelectedItem();
            if(bean==null) return;
            String DeptName=DeptNameTextField.getText();
            String Remarks=RemarksTextArea.getText();
            try{
            
            int rows=DatabaseManager.addDepartment(bean.getFacId(),DeptName,Remarks);
            if(rows>=1){
                getDepartments();
                clear();
                JOptionPane.showMessageDialog(this,rows+"Records Saved");
            }
            } catch(Exception e){
               JOptionPane.showMessageDialog(this,"ERROR"+e.getMessage()); 
                
            }
    }//method add students end here
   

 
     
     
          private void deleteDept(){
   
       DepartmentBean bean=(DepartmentBean) DepartmentsList.getSelectedValue();
       if(bean==null)return;
        try{
            int rows=DatabaseManager.deleteDepartment(bean.getDeptId());
                if(rows>=1){
                getDepartments();
                    clear();
                        JOptionPane.showMessageDialog(this,rows+"Records Deleted");
                }
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
            
        }//Department delete
          
          private void updateDepartment(){
               DepartmentBean bean=(DepartmentBean) DepartmentsList.getSelectedValue();
           
         
                if(bean==null) return;
            String DeptName=DeptNameTextField.getText();
            String Remarks=RemarksTextArea.getText();
            try{
            
            int rows=DatabaseManager.updateDepartment(bean.getFacId(),bean.getDeptId(),DeptName,Remarks);
            if(rows>=1){
                getDepartments();
                clear();
                JOptionPane.showMessageDialog(this,rows+"Records Updated");
            }
            } catch(Exception e){
               JOptionPane.showMessageDialog(this,"ERROR"+e.getMessage()); 
                
            }
          }//class
              
                
             
          
          
          
     
   
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeptLabel = new javax.swing.JLabel();
        DeptsLabel = new javax.swing.JLabel();
        FacultyLabel = new javax.swing.JLabel();
        DeptIdTextField = new javax.swing.JTextField();
        DeptNameTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        RemarksTextArea = new javax.swing.JTextArea();
        DeptIdLabel = new javax.swing.JLabel();
        DeptNameLabel = new javax.swing.JLabel();
        RemarksLabel = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        DepartmentsList = new javax.swing.JList();
        FacComboBox = new javax.swing.JComboBox();

        getContentPane().setLayout(null);

        DeptLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        DeptLabel.setText("Department");
        getContentPane().add(DeptLabel);
        DeptLabel.setBounds(160, 20, 217, 37);

        DeptsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeptsLabel.setText("Departments");
        getContentPane().add(DeptsLabel);
        DeptsLabel.setBounds(490, 90, 90, 40);

        FacultyLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FacultyLabel.setText("Faculty");
        getContentPane().add(FacultyLabel);
        FacultyLabel.setBounds(70, 110, 75, 30);
        getContentPane().add(DeptIdTextField);
        DeptIdTextField.setBounds(140, 180, 140, 30);

        DeptNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(DeptNameTextField);
        DeptNameTextField.setBounds(140, 250, 310, 30);

        RemarksTextArea.setColumns(20);
        RemarksTextArea.setRows(5);
        jScrollPane2.setViewportView(RemarksTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(129, 335, 320, 110);

        DeptIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeptIdLabel.setText("Department ID");
        getContentPane().add(DeptIdLabel);
        DeptIdLabel.setBounds(20, 180, 104, 20);

        DeptNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeptNameLabel.setText("Department Name");
        getContentPane().add(DeptNameLabel);
        DeptNameLabel.setBounds(0, 250, 127, 20);

        RemarksLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RemarksLabel.setText("Remarks");
        getContentPane().add(RemarksLabel);
        RemarksLabel.setBounds(130, 300, 60, 30);

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AddButton);
        AddButton.setBounds(100, 460, 80, 30);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteButton);
        DeleteButton.setBounds(200, 460, 70, 30);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateButton);
        UpdateButton.setBounds(280, 460, 80, 30);

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ClearButton);
        ClearButton.setBounds(370, 460, 80, 30);

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(470, 460, 130, 30);

        DepartmentsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        DepartmentsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                DepartmentsListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(DepartmentsList);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(470, 140, 130, 306);

        FacComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        FacComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(FacComboBox);
        FacComboBox.setBounds(140, 110, 310, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void DeptNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeptNameTextFieldActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       deleteDept();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void DepartmentsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DepartmentsListValueChanged
       
        DepartmentBean bean=(DepartmentBean)DepartmentsList.getSelectedValue();
    
   if(bean==null) return;
        DeptIdTextField.setText(""+bean.getDeptId());
        DeptNameTextField.setText(bean.getDeptName());
        RemarksTextArea.setText(bean.getRemarks());
    
    }//GEN-LAST:event_DepartmentsListValueChanged

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
        addDepartment();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
      updateDepartment();
    }//GEN-LAST:event_UpdateButtonActionPerformed
  public static void main(String args[]) {
                new DepartmentFrame().setVisible(true);
         }
        
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JList DepartmentsList;
    private javax.swing.JLabel DeptIdLabel;
    private javax.swing.JTextField DeptIdTextField;
    private javax.swing.JLabel DeptLabel;
    private javax.swing.JLabel DeptNameLabel;
    private javax.swing.JTextField DeptNameTextField;
    private javax.swing.JLabel DeptsLabel;
    private javax.swing.JComboBox FacComboBox;
    private javax.swing.JLabel FacultyLabel;
    private javax.swing.JLabel RemarksLabel;
    private javax.swing.JTextArea RemarksTextArea;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
