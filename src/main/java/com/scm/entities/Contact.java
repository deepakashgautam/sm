package com.scm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact {

    private  String name;
    @Id
    private String id;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 100)
    private String description;
    private boolean favorite = false;
    private String websiteLink;
    private String linkedIn;
    //private List<String> socialList = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SocialLink> links = new ArrayList<>();




}

