package kimi.service;

import org.springframework.data.jpa.repository.JpaRepository;

import kimi.domain.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}
