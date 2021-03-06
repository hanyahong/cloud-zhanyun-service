package cc.zhanyun.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cc.zhanyun.model.location.Houses;
import cc.zhanyun.model.location.Location;

public interface LocationRepository extends MongoRepository<Location, String> {

	@Query(fields = "{'_id':1,'name':1,'address':1}")
	public List<Location> findByUid(String uid);


}
