package org.example.springquartzprac.global.config;

import lombok.RequiredArgsConstructor;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class QuartzConfig {
    
    private final ApplicationContext applicationContext;
    
    // 스케줄러 팩토리 빈 등록
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource, JobFactory jobFactory) throws SchedulerException {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setDataSource(dataSource); // 데이터베이스를 사용하여 상태 관리
        schedulerFactoryBean.setJobFactory(jobFactory); // 스프링 빈을 Quartz Job으로 주입하기 위한 JobFactory 설정
        schedulerFactoryBean.setOverwriteExistingJobs(true); // 이미 등록된 Job이 있을 경우 덮어쓰기 설정
        schedulerFactoryBean.setAutoStartup(true); // 애플리케이션 시작 시 자동으로 스케줄러 시작
        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true); // 애플리케이션 종료 시 모든 Job이 완료될 때까지 대기
        return schedulerFactoryBean;
    }
    
    // JobFactory 빈 등록
    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        SpringBeanJobFactory jobFactory = new SpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }
    
    // Quartz 스케줄러 빈 등록
    @Bean
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean) {
        return schedulerFactoryBean.getScheduler();
    }
}
