package com.example.donutassessment;


import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DonutTest {
    @Test
    void manualDonutTest() throws ParseException {
        String stringDate = "2022-04-08";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        Donut donut1 = new Donut();
        donut1.setId(1L);
        donut1.setName("a");
        donut1.setTopping("sprinkle");
        donut1.setExpiration(date);
        Donut donut2 = new Donut(2L, "b", "marsh", date);
        Donut donut3 = new Donut("c", "love", date);
        donut3.setId(3L);

        assertEquals("a", donut1.getName());
        assertEquals("b", donut2.getName());
        assertEquals("c", donut3.getName());
        assertEquals(1L, donut1.getId());
        assertEquals(2L, donut2.getId());
        assertEquals(3L, donut3.getId());
        assertEquals("sprinkle", donut1.getTopping());
        assertEquals("marsh", donut2.getTopping());
        assertEquals("love", donut3.getTopping());
        assertEquals(date, donut1.getExpiration());
        assertEquals(date, donut2.getExpiration());
        assertEquals(date, donut3.getExpiration());
    }
}
