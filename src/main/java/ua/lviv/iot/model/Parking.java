package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "`parking`", schema = "`petryshyn_lab3`")
public class Parking {
    @Id
    @Column(name = "id_parking", nullable = false)
    private Integer id_parking;
    @Basic
    @Column(name = "adress", nullable = false, length = 45)
    private String adress;
    @Basic
    @Column(name = "price_for_one_hour", nullable = false)
    private Integer price_for_one_hour;
    @Basic
    @Column(name = "trading_network", nullable = false, length = 45)
    private String trading_network;
    @Basic
    @Column(name = "places_for_disabled_people", nullable = false)
    private Integer places_for_disabled_people;

    public Parking() {}

    public Parking(Integer id_parking, String adress, Integer price_for_one_hour, String trading_network, Integer places_for_disabled_people) {
        this.id_parking = id_parking;
        this.adress = adress;
        this.price_for_one_hour = price_for_one_hour;
        this.trading_network = trading_network;
        this.places_for_disabled_people = places_for_disabled_people;
    }

    public Integer getParkingId(){
        return id_parking;
    }
    public void setParkingId(Integer id_parking) {
        this.id_parking = id_parking;
    }


    public String getAdress(){
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }


    public Integer getPriceForOneHour(){
        return price_for_one_hour;
    }
    public void setPriceForOneHour(Integer price_for_one_hour) {
        this.price_for_one_hour = price_for_one_hour;
    }


    public String getTradingNetwork(){
        return trading_network;
    }
    public void setTradingNetwork(String trading_network) {
        this.trading_network = trading_network;
    }


    public Integer getPlacesForDisabledPeople(){
        return places_for_disabled_people;
    }
    public void setPlacesForDisabledPeople(Integer places_for_disabled_people) {
        this.places_for_disabled_people = places_for_disabled_people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parking that = (Parking) o;

        if (id_parking != null ? !id_parking.equals(that.id_parking) : that.id_parking != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null)
            return false;
        if (price_for_one_hour != null ? !price_for_one_hour.equals(that.price_for_one_hour) : that.price_for_one_hour != null) return false;
        if (trading_network != null ? !trading_network.equals(that.trading_network) : that.trading_network != null) return false;
        if (places_for_disabled_people != null ? !places_for_disabled_people.equals(that.places_for_disabled_people) : that.places_for_disabled_people != null) return false;

        return true;
    }
    @Override
    public int hashCode(){
        int result = id_parking != null ? id_parking.hashCode() : 0;
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (price_for_one_hour != null ? price_for_one_hour.hashCode() : 0);
        result = 31 * result + (trading_network != null ? trading_network.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id_parking=" + id_parking +
                ", adress='" + adress + '\'' +
                ", price_for_one_hour=" + price_for_one_hour +
                ", trading_network='" + trading_network + '\'' +
                ", places_for_disabled_people=" + places_for_disabled_people +
                '}';
    }
}
