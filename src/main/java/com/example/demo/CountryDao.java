package com.example.demo;

import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CountryDao {
    ;

    String countrySelect = "SELECT " +
            " * " +
            " FROM " +
            " country ";

    @Select(countrySelect + " ORDER BY Code ASC, 1 DESC LIMIT #{limit} OFFSET #{skip}")
    List<CountryEntity> getAllCountry(@Param("limit") int limit, @Param("skip") int skip);


    @Select("SELECT " +
            " count(*) " +
            "FROM " +
            " country ")
    int countCountryResult();


    String citySelect =
            "SELECT " +
                    " * " +
                    "FROM " +
                    " city " +
                    "WHERE ";

    @Select(citySelect + " CountryCode=#{countryCode}" + " ORDER BY ID ASC, 1 DESC LIMIT #{limit} OFFSET #{skip}")
    List<CityEntity> getAllCity(@Param("countryCode") String countryCode, @Param("limit") int limit, @Param("skip") int skip);

    String cityCount = "SELECT " +
            " count(*) " +
            " FROM " +
            " city WHERE ";
    @Select(cityCount + " CountryCode=#{countryCode}")
    int countCityResult(@Param("countryCode") String countryCode);
}
