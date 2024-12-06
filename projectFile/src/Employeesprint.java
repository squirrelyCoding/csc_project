/* 
import java.io.Console;

//This is my code [Tristan Code]
public class Employeesprint extends employee implements supervisor
{
    
    public String getMemberInfo()
    {
        memberinfo = employeeinfo;

        return memberinfo;
    }

    public String getSupervisorInfo()
        {
            

            return supervisorinfo;
        }
    
    public void addFreeback()
    {
        String[] i = new String[]; 

    }

    public String getFreeback()
    {
        if(i = 0 || null;)
        {
            Console.println("There is no feeback.");
        }
        
    }

    public void viewData()
    {

    }

}
    ok this my updated code /and below is v 2.0 
*/

public class Employeesprint extends Employee implements Supervisor { 

    private String memberinfo; 
    private String employeeinfo; 
    private String supervisorinfo; 
    private String[] feedback; 
    public Employeesprint(String employeeinfo, String supervisorinfo)
     { 
        super(employeeinfo); // Calling super class constructor 
        this.employeeinfo = employeeinfo; 
        this.supervisorinfo = supervisorinfo;
      }
    public String getMemberInfo() 
     {
         memberinfo = employeeinfo; return memberinfo; 
     }
    public String getSupervisorInfo() 
     { 
         return supervisorinfo; 
     } 
    public void addFeedback(int size) 
     { 
        feedback = new String[size]; 
     } 
     //this a update i added on 11/25/2024 at 10am with some problems with the Json settings adding x: to the () so it took a while but i managed to remove it with the help of Copilot. 
     // which this marks v2.1. which has me learning about the Stringbuilder and adding it to following code.
    public String getFeedback() 
     { 
        if (feedback == null || feedback.length == 0) 
     { 
        System.out.println("their is no feedback"); 
        return null; 
    } 
    StringBuilder feedbackSummary = new StringBuilder(); 
    for (String fb : feedback) 
    { 
        feedbackSummary.append(fb).append("\n"); 
    } 
        return feedbackSummary.toString();
    } 
     public void viewData() 
     { 
        System.out.println("Member Info: " + getMemberInfo()); 
        System.out.println("Supervisor Info: " + getSupervisorInfo()); 
        System.out.println("Feedback:\n" + getFeedback()); 
     }  
     public static void main(String[] args) 
     {
        
     }
    }

