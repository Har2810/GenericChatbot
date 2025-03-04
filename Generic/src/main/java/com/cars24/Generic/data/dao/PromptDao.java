package com.cars24.Generic.data.dao;

import com.cars24.Generic.data.entities.Prompt;

import java.util.List;
import java.util.Optional;

public interface PromptDao {
    List<Prompt> findMainCategoriesWithDisplayOrder();
    Optional<Prompt> findById(String id);
    List<Prompt> findAllByIdIn(List<String> ids);
}
