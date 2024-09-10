package vm.techmaster.simple_module.entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken {
    private String accessToken;
    private Long userId;
}
