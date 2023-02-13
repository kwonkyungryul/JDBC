package db_lab;

import java.sql.Connection;

import db_lab.config.DBConfig;
import db_lab.model.Product;
import db_lab.model.ProductRepository;
import db_lab.service.ProductService;

public class DBApp {
    public static void main(String[] args) throws Exception {
        // 1. 커넥션 가져오기
        Connection conn = DBConfig.getConnection();

        // 2. DAO를 메모리에 올리기
        ProductRepository productRepository = new ProductRepository(conn);

        // 3. Service를 메모리에 올리기
        ProductService productService = new ProductService(productRepository, conn);
        Product product = productRepository.findById(1);
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQty());
        System.out.println(product.getCreatedAt());
        // productService.상품등록("apple", 2000, 5);

        conn.close();
    }
}
