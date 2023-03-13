package demolab.stpiss.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import demolab.stpiss.models.Person;
import demolab.stpiss.repo.personRepo;
import demolab.stpiss.services.EmployeeServices;
import demolab.stpiss.types.loginTemplate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private personRepo repo;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServices emploeeService;

    @Test
    void init() throws Exception {
        mockMvc.perform(get("/SignIn"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void login() throws Exception {
        loginTemplate lT = new loginTemplate();
        lT.login = "v";
        lT.password = "v";

        when(repo.findAll()).thenReturn(Arrays.asList(
                new Person(3, "Vova", "Khreb", "4123434","v","v",0),
                new Person(4, "Katya", "Rebr", "4543534","c","c",0)
        ));


        mockMvc.perform(post("/SignIn/enter")
                        .content(objectMapper.writeValueAsString(lT))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(2)))

    }

}
