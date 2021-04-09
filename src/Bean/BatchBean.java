/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Isra Khan
 */
public class BatchBean {
        private int progId;
        private int batchId;
        private int batchYear;
        private String shift;
        private String groupDesc;
        private String remarks;
        
        
        public void setProgId(int progId){
                this.progId=progId;
        
        }
        public void setBatchId(int batchId){
        this.batchId=batchId;
        
        }
        public void setBatchYear(int batchYear){
            this.batchYear=batchYear;
        
        }
        public void setShift(String shift){
            this.shift=shift;
            
        }
        
        public void setGroupDesc(String groupDesc){
            this.groupDesc=groupDesc;
        
        }
        public void setRemarks(String remarks ){
            this.remarks=remarks;
        
        }
        
        public int  getProgId(){
                return progId;
               
        }
        public int  getBatchId(){
            return batchId;
        }
        public int getBatchYear(){
                return batchYear;
        
        }
        public String getShift(){
                return shift;
        }
        
        public String getGroupDesc(){
            
           return groupDesc;
        }
        public String getRemarks(){
        return remarks;
        
        }
        public String  toString(){
                return ""+batchYear;
}
       
}