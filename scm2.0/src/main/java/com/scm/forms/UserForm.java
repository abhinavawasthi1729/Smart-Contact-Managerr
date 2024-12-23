package com.scm.forms;

import com.scm.entities.User;
import jakarta.persistence.Column;
import lombok.*;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    private String name;
    private String password;

    private String email;

    private String about;

    private String phoneNumber;


    private UserForm(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
        this.email = builder.email;
        this.about = builder.about;
        this.phoneNumber = builder.phoneNumber;
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

    public UserForm() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static class Builder {
        private String name;
        private String password;
        private String email;
        private String about;
        private String phoneNumber;

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

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }



        // Build method to create a User object
        public UserForm build() {
            return new UserForm(this);
        }
    }




}

