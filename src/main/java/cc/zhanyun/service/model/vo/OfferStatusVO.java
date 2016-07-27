package cc.zhanyun.service.model.vo;

import org.springframework.data.annotation.Id;

public class OfferStatusVO {
	@Id
	private String oid;
	private Integer status;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
