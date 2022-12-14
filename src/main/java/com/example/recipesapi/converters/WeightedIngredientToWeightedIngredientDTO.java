package com.example.recipesapi.converters;

import com.example.recipesapi.dto.WeightedIngredientDTO;
import com.example.recipesapi.entity.WeightedIngredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WeightedIngredientToWeightedIngredientDTO implements Converter<WeightedIngredient, WeightedIngredientDTO> {


    @Override
    public WeightedIngredientDTO convert(WeightedIngredient source) {
        WeightedIngredientDTO dto = new WeightedIngredientDTO();
        dto.setId(source.getId());
        dto.setValue(source.getValue());
        dto.setUnit(source.getUnit());
        dto.setIngredientId(source.getIngredient().getid());

        return dto;
    }
}
