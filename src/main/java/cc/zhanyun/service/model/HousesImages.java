package cc.zhanyun.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T02:04:53.655Z")
public class HousesImages  {
  
  private String bimgurl = null;
  private String simgurl = null;

  /**
   * 原始图片路径
   **/
  @ApiModelProperty(value = "原始图片路径")
  @JsonProperty("bimgurl")
  public String getBimgurl() {
    return bimgurl;
  }
  public void setBimgurl(String bimgurl) {
    this.bimgurl = bimgurl;
  }

  /**
   * 缩影图片路径
   **/
  @ApiModelProperty(value = "缩影图片路径")
  @JsonProperty("simgurl")
  public String getSimgurl() {
    return simgurl;
  }
  public void setSimgurl(String simgurl) {
    this.simgurl = simgurl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HousesImages housesImages = (HousesImages) o;
    return Objects.equals(bimgurl, housesImages.bimgurl) &&
        Objects.equals(simgurl, housesImages.simgurl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bimgurl, simgurl);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class HousesImages {\n");
    
    sb.append("  bimgurl: ").append(bimgurl).append("\n");
    sb.append("  simgurl: ").append(simgurl).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
