package axiomq.com.starwars.entities;

import lombok.Data;

import java.util.Objects;

@Data
public class Users {

    private enum UserType{
        USERS, ADMINS
    }

    private Long userId;
    private UserType userType;
    private String email;
    private String password;
    private String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userId, users.userId) &&
                userType == users.userType &&
                Objects.equals(email, users.email) &&
                Objects.equals(password, users.password) &&
                Objects.equals(username, users.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userType, email, password, username);
    }

    
}
