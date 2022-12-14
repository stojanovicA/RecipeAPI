package com.example.recipesapi.dto;

public class UserEditDTO {

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String oldPassword;

    private String newPassword;

    private String newPasswordRe;

    public UserEditDTO() {
    }

    public UserEditDTO(long id, String firstName, String lastName, String email, String oldPassword, String newPassword, String newPasswordRe) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.newPasswordRe = newPasswordRe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordRe() {
        return newPasswordRe;
    }

    public void setNewPasswordRe(String newPasswordRe) {
        this.newPasswordRe = newPasswordRe;
    }
}
