package solutions.adapttech.spaceshipcrud.spaceship;


import solutions.adapttech.spaceshipcrud.crewmember.Crewmember;

import javax.persistence.*;

@Entity
@Table(name = "spaceship")
public class Spaceship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer fuel;


    public Spaceship() {
    }

    public Spaceship(String name, Integer fuel) {
        this.name = name;
        this.fuel = fuel;
    }

    public Spaceship(Long id, String name, Integer fuel) {
        this.id = id;
        this.name = name;
        this.fuel = fuel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
    }
}
