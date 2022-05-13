package More_JDBC;

public class Ex3 {
    // Step 3 & 4: Execute query and Process the query result
conn.setAutoCommit(false);  // Turn off auto-commit for each SQL statement

stmt.addBatch("insert into books values (8001, 'Java ABC', 'Kevin Jones', 1.1, 99)");
stmt.addBatch("insert into books values (8002, 'Java XYZ', 'Kevin Jones', 1.1, 99)");
stmt.addBatch("update books set price = 11.11 where id=8001 or id=8002");
    int[] returnCodes = stmt.executeBatch();

System.out.print("Return codes are: ");
for (int code : returnCodes) {
        System.out.printf(code + ", ");
    }
System.out.println();

conn.commit();  // Commit SQL statements
}
