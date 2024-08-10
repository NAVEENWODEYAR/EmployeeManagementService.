package com.departmentservice.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value("${spring.boot.message}")
    private String message;

    @ApiOperation(value = "Get employees by department")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentId", value = "ID of the department", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "includeInactive", value = "Whether to include inactive employees", required = false, dataType = "boolean", paramType = "query")
    })
    @GetMapping("/message")
    public String getMessage(){
        return message;
    }
}
