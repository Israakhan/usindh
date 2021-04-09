
import Bean.BatchBean;
import Bean.DatabaseManager;
import Bean.DepartmentBean;
import Bean.FacultyBean;
import Bean.ProgramBean;
import Bean.StudentsBean;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isra Khan
 */
public class StudentsFrame extends javax.swing.JFrame {

    /**
     * Creates new form StudentsFrame
     */
    public StudentsFrame() {
        
          initComponents();
          java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
        
        getFaculty();
      
      
    }
    
    
      private void getFaculty(){
        try{
            java.util.Vector v=DatabaseManager.getFaculty();
            FacultyComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
               FacultyComboBox.addItem(v.elementAt(i));
                
                }
            
        }//try
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error:"+e.getMessage());
        }
    
    }
      
      private void getDepartments(){
 FacultyBean bean=(FacultyBean)FacultyComboBox.getSelectedItem();
 if(bean==null) return;
 try{
 java.util.Vector v=DatabaseManager.getDepartment(bean.getFacId());
 DepartmentComboBox.removeAllItems();
 for(int i=0; i<v.size(); i++){
     DepartmentComboBox.addItem(v.elementAt(i));
 }
 } catch(Exception e){e.printStackTrace();}
 
 }
      
      private void getPrograms(){
      DepartmentBean bean= (DepartmentBean)DepartmentComboBox.getSelectedItem();
        if(bean==null)return;
            try{
           java.util.Vector v=DatabaseManager.getProgram(bean.getDeptId());
           ProgComboBox.removeAllItems();
            for(int i=0; i<v.size(); i++){
            
            ProgComboBox.addItem(v.elementAt(i));
            }
            }catch(Exception e){
                    e.printStackTrace();
            }
      }
      
      private void getBatchYears(){
   ProgramBean bean=(ProgramBean) ProgComboBox.getSelectedItem();
    if(bean==null) return;
        try{
        java.util.Vector v=DatabaseManager.getBatch(bean.getProgId());
        BatchYearComboBox.removeAllItems();
        for(int i=0; i<v.size(); i++){
        BatchYearComboBox.addItem(v.elementAt(i));
        }
        
        }catch(Exception e){e.printStackTrace();}
   }//getbatchyears
    
      
      
      
        private void getStudents(){
   BatchBean bean=(BatchBean)BatchYearComboBox.getSelectedItem();
    if(bean==null) return;
    
    this.ShiftTextField.setText(bean.getShift());
    this.GroupTextField.setText(bean.getGroupDesc());
    
    
        try{
        java.util.Vector v=DatabaseManager.getStudent(bean.getBatchId());
        RollNoList.setListData(v);
        
        
        }catch(Exception e){e.printStackTrace();}
          }
        
        
    private void clear(){
 
     StdIdTextField.setText("");
     StdNameTextField.setText("");
     ShiftTextField.setText("");
     GroupTextField.setText("");
     RollnoTextField.setText("");
     FNameTextField.setText("");
     SurnameTextField.setText("");
     RemarksTextArea.setText("");
 
 }     
    
    private void addStudents(){
            BatchBean bean=(BatchBean)BatchYearComboBox.getSelectedItem();
            if(bean==null) return;
            String Name=StdNameTextField.getText();
            String Fname=FNameTextField.getText();
            String Surname=SurnameTextField.getText();
            String Rollno=RollnoTextField.getText();
            String Remarks=RemarksTextArea.getText();
            try{
            
            int rows=DatabaseManager.addStudent(bean.getBatchId(),Name,Fname,Surname,Rollno,Remarks);
            if(rows>=1){
                getStudents();
                clear();
                JOptionPane.showMessageDialog(this,rows+"Records Saved");
            }
            } catch(Exception e){
               JOptionPane.showMessageDialog(this,"ERROR"+e.getMessage()); 
                
            }
    }//method add students end here
    
    
    
    
            
            
    
    
    
    private void deleteStudent(){
       StudentsBean bean=(StudentsBean) RollNoList.getSelectedValue();
       if(bean==null)return;
        try{
            int rows=DatabaseManager.deleteStudent(bean.getStdId());
                if(rows>=1){
                getStudents();
                    clear();
                        JOptionPane.showMessageDialog(this,rows+"Records Deleted");
                }
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
    }//deleteStudents
            
    

        
    private void updateStudents(){
       StudentsBean bean=(StudentsBean) RollNoList.getSelectedValue();
       if(bean==null)return;
      
       String stdName=StdNameTextField.getText();
       String fatherName=FNameTextField.getText();
       String surname=SurnameTextField.getText();
       String rollNo=RollnoTextField.getText();
       String remarks=RemarksTextArea.getText();
       
        try{
            int rows=DatabaseManager.updateStudent(bean.getBatchId(),bean.getStdId(),stdName,fatherName,surname,rollNo,remarks);
                if(rows>=1){
                getStudents();
                    clear();
                        JOptionPane.showMessageDialog(this,rows+"Records Updated");
                }
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,e.getMessage());
                
                }
    }//updateStudents
      
      
      
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeptComboBox = new javax.swing.JComboBox();
        StudentsLabel = new javax.swing.JLabel();
        RollNoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RollNoList = new javax.swing.JList();
        FacultyComboBox = new javax.swing.JComboBox();
        StdIdLabel = new javax.swing.JLabel();
        DepartmentLabel = new javax.swing.JLabel();
        ProgComboBox = new javax.swing.JComboBox();
        ShiftLabel = new javax.swing.JLabel();
        GroupLabel = new javax.swing.JLabel();
        ShiftTextField = new javax.swing.JTextField();
        BatchYearLabel = new javax.swing.JLabel();
        ProgLabel = new javax.swing.JLabel();
        RollnoLabel = new javax.swing.JLabel();
        SurnameLabel = new javax.swing.JLabel();
        FacultyLabel = new javax.swing.JLabel();
        StdIdTextField = new javax.swing.JTextField();
        StdNameTextField = new javax.swing.JTextField();
        StdNameLabel = new javax.swing.JLabel();
        FatherNameLabel = new javax.swing.JLabel();
        FNameTextField = new javax.swing.JTextField();
        RollnoTextField = new javax.swing.JTextField();
        SurnameTextField = new javax.swing.JTextField();
        RemarksLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        RemarksTextArea = new javax.swing.JTextArea();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        GroupTextField = new javax.swing.JTextField();
        BatchYearComboBox = new javax.swing.JComboBox();
        DepartmentComboBox = new javax.swing.JComboBox();

        DeptComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DeptComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptComboBoxActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        StudentsLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        StudentsLabel.setText("Students");
        getContentPane().add(StudentsLabel);
        StudentsLabel.setBounds(180, 0, 162, 44);

        RollNoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RollNoLabel.setText("Roll NO");
        getContentPane().add(RollNoLabel);
        RollNoLabel.setBounds(497, 47, 51, 17);

        RollNoList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        RollNoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                RollNoListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(RollNoList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(500, 100, 90, 480);

        FacultyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        FacultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(FacultyComboBox);
        FacultyComboBox.setBounds(140, 70, 270, 30);

        StdIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        StdIdLabel.setText("Student ID");
        getContentPane().add(StdIdLabel);
        StdIdLabel.setBounds(40, 280, 77, 20);

        DepartmentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DepartmentLabel.setText("Department");
        getContentPane().add(DepartmentLabel);
        DepartmentLabel.setBounds(30, 110, 90, 50);

        ProgComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProgComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(ProgComboBox);
        ProgComboBox.setBounds(140, 170, 270, 30);

        ShiftLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ShiftLabel.setText("shift");
        getContentPane().add(ShiftLabel);
        ShiftLabel.setBounds(280, 210, 30, 17);

        GroupLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        GroupLabel.setText("Group");
        getContentPane().add(GroupLabel);
        GroupLabel.setBounds(350, 210, 43, 17);
        getContentPane().add(ShiftTextField);
        ShiftTextField.setBounds(250, 230, 70, 30);

        BatchYearLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BatchYearLabel.setText("Batch year");
        getContentPane().add(BatchYearLabel);
        BatchYearLabel.setBounds(40, 240, 74, 17);

        ProgLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ProgLabel.setText("Program");
        getContentPane().add(ProgLabel);
        ProgLabel.setBounds(50, 160, 90, 40);

        RollnoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RollnoLabel.setText("Rollno");
        getContentPane().add(RollnoLabel);
        RollnoLabel.setBounds(80, 430, 43, 40);

        SurnameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SurnameLabel.setText("Surname");
        getContentPane().add(SurnameLabel);
        SurnameLabel.setBounds(60, 400, 62, 17);

        FacultyLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FacultyLabel.setText("Faculty");
        getContentPane().add(FacultyLabel);
        FacultyLabel.setBounds(60, 60, 75, 29);
        getContentPane().add(StdIdTextField);
        StdIdTextField.setBounds(140, 280, 110, 30);

        StdNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StdNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(StdNameTextField);
        StdNameTextField.setBounds(140, 320, 270, 30);

        StdNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        StdNameLabel.setText("Student Name");
        getContentPane().add(StdNameLabel);
        StdNameLabel.setBounds(20, 320, 100, 17);

        FatherNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FatherNameLabel.setText("Father's Name");
        getContentPane().add(FatherNameLabel);
        FatherNameLabel.setBounds(20, 370, 100, 17);

        FNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(FNameTextField);
        FNameTextField.setBounds(140, 360, 270, 30);

        RollnoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RollnoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(RollnoTextField);
        RollnoTextField.setBounds(140, 440, 160, 30);
        getContentPane().add(SurnameTextField);
        SurnameTextField.setBounds(140, 400, 160, 30);

        RemarksLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RemarksLabel.setText("Remarks");
        getContentPane().add(RemarksLabel);
        RemarksLabel.setBounds(140, 480, 60, 17);

        RemarksTextArea.setColumns(20);
        RemarksTextArea.setRows(5);
        jScrollPane2.setViewportView(RemarksTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(140, 510, 340, 70);

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AddButton);
        AddButton.setBounds(140, 590, 60, 30);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteButton);
        DeleteButton.setBounds(210, 590, 70, 30);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateButton);
        UpdateButton.setBounds(290, 590, 80, 30);

        ClearButton.setText("clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ClearButton);
        ClearButton.setBounds(380, 590, 100, 30);

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(490, 590, 90, 30);
        getContentPane().add(GroupTextField);
        GroupTextField.setBounds(340, 230, 70, 30);

        BatchYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BatchYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatchYearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(BatchYearComboBox);
        BatchYearComboBox.setBounds(140, 230, 100, 30);

        DepartmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DepartmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(DepartmentComboBox);
        DepartmentComboBox.setBounds(140, 120, 260, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeptComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptComboBoxActionPerformed
       
     
    }//GEN-LAST:event_DeptComboBoxActionPerformed

    private void StdNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StdNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StdNameTextFieldActionPerformed

    private void FNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FNameTextFieldActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        addStudents();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void RollnoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RollnoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RollnoTextFieldActionPerformed

    private void RollNoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_RollNoListValueChanged
    StudentsBean bean=(StudentsBean)RollNoList.getSelectedValue();
    
    if(bean==null) return;
        StdIdTextField.setText(""+bean.getStdId());
        StdNameTextField.setText(bean.getStdName());
      
        RollnoTextField.setText(bean.getRollNo());
        FNameTextField.setText(bean.getFName());
        SurnameTextField.setText(bean.getSurname());
        RemarksTextArea.setText(bean.getRemarks());
        
        
    
    }//GEN-LAST:event_RollNoListValueChanged

    private void FacultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultyComboBoxActionPerformed
       getDepartments();
        
    }//GEN-LAST:event_FacultyComboBoxActionPerformed

    private void BatchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatchYearComboBoxActionPerformed
       getStudents();
    }//GEN-LAST:event_BatchYearComboBoxActionPerformed

    private void ProgComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgComboBoxActionPerformed
        getBatchYears();
    }//GEN-LAST:event_ProgComboBoxActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
     hide();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        clear();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       deleteStudent();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
       updateStudents();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DepartmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentComboBoxActionPerformed
       getPrograms();
    }//GEN-LAST:event_DepartmentComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(StudentsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentsFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox BatchYearComboBox;
    private javax.swing.JLabel BatchYearLabel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JComboBox DepartmentComboBox;
    private javax.swing.JLabel DepartmentLabel;
    private javax.swing.JComboBox DeptComboBox;
    private javax.swing.JTextField FNameTextField;
    private javax.swing.JComboBox FacultyComboBox;
    private javax.swing.JLabel FacultyLabel;
    private javax.swing.JLabel FatherNameLabel;
    private javax.swing.JLabel GroupLabel;
    private javax.swing.JTextField GroupTextField;
    private javax.swing.JComboBox ProgComboBox;
    private javax.swing.JLabel ProgLabel;
    private javax.swing.JLabel RemarksLabel;
    private javax.swing.JTextArea RemarksTextArea;
    private javax.swing.JLabel RollNoLabel;
    private javax.swing.JList RollNoList;
    private javax.swing.JLabel RollnoLabel;
    private javax.swing.JTextField RollnoTextField;
    private javax.swing.JLabel ShiftLabel;
    private javax.swing.JTextField ShiftTextField;
    private javax.swing.JLabel StdIdLabel;
    private javax.swing.JTextField StdIdTextField;
    private javax.swing.JLabel StdNameLabel;
    private javax.swing.JTextField StdNameTextField;
    private javax.swing.JLabel StudentsLabel;
    private javax.swing.JLabel SurnameLabel;
    private javax.swing.JTextField SurnameTextField;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
