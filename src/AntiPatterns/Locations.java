package AntiPatterns;

import java.util.ArrayList;
import java.util.HashMap;

public class Locations {
    String locationId;
    String locationName;
    String locationPhoneNumber;
    String locationImg;
    Double locationLat;
    Double locationLng;
    HashMap<String,Item> locationItems;
    HashMap<String,locationPackages> locationPkgs;
    HashMap<String,Booking> locationBookings;
    HashMap<String,Admins> locationAdmins;
    HashMap<String,Log> locationContacts;
    LocationSettings locationSettings;
    String locationDetail;
    String locationWebsite;

    public HashMap<String, Item> getLocationItems() {
        return locationItems;
    }

    public void setLocationItems(HashMap<String, Item> locationItems) {
        this.locationItems = locationItems;
    }


    public String getLocationWebsite() {
        return locationWebsite;
    }

    public void setLocationWebsite(String locationWebsite) {
        this.locationWebsite = locationWebsite;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    String locationAddress;

    public String getLocationPhoneNumber() {
        return locationPhoneNumber;
    }

    public void setLocationPhoneNumber(String locationPhoneNumber) {
        this.locationPhoneNumber = locationPhoneNumber;
    }


    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationImg() {
        return locationImg;
    }

    public void setLocationImg(String locationImg) {
        this.locationImg = locationImg;
    }

    public Double getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(Double locationLat) {
        this.locationLat = locationLat;
    }

    public Double getLocationLng() {
        return locationLng;
    }

    public void setLocationLng(Double locationLng) {
        this.locationLng = locationLng;
    }

    public HashMap<String, locationPackages> getLocationPkgs() {
        return locationPkgs;
    }

    public void setLocationPkgs(HashMap<String, locationPackages> locationPkgs) {
        this.locationPkgs = locationPkgs;
    }


    public HashMap<String, Booking> getLocationBookings() {
        return locationBookings;
    }

    public void setLocationBookings(HashMap<String, Booking> locationBookings) {
        this.locationBookings = locationBookings;
    }

    public HashMap<String, Admins> getLocationAdmins() {
        return locationAdmins;
    }

    public void setLocationAdmins(HashMap<String, Admins> locationAdmins) {
        this.locationAdmins = locationAdmins;
    }

    public HashMap<String, Log> getLocationContacts() {
        return locationContacts;
    }

    public void setLocationContacts(HashMap<String, Log> locationContacts) {
        this.locationContacts = locationContacts;
    }

    public LocationSettings getLocationSettings() {
        return locationSettings;
    }

    public void setLocationSettings(LocationSettings locationSettings) {
        this.locationSettings = locationSettings;
    }

}
