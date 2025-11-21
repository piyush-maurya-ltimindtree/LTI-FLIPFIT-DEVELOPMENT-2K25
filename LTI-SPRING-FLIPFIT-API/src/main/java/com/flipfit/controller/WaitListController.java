
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

    /**
     * @Method-
     * @Description-
     * @MethodParameters-
     * @exception-
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<WaitList> addToWaitList(@RequestBody WaitList waitList) {
        return ResponseEntity.ok(waitListService.addToWaitList(waitList));
    }

    /**
     * Read: get waitlist entries by slot
     * GET /api/waitlist/slot/{slotId}
     */
    @RequestMapping(value = "/slot/{slotId}", method = RequestMethod.GET)
    public ResponseEntity<List<WaitList>> getWaitListBySlot(@PathVariable Long slotId) {
        return ResponseEntity.ok(waitListService.getWaitListBySlot(slotId));
    }

    /**
     * Delete: remove a waitlist entry
     * DELETE /api/waitlist/remove/{waitListId}
     */
    @RequestMapping(value = "/remove/{waitListId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeFromWaitList(@PathVariable Long waitListId) {
        waitListService.removeFromWaitList(waitListId);
        return ResponseEntity.ok("Removed from waitlist successfully");
    }
}
