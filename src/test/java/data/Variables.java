package data;

import org.testng.annotations.Test;
import pages.objects.Account;

public class Variables {
    @Test(groups="SIGNIN_PRE")
    public Account buildAccount() {
        String email = "minhhai.vu83@gmail.com";
        String password = "7B$viSRK$U!qqcj";
        String firstName = "Melody";
        String lastName = "Melody";

        return Account.builder().email(email).password(password)
                .firstName(firstName).lastName(lastName).build();
    }
}
