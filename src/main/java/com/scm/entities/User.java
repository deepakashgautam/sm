package com.scm.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

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
    private boolean enabled=false;
    private boolean emailVarified=false;
    private boolean phoneVarified=false;

  //SELF,GOOGLE,FACEBOOK,TWITTER,LINKEDIN,GITHUB
  private Providers provider=Providers.SELF;
  private String providerUserId;

  // add more field if needed
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Contact> contacts = new ArrayList<>();



}
