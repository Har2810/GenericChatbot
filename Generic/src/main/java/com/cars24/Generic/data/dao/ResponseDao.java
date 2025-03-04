package com.cars24.Generic.data.dao;

import com.cars24.Generic.data.entities.Response;

import java.util.Optional;

public interface ResponseDao {
    Optional<Response> findByPromptId(String promptId);
}
