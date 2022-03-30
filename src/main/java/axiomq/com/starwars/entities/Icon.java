package axiomq.com.starwars.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Icon {

    private Long iconId;
    private String iconName;
    private String path;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Icon icon = (Icon) o;
        return Objects.equals(iconId, icon.iconId) &&
                Objects.equals(iconName, icon.iconName) &&
                Objects.equals(path, icon.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iconId, iconName, path);
    }
}
