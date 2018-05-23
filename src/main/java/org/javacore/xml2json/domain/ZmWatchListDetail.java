/*
 * Copyright (c) 2017, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.javacore.xml2json.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author HeWenlang
 */
@Getter
@Setter
@JsonRootName("zm_watch_list_detail")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ZhiMaWatchListDetail")
public class ZmWatchListDetail implements Serializable {
    private static final long serialVersionUID = 3767635028820859727L;
    @XmlElement(name = "biz_code")
    @JsonProperty("biz_code")
    private String bizCode;

    @XmlElement(name = "code_code")
    @JsonProperty("code")
    private String code;

    @XmlElement(name = "extend_info")
    @JsonProperty("extend_info")
    private List<ZmWatchListExtendInfo> extendInfo;

    @JsonProperty("level")
    private Long level;

    @JsonProperty("refresh_time")
    private String refreshTime;

    @JsonProperty("settlement")
    private Boolean settlement;

    @JsonProperty("statement")
    private String statement;

    @JsonProperty("status")
    private String status;

    @JsonProperty("type")
    private String type;

    public ZmWatchListDetail(){}
    public ZmWatchListDetail(String bizCode, String code, List extendInfo, Long level, String refreshTime, Boolean settlement, String statement, String status, String type) {
        this.bizCode = bizCode;
        this.code = code;
        this.extendInfo = extendInfo;
        this.level = level;
        this.refreshTime = refreshTime;
        this.settlement = settlement;
        this.statement = statement;
        this.status = status;
        this.type = type;
    }
}
