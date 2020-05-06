package query;
import java.util.List;

import model.CardUser;
public interface IQuery {
	public void create(CardUser user);
	 
    public void update(CardUser user);
 
    public void delete(CardUser user);
 
    public void deleteAll();
    
    public CardUser findById(String id);
 
    public List < CardUser > findByname(String nama);
 
    public List < CardUser > findBylokasi(String lokasi);
 
    public List < CardUser > findAll();
}
