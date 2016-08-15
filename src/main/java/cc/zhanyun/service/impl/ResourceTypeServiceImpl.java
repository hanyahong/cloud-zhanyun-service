package cc.zhanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.zhanyun.model.resources.ResourcesTypes;
import cc.zhanyun.repository.impl.ResourcesTypeRepoImpl;
import cc.zhanyun.service.ResourceTypeService;
import cc.zhanyun.util.TokenUtil;

@Service
public class ResourceTypeServiceImpl implements ResourceTypeService {

	@Autowired
	private ResourcesTypeRepoImpl typeRepo;
	@Autowired
	private TokenUtil token;

	@Override
	public void saveTypeOne(ResourcesTypes type) {
		// TODO Auto-generated method stub
		typeRepo.saveResourceType(type);
	}

	@Override
	public List<ResourcesTypes> selTypeAll() {
		String uid = token.tokenToOid();
		// TODO Auto-generated method stub
		return typeRepo.selResourceTypes(uid);
	}

	@Override
	public ResourcesTypes selTypeOne(String oid) {
		// TODO Auto-generated method stub
		return typeRepo.selResourceTypeOne(oid);
	}

	@Override
	public void delTypeOne(String oid) {
		// TODO Auto-generated method stub
		typeRepo.delResourceType(oid);
	}

}
