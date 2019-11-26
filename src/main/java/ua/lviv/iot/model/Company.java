 package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

 @Entity
 @Table(name = "`company`", schema = "`petryshyn_lab3`")
 public class Company {
     @Id
     @Column(name = "id_company", nullable = false)
     private Integer id_company;
     @Basic
     @Column(name = "name", nullable = false, length = 45)
     private String name;
     @Basic
     @Column(name = "year_of_fondation", nullable = false)
     private Integer year_of_fondation;
     @Basic
     @Column(name = "number_of_cars", nullable = false)
     private Integer number_of_cars;

     public Company() {}

     public Company(Integer id_company, String name, Integer year_of_fondation, Integer number_of_cars) {
         this.id_company = id_company;
         this.name = name;
         this.year_of_fondation = year_of_fondation;
         this.number_of_cars = number_of_cars;
     }

     public Integer getCompanyId(){
         return id_company;
     }
     public void setCompanyId(Integer id_company) {
         this.id_company = id_company;
     }

     public String getName(){
         return name;
     }
     public void setName(String name) {
         this.name = name;
     }


     public Integer getYearOfFoundation(){
         return year_of_fondation;
     }

     public void setYearOfFoundation(Integer year_of_construction) {
         this.year_of_fondation = year_of_construction;
     }


     public Integer getNumberOfCars(){
         return number_of_cars;
     }


     public void setNumberOfCars(Integer number_of_cars) {
         this.number_of_cars = number_of_cars;
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Company that = (Company) o;

         if (!Objects.equals(id_company, that.id_company)) return false;
         if (!Objects.equals(name, that.name))
             return false;
         if (!Objects.equals(year_of_fondation, that.year_of_fondation)) return false;
         if (!Objects.equals(number_of_cars, that.number_of_cars)) return false;
         return true;
     }
     @Override
     public int hashCode(){
         int result = id_company != null ? id_company.hashCode() : 0;
         result = 31 * result + (name != null ? name.hashCode() : 0);
         result = 31 * result + (year_of_fondation != null ? year_of_fondation.hashCode() : 0);
         result = 31 * result + (number_of_cars != null ? number_of_cars.hashCode() : 0);
         return result;
     }

     @Override
     public String toString() {
         return "Company{" +
                 "id_company=" + id_company +
                 ", name='" + name + '\'' +
                 ", year_of_construction=" + year_of_fondation +
                 ", number_of_cars=" + number_of_cars +
                 '}';
     }
 }
