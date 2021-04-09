 
package Bean;

/**
 *
 * @author Isra Khan
 */
public class ProgramBean {
        private int deptId;
        private int progId;
        private String progName;
        private int durationInSem;
        private String remarks;
        
        
        public void setDeptId(int deptId){
                this.deptId=deptId;
        
        }
           public void setProgId(int progId){
                this.progId=progId;
           }
           public void setProgName(String progName){
                this.progName=progName;
           }
           public void setDurationInSem(int durationInSem){
                this.durationInSem=durationInSem;
                  
           }
            public void setRemarks (String remarks ){
                    this.remarks=remarks;
            
            }
             public int getDeptId(){
                return deptId;
        
        }
           public int getProgId(){
                return progId;
           }
           public String getProgName(){
                return progName;
           }
           public int getDurationInSem(){
                return durationInSem;
                  
           }
            public String getRemarks ( ){
                    return remarks;
            
            }
            
            
      public String toString(){
            return progName;
          }        
    
}