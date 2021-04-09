/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Isra Khan
 */
public class StudentsBean {
        private int batchId;
        private int stdId;
        private String stdName;
        private String fName;
        private String surname;
        private String rollNo;
        private String remarks;
        private String shift; 
        private int batchYear;
        private String groupDesc;
                
        public void setBatchId(int batchId){
                this.batchId=batchId;
        
        }
        public void setStdId(int stdId){
        this.stdId=stdId;
        
        }
        public void setStdName(String stdName){
            this.stdName=stdName;
        
        }
        
            public void setFName(String fName ){
            this.fName=fName;
            
            
            }
            public void setSurname(String surname){
                this.surname=surname;
            
            }
            
            public void setRollNo(String rollNo){
            this.rollNo=rollNo;
            
            }
            
            public void setRemarks(String remarks){
                this.remarks=remarks;
            
            }
            
           
            
            
               public int getBatchId(){
                return batchId;
        
        }
        public int getStdId(){
            return stdId;
        
        }
        public String getStdName(){
            return stdName;
        
        }
        
            public String getFName( ){
            return fName;
            
            }
            public String getSurname(){
                return surname;
            
            }
            
            public String getRollNo(){
            return rollNo;
            
            }
            
            public String getRemarks(){
                return remarks;
            
            }
           
           
           public String toString(){
           return rollNo;
           
           }         
        
    
}