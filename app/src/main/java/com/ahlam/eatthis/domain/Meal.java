package com.ahlam.eatthis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal {

    private String idMeal;
    private String strMeal;
    private String strMealThumb;

    @Override
    public String toString() {
        return strMeal;
    }
}
