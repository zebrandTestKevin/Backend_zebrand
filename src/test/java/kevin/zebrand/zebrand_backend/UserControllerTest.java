package kevin.zebrand.zebrand_backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import kevin.zebrand.zebrand_backend.controller.UserController;
import kevin.zebrand.zebrand_backend.dao.UserDao;
import kevin.zebrand.zebrand_backend.model.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    UserDao userDao;

    User RECORD_1 = new User();
    User RECORD_2 = new User();
    User RECORD_3 = new User();

    @Test
    public void getAllAdmins_success() throws Exception {
        List<User> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(userDao.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));
    }

    @Test
    public void postAdmins_success() throws Exception {
        User newAdmin=new User();
        newAdmin.setMail("perra@gmail.com");
        newAdmin.setAdminId(12);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(newAdmin );

        Mockito.when(userDao.save(Mockito.any(User.class))).thenReturn(newAdmin);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/user").content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mail", Matchers.is("perra@gmail.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.adminId", Matchers.is(12)));
    }

}
