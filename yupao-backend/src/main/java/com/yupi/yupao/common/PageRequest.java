package com.yupi.yupao.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页通用类
 */
@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 5035829946869709492L;
    /**
     * 页面大小
     */
    private int pageSize=10;
    /**
     * 当前是第几页
     */
    private int pageNum=1;
}
