package com.scm.entities;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "User")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

  @Id
  private String userId;

  @Column(name="user_name", nullable = false)
  private String name;

  @Column(unique = true, nullable = false)
  private String email;

  private String password;

  @Column(length = 100)
  private String about;

  @Lob
  private String profilePic;

  private String phoneNumber;

  //Information
    @Getter(value = AccessLevel.NONE)
    private boolean enabled = true ;

    private boolean  emailVarified =false;
    private boolean phoneVarified =false;

  //SELF,GOOGLE,FACEBOOK,TWITTER,LINKEDIN,GITHUB
  @Enumerated(value = EnumType.STRING)
  private Providers provider=Providers.SELF;
  private String providerUserId;

  // add more field if needed
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Contact> contacts = new ArrayList<>();


  @ElementCollection(fetch = FetchType.EAGER)
  private List<String> roleList = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    //List of role[USER, ADMIN]
    //Collection of SimpleGrantedAuthority [roles{ADMIN, USER}]
    Collection<SimpleGrantedAuthority> roles = roleList.stream()
            .map(role -> new SimpleGrantedAuthority(role))
            .collect(Collectors.toList());
    return roles;
  }

  @Override
  public boolean isEnabled() {
    return this.enabled;
  }

  //for this project:
  //email id will be the username.
  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public String getPassword() {
    return this.password;
  }


  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
}
