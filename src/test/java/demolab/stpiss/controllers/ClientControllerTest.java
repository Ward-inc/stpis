package demolab.stpiss.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import demolab.stpiss.models.Order;
import demolab.stpiss.repo.orderRepo;
import demolab.stpiss.repo.personRepo;
import demolab.stpiss.services.EmployeeServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private orderRepo repo;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServices emploeeService;

    @Test
    void init() throws Exception {
        mockMvc.perform(get("/client"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void makeOrder() throws Exception {
        Order p1 = new Order("Сайт",3000, "Java","Не готов");
        Mockito.when(repo.save(Mockito.any())).thenReturn(p1);
        mockMvc.perform(
                        post("/client/makeorder")
                                .content(objectMapper.writeValueAsString(p1))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());

    }

}
