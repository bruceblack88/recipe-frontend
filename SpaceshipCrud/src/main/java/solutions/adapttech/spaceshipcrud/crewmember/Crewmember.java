package solutions.adapttech.spaceshipcrud.crewmember;

import solutions.adapttech.spaceshipcrud.spaceship.Spaceship;

import javax.persistence.*;

@Entity
@Table (name = "crewmember")
public class Crewmember extends Spaceship{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer morale;


    public Crewmember() {
    }

    public Crewmember(String name, Integer morale) {
        this.name = name;
        this.morale = morale;
    }

    public Crewmember(Long id, String name, Integer morale) {
        this.id = id;
        this.name = name;
        this.morale = morale;
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

    public Integer getMorale() {
        return morale;
    }

    public void setMorale(Integer morale) {
        this.morale = morale;
    }
}
