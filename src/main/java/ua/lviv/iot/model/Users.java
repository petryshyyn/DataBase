package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "`users`", schema = "`petryshyn_lab3`")
public class Users {
    @Id
    @Column(name = "id_users", nullable = false)
    private Integer id_users;
    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String first_name;
    @Basic
    @Column(name = "last_name", nullable = false)
    private String last_name;
    @Basic
    @Column(name = "number_of_parking", nullable = false)
    private Integer number_of_parking;
    @Basic
    @Column(name = "disabled_people", nullable = false)
    private Integer disabled_people;

    public Users() {}

    public Users(Integer id_users, String first_name, String last_name, Integer number_of_parking, Integer disabled_people) {
        this.id_users = id_users;
        this.first_name = first_name;
        this.last_name = last_name;
        this.number_of_parking = number_of_parking;
        this.disabled_people = disabled_people;
    }

    public Integer getUsersId() {
        return id_users;
    }
    public void setUsersId(Integer id_users) {
        this.id_users = id_users;
    }

    public String getFirstName() {
        return first_name;
    }
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }


    public Integer getNumberOfParking() {
        return number_of_parking;
    }
    public void setNumberOfParking(Integer number_of_parking) {
        this.number_of_parking = number_of_parking;
    }

    public Integer getDisabledPeople() {
        return disabled_people;
    }
    public void setDisabledPeople(Integer disabled_people) {
        this.disabled_people = disabled_people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users that = (Users) o;

        if (id_users != null ? !id_users.equals(that.id_users) : that.id_users != null) return false;
        if (first_name != null ? !first_name.equals(that.first_name) : that.first_name != null)
            return false;
        if (last_name != null ? !last_name.equals(that.last_name) : that.last_name != null) return false;
        if (number_of_parking != null ? !number_of_parking.equals(that.number_of_parking) : that.number_of_parking != null) return false;
        if (disabled_people != null ? !disabled_people.equals(that.disabled_people) : that.disabled_people != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id_users != null ? id_users.hashCode() : 0;
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (number_of_parking != null ? number_of_parking.hashCode() : 0);
        result = 31 * result + (disabled_people != null ? disabled_people.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id_users=" + id_users +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", number_of_parking=" + number_of_parking +
                ", disabled_people=" + disabled_people +
                '}';
    }
}
