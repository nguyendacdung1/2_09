package More_JDBC;

public class Ex1 {
    // Step 3 & 4:Thực hiện truy vấn và xử lý kết quả truy vấn
    //Vô hiệu hóa tự động cam kết cho kết nối, cam kết mọi câu lệnh SQL.
    conn.setAutoCommit(false);

    // Trước khi thay đổi
    ResultSet rset = stmt.executeQuery("chọn id, qty từ sách nơi id trong (1001, 1002)");
System.out.println("-- Trước khi CẬP NHẬT --");
while(rset.next()) {
        System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
    }
conn.commit();     // Commit SELECT

// Phát hành hai tuyên bố CẬP NHẬT thông qua executeUpdate()
stmt.executeUpdate("update books set qty = qty + 1 where id = 1001");
stmt.executeUpdate("update books set qty = qty + 1 where id = 1002");
conn.commit();     // Commit UPDATEs

    rset = stmt.executeQuery("select id, qty from books where id in (1001, 1002)");
System.out.println("-- After UPDATE and Commit --");
while(rset.next()) {
        System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
    }
conn.commit();     // Commit SELECT

// Issue two UPDATE statements thru executeUpdate()
stmt.executeUpdate("update books set qty = qty - 99 where id = 1001");
stmt.executeUpdate("update books set qty = qty - 99 where id = 1002");
conn.rollback();   // Discard all changes since the last commit

    rset = stmt.executeQuery("select id, qty from books where id in (1001, 1002)");
System.out.println("-- After UPDATE and Rollback --");
while(rset.next()) {
        System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
    }
conn.commit();     // Commit SELECT
}
