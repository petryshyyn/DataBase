package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "`parking_time`", schema = "`petryshyn_lab3`")
public class ParkingTime {
    @Id
    @Column(name = "id_parking_time", nullable = false)
    private Integer id_parking_time;
    @Basic
    @Column(name = "time_of_arrival", nullable = false, length = 45)
    private String time_of_arrival;
    @Basic
    @Column(name = "check_out_time", nullable = false, length = 45)
    private String check_out_time;
    @Basic
    @Column(name = "car_number", nullable = false)
    private Integer car_number;

    public ParkingTime() {}

    public ParkingTime(Integer id_parking_time, String time_of_arrival, String check_out_time, Integer car_number) {
        this.id_parking_time = id_parking_time;
        this.time_of_arrival = time_of_arrival;
        this.check_out_time = check_out_time;
        this.car_number = car_number;
    }

    public Integer getParkingTimeId(){
        return id_parking_time;
    }
    public void setParkingTimeId(Integer id_parking_time) {
        this.id_parking_time = id_parking_time;
    }


    public String getTimeOfArrival(){
        return time_of_arrival;
    }
    public void setTimeOfArrival(String time_of_arrival) {
        this.time_of_arrival = time_of_arrival;
    }


    public String getCheckOutTime(){
        return check_out_time;
    }
    public void setCheckOutTime(String check_out_time) {
        this.check_out_time = check_out_time;
    }

    public Integer getCarNumber(){
        return car_number;
    }
    public void setCarNumber(Integer car_number) {
        this.car_number = car_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingTime that = (ParkingTime) o;

        if (id_parking_time != null ? !id_parking_time.equals(that.id_parking_time) : that.id_parking_time != null) return false;
        if (time_of_arrival != null ? !time_of_arrival.equals(that.time_of_arrival) : that.time_of_arrival != null)
            return false;
        if (check_out_time != null ? !check_out_time.equals(that.check_out_time) : that.check_out_time != null) return false;
        if (car_number != null ? !car_number.equals(that.car_number) : that.car_number != null) return false;
        return true;
    }
    @Override
    public int hashCode(){
        int result = id_parking_time != null ? id_parking_time.hashCode() : 0;
        result = 31 * result + (time_of_arrival != null ? time_of_arrival.hashCode() : 0);
        result = 31 * result + (check_out_time != null ? check_out_time.hashCode() : 0);
        result = 31 * result + (car_number != null ? car_number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParkingTime{" +
                "id_parking_time=" + id_parking_time +
                ", time_of_arrival='" + time_of_arrival + '\'' +
                ", check_out_time='" + check_out_time + '\'' +
                ", car_number=" + car_number +
                '}';
    }
}
