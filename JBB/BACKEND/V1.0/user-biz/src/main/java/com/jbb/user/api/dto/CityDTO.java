package com.jbb.user.api.dto;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/3.
 */
public class CityDTO  implements Serializable {


    private int id;

    private String name;

    private int deep;

    private int parentId;

    private double lon;

    private double lat;

    @ApiModelProperty(value = "城市码")
    public int getId() {
        return id;
    }

    @ApiModelProperty(value = "城市码")
    public void setId(int id) {
        this.id = id;
    }

    @ApiModelProperty(value = "城市名")
    public String getName() {
        return name;
    }

    @ApiModelProperty(value = "城市名")
    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(value = "深度，1：省会 2：市 3：区或县")
    public int getDeep() {
        return deep;
    }

    @ApiModelProperty(value = "深度，1：省会 2：市 3：区或县")
    public void setDeep(int deep) {
        this.deep = deep;
    }

    @ApiModelProperty(value = "上级城市的编码")
    public int getParentId() {
        return parentId;
    }

    @ApiModelProperty(value = "上级城市的编码")
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @ApiModelProperty(value = "纬度")
    public double getLon() {
        return lon;
    }

    @ApiModelProperty(value = "纬度")
    public void setLon(double lon) {
        this.lon = lon;
    }

    @ApiModelProperty(value = "经度")
    public double getLat() {
        return lat;
    }
    @ApiModelProperty(value = "经度")
    public void setLat(double lat) {
        this.lat = lat;
    }
}
