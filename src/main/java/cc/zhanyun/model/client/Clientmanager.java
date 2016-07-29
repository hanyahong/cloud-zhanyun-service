package cc.zhanyun.model.client;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-20T07:07:41.123Z")
public class Clientmanager {
	@Id
	private String oid = null;

	private String name = null;
	private String sex = null;
	private String company = null;
	private String dept = null;
	private String tel = null;
	private String email = null;
	private String industry = null;
	private String website = null;
	private String address = null;
	private String _abstract = null;

	/**
	 * 客户唯一编号
	 **/
	@ApiModelProperty(value = "客户唯一编号")
	@JsonProperty("oid")
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * 客户姓名
	 **/
	@ApiModelProperty(value = "客户姓名")
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 客户性别
	 **/
	@ApiModelProperty(value = "客户性别")
	@JsonProperty("sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 客户公司
	 **/
	@ApiModelProperty(value = "客户公司")
	@JsonProperty("company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 客户部门
	 **/
	@ApiModelProperty(value = "客户部门")
	@JsonProperty("dept")
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	/**
	 * 客户电话
	 **/
	@ApiModelProperty(value = "客户电话")
	@JsonProperty("tel")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 客户邮件
	 **/
	@ApiModelProperty(value = "客户邮件")
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 客户行业
	 **/
	@ApiModelProperty(value = "客户行业")
	@JsonProperty("industry")
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * 客户网站
	 **/
	@ApiModelProperty(value = "客户网站")
	@JsonProperty("website")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * 客户地址
	 **/
	@ApiModelProperty(value = "客户地址")
	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 个人简介
	 **/
	@ApiModelProperty(value = "个人简介")
	@JsonProperty("abstract")
	public String getAbstract() {
		return _abstract;
	}

	public void setAbstract(String _abstract) {
		this._abstract = _abstract;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Clientmanager clientmanager = (Clientmanager) o;
		return Objects.equals(oid, clientmanager.oid)
				&& Objects.equals(name, clientmanager.name)
				&& Objects.equals(sex, clientmanager.sex)
				&& Objects.equals(company, clientmanager.company)
				&& Objects.equals(dept, clientmanager.dept)
				&& Objects.equals(tel, clientmanager.tel)
				&& Objects.equals(email, clientmanager.email)
				&& Objects.equals(industry, clientmanager.industry)
				&& Objects.equals(website, clientmanager.website)
				&& Objects.equals(address, clientmanager.address)
				&& Objects.equals(_abstract, clientmanager._abstract);
	}

	@Override
	public int hashCode() {
		return Objects.hash(oid, name, sex, company, dept, tel, email,
				industry, website, address, _abstract);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Clientmanager {\n");

		sb.append("  oid: ").append(oid).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  sex: ").append(sex).append("\n");
		sb.append("  company: ").append(company).append("\n");
		sb.append("  dept: ").append(dept).append("\n");
		sb.append("  tel: ").append(tel).append("\n");
		sb.append("  email: ").append(email).append("\n");
		sb.append("  industry: ").append(industry).append("\n");
		sb.append("  website: ").append(website).append("\n");
		sb.append("  address: ").append(address).append("\n");
		sb.append("  _abstract: ").append(_abstract).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
