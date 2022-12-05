package com.ratepay.challenge.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {

    private List<ProductDto> products = new ArrayList<>();

    private String buyerId;
}
