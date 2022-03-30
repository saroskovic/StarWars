package axiomq.com.starwars.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Votes {

    private Long voteId;
    private Integer numericalValue;
    private String comment;
    private Icon icon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Votes votes = (Votes) o;
        return Objects.equals(voteId, votes.voteId) &&
                Objects.equals(numericalValue, votes.numericalValue) &&
                Objects.equals(comment, votes.comment) &&
                Objects.equals(icon, votes.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voteId, numericalValue, comment, icon);
    }
}
