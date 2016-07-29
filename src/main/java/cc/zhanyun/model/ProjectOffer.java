package cc.zhanyun.model;

import org.springframework.data.annotation.Id;

import cc.zhanyun.model.offer.Offer;
import cc.zhanyun.model.project.Project;

public class ProjectOffer {
	@Id
	private String oid;
	private String name;
	private Project project;
	private Offer offer;

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}
