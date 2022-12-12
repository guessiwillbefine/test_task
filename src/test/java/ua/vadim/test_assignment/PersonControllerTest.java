package ua.vadim.test_assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {
    @Autowired
    private MockMvc mock;

    @Test
    void testWithValidId() throws Exception {
        int usersAmount = 7;
        for (int i = 1; i < usersAmount; i++) {
            mock.perform(get("/users/" + i)).andExpect(status().isOk());
        }
    }

    @Test
    void testWithInvalidId() throws Exception {
        mock.perform(get("/users/someTrash")).andExpect(status().isBadRequest());
        mock.perform(get("/users/-1")).andExpect(status().isNotFound());

    }
}
