package cc.zhanyun.service.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import cc.zhanyun.service.model.Project;

import com.mongodb.BasicDBObject;

@Repository
public class ProjectService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Project> getProjects() {

	

		// 排序条件
		// Criteria criteria = new Criteria();
		// 查询项目集合
		Query query = new Query();
		query.with(new Sort(new Sort.Order(Sort.Direction.ASC,"barOrder")));
		
		// 执行返回结果
		List<Project> plist = mongoTemplate.find(query, Project.class,
				"project");
		
		// 返回结果
		System.out.println("plist长度：" + plist.size());
		return plist;
	}
}
