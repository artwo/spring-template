package com.template.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import io.swagger.annotations.*;
import io.swagger.annotations.ApiModelProperty.*;
import lombok.*;

@Data
@ApiModel(description = "This is a demo model of the API.")
@JsonInclude(Include.NON_EMPTY)
public class Ticket {
    @ApiModelProperty(accessMode = AccessMode.READ_ONLY, required = false)
    private final String id;

    @ApiModelProperty(required = true)
    private final String name;

    @ApiModelProperty(required = false)
    private final String content;

    @ApiModelProperty(required = false)
    private final String state;

    public void checkValidityAndThrow() {
        if (name == null || name.isEmpty()) {
            throw new TicketMalformedException("The name field of ticket is empty or invalid.");
        }
    }
}
