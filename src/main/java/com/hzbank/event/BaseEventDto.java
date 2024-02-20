package com.hzbank.event;

import java.io.Serializable;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2024/2/1 10:29
 * @Description: BaseEventDto
 * @Version 1.0.0
 */
public class BaseEventDto implements Serializable {
    private static final long serialVersionUID = -1;
    /**
     * 判断交易是否重复
     */
    private Boolean isDuplicate;

    public Boolean getDuplicate() {
        return isDuplicate;
    }

    public void setDuplicate(Boolean duplicate) {
        isDuplicate = duplicate;
    }
}
