public class newMember {
    private String firstName;
    private String lastName;
    private String email;
    private String dateHired;
    private String hardSkills;
    private String softSkills;
    private int memberID;
    
    //constructor for new member
    public newMember(String firstName, String lastName, String email, String dateHired){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDateHired() {
        return dateHired;
    }

    public String getHardSkills() {
        return hardSkills;
    }

    public String getSoftSkills() {
        return softSkills;
    }

    public int getMemberID() {
        return memberID;
    }

    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    public void setHardSkills(String hardSkills) {
        this.hardSkills = hardSkills;
    }

    public void setSoftSkills(String softSkills) {
        this.softSkills = softSkills;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

}