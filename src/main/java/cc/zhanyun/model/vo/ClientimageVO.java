package cc.zhanyun.model.vo;

import org.springframework.data.annotation.Id;

public class ClientimageVO {
	@Id
	private String oid;
	private String image;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
