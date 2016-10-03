package org.webonise.springcollectionassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class DataFetcher {
    private static final String sql = "SELECT * From Users;";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Users> queryUsersList() {
        List<Users> usersList = jdbcTemplate.query(sql, new UserRowMapper());
        return usersList;
    }

    public Map<Integer, Users> queryUsersMap() {
        List<Users> userslist = jdbcTemplate.query(sql, new UserRowMapper());
        Map<Integer, Users> usersMap = new HashMap<Integer, Users>();
        for (Users user : userslist) {
            usersMap.put(user.getId(), user);
        }
        return usersMap;
    }

    public Set<Users> queryUsersSet() {
        List<Users> usersList = jdbcTemplate.query(sql, new UserRowMapper());
        Set<Users> usersSet = new HashSet<Users>();
        for (Users user : usersList) {
            usersSet.add(user);
        }
        return usersSet;
    }
}
