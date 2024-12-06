import java.sql.*;
import java.util.Random;

public class App {
    public static String getInfo(String type) throws SQLException {
        String jdbcEmployeeUrl = "jdbc:sqlite:Employees.db";
        String employeeStr = "SELECT * FROM employees";
        Connection conn1 = DriverManager.getConnection(jdbcEmployeeUrl);
        Statement statement1 = conn1.createStatement();
        ResultSet Result1 = statement1.executeQuery(employeeStr);
        
        String jdbcEmpEXPUrl = "jdbc:sqlite:EmpEXP.db";
        String empEXPStr = "SELECT * FROM empEXP";
        Connection conn2 = DriverManager.getConnection(jdbcEmpEXPUrl);
        Statement statement2 = conn2.createStatement();
        ResultSet Result2 = statement2.executeQuery(empEXPStr);

        String answer = "";
        String search;
        int count = 1;
        while (Result1.next()) {
            Result2.next();
            // Display all of the DB data
            if (type.equals("Full")) {
                answer = answer + "Employee #" + count + " ID:"+ Result1.getString("id")
                    + " | Name:" + Result1.getString("name")
                    + " | Age:" + Result1.getString("age") + "\n";
                ++count;

            // Display specific DB data
            } else if (type.equals("ID")) {
                answer = answer + "Employee #" + count + " ID:"+ Result1.getString("id") + "\n";
            } else if (type.equals("Name")) {
                answer = answer + "Employee #" + count + " Name:" + Result1.getString("name") + "\n";
            } else if (type.equals("Age")) {
                answer = answer + "Employee #" + count + " Age:" + Result1.getString("age") + "\n";

            // Search query based on a specified Variables
            } else if (type.contains("S")) {
                search = type.replace("S", "");
                if (search.contains("ID:")) {
                    search = search.replace("ID: ", "");
                    if (search.equals("")) {
                        answer = "No ID given\n";
                    } else if (Result1.getString("id").contains(search)) {
                        answer = answer + "Employee #" + count + " ID:"+ Result1.getString("id")
                            + " | Name:" + Result1.getString("name")
                            + " | Age:" + Result1.getString("age") + "\n";
                        ++count;
                    }
                } else if (search.contains("Name:")) {
                    search = search.replace("Name: ", "");
                    if (search.equals("")) {
                        answer = "No Name given\n";
                    } else if (Result1.getString("name").contains(search)) {
                        answer = answer + "Employee #" + count + " ID:"+ Result1.getString("id")
                            + " | Name:" + Result1.getString("name")
                            + " | Age:" + Result1.getString("age") + "\n";
                        ++count;
                    }
                } else if (search.contains("Age:")) {
                    search = search.replace("Age: ", "");
                    if (search.equals("")) {
                        answer = "No Age given\n";
                    } else if (Result1.getString("age").contains(search)) {
                        answer = answer + "Employee #" + count + " ID:"+ Result1.getString("id")
                            + " | Name:" + Result1.getString("name")
                            + " | Age:" + Result1.getString("age") + "\n";
                        ++count;
                    }
                }
            }
        }
        if (answer.equals("")) {
            answer = "Couldn't find query (Make sure to enter \"ID: ___\", \"Name: ___\", or \"Age: ___\")\n";
        }
        return answer;
    }
    public static void saveInfo(String name, String age, String email, String phone, String date, String HS1, String HS2, String HS3, String SS1, String SS2, String SS3) throws SQLException {
        String jdbcEmployeeUrl = "jdbc:sqlite:Employees.db";
        String jdbcEmpEXPUrl = "jdbc:sqlite:EmpEXP.db";
        String jdbcSprintUrl = "jdbc:sqlite:SprintEval.db";
        String employeeStr = "SELECT * FROM employees";
        String rowCount = "SELECT COUNT(*) FROM employees";
        Connection conn = DriverManager.getConnection(jdbcEmployeeUrl);
        Statement statement = conn.createStatement();
        ResultSet Result = statement.executeQuery(rowCount);
        ResultSetMetaData RSMD;
        Random rand = new Random();
        int IssueID = 1 + rand.nextInt(10);
        Result.next();
        if (!(Result.getInt(1) >= 10)) {
            Result = statement.executeQuery(employeeStr);
            while (Result.next()) {
                while (Result.getInt("id") == IssueID) {
                    IssueID = 1 + rand.nextInt(10);
                    Result = statement.executeQuery(employeeStr);
                }
            }
            // Inserts info into first DB
            statement.executeUpdate("INSERT INTO employees(id, name, age, email, phoneNum, dateHired)" +
            " VALUES(" + IssueID + ", '" + name + "', '" + age + "', '" + email + "', '" + phone + "', '" + date + "');");
            // Inserts info into second DB
            conn = DriverManager.getConnection(jdbcEmpEXPUrl);
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO empEXP(id, hardSkill1, hardSkill2, hardSkill3, softSkill1, softSkill2, softSkill3)" + 
            " VALUES(" + IssueID + ", '" + HS1 + "', '" + HS2 + "', '" + HS3 + "', '" + SS1 + "', '" + SS2 + "', '" + SS3 + "');");
            // Inserts info into third DB
            conn = DriverManager.getConnection(jdbcSprintUrl);
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO sprintEval(id) VALUES(" + IssueID + ");");
        } else {
            System.out.println("DB Full");
        }
    }
    public static void editInfo(int ID, String Name, int Age) throws SQLException {
        String jdbcUrl = "jdbc:sqlite:Employees.db";
        Connection conn = DriverManager.getConnection(jdbcUrl);
        Statement statement = conn.createStatement();
        statement.executeUpdate("UPDATE employees SET name=" + Name + " WHERE id=" + ID);
        statement.executeUpdate("UPDATE employees SET age=" + Age + " WHERE id=" + ID);
    }
    public static void deleteInfo(int ID) throws SQLException {
        String jdbcUrl = "jdbc:sqlite:Employees.db";
        Connection conn = DriverManager.getConnection(jdbcUrl);
        Statement statement = conn.createStatement();
        statement.executeUpdate("DELETE FROM employees WHERE id=" + ID);
    }
    public static void main(String[] args) throws Exception {
        new MyFrame();
        new TitleFrame();
    }
}

// Note to self "!!USE FOR DB3 QUERY'S!!"
//             String sprintQuery = "INSERT INTO sprintEval(id";
//             Result = statement.executeQuery(sprintStr);
//             RSMD = Result.getMetaData();
//             for(tempInt = 1; tempInt < RSMD.getColumnCount(); ++tempInt) {
//                 sprintQuery = (sprintQuery + ", '" + tempInt);
//             }
//             Result = statement.executeQuery(sprintStr);
//             RSMD = Result.getMetaData();
//             sprintQuery = sprintQuery + "') VALUES(" + IssueID;
//             for(tempInt = 1; tempInt < RSMD.getColumnCount(); ++tempInt) {
//                 sprintQuery = (sprintQuery + ", NULL");
//             }
//             sprintQuery = (sprintQuery + ");");