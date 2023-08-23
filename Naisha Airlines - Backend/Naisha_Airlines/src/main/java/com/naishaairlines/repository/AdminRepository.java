package com.naishaairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naishaairlines.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
