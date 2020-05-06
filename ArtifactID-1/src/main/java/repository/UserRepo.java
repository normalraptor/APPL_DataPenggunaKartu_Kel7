package repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
 
import model.CardUser;

@Repository
public interface UserRepo extends MongoRepository <CardUser , String> {
	@Query("{ 'nama' : ?0 }")
	List <CardUser> findByname(String name);
	
	@Query("{ 'lokasi' : ?0 }")
	List <CardUser> findBylokasi(String lokasi);
}
