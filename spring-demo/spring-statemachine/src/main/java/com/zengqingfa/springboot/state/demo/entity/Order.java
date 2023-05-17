package com.zengqingfa.springboot.state.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: slfx
 * @Date: 2022-10-02
 * @Description:
 **/
@Data
@ApiModel(value = "Order对象", description = "订单表")
//mysql关于order不能当表名的问题:order是mysql的保留字，是不能作为数据表的表名
@TableName("tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单编码")
    private String orderCode;

    @ApiModelProperty("订单状态")
    private Integer status;

    @ApiModelProperty("订单名称")
    private String name;

    @ApiModelProperty("订单价格")
    private BigDecimal price;

    @ApiModelProperty("删除标记，0未删除  1已删除")
    private Integer deleteFlag;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("创建人")
    private String createUserCode;

    @ApiModelProperty("更新人")
    private String updateUserCode;

    @ApiModelProperty("版本号")
    private Integer version;

    @ApiModelProperty("备注")
    private String remark;


}
