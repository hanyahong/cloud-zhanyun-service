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
	private String uid;
	private String othername;

	public String getOthername() {
		return othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

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
