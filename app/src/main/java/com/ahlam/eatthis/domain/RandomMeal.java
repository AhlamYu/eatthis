package com.ahlam.eatthis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RandomMeal {

    private String idRandMeal;
    private String strRandMeal;
    private String strCategory;
    private String strArea;
    private String strMealThumb;

    @Override
    public String toString() {
        return strRandMeal;
    }
}
