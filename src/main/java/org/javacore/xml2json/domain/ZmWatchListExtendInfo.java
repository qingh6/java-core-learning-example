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

/**
 * @author HeWenlang
 */
@Getter
@Setter
@JsonRootName("zm_watch_list_extend_info")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZmWatchListExtendInfo implements Serializable {
    private static final long serialVersionUID = 4288655341892862437L;

    @XmlElement(name = "key_des")
    @JsonProperty("description")
    private String description;

    @XmlElement(name = "key_ke")
    @JsonProperty("key")
    private String key;

    @XmlElement(name = "value_value")
    @JsonProperty("value")
    private String value;

}
