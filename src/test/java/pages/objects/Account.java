package pages.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Account {
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
