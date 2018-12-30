package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CityListInfo implements DataInfo{
    private List<CityEntity> cityEntities;
}
