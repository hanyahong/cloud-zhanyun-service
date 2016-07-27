package cc.zhanyun.service.model.offer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T06:37:51.280Z")
public class Resourcetypes {
	@Id
	private String name = null;
	private List<Selectedresources> selectedresources = new ArrayList<Selectedresources>();
	private Boolean enabled = null;

	/**
	 * 设备类别名称
	 **/
	@ApiModelProperty(value = "设备类别名称")
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
	@JsonProperty("selectedresources")
	public List<Selectedresources> getSelectedresources() {
		return selectedresources;
	}

	public void setSelectedresources(List<Selectedresources> selectedresources) {
		this.selectedresources = selectedresources;
	}

	/**
	 * 此资设备类别是否启用
	 **/
	@ApiModelProperty(value = "此资设备类别是否启用")
	@JsonProperty("enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Resourcetypes resourcetypes = (Resourcetypes) o;
		return Objects.equals(name, resourcetypes.name)
				&& Objects.equals(selectedresources,
						resourcetypes.selectedresources)
				&& Objects.equals(enabled, resourcetypes.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, selectedresources, enabled);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Resourcetypes {\n");

		sb.append("  name: ").append(name).append("\n");
		sb.append("  selectedresources: ").append(selectedresources)
				.append("\n");
		sb.append("  enabled: ").append(enabled).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
