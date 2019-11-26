package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "`reserved`", schema = "`petryshyn_lab3`")
public class Reserved {
    @Id
    @Column(name = "id_reserved", nullable = false)
    private Integer id_reserved;
    @Basic
    @Column(name = "time", nullable = false, length = 45)
    private String time;
    @Basic
    @Column(name = "number_cars", nullable = false)
    private Integer number_cars;

    public Reserved(){}

    public Reserved(Integer id_reserved, String time, Integer number_cars) {
        this.id_reserved = id_reserved;
        this.time = time;
        this.number_cars = number_cars;
    }

    public Integer getReservedId() {
        return id_reserved;
    }
    public void setReservedId(Integer id_reserved) {
        this.id_reserved = id_reserved;
    }


    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }


    public Integer getNumberCars() {
        return number_cars;
    }
    public void setNumberCars(Integer number_cars) {
        this.number_cars = number_cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reserved that = (Reserved) o;

        if (id_reserved != null ? !id_reserved.equals(that.id_reserved) : that.id_reserved != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null)
            return false;
        if (number_cars != null ? !number_cars.equals(that.number_cars) : that.number_cars != null) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = id_reserved != null ? id_reserved.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (number_cars != null ? number_cars.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reserved{" +
                "id_reserved=" + id_reserved +
                ", time='" + time + '\'' +
                ", number_cars=" + number_cars +
                '}';
    }

}
