package com.qdsg.his.domain;

import java.lang.annotation.*;

/**
 * @Author zhouligang
 * @Date 2023/3/6 10:37
 * @Desc 实体聚合根
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface AggregateRoot {
}
