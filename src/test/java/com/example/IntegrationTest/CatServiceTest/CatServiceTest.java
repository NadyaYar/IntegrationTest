package com.example.IntegrationTest.CatServiceTest;

import com.example.IntegrationTest.cat.model.Cat;
import com.example.IntegrationTest.cat.service.impl.CatServiceImpl;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@WireMockTest(httpPort = 8080)
@TestPropertySource(properties = "cat.url=http://localhost:8080")
public class CatServiceTest {

    @Autowired
    private CatServiceImpl catService;

    @Test
    void testCatService(WireMockRuntimeInfo runtimeInfo) {
        Cat actualCat = new Cat();
        actualCat.setFact("In the original Italian version of Cinderella," +
                " the benevolent fairy godmother figure was a cat.");
        actualCat.setLength(95);

        stubFor(get("/").willReturn(jsonResponse(actualCat, HttpStatus.OK.value())));

        Cat expectedCat = catService.getFact();
        assertEquals(actualCat, expectedCat);
    }
}
