package cc.zhanyun.model.offer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T06:37:51.280Z")
public class Selectedresources {

	private String name = null;
	private String simplename = null;
	private Integer amount = null;
	private String unit = null;
	private Integer days = null;
	private BigDecimal unitprice = null;

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
	 * 资源天数
	 **/
	@ApiModelProperty(value = "资源天数")
	@JsonProperty("days")
	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Selectedresources selectedresources = (Selectedresources) o;
		return Objects.equals(name, selectedresources.name)
				&& Objects.equals(simplename, selectedresources.simplename)
				&& Objects.equals(amount, selectedresources.amount)
				&& Objects.equals(unit, selectedresources.unit)
				&& Objects.equals(days, selectedresources.days)
				&& Objects.equals(unitprice, selectedresources.unitprice);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, simplename, amount, unit, days, unitprice);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Selectedresources {\n");

		sb.append("  name: ").append(name).append("\n");
		sb.append("  simplename: ").append(simplename).append("\n");
		sb.append("  amount: ").append(amount).append("\n");
		sb.append("  unit: ").append(unit).append("\n");
		sb.append("  days: ").append(days).append("\n");
		sb.append("  unitprice: ").append(unitprice).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
