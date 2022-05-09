package example.micronaut;

import io.micronaut.core.annotation.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface FootballClubRepository {

    @NonNull
    List<FootballClub> list();

    void save(@NonNull @NotNull @Valid FootballClub footballClub);
}