package cc.zhanyun.model.resources;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-22T03:38:45.720Z")
public class ResourcesParameter {
	@Id
	private String oid = null;
	private String name = null;
	private String value = null;

	/**
	 * 资源属性ID
	 **/
	@ApiModelProperty(value = "资源属性ID")
	@JsonProperty("oid")
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * 资源属性名称
	 **/
	@ApiModelProperty(value = "资源属性名称")
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 资源属性值
	 **/
	@ApiModelProperty(value = "资源属性值")
	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourcesParameter resourcesParameter = (ResourcesParameter) o;
		return Objects.equals(oid, resourcesParameter.oid)
				&& Objects.equals(name, resourcesParameter.name)
				&& Objects.equals(value, resourcesParameter.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(oid, name, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResoucesParameter {\n");

		sb.append("  oid: ").append(oid).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  value: ").append(value).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
