/*
 * Copyright (c) 2017, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.javacore.xml2json.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * @author HeWenlang
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ZmxyResponse")
public class ZmWatchListResponse implements Serializable {
    private static final long serialVersionUID = 6442215143444381436L;

    @XmlElement(name = "biz_no")
    @JsonProperty("biz_no")
    private String bizNo;

    @XmlElement(name = "ZhiMaWatchListDetail")
    @JsonProperty("details")
    private List<ZmWatchListDetail> details;

    @XmlElement(name = "is_matched")
    @JsonProperty("is_matched")
    private Boolean isMatched;

    private boolean success;
    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("error_message")
    private String errorMessage;

    private String body;

    private Map<String, String> params;
}
