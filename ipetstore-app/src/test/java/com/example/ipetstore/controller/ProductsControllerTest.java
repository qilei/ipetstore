package com.example.ipetstore.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.ipetstore.domain.product.ProductCatalog;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ProductsControllerTest {

  @Rule
  public MockitoRule rule = MockitoJUnit.rule();

  @InjectMocks
  private ProductsController productsController;

  @Mock
  private ProductCatalog productCatalog;

  private MockMvc mockMvc;

  @Before
  public void setup(){
    this.mockMvc = MockMvcBuilders.standaloneSetup(productsController).build();
  }

  @Test
  public void index() throws Exception {
    when(productCatalog.findByKeyword("dog")).thenReturn(Lists.newArrayList());

    mockMvc.perform(get("/search?keyword=dog"))
        .andExpect(status().isOk());
  }

}