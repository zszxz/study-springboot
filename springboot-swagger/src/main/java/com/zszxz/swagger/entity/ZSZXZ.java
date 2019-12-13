package com.zszxz.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
@ApiModel(description = "用户知识追寻者实体")
public class ZSZXZ {

    @ApiModelProperty(value = "姓名",dataType = "String")
    private String name;
    @ApiModelProperty(value = "邮件",dataType = "String")
    private String email;
    @ApiModelProperty(value = "爱好",dataType = "String")
    private String hobby;
}
