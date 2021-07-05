package com.xu.c3p0;

import com.xu.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void update(User user) {
        String sql = "update user set username=?,password=? where id=?";
        Object[] args = {user.getUsername(), user.getPassword(), user.getId()};
        jdbcTemplate.update(sql, args);
    }
}
