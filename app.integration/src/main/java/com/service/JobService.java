package com.service;

import org.springframework.data.domain.Page;

import com.jpa.entities.Job;

public interface JobService {

  public void saveJob(Job job);

  public Page<Job> findALL(int page, int rows, String sortOrder, String orderByField);

  public Job findJob(Long id);

  public void updateJob(Job jobToUpdate);

  public Page<Job> findByCategory(String category, int page, int rows, String sortOrder, String orderByField);
}
