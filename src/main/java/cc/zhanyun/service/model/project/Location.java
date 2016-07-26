package cc.zhanyun.service.model.project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T02:04:53.655Z")
public class Location {

	private String oid = null;
	private String name = null;
	private List<Houses> houses = new ArrayList<Houses>();

	/**
	 * 地址唯一编号
	 **/
	@ApiModelProperty(value = "地址唯一编号")
	@JsonProperty("oid")
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * 场地名称
	 **/
	@ApiModelProperty(value = "场地名称")
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("houses")
	public List<Houses> getHouses() {
		return houses;
	}

	public void setHouses(List<Houses> houses) {
		this.houses = houses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Location location = (Location) o;
		return Objects.equals(oid, location.oid)
				&& Objects.equals(name, location.name)
				&& Objects.equals(houses, location.houses);
	}

	@Override
	public int hashCode() {
		return Objects.hash(oid, name, houses);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Location {\n");

		sb.append("  oid: ").append(oid).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  houses: ").append(houses).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
