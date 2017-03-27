package com.vjam.demo.data.db.item_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by anand.chandaliya on 27-03-2017.
 */
@Entity(nameInDb = "user")
public class User {

/*    1.Name
2.Password
3.UserId
4.Image If aval
5.Location
6.Phone Number*/

    @Expose
    @SerializedName("id")
    @Id(autoincrement = true)
    private Long keyId;

    @Expose
    @SerializedName("name")
    @Property(nameInDb = "name")
    private String name;

    @Expose
    @SerializedName("password")
    @Property(nameInDb = "password")
    private String password;

    @Expose
    @SerializedName("user_id")
    @Property(nameInDb = "User_id")
    private String userId;

    @Expose
    @SerializedName("user_image")
    @Property(nameInDb = "user_image")
    private String userImage;


    /*@Expose
    @SerializedName("location")
    @Property(nameInDb = "location")
    private String location;*/

    @Expose
    @SerializedName("phone_number")
    @Property(nameInDb = "phone_number")
    private String phoneNumber;

    @Expose
    @SerializedName("address_one")
    @Property(nameInDb = "address_one")
    private String addressOne;

    @Expose
    @SerializedName("address_two")
    @Property(nameInDb = "address_two")
    private String addressTwo;

    @Generated(hash = 1427068656)
    public User(Long keyId, String name, String password, String userId, String userImage,
            String phoneNumber, String addressOne, String addressTwo) {
        this.keyId = keyId;
        this.name = name;
        this.password = password;
        this.userId = userId;
        this.userImage = userImage;
        this.phoneNumber = phoneNumber;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
    }

    public User() {
    }

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }
}
