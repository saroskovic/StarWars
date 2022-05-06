package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.Character;
import axiomq.com.starwars.entities.Vote;
import axiomq.com.starwars.repositories.VoteRepository;
import axiomq.com.starwars.services.CharacterService;
import axiomq.com.starwars.services.UserService;
import axiomq.com.starwars.services.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
    private final CharacterService characterService;
    private final UserService userService;

    @Override
    public Vote doVote(Vote vote, MultipartFile file, Long characterId) {
        Character character = characterService.getCharacterById(characterId);
        vote.setCharacter(character);

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
        if (newVote.getComment() != null)
            vote.setComment(newVote.getComment());
        if (newVote.getNumericalValue() != null)
            vote.setNumericalValue(newVote.getNumericalValue());
        return null;
    }

    @Override
    public void deleteVote(Long voteId) {
        Vote vote = getVoteById(voteId);
        voteRepository.delete(vote);
    }
}
