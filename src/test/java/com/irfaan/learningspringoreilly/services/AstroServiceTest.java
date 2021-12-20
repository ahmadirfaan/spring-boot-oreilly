
package com.irfaan.learningspringoreilly.services;

import com.irfaan.learningspringoreilly.json.AstroResult;
import com.irfaan.learningspringoreilly.json.Astronauts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: AstroServiceTest.java, v 0.1 2021‐12‐17 14.08 Ahmad Irfaan Hibatullah Exp $$
 */

@SpringBootTest
public class AstroServiceTest {

    @Autowired
    private AstroService astroService;

    @Test
    void getAstronautService() {
        AstroResult astroResult = astroService.getAstronauts();
        int number = astroResult.getNumber();
        System.out.println("There are : " + number + " people in space");
        List<Astronauts> astronautsList = astroResult.getPeople();
        astronautsList.forEach(System.out::println);
        assertAll(
                () -> assertTrue(number >= 0),
                () -> assertEquals(number, astronautsList.size())
        );
    }

    /**
     * Testing method service yang menggunakan reactive programming
     * ini merupakan consume sebuah backend atau API yang lebih modern daripada menggunakan REST Template
     * karena dengan menggunakan webclient kita sedang menerapkan reactive programming (asynchronous program)
     * sehingga kita tidak perlu menunggu response balikan dari sebuah server seperti halnya Rest Template
     * yang masih menggunakan synchronous programming
     */
    @Test
    void getAstronautServiceWebClient() {
        AstroResult astroResult = astroService.getAstronautsWebClient();
        int number = astroResult.getNumber();
        System.out.println("There are : " + number + " people in space");
        List<Astronauts> astronautsList = astroResult.getPeople();
        astronautsList.forEach(System.out::println);
        assertAll(
                () -> assertTrue(number >= 0),
                () -> assertEquals(number, astronautsList.size())
        );
    }
}