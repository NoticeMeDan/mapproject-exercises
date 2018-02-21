package main.model;

public class OSMNode {
    public double lat, lon;

    public OSMNode(double lon, double lat) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }
}
