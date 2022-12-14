package com.example.recipesapi.controller;


import com.example.recipesapi.dto.IngredientDTO;
import com.example.recipesapi.entity.Ingredient;
import com.example.recipesapi.service.IngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.crypto.KeyAgreementSpi;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;


    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getAll(){

        List<Ingredient> ingredients =  ingredientService.findAll();
        
        return new ResponseEntity<>(IngredientDTO.toDTO(ingredients), HttpStatus.OK);


    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<IngredientDTO> save(@RequestBody IngredientDTO ingredientDTO){


      Ingredient savedIngredient =  ingredientService.add(modelMapper.map(ingredientDTO, Ingredient.class));
      return new ResponseEntity<>(IngredientDTO.toDTO(savedIngredient), HttpStatus.OK);

    }



    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id){
        if(ingredientService.findById(id).isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        ingredientService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<IngredientDTO> update (@PathVariable long id, @RequestBody IngredientDTO ingredientDTO){
        if(ingredientService.findById(id).isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        ingredientDTO.setid(id);
        Ingredient savedIngredient = ingredientService.update(modelMapper.map(ingredientDTO,Ingredient.class));
        return new ResponseEntity<>(IngredientDTO.toDTO(savedIngredient), HttpStatus.OK);

    }

    @GetMapping("{id}")
    public  ResponseEntity<IngredientDTO> getOne(@PathVariable long id){
        Optional<Ingredient> optionalIngredient = ingredientService.findById(id);
        if(optionalIngredient.isEmpty() ) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }



        return new ResponseEntity<>(IngredientDTO.toDTO(optionalIngredient.get()),HttpStatus.OK);
    }
}
