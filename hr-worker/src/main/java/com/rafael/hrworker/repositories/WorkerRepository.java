package com.rafael.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
