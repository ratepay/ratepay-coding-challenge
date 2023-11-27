package com.ratepay.challenge.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    /*
     *TODO: Write controller test to handle the scenario when the buyer does not exist.
     * TODO: Write controller test to verify the save operation when the buyer already exists.
     * Ensure to cover both cases thoroughly.
     */

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHandleNonExistentBuyer() {
        // Your test code here
    }

    @Test
    public void testSaveOperationWithExistingBuyer() {
        // Your test code here
    }
}