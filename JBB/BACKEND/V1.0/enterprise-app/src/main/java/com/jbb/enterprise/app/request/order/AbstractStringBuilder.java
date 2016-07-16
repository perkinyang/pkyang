/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.jbb.enterprise.app.request.order;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author yangxiangqian
 *
 */
public abstract class AbstractStringBuilder implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
