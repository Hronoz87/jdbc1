package ru.netology.jdbc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class JdbcRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String joinJdbc = read();

    private static String read() {
        try (InputStream is = new ClassPathResource("join.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        StringBuilder sb = new StringBuilder();
        SqlParameterSource namedParameters = new MapSqlParameterSource("name", "%" + name + "%");
        String joinJdbc = read();
        SqlRowSet obj = namedParameterJdbcTemplate.queryForRowSet(joinJdbc, namedParameters);

        while (obj.next()) {
            sb.append(obj.getString("product_name"));
            sb.append(";");
        }
        return sb.toString();
    }

}
