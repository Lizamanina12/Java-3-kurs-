package by.manina.spring.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Data
public class UserE {
    public UserE(){

    }
    public UserE(String login , String password ,String email, RoleE roleEntity) {

        this.login = login;
        this.Email=email;
        this.password = password;
        this.roleEntity = roleEntity;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String login;

    @Column
    private String password;
    @Column
    private String Email ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private  RoleE roleEntity;
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public RoleE getRoleEntity() {
        return roleEntity;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setRoleE(RoleE roleEntity) {
        this.roleEntity = roleEntity;
    }


}

