/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g31.jpa.service;

import com.g31.jpa.entity.Category;
import com.g31.jpa.entity.Game;
import com.g31.jpa.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo Torres C
 */
@Service

public class CategoryService {
    @Autowired        
    private CategoryRepository categoryRepository;
    
    public List <Category> getCategory(){
        return categoryRepository.findAll();
    }
    
    public Category getCategoryById(Long idCat){
        
    // Control de error si esta el valor vacio
        /*if (!categoryRepository.findById(idCat).isEmpty()){
            return categoryRepository.findById(idCat).get();
        }else{
            return null;
        }*/ 
        
        return categoryRepository.findById(idCat).get();
    }
    
    public List<Game> getGamesByCategory(Long idCat){
        Category category =categoryRepository.findById(idCat).get();
        return category.getGames();
    }
    
    public Category saveCategory (Category category){
        return categoryRepository.save(category);
    }
}
                