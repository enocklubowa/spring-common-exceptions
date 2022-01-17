package com.enocklubowa.springcommonexceptions.repository;

import com.enocklubowa.springcommonexceptions.model.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface DemoEntityRepository extends JpaRepository<DemoEntity, Long> {
    Optional<DemoEntity> findByUsernameEquals(@NonNull String username);
}