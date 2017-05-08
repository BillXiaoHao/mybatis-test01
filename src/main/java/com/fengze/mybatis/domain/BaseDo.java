package com.fengze.mybatis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/4.
 */
@Data
public class BaseDo implements Serializable {
    private String state;//是否可用(状态)
    private String createBy;//创建人
    private String createDate;//创建时间
    private String updateBy;//更新人
    private String updateDate;//更新时间
}
