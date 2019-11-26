package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "`cars`", schema = "`petryshyn_lab3`")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cars", nullable = false)
    private Integer id_car;
    @Basic
    @Column(name = "ouner", nullable = false, length = 45)
    private String ouner;
    @Basic
    @Column(name = "year_of_construction", nullable = false)
    private Integer year_of_construction;

    @Basic
    @Column(name = "color", nullable = false, length = 45)
    private String color;
    @Basic
    @Column(name = "price", nullable = false)
    private Integer price;
    @Basic
    @Column(name = "numbers", nullable = false)
    private Integer numbers;

    public Cars(){}

    public Cars(Integer id_car, String ouner, Integer year_of_construction, String color, Integer price, Integer numbers){
        this.id_car = id_car;
        this.ouner = ouner;
        this.year_of_construction = year_of_construction;
        this.color = color;
        this.price = price;
        this.numbers = numbers;
    }

    public Integer getCarsId() {
        return id_car;
    }
    public void setCarsId(Integer id_car) {
        this.id_car = id_car;
    }

    public String getOuner() {
        return ouner;
    }
    public void setOuner(String ouner) {
        this.ouner = ouner;
    }
    public Integer getYearOfConstruction() {
        return year_of_construction;
    }
    public void setYearOfConstruction(Integer year_of_construction) {
        this.year_of_construction = year_of_construction;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars that = (Cars) o;

        if (id_car != null ? !id_car.equals(that.id_car) : that.id_car != null) return false;
        if (ouner != null ? !ouner.equals(that.ouner) : that.ouner != null)
            return false;
        if (year_of_construction != null ? !year_of_construction.equals(that.year_of_construction) : that.year_of_construction != null)
            return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (numbers != null ? !numbers.equals(that.numbers) : that.numbers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id_car != null ? id_car.hashCode() : 0;
        result = 31 * result + (ouner != null ? ouner.hashCode() : 0);
        result = 31 * result + (year_of_construction != null ? year_of_construction.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (numbers != null ? numbers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id_car=" + id_car +
                ", ouner='" + ouner + '\'' +
                ", year_of_construction=" + year_of_construction +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", numbers=" + numbers +
                '}';
    }
}
