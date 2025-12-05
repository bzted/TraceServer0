package es.upm.dit.apsv.traceserver.model;

import java.util.Objects;

import javax.persistence.Entity;

import javax.persistence.Id;

import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.ToString;

@Entity

@Getter @Setter @NoArgsConstructor @ToString

public class TransportationOrder {  

    private String toid;

    @Id

    private String truck;

    private long originDate;

    private double originLat;

    private double originLong;

    private long dstDate;

    private double dstLat;

    private double dstLong;

    private long lastDate;

    private double lastLat;

    private double lastLong;

    private int st;

    public TransportationOrder(long dstDate, double dstLat, double dstLong, long lastDate, double lastLat, double lastLong, long originDate, double originLat, double originLong, int st, String toid, String truck) {
        this.dstDate = dstDate;
        this.dstLat = dstLat;
        this.dstLong = dstLong;
        this.lastDate = lastDate;
        this.lastLat = lastLat;
        this.lastLong = lastLong;
        this.originDate = originDate;
        this.originLat = originLat;
        this.originLong = originLong;
        this.st = st;
        this.toid = toid;
        this.truck = truck;
    }


    public double distanceToDestination() {

        return Math.sqrt(Math.pow(this.dstLat -this.lastLat, 2)

                    + Math.pow(this.dstLong - this.lastLong, 2));

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.truck);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransportationOrder other = (TransportationOrder) obj;
        return Objects.equals(this.truck, other.truck);
    }

    
}

