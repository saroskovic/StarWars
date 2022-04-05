package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.Vote;
import axiomq.com.starwars.repositories.VoteRepository;
import axiomq.com.starwars.services.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    @Override
    public Vote doVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public List<Vote> fetchAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public Vote getVoteById(Long voteId) {
        return voteRepository.findById(voteId)
                .orElseThrow(() -> new NoSuchElementException(String.format("Vote: %d not found", voteId)));
    }

    @Override
    public Vote updateVote(Long voteId, Vote newVote) {
        Vote vote = getVoteById(voteId);
        if(newVote.getComment() != null)
            vote.setComment(newVote.getComment());
        if(newVote.getNumericalValue() != null)
            vote.setNumericalValue(newVote.getNumericalValue());
        return null;
    }

    @Override
    public void deleteVote(Long voteId) {
        Vote vote = getVoteById(voteId);
        voteRepository.delete(vote);

    }
}
