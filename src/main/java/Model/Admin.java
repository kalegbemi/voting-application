package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin_table")
@Data

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int adminId;
    private String username;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

}
