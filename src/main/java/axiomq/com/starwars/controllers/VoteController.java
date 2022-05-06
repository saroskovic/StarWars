package axiomq.com.starwars.controllers;

import axiomq.com.starwars.entities.Vote;
import axiomq.com.starwars.services.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/vote")
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public Vote saveVote(@RequestPart("icon")MultipartFile icon, @RequestBody Vote newVote){
        Vote vote = voteService.doVote(newVote, icon, newVote.getCharacter().getId());
        return vote;
    }
}
