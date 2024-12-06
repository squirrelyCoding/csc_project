
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class Database {
//     // ...existing code...

//     public static void initialize() throws SQLException {
//         Connection conn = null;
//         Statement stmt = null;
//         try {
//             conn = getConnection();
//             stmt = conn.createStatement();
//             String sql = "CREATE TABLE IF NOT EXISTS employees (" +
//                          "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                          "name TEXT NOT NULL," +
//                          "date_hired TEXT NOT NULL," +
//                          "skill TEXT NOT NULL)";
//             stmt.executeUpdate(sql);
//         } finally {
//             if (stmt != null) stmt.close();
//             if (conn != null) conn.close();
//         }
//     }
//     // ...existing code...
// }