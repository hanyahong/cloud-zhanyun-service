package cc.zhanyun.model.project;

import org.springframework.data.annotation.Id;

import cc.zhanyun.model.client.Clientmanager;
import cc.zhanyun.model.location.Location;

public class Project {
	@Id
	private String oid;
	private String group;
	private String name;
	private String py;
	private String progress;
	private String status;
	private Location location;
	private Company company;
	private Clientmanager clientmanager;
	private String prepareplantime;
	private String preparetime;
	private String startplantime;
	private String starttime;
	private String leaveplantime;
	private String leavetime;
	private Creator creator;
	private String createtime;
	private String uid;
	private String imageOid;

	public String getImageOid() {
		return imageOid;
	}

	public void setImageOid(String imageOid) {
		this.imageOid = imageOid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	private String description;
	

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPy() {
		return py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Clientmanager getClientmanager() {
		return clientmanager;
	}

	public void setClientmanager(Clientmanager clientmanager) {
		this.clientmanager = clientmanager;
	}

	public String getPrepareplantime() {
		return prepareplantime;
	}

	public void setPrepareplantime(String prepareplantime) {
		this.prepareplantime = prepareplantime;
	}

	public String getPreparetime() {
		return preparetime;
	}

	public void setPreparetime(String preparetime) {
		this.preparetime = preparetime;
	}

	public String getStartplantime() {
		return startplantime;
	}

	public void setStartplantime(String startplantime) {
		this.startplantime = startplantime;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getLeaveplantime() {
		return leaveplantime;
	}

	public void setLeaveplantime(String leaveplantime) {
		this.leaveplantime = leaveplantime;
	}

	public String getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
