package com.podufalyy.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserHasFlightPK implements Serializable {
    private int userId;
    private int flightId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "flight_id")
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserHasFlightPK)) return false;
        UserHasFlightPK that = (UserHasFlightPK) o;
        return getUserId() == that.getUserId() && getFlightId() == that.getFlightId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFlightId());
    }
}
