package dbrepository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import pojo.Prospect;

public interface ProspectRepository extends MongoRepository<Prospect,String> {
    Prospect findAllBy(ObjectId _id);
}
