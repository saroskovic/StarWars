package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.Vote;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VoteService {

    Vote doVote(Vote vote, MultipartFile file, Long characterId);

    List<Vote> fetchAllVotes();

    Vote getVoteById(Long voteId);

    Vote updateVote(Long voteId, Vote vote);

    void deleteVote(Long voteId);
}
