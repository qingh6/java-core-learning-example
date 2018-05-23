/*
 * Copyright (c) 2017, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.javacore.xml2json.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author HeWenlang
 */
@Getter
@Setter
public class ZmBaseResponse implements Serializable {
    private static final long serialVersionUID = 4326162674611129564L;

    private boolean success;
    @JsonProperty("error_code")
    private String errorCode;
    @JsonProperty("error_message")
    private String errorMessage;
    private String body;
    private Map<String, String> params;
}
