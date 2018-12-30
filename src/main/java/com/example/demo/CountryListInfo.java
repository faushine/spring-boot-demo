package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class CountryListInfo implements DataInfo {
    private List<CountryEntity> countryEntityList;
}
