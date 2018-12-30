package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceConfig {
    private String url;
    private String userName;
    private String password;
    private String driver;
    private int maxPoolSize;
}
