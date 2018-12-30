package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private CountryService countryService;

    @Inject
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<DemoResponseBody> getAllCountry(@RequestParam(name = "limit", defaultValue = "10") String limit,
                                                          @RequestParam(name = "skip", defaultValue = "0") String skip)
            throws IOException {
        int count = countryService.getCountCountries();
        Pagination pagination = new Pagination();
        pagination.setLimit(Integer.valueOf(limit));
        pagination.setSkip(Integer.valueOf(skip));
        pagination.setCount(count);

        List<CountryEntity> countryEntities =
                countryService.getListCountries(Integer.valueOf(limit), Integer.valueOf(skip));

        return new ResponseEntity<>(
                DemoResponseBody.builder()
                        .status(new MessageInfo(DemoResponseStatus.MESSAGE_FOUND))
                        .data(new CountryListInfo(countryEntities))
                        .pagination(pagination)
                        .build(),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{countryCode}", method = RequestMethod.GET)
    public ResponseEntity<DemoResponseBody> getCitiesByCode(@PathVariable String countryCode,
                                                            @RequestParam(name = "limit", defaultValue = "10") String limit,
                                                            @RequestParam(name = "skip", defaultValue = "0") String skip) {
        int count = countryService.getCountCities(countryCode);
        Pagination pagination = new Pagination();
        pagination.setLimit(Integer.valueOf(limit));
        pagination.setSkip(Integer.valueOf(skip));
        pagination.setCount(count);

        List<CityEntity> cityEntities =
                countryService.getListCities(countryCode, Integer.valueOf(limit), Integer.valueOf(skip));

        return new ResponseEntity<>(
                DemoResponseBody.builder()
                        .status(new MessageInfo(DemoResponseStatus.MESSAGE_FOUND))
                        .data(new CityListInfo(cityEntities))
                        .pagination(pagination)
                        .build(),
                HttpStatus.OK);
    }
}

