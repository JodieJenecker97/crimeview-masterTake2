package t.flatearchsocie.crimeview;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Crime implements Serializable {

    private int crimeID, categoryID, locationID, userID;
    private Boolean verified;
    private Time timeRecorded;
    private float latitude, longitude;
    private Date date;



    public Crime(int crimeID, int categoryID, int locationID, int userID, Boolean verified, Time timeRecorded, float latitude, float longitude , Date date) {
        this.crimeID = crimeID;
        this.categoryID = categoryID;
        this.locationID = locationID;
        this.userID = userID;
        this.verified = verified;
        this.timeRecorded = timeRecorded;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
    }

    public int getCrimeID() {
        return crimeID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getLocationID() {
        return locationID;
    }

    public int getUserID() {
        return userID;
    }

    public Boolean getVerified() {
        return verified;
    }

    public Time getTimeRecorded() {
        return timeRecorded;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Date getDate() {return date;}
}
