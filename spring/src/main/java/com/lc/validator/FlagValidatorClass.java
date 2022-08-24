package com.lc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description:
 * @Auther: LuChao
 * @Date: 2022/8/22 11:27
 * @Version: v1.0
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Integer> {
    private String[] values;
    @Override
    public void initialize(FlagValidator flagValidator) {
        this.values = flagValidator.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        for (String s : values) {
            if (s.equals(String.valueOf(value))) {
                return true;
            }
        }
        return false;
    }
}
