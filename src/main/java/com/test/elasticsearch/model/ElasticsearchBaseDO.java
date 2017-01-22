package com.test.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * author: JinBingBing
 * description: elasticsearch 基类
 * time: 2017/1/18 16:47.
 */
public class ElasticsearchBaseDO implements Serializable{

    private static final long serialVersionUID = -5518013256639387814L;

    /**
     * 主键
     */
    @Id
    @Field(type = FieldType.String)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
