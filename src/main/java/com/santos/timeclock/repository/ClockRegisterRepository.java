package com.santos.timeclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santos.timeclock.entities.ClockRegister;

public interface ClockRegisterRepository extends JpaRepository<ClockRegister, Long> {

}
