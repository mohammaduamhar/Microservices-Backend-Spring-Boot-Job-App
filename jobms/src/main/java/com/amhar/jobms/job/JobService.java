package com.amhar.jobms.job;

import com.amhar.jobms.job.dto.JobDTO;

import java.util.List;

public interface JobService {
   List<JobDTO> findAll();

   void createJob(Job job);

   JobDTO getJobById(Long id);


   boolean deleteJob(Long id);

   boolean updateJob(Long id, Job job);
}
