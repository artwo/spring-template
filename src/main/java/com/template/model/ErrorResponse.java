package com.template.model;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.*;
import lombok.*;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@ApiModel("Error")
public class ErrorResponse {

    @ApiModelProperty(value = "HTTP status code of the response.", example = "500")
    private final int code;

    @ApiModelProperty(
            value = "Human friendly description of the error.",
            example = "An unexpected error occurred.")
    private final String message;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private final String exceptionMessage;
}
