package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "`security`", schema = "`petryshyn_lab3`")
public class Security {
    @Id
    @Column(name = "id_security", nullable = false)
    private Integer id_security;
    @Basic
    @Column(name = "fined_cars", nullable = false)
    private Integer fined_cars;
    @Basic
    @Column(name = "fines", nullable = false)
    private Integer fines;

    public Security(){}

    public Security(Integer id_security, Integer fined_cars, Integer fines) {
        this.id_security = id_security;
        this.fined_cars = fined_cars;
        this.fines = fines;
    }

    public Integer getSecurityId() {
        return id_security;
    }
    public void setSecurityId(Integer id_security) {
        this.id_security = id_security;
    }


    public Integer getFinedCars() {
        return fined_cars;
    }
    public void setFinedCars(Integer fined_cars) {
        this.fined_cars = fined_cars;
    }


    public Integer getFines() {
        return fines;
    }
    public void setFines(Integer fines) {
        this.fines = fines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Security that = (Security) o;

        if (id_security != null ? !id_security.equals(that.id_security) : that.id_security != null) return false;
        if (fined_cars != null ? !fined_cars.equals(that.fined_cars) : that.fined_cars != null) return false;
        if (fines != null ? !fines.equals(that.fines) : that.fines != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id_security != null ? id_security.hashCode() : 0;
        result = 31 * result + (fined_cars != null ? fined_cars.hashCode() : 0);
        result = 31 * result + (fines != null ? fines.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Security{" +
                "id_security=" + id_security +
                ", fined_cars=" + fined_cars +
                ", fines=" + fines +
                '}';
    }
}
