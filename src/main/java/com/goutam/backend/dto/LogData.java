package com.goutam.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class LogData {
    private Map<String,String> data;
}


