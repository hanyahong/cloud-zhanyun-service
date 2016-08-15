package cc.zhanyun.model.resources;

import io.swagger.annotations.ApiModel;

import java.util.List;

import org.springframework.data.annotation.Id;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-22T07:09:16.780Z")
public class ResourcesTypes {
	@Id
	private String oid = null;
	private String name = null;
	private List<ResourcesOid> resourcesoid = null;
	private String uid;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ResourcesOid> getResourcesoid() {
		return resourcesoid;
	}

	public void setResourcesoid(List<ResourcesOid> resourcesoid) {
		this.resourcesoid = resourcesoid;
	}

}
