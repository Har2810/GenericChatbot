package com.cars24.Generic.data.dao.impl;

import com.cars24.Generic.data.dao.PromptDao;
import com.cars24.Generic.data.entities.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.query.Query;  // ✅ CORRECT

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PromptDaoImpl implements PromptDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
//    public List<Prompt> findByDisplayOrderLessThanEqual(int displayOrder)
        public List<Prompt> findMainCategoriesWithDisplayOrder(){
//        Query query = new Query(Criteria.where("displayOrder").lte(displayOrder));
        Query query = new Query(Criteria
                .where("category").is("main_category")
                .and("displayOrder").lte(5)
        );
        return mongoTemplate.find(query, Prompt.class);
    }

    @Override
    public Optional<Prompt> findById(String id) {
        Prompt prompt = mongoTemplate.findById(id, Prompt.class);
        return Optional.ofNullable(prompt);
    }

    @Override
    public List<Prompt> findAllByIdIn(List<String> ids) {
        Query query = new Query(Criteria.where("_id").in(ids));
        return mongoTemplate.find(query, Prompt.class);
    }
}
