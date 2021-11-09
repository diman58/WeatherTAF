package Utils;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfilePojo {
    private static String firstName = "DemoName";
    private static String lastName = "DemoLastName";
    private static String email = "market-nord1@mail.ru";

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getEmail() {
        return email;
    }

    public boolean equals(ProfilePojo obj) {
        return (this.firstName.equals(obj.firstName)
                &&(this.lastName.equals(obj.lastName))
                &&(this.email.equals(obj.email)));
    }

    public static ProfilePojo getProfile() {
        return new ProfilePojo();
    }
}
