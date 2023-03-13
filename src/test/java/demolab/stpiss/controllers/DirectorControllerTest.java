package demolab.stpiss.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import demolab.stpiss.models.Person;
import demolab.stpiss.repo.orderRepo;
import demolab.stpiss.repo.personRepo;
import demolab.stpiss.services.EmployeeServices;
import demolab.stpiss.types.ChangePassTemplate;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DirectorControllerTest {

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
        mockMvc.perform(get("/director"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void contacts() throws Exception {

        Person p1 = new Person(3, "Vova", "Khreb", "4123434","v","v",0);
        Person p2 = new Person(4, "Vova", "Khreb", "4123434","v","v",0);
        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(p1, p2));
        mockMvc.perform(
                        get("/dev/contacts"))
                .andDo(print())
                .andExpect(status().isOk());


    }
    @Test
    void changepass() throws Exception {
        Person p1 = new Person(3, "Vova", "Khreb", "4123434","v","v",0);
        Person p2 = new Person(4, "Vova", "Khreb", "4123434","v","v",0);
        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(p1, p2));
        ChangePassTemplate devOrder = new ChangePassTemplate(3L, "k");

        mockMvc.perform(post("/mark/changepass")
                        .content(objectMapper.writeValueAsString(devOrder))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(2)))
    }
    @Test
    void deleteEmploee() throws Exception {
        Person emp = new Person(3, "Vova", "Khreb", "4123434","v","v",0);
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.of(emp));
        mockMvc.perform(
                        delete("/director/employee/remove/3"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
