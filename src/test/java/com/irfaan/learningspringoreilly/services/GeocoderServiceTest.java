
package com.irfaan.learningspringoreilly.services;

import com.irfaan.learningspringoreilly.json.Site;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: GeocoderServiceTest.java, v 0.1 2021‐12‐17 15.50 Ahmad Irfaan Hibatullah Exp $$
 */

@SpringBootTest
public class GeocoderServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeocoderServiceTest.class);

    @Autowired
    private GeocoderService geocoderService;

    @Test
    void getLatLngWithoutStreet() {
        Site site = geocoderService.getLatLong("Boston", "MA");
        LOGGER.info(site.toString());
        assertAll(
                () -> assertEquals(42.36, site.getLatitude(), 0.01),
                () -> assertEquals(-71.06, site.getLongitude(), 0.01)
        );
    }

    /**
     * Karena response JSON format mennggunakan snake case sedangkan yang kita gunakan adalah camelCase
     * maka di application.properties dapat dilakukan pengaturan format yang diinginkan dengan mendefinisikan
     * format JSON yang diterima seperti apa, di Spring Web menggunakan library Jackson untuk serializer dan
     * deserializer JSON ke POJO ataupun sebaliknyna
     */
    @Test
    void getLatLngWithStreet() {
        Site site = geocoderService.getLatLong("1600 Ampitheatre Parkway", "Mountain View", "CA");
        LOGGER.info(site.toString());
        assertAll(
                () -> assertEquals(37.42, site.getLatitude(), 0.01),
                () -> assertEquals(-122.09, site.getLongitude(), 0.01)
        );
    }
}