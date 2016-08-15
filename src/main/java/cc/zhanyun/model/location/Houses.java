package cc.zhanyun.model.location;

import org.springframework.data.annotation.Id;

public class Houses {
	@Id
	private String oid;
	private String name;
	private String length;
	private String width;
	private String height;
	private String description;
	private String introduction;
	private String notes;
	private String images;
	private String caseimages;

	public String getCaseimages() {
		return caseimages;
	}

	public void setCaseimages(String caseimages) {
		this.caseimages = caseimages;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
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

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHight() {
		return height;
	}

	public void setHight(String hight) {
		this.height = hight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
