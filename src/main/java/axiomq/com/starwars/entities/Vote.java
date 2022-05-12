package axiomq.com.starwars.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numericalValue;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "icon")
    private Icon icon;

    private String url;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(id, vote.id) &&
                Objects.equals(numericalValue, vote.numericalValue) &&
                Objects.equals(comment, vote.comment) &&
                Objects.equals(icon, vote.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numericalValue, comment, icon);
    }
}
