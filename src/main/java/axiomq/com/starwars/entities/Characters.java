package axiomq.com.starwars.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Data
@NoArgsConstructor
public class Characters {

    private Long characterId;
    private String name;
    private String gender;
    private String[] films;
    private String planet;
    private Integer votersCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Characters that = (Characters) o;
        return Objects.equals(characterId, that.characterId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Arrays.equals(films, that.films) &&
                Objects.equals(planet, that.planet) &&
                Objects.equals(votersCount, that.votersCount);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(characterId, name, gender, planet, votersCount);
        result = 31 * result + Arrays.hashCode(films);
        return result;
    }
}
