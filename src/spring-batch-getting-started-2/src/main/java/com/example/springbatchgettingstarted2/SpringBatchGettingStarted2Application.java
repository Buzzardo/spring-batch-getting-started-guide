package com.example.springbatchgettingstarted2;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBatchGettingStarted2Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchGettingStarted2Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(BatchConfiguration.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		try {
			jobLauncher.run(job, new JobParameters());
		} catch (Exception e) {
			System.out.println("jobLauncher failed");
		}
	}
}
