package cc.zhanyun.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cc.zhanyun.service.model.resources.ResourcesTypes;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T02:04:53.655Z")
public class Offer {

	private String oid = null;
	private String name = null;
	private String content = null;
	private String tax = null;
	private String benefit = null;
	private String total = null;
	private String createby = null;
	private String updatedtime = null;
	private String status = null;
	private List<Houses> houses = new ArrayList<Houses>();
	private List<ResourcesTypes> ResourcesTypes = new ArrayList<ResourcesTypes>();

	/**
	 * 报价单编号
	 **/
	@ApiModelProperty(value = "报价单编号")
	@JsonProperty("oid")
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * 报价单名称
	 **/
	@ApiModelProperty(value = "报价单名称")
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 报价单描述
	 **/
	@ApiModelProperty(value = "报价单描述")
	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 报价含税部分
	 **/
	@ApiModelProperty(value = "报价含税部分")
	@JsonProperty("tax")
	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	/**
	 * 报价优惠部分
	 **/
	@ApiModelProperty(value = "报价优惠部分")
	@JsonProperty("benefit")
	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	/**
	 * 报价总计，此值应该动态计算
	 **/
	@ApiModelProperty(value = "报价总计，此值应该动态计算")
	@JsonProperty("total")
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * 报价创建人
	 **/
	@ApiModelProperty(value = "报价创建人")
	@JsonProperty("createby")
	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	/**
	 * 报价修改时间
	 **/
	@ApiModelProperty(value = "报价修改时间")
	@JsonProperty("updatedtime")
	public String getUpdatedtime() {
		return updatedtime;
	}

	public void setUpdatedtime(String updatedtime) {
		this.updatedtime = updatedtime;
	}

	/**
	 * 报价状态：-报价中,-进行中,-已完成,-已废弃
	 **/
	@ApiModelProperty(value = "报价状态：-报价中,-进行中,-已完成,-已废弃")
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("ResourcesTypes")
	public List<ResourcesTypes> getResourcesTypes() {
		return ResourcesTypes;
	}

	public void setResourcesTypes(List<ResourcesTypes> ResourcesTypes) {
		this.ResourcesTypes = ResourcesTypes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Offer offer = (Offer) o;
		return Objects.equals(oid, offer.oid)
				&& Objects.equals(name, offer.name)
				&& Objects.equals(content, offer.content)
				&& Objects.equals(tax, offer.tax)
				&& Objects.equals(benefit, offer.benefit)
				&& Objects.equals(total, offer.total)
				&& Objects.equals(createby, offer.createby)
				&& Objects.equals(updatedtime, offer.updatedtime)
				&& Objects.equals(status, offer.status)
				&& Objects.equals(houses, offer.houses)
				&& Objects.equals(ResourcesTypes, offer.ResourcesTypes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(oid, name, content, tax, benefit, total, createby,
				updatedtime, status, houses, ResourcesTypes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Offer {\n");

		sb.append("  oid: ").append(oid).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  content: ").append(content).append("\n");
		sb.append("  tax: ").append(tax).append("\n");
		sb.append("  benefit: ").append(benefit).append("\n");
		sb.append("  total: ").append(total).append("\n");
		sb.append("  createby: ").append(createby).append("\n");
		sb.append("  updatedtime: ").append(updatedtime).append("\n");
		sb.append("  status: ").append(status).append("\n");
		sb.append("  houses: ").append(houses).append("\n");
		sb.append("  ResourcesTypes: ").append(ResourcesTypes).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
