package com.template.controller;

import com.template.model.*;
import io.swagger.annotations.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Demo")
@RestController
@RequestMapping(value = {"/${api.basepath}/"})
public class DemoController {

    @ApiOperation(value = "Greets!", response = SuccessResponse.class)
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = SuccessResponse.class)})
    @GetMapping(value = "/demo", produces = "application/json")
    public SuccessResponse greeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return new SuccessResponse("Hello " + name);
    }

    @ApiOperation(value = "Creates a Ticket.", response = SuccessResponse.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK", response = SuccessResponse.class),
        @ApiResponse(code = 400, message = "Bad request", response = ErrorResponse.class)
    })
    @PostMapping(value = "/ticket", produces = "application/json")
    public ResponseEntity<SuccessResponse> createTicket(
            @ApiParam(required = true) @RequestBody Ticket ticket) {
        ticket.checkValidityAndThrow();
        return new ResponseEntity<>(
                new SuccessResponse("Ticket created successfully"), HttpStatus.CREATED);
    }
}
