package org.example.springquartzprac.scheduler.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springquartzprac.item.service.ItemInfoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
public class UpdateItemDateSchedule extends QuartzJobBean {
    
    private final ItemInfoService itemInfoService;
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("UpdateItemDateSchedule Job 실행");
        
        itemInfoService.updateItemDate(LocalDate.now());
    }
}
