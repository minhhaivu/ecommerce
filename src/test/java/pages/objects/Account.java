package pages.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
