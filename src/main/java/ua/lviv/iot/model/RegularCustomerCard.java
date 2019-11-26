package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`regular_customer_card`", schema = "`petryshyn_lab3`")
public class RegularCustomerCard {
    @Id
    @Column(name = "id_regular_customer_card", nullable = false)
    private Integer id_regular_customer_card;
    @Basic
    @Column(name = "ouner", nullable = false, length = 45)
    private String ouner;
    @Basic
    @Column(name = "number_of_free_spaces", nullable = false)
    private Integer number_of_free_spaces;
    @Basic
    @Column(name = "deadline", nullable = false, length = 45)
    private String deadline;

    public RegularCustomerCard() {}

    public RegularCustomerCard(Integer id_regular_customer_card, String ouner, Integer number_of_free_spaces, String deadline) {
        this.id_regular_customer_card = id_regular_customer_card;
        this.ouner = ouner;
        this.number_of_free_spaces = number_of_free_spaces;
        this.deadline = deadline;
    }

    public Integer getRegularCustomerCardId() {
        return id_regular_customer_card;
    }
    public void setRegularCustomerCardId(Integer id_regular_customer_card) {
        this.id_regular_customer_card = id_regular_customer_card;
    }

    public String getOuner() {
        return ouner;
    }
    public void setOuner(String ouner) {
        this.ouner = ouner;
    }

    public Integer getNumberOfFreeSpaces() {
        return number_of_free_spaces;
    }

    public void setNumberOfFreeSpaces(Integer number_of_free_spaces) {
        this.number_of_free_spaces = number_of_free_spaces;
    }

    public String getDeadline() {
        return deadline;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegularCustomerCard that = (RegularCustomerCard) o;

        if (id_regular_customer_card != null ? !id_regular_customer_card.equals(that.id_regular_customer_card) : that.id_regular_customer_card != null) return false;
        if (ouner != null ? !ouner.equals(that.ouner) : that.ouner != null)
            return false;
        if (number_of_free_spaces != null ? !number_of_free_spaces.equals(that.number_of_free_spaces) : that.number_of_free_spaces != null) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = id_regular_customer_card != null ? id_regular_customer_card.hashCode() : 0;
        result = 31 * result + (ouner != null ? ouner.hashCode() : 0);
        result = 31 * result + (number_of_free_spaces != null ? number_of_free_spaces.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegularCustomerCard{" +
                "id_regular_customer_card=" + id_regular_customer_card +
                ", ouner='" + ouner + '\'' +
                ", number_of_free_spaces=" + number_of_free_spaces +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
