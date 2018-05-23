/*
 * Copyright (c) 2017, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.javacore.xml2json.domain;

import lombok.Getter;
import lombok.Setter;
import org.javacore.xml2json.domain.ZhiMaWatchListDetailXml;

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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ZhiMaWatchList")
public class ZmWatchDetailXml implements Serializable {
    private static final long serialVersionUID = -2412112527260495911L;

    @XmlElement(name = "biz_no")
    private String bizNo;

    @XmlElement(name = "is_matched")
    private String isMatched;

    @XmlElement(name = "ZhiMaWatchListDetail")
    private List<ZhiMaWatchListDetailXml> zhiMaWatchListDetails;
}
