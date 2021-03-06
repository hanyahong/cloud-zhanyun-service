package cc.zhanyun.model.vo;

import org.springframework.data.annotation.Id;

public class ProjectOfferVO {
	@Id
	private String oid;
	private String name;
	private String address;
	private Integer status;
	private String clientmanager;

	public String getClientmanager() {
		return clientmanager;
	}

	public void setClientmanager(String clientmanager) {
		this.clientmanager = clientmanager;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
