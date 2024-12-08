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

    private String[] feedback; 
    public String viewSprint(int ID) throws SQLException
    { 
        // Setting up variables and such for SQL queries
        String jdbcEmpEXPUrl = "jdbc:sqlite:EmpEXP.db";
        String EmpEXPStr = "SELECT * FROM empExp";
        Connection conn1 = DriverManager.getConnection(jdbcEmpEXPUrl);
        Statement statement1 = conn1.createStatement();
        ResultSet Result1 = statement1.executeQuery(EmpEXPStr);

        String jdbcSprintEvalURL = "jdbc:sqlite:SprintEval.db";
        String SprintEvalStr = "SELECT * FROM sprintEval";
        Connection conn2 = DriverManager.getConnection(jdbcSprintEvalURL);
        Statement statement2 = conn2.createStatement();
        ResultSet Result2 = statement2.executeQuery(SprintEvalStr);

        int count = 0;
        int n;

        String Sprint = "";
        
            while (Result1.next()) {
                if (Result1.getInt("id") == ID) {
                    count = Result1.getInt("sprintCount");
                }
            }

            // Keep run-time high
            conn1.close();
            statement1.close();
            Result1.close();

            while (Result2.next()) {
                if (Result2.getInt("id") == ID) {
                    for (n = 1; count >= n; n++) {
                        Sprint = Sprint + Result2.getString("Sprint " + n) + "\n\n";
                    }
                }
            }
        return Sprint;
    }
    public void addSprint(String sprint, int ID) throws SQLException
    {
        // Setting up variables and such for SQL queries
        String jdbcEmpEXPUrl = "jdbc:sqlite:EmpEXP.db";
        String EmpEXPStr = "SELECT * FROM empExp";
        Connection conn1 = DriverManager.getConnection(jdbcEmpEXPUrl);
        Statement statement1 = conn1.createStatement();
        ResultSet Result1 = statement1.executeQuery(EmpEXPStr);

        String jdbcSprintEvalURL = "jdbc:sqlite:SprintEval.db";
        String SprintEStr = "SELECT * FROM sprintEval";
        Connection conn2 = DriverManager.getConnection(jdbcSprintEvalURL);
        Statement statement2 = conn2.createStatement();
        ResultSet Result2 = statement2.executeQuery(SprintEStr);
        ResultSetMetaData RSMD = Result2.getMetaData();
        int ColumnCount = RSMD.getColumnCount();

        // Keeps run-time high
        Result2.close();

        int sprintCount = 0;
        String query = ("ALTER TABLE sprintEval ADD Sprint " + ColumnCount + " TEXT DEFAULT 'NULL'");
        // Add's a new Collumn if it's needed in SprintEval.db
        while (Result1.next()) {
            if (Result1.getInt("id") == ID) {
                sprintCount = Result1.getInt("sprintCount");
            }
            if (sprintCount == (ColumnCount - 1)) {
                statement2.executeUpdate(query);
            }
        }

        // Keeps run-time high
        conn1.close();
        statement1.close();
        Result1.close();

        // Add's the new sprint into SprintEval.db
        statement2.executeUpdate("UPDATE employees SET " + (sprintCount + 1) + "=" + sprint + "WHERE id=" + ID);
        
        // Keeps run-time high
        conn2.close();
        statement2.close();
    }
    public void editSprint() throws SQLException
    {
        // Setting up variables and such for SQL queries
        String jdbcSprintEvalURL = "jdbc:sqlite:SprintEval.db";
        Connection conn = DriverManager.getConnection(jdbcSprintEvalURL);
        Statement statement = conn.createStatement();   
    }
    public void deleteSprint() throws SQLException
    {
        // Setting up variables and such for SQL queries
        String jdbcSprintEvalURL = "jdbc:sqlite:SprintEval.db";
        Connection conn = DriverManager.getConnection(jdbcSprintEvalURL);
        Statement statement = conn.createStatement(); 
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
    }

