package src;


public class Department {
    private String partId;
    private String partName;
    int currentNumberEmployees;

    // CONSTRUCTOR
    public Department() {
    }

    public Department(String partName, int currentNumberEmployees) {
        this.partName = partName;
        this.currentNumberEmployees = currentNumberEmployees;
        setDepartmentName(partName);
    }




    public void setDepartmentName(String partName){
        if(partName.equalsIgnoreCase("Business")){
            partId = "BPB";
        }
        if(partName.equalsIgnoreCase("Project")){
            partId = "BPP";
        }
        if(partName.equalsIgnoreCase("Technical")){
            partId = "BPT";
        }
    }

    // GETTER , SETTER
    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getCurrentNumberEmployees() {
        return currentNumberEmployees;
    }

    public void setCurrentNumberEmployees(int currentNumberEmployees) {
        this.currentNumberEmployees = currentNumberEmployees;
    }

    @Override
    public String toString() {
        
        return "\nPart id: " + partId + ", Part name: " + partName + ", Current number staff: " + currentNumberEmployees;
    }
    
    
    
        
}