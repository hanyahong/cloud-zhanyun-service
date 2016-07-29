package cc.zhanyun.model.vo;

import org.springframework.data.annotation.Id;

public class LocationVO {
	@Id
	private String oid;
	private String name;
	private String address;

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

}
