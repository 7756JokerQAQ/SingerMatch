package com.yupi.yupao.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除通用类
 */
@Data
public class DeleteRequest implements Serializable {


    private static final long serialVersionUID = -6739269185332694902L;

    private long id;
}
