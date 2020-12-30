package com.guidetoaddis;

import com.google.gson.annotations.SerializedName;

public class ListResult {

    @SerializedName("vid")
    private String vid;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("title")
    private String title;

    @SerializedName("features")
    private String features;

    @SerializedName("image")
    private String image;

    @SerializedName("rent_cost")
    private String rentCost;

    @SerializedName("availability_detail")
    private String availabilityDetail;

    @SerializedName("mileage_cap")
    private String mileageCap;

    @SerializedName("maintenance")
    private String maintenance;

    @SerializedName("pickup_info")
    private String pickupInfo;

    @SerializedName("available_booking")
    private String availableBooking;

    @SerializedName("instant_booking")
    private String instantBooking;

    @SerializedName("normal_booking")
    private String normalBooking;

    @SerializedName("insurance_company")
    private String insuranceCompany;

    @SerializedName("created")
    private String created;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRentCost() {
        return rentCost;
    }

    public void setRentCost(String rentCost) {
        this.rentCost = rentCost;
    }

    public String getAvailabilityDetail() {
        return availabilityDetail;
    }

    public void setAvailabilityDetail(String availabilityDetail) {
        this.availabilityDetail = availabilityDetail;
    }

    public String getMileageCap() {
        return mileageCap;
    }

    public void setMileageCap(String mileageCap) {
        this.mileageCap = mileageCap;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public String getPickupInfo() {
        return pickupInfo;
    }

    public void setPickupInfo(String pickupInfo) {
        this.pickupInfo = pickupInfo;
    }

    public String getAvailableBooking() {
        return availableBooking;
    }

    public void setAvailableBooking(String availableBooking) {
        this.availableBooking = availableBooking;
    }

    public String getInstantBooking() {
        return instantBooking;
    }

    public void setInstantBooking(String instantBooking) {
        this.instantBooking = instantBooking;
    }

    public String getNormalBooking() {
        return normalBooking;
    }

    public void setNormalBooking(String normalBooking) {
        this.normalBooking = normalBooking;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

}
