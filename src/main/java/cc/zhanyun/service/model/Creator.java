package cc.zhanyun.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-18T02:04:53.655Z")
public class Creator  {
  
  private String oid = null;
  private String name = null;

  /**
   * 创建者ID
   **/
  @ApiModelProperty(value = "创建者ID")
  @JsonProperty("oid")
  public String getOid() {
    return oid;
  }
  public void setOid(String oid) {
    this.oid = oid;
  }

  /**
   * 创建者姓�?   **/
  @ApiModelProperty(value = "创建者姓ID")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Creator creator = (Creator) o;
    return Objects.equals(oid, creator.oid) &&
        Objects.equals(name, creator.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oid, name);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Creator {\n");
    
    sb.append("  oid: ").append(oid).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
