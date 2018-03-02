package com.example.demo.services;

import com.example.demo.converters.RecipeCommandToRecipe;
import com.example.demo.converters.RecipeToRecipeCommand;
import com.example.demo.models.Recipe;
import com.example.demo.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeService recipeService;
    RecipeCommandToRecipe recipeCommandToRecipe;
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        //init mocks
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipeByIdTest() {
        /* given */
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        /* when */
        Recipe recipeReturned = recipeService.findById(1L);

        /* then */
        assertNotNull("null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void getRecipes() {
        /* given */
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        /* when */
        when(recipeService.getRecipes()).thenReturn(recipeData);
        Set<Recipe> recipeSet = recipeService.getRecipes();

        /* then */
        assertEquals(recipeSet.size(), 1);
        verify(recipeRepository, times(1)).findAll();

    }
}