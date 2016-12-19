package kz.gcs.rest.model;

import java.io.Serializable;
import java.util.Date;

public final class Location implements Serializable, Comparable<Location> {
    private static final long serialVersionUID = 4070830229335439060L;

    private Long id;
    private Date time;
    private Double latitude;
    private Double longitude;
    private Double accuracy;
    private Long gadget_id;


    public Location(Date time, Double latitude, Double longitude, Double accuracy, Long gadget_id) {
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
        this.gadget_id = gadget_id;
    }

    public Location() {
    }

    public int compareTo(Location o1) {
        return this.getTime().compareTo(o1.getTime());
    }

    @Override
    public String toString() {
        return "Location{" +
                "time=" + time +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", accuracy=" + accuracy +
                ", gadget_id=" + gadget_id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Long getGadget_id() {
        return gadget_id;
    }

    public void setGadget_id(Long gadget_id) {
        this.gadget_id = gadget_id;
    }
}
