package cc.zhanyun.model;

import org.springframework.stereotype.Repository;

@Repository
public class Info {
	private String status;
	private String oid;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
