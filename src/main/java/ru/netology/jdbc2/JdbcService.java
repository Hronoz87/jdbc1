package ru.netology.jdbc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JdbcService {

    JdbcRepository jdbcRepository;

    @Autowired
    public JdbcService(JdbcRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    public String getProductName(String name) {
        return jdbcRepository.getProductName(name);
    }
}
