package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.Vote;

import java.util.List;

public interface VoteService {

    Vote doVote(Vote vote);

    List<Vote> fetchAllVotes();

    Vote getVoteById(Long voteId);

    Vote updateVote(Long voteId, Vote vote);

    void deleteVote(Long voteId);
}
