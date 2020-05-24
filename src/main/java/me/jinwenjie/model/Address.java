package me.jinwenjie.model;

public class Address {
    private Integer addressId;

    private String address;

    private String addressType;

    private Integer userId;

    public Address(Integer addressId, String address, String addressType, Integer userId) {
        this.addressId = addressId;
        this.address = address;
        this.addressType = addressType;
        this.userId = userId;
    }

    public Address() {
        super();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType == null ? null : addressType.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}