package com.tsckey.processtracker.repository;

import com.tsckey.processtracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public Task findByName(String name);
    public Optional<Task> findById(Long id);
    public List<Task>  findAll();
    public void deleteById(Long id);

}
