package cc.zhanyun.model.vo;

import org.springframework.data.annotation.Id;

public class ClientVO {
	@Id
	private String oid;
	private String name;

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

}
