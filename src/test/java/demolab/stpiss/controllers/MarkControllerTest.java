package demolab.stpiss.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import demolab.stpiss.models.Person;
import demolab.stpiss.repo.orderRepo;
import demolab.stpiss.repo.personRepo;
import demolab.stpiss.services.EmployeeServices;
import demolab.stpiss.types.ChangePassTemplate;
import demolab.stpiss.types.DevOrderTemplate;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MarkControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private orderRepo repo;
    @MockBean
    private personRepo repoper;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServices emploeeService;

    @Test
    void init() throws Exception {
        mockMvc.perform(get("/mark"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void contacts() throws Exception {

        Person p1 = new Person(3, "Vova", "Khreb", "4123434","v","v",0);
        Person p2 = new Person(4, "Vova", "Khreb", "4123434","v","v",0);
        Mockito.when(repoper.findAll()).thenReturn(Arrays.asList(p1, p2));
        mockMvc.perform(
                        get("/dev/contacts"))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    void OrderDev() throws Exception {

        DevOrderTemplate devOrder = new DevOrderTemplate(1L, 1L);

        mockMvc.perform(post("/mark/orderdev")
                        .content(objectMapper.writeValueAsString(devOrder))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(2)))

    }
    @Test
    void changepass() throws Exception {
        Person p1 = new Person(3, "Vova", "Khreb", "4123434","v","v",0);
        Person p2 = new Person(4, "Vova", "Khreb", "4123434","v","v",0);
        Mockito.when(repoper.findAll()).thenReturn(Arrays.asList(p1, p2));
        ChangePassTemplate devOrder = new ChangePassTemplate(3L, "k");

        mockMvc.perform(post("/mark/changepass")
                        .content(objectMapper.writeValueAsString(devOrder))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(2)))
    }
}
