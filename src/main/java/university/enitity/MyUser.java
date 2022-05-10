package university.enitity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString

public class MyUser implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    @Column(name = "enable", nullable = false)
    private boolean enabled;

    @Column(nullable = false)
    private String fullName;


    @OneToOne(cascade = CascadeType.ALL)
    private ContactDetails contactDetails;


    @Column(unique = true)
    private String email;

    @Column
    private String randomToken;

    @Transient
    private String randomTokenEmail;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles = new HashSet<>();


    @OneToMany(mappedBy = "user")
    private Set<Faculty> faculties;

    @Transient
    private String passwordConfirm;

    public MyUser(MyUser user) {                      //constructor de copiere
        this.enabled = user.isEnabled();
        this.contactDetails = user.getContactDetails();
        this.roles = user.getRoles();
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.id = user.getId();
        this.accountNonExpired = user.isAccountNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.faculties = user.getFaculties();
        this.email = user.getEmail();
    }

    public MyUser(String username, String password, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, String fullName, ContactDetails contactDetails, String email, Set<Role> roles, Set<Faculty> faculties, String passwordConfirm) {
    }


    public Long getId() {
        return id;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());
    }


}
