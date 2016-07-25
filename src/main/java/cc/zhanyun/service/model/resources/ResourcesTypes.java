package cc.zhanyun.service.model.resources;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-22T07:09:16.780Z")
public class ResourcesTypes {
	@Id
	private String oid = null;
	private String name = null;

	/**
	 * 资源分类ID
	 **/
	@ApiModelProperty(value = "资源分类ID")
	@JsonProperty("oid")
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * 资源分类名称
	 **/
	@ApiModelProperty(value = "资源分类名称")
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 资源
	 **/
	@ApiModelProperty(value = "资源")
	@JsonProperty("resources")
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourcesTypes resourcesTypes = (ResourcesTypes) o;
		return Objects.equals(oid, resourcesTypes.oid)
				&& Objects.equals(name, resourcesTypes.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(oid, name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourcesTypes {\n");

		sb.append("  oid: ").append(oid).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  resources: ").append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
