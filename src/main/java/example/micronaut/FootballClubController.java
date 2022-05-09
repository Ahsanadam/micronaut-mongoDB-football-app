package example.micronaut;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static io.micronaut.http.HttpStatus.CREATED;

@Controller("/footballclubs")
@ExecuteOn(TaskExecutors.IO)
class FootballClubController {

    private final FootballClubRepository footballClubService;

    FootballClubController(FootballClubRepository footballClubService) {
        this.footballClubService = footballClubService;
    }

    @Get
    List<FootballClub> list() {
        return footballClubService.list();
    }

    @Post
    @Status(CREATED)
    void save(@NonNull @NotNull @Valid FootballClub footballClub) {
        footballClubService.save(footballClub);
    }
}