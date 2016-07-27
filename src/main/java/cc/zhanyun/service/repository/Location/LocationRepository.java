package cc.zhanyun.service.repository.Location;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cc.zhanyun.service.model.location.Location;

public interface LocationRepository extends MongoRepository<Location, String> {
	@Query(value = "{'_id':{'$ne':null}}", fields = "{'oid':1,'name':1,'address':1}")
	public List<Location> findByIdNotNull();
	
	
}
