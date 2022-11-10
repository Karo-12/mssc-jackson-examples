package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest {
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);

        assertNotNull(jsonString);

    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"54a37641-4f64-4f19-9d0d-afc659b2acb0\",\"beerName\":\"Beer name\",\"beerStyle\":\"ALE\",\"upc\"" +
                ":57587586868798,\"price\":12.99,\"createdDate\":\"2022-11-10T14:40:38.3264356+01:00\",\"lastUpdatedDate\":\"2022-11" +
                "-10T14:40:38.3274388+01:00\"}\n";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }

}