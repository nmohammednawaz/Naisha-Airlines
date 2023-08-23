package com.naishaairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
