package com.lc.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @Description: human
 * @Auther: LuChao
 * @Date: 2022/8/22 09:52
 * @Version: v1.0
 */
@Getter
@Setter
public class PersonForm {
    @NotNull
    private String name;
    private int age;
}
