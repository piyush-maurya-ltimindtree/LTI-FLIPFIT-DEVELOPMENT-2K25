
package com.flipfit.controller;

import com.flipfit.entity.WaitList;
import com.flipfit.service.WaitListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waitlist")
public class WaitListController {

    private final WaitListService waitListService;

    public WaitListController(WaitListService waitListService) {
        this.waitListService = waitListService;
    }

    @PostMapping("/add")
    public ResponseEntity<WaitList> addToWaitList(@RequestBody WaitList waitList) {
        return ResponseEntity.ok(waitListService.addToWaitList(waitList));
    }

    @GetMapping("/slot/{slotId}")
    public ResponseEntity<List<WaitList>> getWaitListBySlot(@PathVariable Long slotId) {
        return ResponseEntity.ok(waitListService.getWaitListBySlot(slotId));
    }

    @DeleteMapping("/remove/{waitListId}")
    public ResponseEntity<String> removeFromWaitList(@PathVariable Long waitListId) {
        waitListService.removeFromWaitList(waitListId);
        return ResponseEntity.ok("Removed from waitlist successfully");
    }
}