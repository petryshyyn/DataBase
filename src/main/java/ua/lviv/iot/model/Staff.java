package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "`staff`", schema = "`petryshyn_lab3`")
public class Staff {
    @Id
    @Column(name = "id_staff", nullable = false)
    private Integer id_staff;
    @Basic
    @Column(name = "guards", nullable = false)
    private Integer guards;
    @Basic
    @Column(name = "cleaners", nullable = false)
    private Integer cleaners;

    public Staff(){}

    public Staff(Integer id_staff, Integer guards, Integer cleaners) {
        this.id_staff = id_staff;
        this.guards = guards;
        this.cleaners = cleaners;
    }

    public Integer getStaffId() {
        return id_staff;
    }
    public void setStaffId(Integer id_staff) {
        this.id_staff = id_staff;
    }


    public Integer getGuards() {
        return guards;
    }
    public void setGuards(Integer guards) {
        this.guards = guards;
    }

    public Integer getCleaners() {
        return cleaners;
    }
    public void setCleaners(Integer cleaners) {
        this.cleaners = cleaners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff that = (Staff) o;

        if (id_staff != null ? !id_staff.equals(that.id_staff) : that.id_staff != null) return false;
        if (guards != null ? !guards.equals(that.guards) : that.guards != null)
            return false;
        if (cleaners != null ? !cleaners.equals(that.cleaners) : that.cleaners != null) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = id_staff != null ? id_staff.hashCode() : 0;
        result = 31 * result + (guards != null ? guards.hashCode() : 0);
        result = 31 * result + (cleaners != null ? cleaners.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id_staff=" + id_staff +
                ", guards=" + guards +
                ", cleaners=" + cleaners +
                '}';
    }
}
