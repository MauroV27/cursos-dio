package com.learn.tasks.domain.repository;

import com.learn.tasks.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Método para atualizar o campo completed
//    @Modifying
//    @Query("UPDATE Task t SET t.status = NOT t.status WHERE t.id = :id")
//    int updateStatusById(@Param("id") Long id);

}
