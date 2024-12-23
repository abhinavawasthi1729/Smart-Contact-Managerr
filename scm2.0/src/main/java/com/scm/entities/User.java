package com.scm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="user")
@Table(name = "users")
@Getter
@Setter
@Builder
public class User {
    @Id
    private String userId;
    @Column(name = "user_name", nullable = false)
    private String name;
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(length=1000)
    private String about;

    @Column(length=1000)
    private String profilePic;
    private String phoneNumber;

    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    @Enumerated(value = EnumType.STRING)
    private Providers provider=Providers.SELF;
    private String providerId;

    private User(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
        this.email = builder.email;
        this.about = builder.about;
        this.phoneNumber = builder.phoneNumber;
        this.profilePic=builder.profilePic;
    }


    public User(String name, String password, String about, String email, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.about = about;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts=new ArrayList<>();

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public User(String userId, String name, String password, String email, String about, String profilePic, String phoneNumber, boolean enabled, boolean emailVerified, boolean phoneVerified, Providers provider, String providerId, List<Contact> contacts) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.about = about;
        this.profilePic = profilePic;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.emailVerified = emailVerified;
        this.phoneVerified = phoneVerified;
        this.provider = provider;
        this.providerId = providerId;
        this.contacts = contacts;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public Providers getProvider() {
        return provider;
    }

    public void setProvider(Providers provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public static class Builder {
        private String name;
        private String password;
        private String email;
        private String about;
        private String phoneNumber;
        private String profilePic;

        // Setter methods for each field
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAbout(String about) {
            this.about = about;
            return this;
        }

        public Builder() {
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setProfilePic(String profilePic) {
            this.profilePic = profilePic;
            return this;
        }

        // Build method to create a User object
        public User build() {
            return new User(this);
        }
    }
}
