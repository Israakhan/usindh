/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Isra Khan
 */
import java.sql.*;
import java.util.*;
public class DatabaseManager {
    
    private static Connection con;
    static{ try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con=DriverManager.getConnection("jdbc:odbc:Usindh");
    }catch(Exception e){
             e.printStackTrace();
         }//catch
        
    }//static
   public static Vector getFaculty()throws Exception {
       String query="Select Fac_id,Fac_name,remarks from Faculty" ;
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                    FacultyBean bean=new FacultyBean();
                    bean.setFacId(result.getInt("Fac_id"));
                    bean.setFacName(result.getString("Fac_name"));
                    bean.setRemarks(result.getString("remarks"));
                    v.addElement(bean);
            }//while
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
        }//end method
   
  
     public static Vector getDepartment(int facId)throws Exception {
       String query="Select * from Department where Fac_id="+facId;
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                    DepartmentBean bean=new DepartmentBean();
                    bean.setDeptId(result.getInt("Dept_id"));
                    bean.setFacId(result.getInt("Fac_id"));
                    bean.setDeptName(result.getString("Dept_name"));
                    bean.setRemarks(result.getString("remarks"));
                     v.addElement(bean);
            }//while
            
           
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
        
        
        
        
        
        
        }//end method
     
     
     
       public static Vector getProgram(int deptId)throws Exception {
       String query="Select * from Program where Dept_id="+deptId;
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                    ProgramBean bean=new ProgramBean();
                    bean.setProgId(result.getInt("Prog_id"));
                    bean.setDeptId(result.getInt("Dept_id"));
                    bean.setProgName(result.getString("Prog_name"));
                    bean.setDurationInSem(result.getInt("Duration_in_sem"));
                    bean.setRemarks(result.getString("remarks"));
                    v.addElement(bean);
                    
            }//while
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
        }//end method
   
     public static Vector getBatch(int progId)throws Exception {
       String query="Select * from Batch where Prog_id="+progId;
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                    BatchBean bean=new BatchBean();
                    bean.setBatchId(result.getInt("Batch_id"));
                    bean.setProgId(result.getInt("Prog_id"));
                    bean.setBatchYear(result.getInt("Batch_year"));
                    bean.setShift(result.getString("shift"));
                    bean.setGroupDesc(result.getString("Group_desc"));
                    bean.setRemarks(result.getString("remarks"));
                    v.addElement(bean);
            }//while
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
        }//end method
     
       public static Vector getStudent(int batchId)throws Exception {
       String query="Select * from Students where Batch_id="+batchId;
        System.out.println(query);
        Statement st=null;
        ResultSet result=null;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v=new Vector();
            while(result.next()){
                    StudentsBean bean=new StudentsBean();
                        bean.setStdId(result.getInt("Std_id"));
                        
                          bean.setBatchId(result.getInt("Batch_id"));
                          bean.setStdName(result.getString("Std_name"));
                          bean.setFName(result.getString("fname"));
                          bean.setSurname(result.getString("surname"));
                          
                           bean.setRollNo(result.getString("rollno"));
                             
                          bean.setRemarks(result.getString("remarks"));
             
                    v.addElement(bean);
            }//while
            return v;
            }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
               
        }//finally
        }//end method
       
       public static int deletefaculty(int facId) throws Exception{
           String query="Delete from faculty where Fac_id="+facId;
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
       
       
           public static int deleteDepartment(int deptId) throws Exception{
           String query="Delete from Department where Dept_id="+deptId;
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
       
       
           
            public static int deleteProgram(int progId ) throws Exception{
           String query="Delete from Program where Prog_id="+progId;
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
            
        
          public static int deleteStudent (int stdId ) throws Exception{
           String query="Delete from Students where Std_id="+stdId ;
                  
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
    public static int deleteBatch (int batchId ) throws Exception{
           String query="Delete from Batch where Batch_id="+batchId ;
                  
           System.out.println(query);
           Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
       
       
       }
    
    
    public static int addFaculty(String facName,String remarks) throws Exception{

        String query="Insert into Faculty(Fac_name,remarks)Values('"+facName+"','"+remarks+"')";
                    System.out.println(query);
                        
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
    
    
      public static int addDepartment(int facId,String deptName,String remarks) throws Exception{
        
            String query="Insert into Department(Fac_id,Dept_name,remarks)Values('"+facId+"','"+deptName+"','"+remarks+"')";
                    
                    
                    System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
      }
           
             public static int addProgram(int deptId,String progName,String durationInSem,String remarks) throws Exception{
        
            String query="Insert into Program(Dept_id,Prog_name,Duration_in_sem,remarks)Values('"+deptId+"','"+progName+"','"+durationInSem+"','"+remarks+"')";
                    System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
    
    
      
      public static int addBatch(int progId, String batchYear,String remarks) throws Exception{
        
            String query="Insert into Batch(Prog_id,Batch_year,remarks)values('" +progId+"','"+batchYear+"','"+remarks+"')";
                    System.out.println(query);
                    
                       Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
           
            public static int addStudent(int batchId,String stdName, String fName,String surname,String rollNo,String remarks) throws Exception{
        
            String query="Insert into Students(Batch_id,Std_name,fname,surname,rollno) Values ('"+batchId+"','"+stdName+"','"+fName+"','"+surname+"','"+rollNo+"')";
             System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
       
      
      public static int updateFaculty(int facId,String facName,String remarks) throws Exception{
          String query="update Faculty Set Fac_name='"+facName+"',remarks='"+remarks+"'where Fac_id="+facId;
      
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
       
      
      public static int updateDepartment(int facId,int deptId,String deptName,String remarks) throws Exception{
                
      
          String query="update Department set Fac_id="+facId+",Dept_name='"+deptName+"',remarks='"+remarks+"' where Dept_id="+deptId; 
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
         
                    
      public static int updateProgram(int deptId,int progId,String progName,String progDur,String remarks) throws Exception{
          String query="update Program Set Dept_id="+deptId +",Prog_name='"+progName+"',Duration_in_sem='"+progDur+"',remarks='"+remarks+"'where prog_id="+progId;
      
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
      
            public static int updateBatch(int progId,int batchId, int batchYear,String remarks) throws Exception{
                    String query="update Batch Set Prog_id="+progId +",Batch_year="+batchYear+",remarks='"+remarks+"' where Batch_id="+batchId;

      
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }
        
      
                 public static int updateStudent(int batchId,int stdId,String stdName,String surname ,String rollNo ,String fName,String remarks) throws Exception{
          String query = "update Students Set Batch_id="+batchId+",Std_name='"+stdName+"',surname='"+surname+"',rollno='"+rollNo+"',fname='"+fName+"',remarks='"+remarks+"'where Std_id="+stdId;
          
                  
          

      
          
                      System.out.println(query);
                    
                        Statement st=null;
           try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
                    
           }
           finally{
               if(st!=null) st.close();
           }
    }

   
        
        
      
    

}//class
