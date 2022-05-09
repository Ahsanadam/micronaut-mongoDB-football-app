package example.micronaut;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class MongoDbFootballClubRepository implements FootballClubRepository {

    private final MongoDbConfiguration mongoConf;
    private final MongoClient mongoClient;

    public MongoDbFootballClubRepository(MongoDbConfiguration mongoConf,
                                         MongoClient mongoClient) {
        this.mongoConf = mongoConf;
        this.mongoClient = mongoClient;
    }

    @Override
    public void save(@NonNull @NotNull @Valid FootballClub footballClub) {
        getCollection().insertOne(footballClub);
    }

    @Override
    @NonNull
    public List<FootballClub> list() {
        return getCollection().find().into(new ArrayList<>());
    }

    @NonNull
    private MongoCollection<FootballClub> getCollection() {
        return mongoClient.getDatabase(mongoConf.getName())
                .getCollection(mongoConf.getCollection(), FootballClub.class);
    }
}