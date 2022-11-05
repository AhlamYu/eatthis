package com.ahlam.eatthis.supriseme;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupriseMeal {

    private String idMeal;
    private String strMeal;
    private String strCategory;
    private String strArea;
    private String strMealThumb;
}
