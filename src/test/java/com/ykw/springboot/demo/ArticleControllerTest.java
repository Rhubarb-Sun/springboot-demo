package com.ykw.springboot.demo;

import com.ykw.springboot.demo.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/**
 * @author: sunxun
 * @date: 12/27/22 10:35 AM
 * @description: 启动Servlet容器进行测试，仅限Controller，不支持注入其他层。
 */

@Slf4j
public class ArticleControllerTest {

    private static MockMvc mockMvc;

    @BeforeAll
    static void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    @Test
    public void getArticle() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.GET, "/articles/1")
                        .contentType("application/json")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("J. K. Rowling"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value("1"))
                .andDo(print())
                .andReturn();

        log.info(mvcResult.getResponse().getContentAsString());
    }
}
