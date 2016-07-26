package cc.zhanyun.service.model.project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T02:04:53.655Z")
public class Attachments  {
  
  private String name = null;
  private String img = null;
  private String oid = null;

  /**
   * 图片名称
   **/
  @ApiModelProperty(value = "图片名称")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 图片路径
   **/
  @ApiModelProperty(value = "图片路径")
  @JsonProperty("img")
  public String getImg() {
    return img;
  }
  public void setImg(String img) {
    this.img = img;
  }

  /**
   * 图片ID
   **/
  @ApiModelProperty(value = "图片ID")
  @JsonProperty("oid")
  public String getOid() {
    return oid;
  }
  public void setOid(String oid) {
    this.oid = oid;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachments attachments = (Attachments) o;
    return Objects.equals(name, attachments.name) &&
        Objects.equals(img, attachments.img) &&
        Objects.equals(oid, attachments.oid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, img, oid);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachments {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  img: ").append(img).append("\n");
    sb.append("  oid: ").append(oid).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
