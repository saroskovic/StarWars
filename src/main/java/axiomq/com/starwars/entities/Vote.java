package axiomq.com.starwars.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numericalValue;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "icon")
    private Icon icon;

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
