import java.sql.*;
import java.util.Random;

public class App {
    public static String getInfo(String type) throws SQLException {
        String queryStr = "SELECT * FROM employees";
        String jdbcUrl = "jdbc:sqlite:Employees.db";
        Connection conn = DriverManager.getConnection(jdbcUrl);
        Statement statement = conn.createStatement();
        ResultSet Result = statement.executeQuery(queryStr);
        String answer = "";
        String search;
        int count = 1;
        while (Result.next()) {

            // Display all of the DB data
            if (type.equals("Full")) {
                answer = answer + "Employee #" + count + " ID:<"+ Result.getString("id")
                    + "> | Name:<" + Result.getString("name")
                    + "> | Age:<" + Result.getString("age") + ">\n";
                ++count;

            // Display specific DB data
            } else if (type.equals("ID")) {
                answer = answer + "Employee #" + count + " ID:<"+ Result.getString("id") + ">\n";
            } else if (type.equals("Name")) {
                answer = answer + "Employee #" + count + " Name:<" + Result.getString("name") + ">\n";
            } else if (type.equals("Age")) {
                answer = answer + "Employee #" + count + " Age:<" + Result.getString("age") + ">\n";

            // Search query based on a specified Variables
            } else if (type.contains("S")) {
                search = type.replace("S", "");
                if (search.contains("ID:")) {
                    search = search.replace("ID: ", "");
                    if (search.equals("")) {
                        answer = "No ID given\n";
                    } else if (Result.getString("id").contains(search)) {
                        answer = answer + "Employee #" + count + " ID:<"+ Result.getString("id")
                            + "> | Name:<" + Result.getString("name")
                            + "> | Age:<" + Result.getString("age") + ">\n";
                        ++count;
                    }
                } else if (search.contains("Name:")) {
                    search = search.replace("Name: ", "");
                    if (search.equals("")) {
                        answer = "No Name given\n";
                    } else if (Result.getString("name").contains(search)) {
                        answer = answer + "Employee #" + count + " ID:<"+ Result.getString("id")
                            + "> | Name:<" + Result.getString("name")
                            + "> | Age:<" + Result.getString("age") + ">\n";
                        ++count;
                    }
                } else if (search.contains("Age:")) {
                    search = search.replace("Age: ", "");
                    if (search.equals("")) {
                        answer = "No Age given\n";
                    } else if (Result.getString("age").contains(search)) {
                        answer = answer + "Employee #" + count + " ID:<"+ Result.getString("id")
                            + "> | Name:<" + Result.getString("name")
                            + "> | Age:<" + Result.getString("age") + ">\n";
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
    public static void saveEmployee(String name, String dateHired, String skills) throws SQLException {
        int IssueID = 0;
        boolean taken = false;
        String queryStr = "SELECT * FROM employees";
        String jdbcUrl = "jdbc:sqlite:Employees.db";
        Connection conn = DriverManager.getConnection(jdbcUrl);
        Statement statement = conn.createStatement();
        ResultSet Result;
        Random rand = new Random();
        IssueID = 1 + rand.nextInt(9999);
        while(taken) {
            IssueID = 1 + rand.nextInt(9999);
            Result = statement.executeQuery(queryStr);
            taken = false;
            while (Result.next()) {
                if (Result.getInt("id") == IssueID) {
                    taken = true;
                }
            }
        }
        statement.executeUpdate("INSERT INTO employees(id, name, age) VALUES(" + IssueID + ", '" + name + "', " + (19 + rand.nextInt(42)) + ");");
    }
    public static void main(String[] args) throws Exception {
        new MyFrame();
    }
}