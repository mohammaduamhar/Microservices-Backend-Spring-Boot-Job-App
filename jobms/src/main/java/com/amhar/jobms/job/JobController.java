package com.amhar.jobms.job;

import com.amhar.jobms.job.dto.JobWithCompanyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {
    private  JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobWithCompanyDTO>> findAll(){
        return  ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping
   public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("job added successfully", HttpStatus.CREATED);
    }


@GetMapping("/{id}")
        public ResponseEntity<JobWithCompanyDTO> getJobById(@PathVariable Long id) {

    JobWithCompanyDTO jobWithCompanyDTO = jobService.getJobById(id);
         if (jobWithCompanyDTO != null) {
             return new ResponseEntity<>(jobWithCompanyDTO, HttpStatus.OK );
         }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }




        @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
      boolean deleted =  jobService.deleteJob(id);
      if (deleted) {
          return new ResponseEntity<>("job deleted successfully", HttpStatus.OK);
      }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job) {
        jobService.updateJob(id, job);
        return new ResponseEntity<>("job updated successfully", HttpStatus.OK);
    }




}