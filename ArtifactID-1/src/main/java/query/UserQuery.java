package query;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import model.CardUser;
import repository.UserRepo;

@Service("query")
public class UserQuery implements IQuery{
	@Autowired
	UserRepo theRepo;
	
	@Override
	public void create(CardUser user) {
		CardUser usr = theRepo.insert(user);
		System.out.println("created " + usr);
	}
	
	@Override
	public void update(CardUser user) {
		CardUser usr = theRepo.save(user);
		System.out.println("updated " + usr);
	}
	
	@Override
	public void delete(CardUser user) {
		theRepo.delete(user);
		System.out.println("deleted " + user.getID());
	}
	
	@Override
	public void deleteAll() {
		theRepo.deleteAll();
	}
	
	@Override
	public CardUser findById(String id) {
		if(theRepo.existsById(id)) {
    		return theRepo.findById(id).get();
    	}
    	return null;
	}
	
	@Override
	public List <CardUser> findByname(String nama) {
		return theRepo.findByname(nama);
	}
	
	@Override
	public List <CardUser> findBylokasi(String lokasi) {
		return theRepo.findBylokasi(lokasi);
	}
	
	@Override
	public List <CardUser> findAll() {
		return theRepo.findAll();
	}
}
