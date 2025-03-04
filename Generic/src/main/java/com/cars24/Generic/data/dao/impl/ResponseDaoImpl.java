package com.cars24.Generic.data.dao.impl;

import com.cars24.Generic.data.dao.ResponseDao;
import com.cars24.Generic.data.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;  // ✅ CORRECT

//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ResponseDaoImpl implements ResponseDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<Response> findByPromptId(String promptId) {
        Query query = new Query(Criteria.where("promptId").is(promptId));
        Response response = mongoTemplate.findOne(query, Response.class);
        return Optional.ofNullable(response);
    }

}
