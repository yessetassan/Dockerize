package com.project.springApp;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Repo extends JpaRepository<Message, Integer> {

    @Query("select m from Message m where m.id = ?1")
    Optional<Message> findById(Integer id);
}
