/*
 * Copyright (c) 2017, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.javacore.xml2json.domain;

import lombok.Getter;
import lombok.Setter;
import org.javacore.xml2json.domain.ZmWatchDetailXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author HeWenlang
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ZmxyResponse")
public class ZmWatchXml implements Serializable {
    private static final long serialVersionUID = 1625952816699475799L;

    @XmlElement(name = "ZhiMaWatchList")
    private ZmWatchDetailXml zmWatchList;
}
