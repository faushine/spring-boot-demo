package com.example.demo;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;

@Named
public class CountryService {
    private CountryDao countryDao;

    @Inject
    public CountryService(CountryDao countryDao){
        this.countryDao = countryDao;
    }

    public int getCountCountries(){
        int count = countryDao.countCountryResult();
        return count;
    }

    public int getCountCities(String countryId){
        int count = countryDao.countCityResult(countryId);
        return count;
    }

    public List<CountryEntity> getListCountries(Integer limit, Integer skip) throws IOException {
        List<CountryEntity> countryEntities = countryDao.getAllCountry(limit, skip);
        return countryEntities;
    }

    public List<CityEntity> getListCities(String countryId, Integer limit, Integer skip){
        List<CityEntity> cityEntities = countryDao.getAllCity(countryId,limit,skip);
        return cityEntities;
    }
}
