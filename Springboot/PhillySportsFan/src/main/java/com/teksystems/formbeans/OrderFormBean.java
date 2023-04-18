package com.teksystems.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderFormBean {

    private Integer productId;

    private String size;

    private Integer quantity;
}
