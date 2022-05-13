package More_JDBC;

public class Ex4 {
    // Step 1: Allocate a "Connection"
    Connection conn = DriverManager.getConnection(......);

    // Step 2: Allocate a "PreparedStatement" instead of "Statement"
    PreparedStatement pstmt = conn.prepareStatement(
            "insert into books values (?, ?, ?, ?, ?)");  // Five parameters 1 to 5

conn.setAutoCommit(false);  // Disable auto-commit for each SQL statement

pstmt.setInt(1, 8003);  // Set values for parameters 1 to 5
pstmt.setString(2, "Java 123");
pstmt.setString(3, "Kevin Jones");
pstmt.setDouble(4, 12.34);
pstmt.setInt(5, 88);
pstmt.addBatch();   // add the statement for batch processing

pstmt.setInt(1, 8004);  // Change values for parameters 1 and 2
pstmt.setString(2, "Java 456");
// No change in values for parameters 3 to 5
pstmt.addBatch();  // add the statement for batch processing

    int[] returnCodes = pstmt.executeBatch();
    // executeBatch() returns an int array, keeping the return codes of all statements

System.out.print("Return codes are: ");
for (int code : returnCodes) System.out.printf(code + ", ");
System.out.println();

conn.commit();
}
