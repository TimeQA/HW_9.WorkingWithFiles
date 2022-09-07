package com.example;

import com.example.domain.Squad;
import com.example.domain.SquadArrayWithObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonParse {

    ClassLoader classLoader = ReadingFilesFromTheArchive.class.getClassLoader();


    @DisplayName("Не понимаю в чем ошибка, почему с геттерами работает, а без нет")
    @Disabled
    @Test
    public void jsonTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = classLoader.getResourceAsStream("FileForTest.json");
        JsonObject jsonObject = mapper.readValue(new InputStreamReader(is), JsonObject.class);
        assertThat(jsonObject.get("squadName").getAsString()).isEqualTo("Super hero squad");
    }

    @DisplayName("С Map тоже работает...")
    @Test
    public void jsonTestWithHelpMap() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = classLoader.getResourceAsStream("FileForTest.json");
        Map<String, Object> jsonMap = mapper.readValue(new InputStreamReader(is), Map.class);
        assertThat(jsonMap.get("squadName")).isEqualTo("Super hero squad");
    }

    @Test
    public void jsonTestWithGetter() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = classLoader.getResourceAsStream("FileForTest2.json");
        Squad squad = mapper.readValue(new InputStreamReader(is), Squad.class);

        String[] powers = new String[]{"Radiation resistance", "Turning tiny", "Radiation blast"};
        assertThat(squad.getSquadName()).isEqualTo("Super hero squad");
        assertThat(squad.getHomeTown()).isEqualTo("Metro City");
        assertThat(squad.getFormed()).isEqualTo(2016);
        assertThat(squad.getSecretBase()).isEqualTo("Super tower");
        assertThat(squad.getActive()).isEqualTo(true);
        assertThat(squad.getPowers()).isEqualTo(powers);
    }
    @DisplayName("Пока не понимаю как сделать проверку с массивом из вложенных объектов")
    @Disabled
    @Test
    public void jsonTestWithGetterAndArrayWithObject() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = classLoader.getResourceAsStream("FileForTest.json");
        SquadArrayWithObject squadArrayWithObject = mapper.readValue(is, SquadArrayWithObject.class);

        assertThat(squadArrayWithObject.getSquadName()).isEqualTo("Super hero squad");
        assertThat(squadArrayWithObject.getHomeTown()).isEqualTo("Metro City");
        assertThat(squadArrayWithObject.getFormed()).isEqualTo(2016);
        assertThat(squadArrayWithObject.getSecretBase()).isEqualTo("Super tower");
        assertThat(squadArrayWithObject.getActive()).isEqualTo(true);
    }
}
