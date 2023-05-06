package com.yupi.yupao.model.vo;

import com.yupi.yupao.model.domain.Im;
import lombok.Data;

/**
 * @author LYC
 */
@Data
public class ImMessageVo {

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 消息
     */
    private Im im;

}
