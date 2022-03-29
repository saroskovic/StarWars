package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.Votes;

import java.util.List;

public interface VotesService {

    Votes doVote(Votes vote);

    List<Votes> fetchAllVotes();

    List<Votes> fetchAllVotesByUserId(Long userId);

    List<Votes> fetchAllVotesByCharacterId(Long characterId);

    Votes updateVote(Long voteId, Votes vote);

    void deleteVote(Long voteId);

}
