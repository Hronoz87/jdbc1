package ru.netology.jdbc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

    JdbcService jdbcService;

    @Autowired
    public JdbcController(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @GetMapping("/products/fetch-product")
    public String fetchProduct(@RequestParam("name") String name) {
        return jdbcService.getProductName(product_name);
    }
}
