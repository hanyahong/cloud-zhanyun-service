package cc.zhanyun.service.model.project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T02:04:53.655Z")
@Document(collection = "project")
public class Project {

	private String group = null;
	@Id
	private String oid = null;
	private String name = null;
	private List<ProjectImages> image = new ArrayList<ProjectImages>();
	private String py = null;
	private Integer progress = null;
	private Integer status = null;
	private List<Location> location = new ArrayList<Location>();
	private BigDecimal totalmoney = null;
	private Object clientmanager = null;
	private String prepareplantime = null;
	private String preparetime = null;
	private String startplantime = null;
	private String starttime = null;
	private String leaveplantime = null;
	private String leavetime = null;
	private BigDecimal advancepayment = null;
	private BigDecimal advancepaymenttime = null;
	private BigDecimal finalpayment = null;
	private String finalpayplantime = null;
	private String finalpaytime = null;
	private BigDecimal debt = null;
	private String createtime = null;
	private List<Attachments> attachments = new ArrayList<Attachments>();
	private String description = null;
	private List<Offer> offer = new ArrayList<Offer>();

	/**
	 * 项目所属分组
	 **/
	@ApiModelProperty(value = "项目所属分组")
	@JsonProperty("group")
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * 项目唯一编号
	 **/
	@ApiModelProperty(value = "项目唯一编号")
	@JsonProperty("oid")
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * 项目名称
	 **/
	@ApiModelProperty(value = "项目名称")
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
	@JsonProperty("image")
	public List<ProjectImages> getImage() {
		return image;
	}

	public void setImage(List<ProjectImages> image) {
		this.image = image;
	}

	/**
	 * 项目拼音缩写，方便按拼音首字母进行检索，也可以后台根据名称动态生成
	 **/
	@ApiModelProperty(value = "项目拼音缩写，方便按拼音首字母进行检索，也可以后台根据名称动态生成")
	@JsonProperty("py")
	public String getPy() {
		return py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	/**
	 * 项目进度，暂时无用处
	 **/
	@ApiModelProperty(value = "项目进度，暂时无用处")
	@JsonProperty("progress")
	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	/**
	 * 项目状态，暂时无用处
	 **/
	@ApiModelProperty(value = "项目状态，暂时无用处")
	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("location")
	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}

	/**
	 * 项目总价，在合同签订后确定，暂时无用处
	 **/
	@ApiModelProperty(value = "项目总价，在合同签订后确定，暂时无用处")
	@JsonProperty("totalmoney")
	public BigDecimal getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(BigDecimal totalmoney) {
		this.totalmoney = totalmoney;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("clientmanager")
	public Object getClientmanager() {
		return clientmanager;
	}

	public void setClientmanager(Object clientmanager) {
		this.clientmanager = clientmanager;
	}

	/**
	 * 计划安装时间，暂时无用处
	 **/
	@ApiModelProperty(value = "计划安装时间，暂时无用处")
	@JsonProperty("prepareplantime")
	public String getPrepareplantime() {
		return prepareplantime;
	}

	public void setPrepareplantime(String prepareplantime) {
		this.prepareplantime = prepareplantime;
	}

	/**
	 * 安装时间
	 **/
	@ApiModelProperty(value = "安装时间")
	@JsonProperty("preparetime")
	public String getPreparetime() {
		return preparetime;
	}

	public void setPreparetime(String preparetime) {
		this.preparetime = preparetime;
	}

	/**
	 * 计划活动时间，暂时无用处
	 **/
	@ApiModelProperty(value = "计划活动时间，暂时无用处")
	@JsonProperty("startplantime")
	public String getStartplantime() {
		return startplantime;
	}

	public void setStartplantime(String startplantime) {
		this.startplantime = startplantime;
	}

	/**
	 * 活动时间
	 **/
	@ApiModelProperty(value = "活动时间")
	@JsonProperty("starttime")
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * 计划拆卸时间，暂时无用处
	 **/
	@ApiModelProperty(value = "计划拆卸时间，暂时无用处")
	@JsonProperty("leaveplantime")
	public String getLeaveplantime() {
		return leaveplantime;
	}

	public void setLeaveplantime(String leaveplantime) {
		this.leaveplantime = leaveplantime;
	}

	/**
	 * 拆卸时间
	 **/
	@ApiModelProperty(value = "拆卸时间")
	@JsonProperty("leavetime")
	public String getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}

	/**
	 * 预付款，暂时无用处
	 **/
	@ApiModelProperty(value = "预付款，暂时无用处")
	@JsonProperty("advancepayment")
	public BigDecimal getAdvancepayment() {
		return advancepayment;
	}

	public void setAdvancepayment(BigDecimal advancepayment) {
		this.advancepayment = advancepayment;
	}

	/**
	 * 预付款时间，暂时无用处
	 **/
	@ApiModelProperty(value = "预付款时间，暂时无用处")
	@JsonProperty("advancepaymenttime")
	public BigDecimal getAdvancepaymenttime() {
		return advancepaymenttime;
	}

	public void setAdvancepaymenttime(BigDecimal advancepaymenttime) {
		this.advancepaymenttime = advancepaymenttime;
	}

