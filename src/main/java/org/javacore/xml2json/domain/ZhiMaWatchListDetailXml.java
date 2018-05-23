/*
 * Copyright (c) 2017, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.javacore.xml2json.domain;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author lqh
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ZhiMaWatchListDetail")
public class ZhiMaWatchListDetailXml implements Serializable {
    private static final long serialVersionUID = 3767635028820859727L;

    @XmlElement(name = "biz_code")
    private String bizCode;
    @XmlElement(name = "code")
    private String code;
    @XmlElement(name = "ZmWatchListExtendInfo")
    private List<ZhiMaWatchListExtendInfoXml> zhiMaWatchListExtendInfos;
    @XmlElement(name = "level")
    private Long level;
    @XmlElement(name = "refreshTime")
    private String refreshTime;
    @XmlElement(name = "settlement")
    private String settlement;
    @XmlElement(name = "statement")
    private String statement;
    @XmlElement(name = "status")
    private String status;
    @XmlElement(name = "type")
    private String type;

}
