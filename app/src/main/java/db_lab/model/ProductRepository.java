/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package db_lab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private Connection conn;

    public ProductRepository(Connection conn) {
        this.conn = conn;
    }

    public Product findById(int id) throws Exception {
        Product product = null;

        // 2. 버퍼 접근
        String sql = "select * from product where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼

        // 3. 물음표 완성
        pstmt.setInt(1, id);

        // 4. 전송
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            int v1 = rs.getInt(id);
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int qty = rs.getInt("qty");
            Timestamp createdAt = rs.getTimestamp("created_at");

            product = new Product(id, name, price, qty, createdAt);
        }
        return product;
    }

    public List<Product> findAll() throws Exception {
        List<Product> productList = new ArrayList<>();

        // 2. 버퍼 접근
        String sql = "select * from product";
        PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼

        // 3. 전송
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int qty = rs.getInt("qty");
            Timestamp createdAt = rs.getTimestamp("created_at");

            Product product = new Product(id, name, price, qty, createdAt);
            productList.add(product);
        }
        return productList;
    }

    public void insert(String name, Integer price, Integer qty) throws SQLException {

        // 2. 버퍼 접근
        String sql = "insert into product(name, price, qty, created_at) values(?, ?, ?, now())"; // PreparedStatement는 '?' 를 지원해준다
        PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼

        // 3. 물음표 완성
        pstmt.setString(1, name); // 첫 번째 물음표에 값 세팅
        pstmt.setInt(2, price); // 두 번째 물음표에 값 세팅
        pstmt.setInt(3, qty); // 세 번째 물음표에 값 세팅

        // 4. 전송
        int result = pstmt.executeUpdate();

        // 5. 응답에 대한 처리
        if (result == 1) {
            System.out.println("insert 되었습니다.");
        } else {
            System.out.println("인서트 실패");
        }

        // 6. 최종 마무리
        pstmt.close();
    }

    public void deleteById(int id) throws SQLException {

        // 2. 버퍼 접근
        String sql = "delete from product where id = ?"; // PreparedStatement는 '?' 를 지원해준다
        PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼

        // 3. 물음표 완성
        pstmt.setInt(1, id); // 첫 번째 물음표에 값 세팅

        // 4. 전송
        int result = pstmt.executeUpdate();

        // 5. 응답에 대한 처리
        if (result == 1) {
            System.out.println("delete 되었습니다.");
        } else {
            System.out.println("delete 실패");
        }

        // 6. 최종 마무리
        pstmt.close();
    }

    public void updateById(int id, String name, int price, int qty) throws SQLException {

        // 2. 버퍼 접근
        String sql = "update product set name = ?, price = ?, qty = ? where id = ?"; // PreparedStatement는 '?' 를 지원해준다
        PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼

        // 3. 물음표 완성
        pstmt.setString(1, name);
        pstmt.setInt(2, price);
        pstmt.setInt(3, qty);
        pstmt.setInt(4, id);

        // 4. 전송
        int result = pstmt.executeUpdate();

        // 5. 응답에 대한 처리
        if (result == 1) {
            System.out.println("delete 되었습니다.");
        } else {
            System.out.println("delete 실패");
        }

        // 6. 최종 마무리
        pstmt.close();
    }
}
