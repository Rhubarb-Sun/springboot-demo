package com.ykw.springboot.demo;

import com.ykw.springboot.demo.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/**
 * @author: sunxun
 * @date: 12/27/22 10:35 AM
 * @description: 启动Servlet容器环境和Spring上下文进行测试。
 * 但速度较慢。
 */

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc // 构建Spring上下文
@ExtendWith(SpringExtension.class) //构建Spring运行时Servlet容器环境
public class ArticleControllerWithSpringTest {

    /*
    @AutoConfigureMockMvc
    有这个注解就可以自动装配
     */
    @Resource
    private MockMvc mockMvc;

//    @BeforeAll
//    static void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//    }

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
