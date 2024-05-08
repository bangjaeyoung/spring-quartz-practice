package org.example.springquartzprac.scheduler;

import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SchedulerController {
    
    private final ItemScheduler itemScheduler;
    
    @GetMapping("/test")
    public ResponseEntity<String> test() throws SchedulerException {
        itemScheduler.updateItemDateSchedule();
        return ResponseEntity.ok("OK");
    }
}
