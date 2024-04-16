package org.example.springquartzprac.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springquartzprac.scheduler.job.UpdateItemDateSchedule;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

@Slf4j
@RequiredArgsConstructor
public class ItemScheduler {
    
    private final Scheduler scheduler;
    
    // TODO: Quartz 관련 필요한 H2 DB에 맞는 기본 테이블 추가 스크립트 필요 - data.sql?
    private void updateItemDateSchedule() throws SchedulerException {
        log.info("=== UpdateItemDateSchedule 시작 ===");
        
        JobDetail jobDetail = JobBuilder.newJob(UpdateItemDateSchedule.class)
                .build();
        
        TriggerKey triggerKey = new TriggerKey("UpdateItemDateSchedule");

//        scheduler.unscheduleJob("another trigger key");    // 다른 스케쥴러가 취소되어야 할 경우
        
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey)
                .withSchedule(CronScheduleBuilder.cronSchedule("*/10 * * * * ?"))
                .build();
        
        scheduler.scheduleJob(jobDetail, trigger);
        
        log.info("=== UpdateItemDateSchedule 종료 ===");
    }
}
