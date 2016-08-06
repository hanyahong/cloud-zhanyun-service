package cc.zhanyun.model.location;

import org.springframework.data.annotation.Id;

public class Images {
	@Id
	private String imageoid;
	private String name;
	private String url;
	private String projectoid;

	public String getProjectoid() {
		return projectoid;
	}

	public void setProjectoid(String projectoid) {
		this.projectoid = projectoid;
	}

	public String getImageoid() {
		return imageoid;
	}

	public void setImageoid(String imageoid) {
		this.imageoid = imageoid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
