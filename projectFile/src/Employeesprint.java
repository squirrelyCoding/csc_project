import java.sql.*;
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


public class Employeesprint { 

    private String memberinfo; 
  
    private String[] feedback; 
    public Employeesprint() throws SQLException
    { 
        String jdbcEmployeeUrl = "jdbc:sqlite:Employees.db";
        String employeeStr = "SELECT * FROM employees";
        Connection conn1 = DriverManager.getConnection(jdbcEmployeeUrl);
        Statement statement1 = conn1.createStatement();
        ResultSet Result1 = statement1.executeQuery(employeeStr);

        String jdbcSprintEvalURL = "jdbc:sqlite:SprintEval.db";
        String empEXPStr = "SELECT * FROM sprintEval";
        Connection conn2 = DriverManager.getConnection(jdbcSprintEvalURL);
        Statement statement2 = conn2.createStatement();
        ResultSet Result2 = statement2.executeQuery(empEXPStr);
        
    }
    
    public void addSprint(String sprint, int ID) throws SQLException
    {
        String jdbcEmpEXPURL = "jdbc:sqlite:EmpEXP.db";
        String empEXPStr = "SELECT * FROM empEXP";
        Connection conn1 = DriverManager.getConnection(jdbcEmpEXPURL);
        Statement statement1 = conn1.createStatement();
        ResultSet Result1 = statement1.executeQuery(empEXPStr);

        String jdbcSprintEvalURL = "jdbc:sqlite:SprintEval.db";
        String SprintESTR = "SELECT * FROM sprintEval";
        Connection conn2 = DriverManager.getConnection(jdbcSprintEvalURL);
        Statement statement2 = conn2.createStatement();
        ResultSet Result2 = statement2.executeQuery(SprintESTR);
        ResultSetMetaData RSMD = Result2.getMetaData();
        int ColumnCount = RSMD.getColumnCount();

        int sprintCount;

        while (Result1.next())
        {
            if (Result1.getString("id").equals(ID))
            {
                sprintCount = Result1.getInt("sprintCount");
            }
        }
        // if(ColumnCount) {}
     
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
        System.out.println("Feedback:\n" + getFeedback()); 
     }  
     public static void main(String[] args) 
     {
        
     }
    }

