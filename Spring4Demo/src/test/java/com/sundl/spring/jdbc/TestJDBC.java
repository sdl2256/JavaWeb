package com.sundl.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sun on 2015/5/10.
 */
public class TestJDBC {
    private ApplicationContext context = null;

    private JdbcTemplate jdbcTemplate;

    {
        context = new ClassPathXmlApplicationContext("applicationContext_jdbc.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }


    @Test
    public void testQueryForObjectResult() throws Exception {
        String sql = "SELECT count(*) from tb_person";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);

    }

    @Test
    public void testQueryForList() throws Exception {
        String sql = "SELECT id,birthday,file,gender,info,name name from tb_person WHERE id > ?";

        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper, 2);

        System.out.println(users);

    }

    @Test
    public void testQueryForObject() throws Exception {
        //使用列的别名映射类的属性名
        String sql = "SELECT id,birthday,file,gender,info,name name from tb_person WHERE id = ?";
        //不是这个方法
//        User user = jdbcTemplate.queryForObject(sql, User.class, 2);

        //而是这个方法
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, 2);


        System.out.println(user);

    }

    /**
     * 执行INSERT UPDATE DELETE
     *
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {
        String sql = "UPDATE tb_person SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, "Jack-孙", 1);

    }

    /**
     * 批量更新，INSERT UPDATE DELETE
     *
     * @throws Exception
     */

    @Test
    public void testBatchUpdate() throws Exception {
        String sql = "INSERT INTO tb_person(birthday,gender, info, name) VALUES(?,?,?,?)";
        List<Object[]> batcheArgs = new ArrayList<Object[]>();
        batcheArgs.add(new Object[]{new Date(), "MAN", "AA", "AAA"});
        batcheArgs.add(new Object[]{new Date(), "MAN", "BB", "bbb"});
        batcheArgs.add(new Object[]{new Date(), "WOMAN", "CC", "CCC"});
        jdbcTemplate.batchUpdate(sql, batcheArgs);

    }

    @Test
    public void testDataSource() throws Exception {
        DataSource dataSource = context.getBean(DataSource.class);

        System.out.println(dataSource.getConnection());

    }
}
