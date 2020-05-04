package me.jinwenjie.model;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userProfilePhoto;

    private String userGender;

    private Date userBday;

    private Date userRegistrationDate;

    private String userIp;

    private Integer userTelephoneNumber;

    private String userHobby;

    public User(Integer userId, String userName, String userPassword, String userEmail, String userProfilePhoto, String userGender, Date userBday, Date userRegistrationDate, String userIp, Integer userTelephoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userProfilePhoto = userProfilePhoto;
        this.userGender = userGender;
        this.userBday = userBday;
        this.userRegistrationDate = userRegistrationDate;
        this.userIp = userIp;
        this.userTelephoneNumber = userTelephoneNumber;
    }

    public User(Integer userId, String userName, String userPassword, String userEmail, String userProfilePhoto, String userGender, Date userBday, Date userRegistrationDate, String userIp, Integer userTelephoneNumber, String userHobby) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userProfilePhoto = userProfilePhoto;
        this.userGender = userGender;
        this.userBday = userBday;
        this.userRegistrationDate = userRegistrationDate;
        this.userIp = userIp;
        this.userTelephoneNumber = userTelephoneNumber;
        this.userHobby = userHobby;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto == null ? null : userProfilePhoto.trim();
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    public Date getUserBday() {
        return userBday;
    }

    public void setUserBday(Date userBday) {
        this.userBday = userBday;
    }

    public Date getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Date userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public Integer getUserTelephoneNumber() {
        return userTelephoneNumber;
    }

    public void setUserTelephoneNumber(Integer userTelephoneNumber) {
        this.userTelephoneNumber = userTelephoneNumber;
    }

    public String getUserHobby() {
        return userHobby;
    }

    public void setUserHobby(String userHobby) {
        this.userHobby = userHobby == null ? null : userHobby.trim();
    }
}