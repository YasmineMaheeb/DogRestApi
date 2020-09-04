package com.udacity.DogRestApi;

import com.udacity.DogRestApi.controller.DogController;
import com.udacity.DogRestApi.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DogService dogService;


    @Test
    public void getAllBreeds() throws Exception {
        mockMvc.perform(get("/breeds").with(httpBasic("admin","password")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogBreeds();
    }

    @Test
    public void getBreed() throws Exception {
        mockMvc.perform(get("/breed/1").with(httpBasic("admin","password")))
                .andExpect(status().isOk());

        verify(dogService, times(1)).retrieveDogBreedById(1l);
    }

}
