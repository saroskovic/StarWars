package axiomq.com.starwars.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Icon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String iconName;
    private String path;

    @OneToMany(mappedBy = "icon", fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    private List<Vote> votes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Icon icon = (Icon) o;
        return Objects.equals(id, icon.id) &&
                Objects.equals(iconName, icon.iconName) &&
                Objects.equals(path, icon.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iconName, path);
    }
}
