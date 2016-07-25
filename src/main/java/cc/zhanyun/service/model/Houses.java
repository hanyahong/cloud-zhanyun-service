package cc.zhanyun.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T02:04:53.655Z")
public class Houses  {
  
  private String name = null;
  private String description = null;
  private List<HousesImages> image = new ArrayList<HousesImages>();

  /**
   * 房间名称
   **/
  @ApiModelProperty(value = "房间名称")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 房间详细信息
   **/
  @ApiModelProperty(value = "房间详细信息")
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
  @JsonProperty("image")
  public List<HousesImages> getImage() {
    return image;
  }
  public void setImage(List<HousesImages> image) {
    this.image = image;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Houses houses = (Houses) o;
    return Objects.equals(name, houses.name) &&
        Objects.equals(description, houses.description) &&
        Objects.equals(image, houses.image);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, image);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Houses {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  image: ").append(image).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
