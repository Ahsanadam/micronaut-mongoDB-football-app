package example.micronaut;

import io.micronaut.core.annotation.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import javax.validation.constraints.NotBlank;

@Introspected
@ReflectiveAccess
public class FootballClub {

    @NonNull
    @NotBlank
    @BsonProperty("name")
    private final String name;

    @Nullable
    @BsonProperty("stadium")
    private final String stadium;

    public FootballClub(@NonNull String name) {
        this(name, null);
    }

    @Creator
    @BsonCreator
    public FootballClub(@NonNull @BsonProperty("name") String name,
                 @Nullable @BsonProperty("stadium") String stadium) {
        this.name = name;
        this.stadium = stadium;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getStadium() {
        return stadium;
    }
}