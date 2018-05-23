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

/**
 * @author lqh
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ZmWatchListExtendInfo")
public class ZhiMaWatchListExtendInfoXml implements Serializable {
    private static final long serialVersionUID = 4288655341892862437L;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "key")
    private String key;
    @XmlElement(name = "value")
    private String value;

}
