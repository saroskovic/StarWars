package axiomq.com.starwars.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinTable(name = "characters_in_films", joinColumns =
            {@JoinColumn(name = "character_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id")})
    private Set<Film> films = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "planet")
    private Planet planet;

    private Integer votersCount;

    @OneToMany(mappedBy = "character", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Vote> votes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id) && Objects.equals(name, character.name) && Objects.equals(gender, character.gender) && Objects.equals(planet, character.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, planet);
    }

}
