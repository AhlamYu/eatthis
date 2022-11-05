package com.ahlam.eatthis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealByCategory {

    private String idMeal;
    private String strMeal;
    private String strMealThumb;
    private String strCategory;

    @Override
    public String toString() {
        return strMeal;
    }


}
