package cc.zhanyun.model.resources;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-22T03:38:45.720Z")
public class Resources {
	@Id
	private String oid = null;
	private String name = null;
	private String classification = null;
	private String simplename = null;
	private Integer amount = null;
	private String unit = null;
	private BigDecimal unitprice = null;
	private String remark = null;
	private List<ResourcesParameter> parameter = new ArrayList<ResourcesParameter>();
	private String images;
	private String uid;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	/**
	 * 资源ID
	 **/
	@ApiModelProperty(value = "资源ID")
	@JsonProperty("oid")
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * 资源名称
	 **/
	@ApiModelProperty(value = "资源名称")
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 资源分类
	 **/
	@ApiModelProperty(value = "资源分类")
	@JsonProperty("classification")
	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
	 * 资源简称
	 **/
	@ApiModelProperty(value = "资源简称")
	@JsonProperty("simplename")
	public String getSimplename() {
		return simplename;
	}

	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}

	/**
	 * 资源数量
	 **/
	@ApiModelProperty(value = "资源数量")
	@JsonProperty("amount")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * 资源单位
	 **/
	@ApiModelProperty(value = "资源单位")
	@JsonProperty("unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 资源单价
	 **/
	@ApiModelProperty(value = "资源单价")
	@JsonProperty("unitprice")
	public BigDecimal getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}

	/**
	 * 资源备注
	 **/
	@ApiModelProperty(value = "资源备注")
	@JsonProperty("remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("parameter")
	public List<ResourcesParameter> getParameter() {
		return parameter;
	}

	public void setParameter(List<ResourcesParameter> parameter) {
		this.parameter = parameter;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Resources resources = (Resources) o;
		return Objects.equals(oid, resources.oid)
				&& Objects.equals(name, resources.name)
				&& Objects.equals(classification, resources.classification)
				&& Objects.equals(simplename, resources.simplename)
				&& Objects.equals(amount, resources.amount)
				&& Objects.equals(unit, resources.unit)
				&& Objects.equals(unitprice, resources.unitprice)
				&& Objects.equals(remark, resources.remark)
				&& Objects.equals(parameter, resources.parameter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(oid, name, classification, simplename, amount,
				unit, unitprice, remark, parameter);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Resources {\n");

		sb.append("  oid: ").append(oid).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  classification: ").append(classification).append("\n");
		sb.append("  simplename: ").append(simplename).append("\n");
		sb.append("  amount: ").append(amount).append("\n");
		sb.append("  unit: ").append(unit).append("\n");
		sb.append("  unitprice: ").append(unitprice).append("\n");
		sb.append("  remark: ").append(remark).append("\n");
		sb.append("  parameter: ").append(parameter).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
