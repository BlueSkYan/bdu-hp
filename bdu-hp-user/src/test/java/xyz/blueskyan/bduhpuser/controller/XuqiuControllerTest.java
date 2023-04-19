package xyz.blueskyan.bduhpuser.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


/**
 * @author Shijie Yan
 * @date 2023/3/17
 */
@SpringBootTest
@AutoConfigureMockMvc
class XuqiuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void save() {
    }

    @Test
    void list() throws Exception {
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/xuqiu/list"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @Test
    void getMySaved() {
    }

    @Test
    void getMySolved() {
    }

    @Test
    void goHelp() {
    }

    @Test
    void toDel() {
    }

    @Test
    void update() {
    }
}