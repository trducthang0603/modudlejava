package vm.techmaster.simple_module.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vm.techmaster.simple_module.entity.User;
import vm.techmaster.simple_module.entity.UserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId((long) rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setDisplayName(rs.getString("display_name"));
        user.setStatus((rs.getString("status")));
        user.setCreatedAt(
                rs.getTimestamp("updated_at")
        );
        user.setCreatedAt(
                rs.getTimestamp("created_at")
        );
        return user;
    }
}