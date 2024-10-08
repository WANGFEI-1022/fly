package com.wf.imaotai.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Data
public class User implements Serializable{
    private Long userId;
    private String mobile;
    private String name;
    private String token;
    private String cookie;
    private String deviceId;
    private String shopId;
    private String itemCode;
    private String provinceName;
    private String cityName;
    private String address;
    private String jsonResult;
    private String remark;
    private Date randomMinute;
    private Date delFlag;
    private Date expireTime;
    private Date updateTime;
    private Date createTime;
    /**
     * 类型(1：预约本市出货量最大的门店，2：预约你的位置附近门店)
     */
    private int shopType;

    //
    private String lat;
    private String lng;
    private String code;

    public User() {

    }
    public User(String mobile, JSONObject jsonObject) {
        JSONObject data = jsonObject.getJSONObject("data");
        this.userId = data.getLong("userId");
        this.mobile = mobile;
        this.token = data.getString("token");
        this.cookie = data.getString("cookie");
        this.jsonResult = StringUtils.substring(jsonObject.toJSONString(), 0, 2000);

        if (StringUtils.isEmpty(this.remark)) {
            this.remark = data.getString("userName");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date thirtyDaysLater = calendar.getTime();
        this.expireTime = thirtyDaysLater;
    }

    public User(String mobile, String deviceId, JSONObject jsonObject) {
        JSONObject data = jsonObject.getJSONObject("data");
        this.userId = data.getLong("userId");
        this.mobile = mobile;
        this.token = data.getString("token");
        this.cookie = data.getString("cookie");
        this.deviceId = deviceId.toLowerCase();
        this.jsonResult = StringUtils.substring(jsonObject.toJSONString(), 0, 2000);

        if (StringUtils.isEmpty(this.remark)) {
            this.remark = data.getString("userName");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date thirtyDaysLater = calendar.getTime();
        this.expireTime = thirtyDaysLater;
    }

}