	/**
	 * 尾款，暂时无用处
	 **/
	@ApiModelProperty(value = "尾款，暂时无用处")
	@JsonProperty("finalpayment")
	public BigDecimal getFinalpayment() {
		return finalpayment;
	}

	public void setFinalpayment(BigDecimal finalpayment) {
		this.finalpayment = finalpayment;
	}

	/**
	 * 计划尾款时间，暂时无用处
	 **/
	@ApiModelProperty(value = "计划尾款时间，暂时无用处")
	@JsonProperty("finalpayplantime")
	public String getFinalpayplantime() {
		return finalpayplantime;
	}

	public void setFinalpayplantime(String finalpayplantime) {
		this.finalpayplantime = finalpayplantime;
	}

	/**
	 * 尾款实际日期，暂时无用处
	 **/
	@ApiModelProperty(value = "尾款实际日期，暂时无用处")
	@JsonProperty("finalpaytime")
	public String getFinalpaytime() {
		return finalpaytime;
	}

	public void setFinalpaytime(String finalpaytime) {
		this.finalpaytime = finalpaytime;
	}

	/**
	 * 欠款，暂时无用处
	 **/
	@ApiModelProperty(value = "欠款，暂时无用处")
	@JsonProperty("debt")
	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

	/**
	 * 项目创建时间
	 **/
	@ApiModelProperty(value = "项目创建时间")
	@JsonProperty("createtime")
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("attachments")
	public List<Attachments> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}

	/**
	 * 项目描述
	 **/
	@ApiModelProperty(value = "项目描述")
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
   **/
	@ApiModelProperty(value = "")
	@JsonProperty("offer")
	public List<Offer> getOffer() {
		return offer;
	}

	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Project project = (Project) o;
		return Objects.equals(group, project.group)
				&& Objects.equals(oid, project.oid)
				&& Objects.equals(name, project.name)
				&& Objects.equals(image, project.image)
				&& Objects.equals(py, project.py)
				&& Objects.equals(progress, project.progress)
				&& Objects.equals(status, project.status)
				&& Objects.equals(location, project.location)
				&& Objects.equals(totalmoney, project.totalmoney)
				&& Objects.equals(clientmanager, project.clientmanager)
				&& Objects.equals(prepareplantime, project.prepareplantime)
				&& Objects.equals(preparetime, project.preparetime)
				&& Objects.equals(startplantime, project.startplantime)
				&& Objects.equals(starttime, project.starttime)
				&& Objects.equals(leaveplantime, project.leaveplantime)
				&& Objects.equals(leavetime, project.leavetime)
				&& Objects.equals(advancepayment, project.advancepayment)
				&& Objects.equals(advancepaymenttime,
						project.advancepaymenttime)
				&& Objects.equals(finalpayment, project.finalpayment)
				&& Objects.equals(finalpayplantime, project.finalpayplantime)
				&& Objects.equals(finalpaytime, project.finalpaytime)
				&& Objects.equals(debt, project.debt)
				&& Objects.equals(createtime, project.createtime)
				&& Objects.equals(attachments, project.attachments)
				&& Objects.equals(description, project.description)
				&& Objects.equals(offer, project.offer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(group, oid, name, image, py, progress, status,
				location, totalmoney, clientmanager, prepareplantime,
				preparetime, startplantime, starttime, leaveplantime,
				leavetime, advancepayment, advancepaymenttime, finalpayment,
				finalpayplantime, finalpaytime, debt, createtime, attachments,
				description, offer);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Project {\n");

		sb.append("  group: ").append(group).append("\n");
		sb.append("  oid: ").append(oid).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  image: ").append(image).append("\n");
		sb.append("  py: ").append(py).append("\n");
		sb.append("  progress: ").append(progress).append("\n");
		sb.append("  status: ").append(status).append("\n");
		sb.append("  location: ").append(location).append("\n");
		sb.append("  totalmoney: ").append(totalmoney).append("\n");
		sb.append("  clientmanager: ").append(clientmanager).append("\n");
		sb.append("  prepareplantime: ").append(prepareplantime).append("\n");
		sb.append("  preparetime: ").append(preparetime).append("\n");
		sb.append("  startplantime: ").append(startplantime).append("\n");
		sb.append("  starttime: ").append(starttime).append("\n");
		sb.append("  leaveplantime: ").append(leaveplantime).append("\n");
		sb.append("  leavetime: ").append(leavetime).append("\n");
		sb.append("  advancepayment: ").append(advancepayment).append("\n");
		sb.append("  advancepaymenttime: ").append(advancepaymenttime)
				.append("\n");
		sb.append("  finalpayment: ").append(finalpayment).append("\n");
		sb.append("  finalpayplantime: ").append(finalpayplantime).append("\n");
		sb.append("  finalpaytime: ").append(finalpaytime).append("\n");
		sb.append("  debt: ").append(debt).append("\n");
		sb.append("  createtime: ").append(createtime).append("\n");
		sb.append("  attachments: ").append(attachments).append("\n");
		sb.append("  description: ").append(description).append("\n");
		sb.append("  offer: ").append(offer).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
