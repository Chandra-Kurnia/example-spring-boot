package com.latihan.postgres.demo.helper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageModel {

    private String message;
    private boolean status;
    private Object data;
}
