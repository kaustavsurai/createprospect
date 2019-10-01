package dbrepository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import pojo.Contact;
import pojo.Prospect;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact,String> {
    Contact findAllByName(String name);

    List<Contact> findAllByAndName(String name);

    void deleteByName(String name);
}
