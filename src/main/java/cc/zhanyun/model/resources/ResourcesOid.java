package cc.zhanyun.model.resources;

import org.springframework.data.annotation.Id;

public class ResourcesOid {
	@Id
	private String oid;
	private String resourcesoid;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getResourcesoid() {
		return resourcesoid;
	}

	public void setResourcesoid(String resourcesoid) {
		this.resourcesoid = resourcesoid;
	}

}
