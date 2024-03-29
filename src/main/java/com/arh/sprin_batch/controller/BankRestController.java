package com.arh.sprin_batch.controller;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BankRestController {

    private JobLauncher jobLauncher;
    private Job job;

    @GetMapping("load-data")
    public BatchStatus load() throws Exception {
        Map<String, JobParameter> parameters=new HashMap<>();
        parameters.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters=new JobParameters(parameters);
        JobExecution jobExecution=jobLauncher.run(job,jobParameters);
        while (jobExecution.isRunning())
            System.out.println(".......");
        return jobExecution.getStatus();
    }
}
