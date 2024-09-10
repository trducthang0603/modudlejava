package vm.techmaster.simple_module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;                    // Matches `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT
    private String username;             // Matches `username` VARCHAR(60)
    private String email;                // Matches `email` VARCHAR(120)
    private String password;             // Matches `password` VARCHAR(60)
    private String displayName;          // Matches `display_name` VARCHAR(120), nullable
    private String status;               // Matches `status` VARCHAR(25)
    private Timestamp createdAt;     // Matches `created_at` DATETIME
    private Timestamp updatedAt;     // Matches `updated_at` DATETIME
}
