package com.ahlam.eatthis.domain;

import com.ahlam.eatthis.domain.Category;
import com.ahlam.eatthis.domain.RandomMeal;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RandomApiList {

    List<RandomMeal> randomMeals;

}
