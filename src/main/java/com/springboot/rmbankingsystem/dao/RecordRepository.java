package com.springboot.rmbankingsystem.dao;

import com.springboot.rmbankingsystem.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Integer> {
}
