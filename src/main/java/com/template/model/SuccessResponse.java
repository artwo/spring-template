package com.template.model;

import io.swagger.annotations.*;
import lombok.*;

@Data
@ApiModel
@AllArgsConstructor
public class SuccessResponse {
    String message;
}
