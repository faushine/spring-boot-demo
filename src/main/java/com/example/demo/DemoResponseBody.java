package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoResponseBody {
    private MessageInfo status;
    private Pagination pagination;
    private DataInfo data;
}
