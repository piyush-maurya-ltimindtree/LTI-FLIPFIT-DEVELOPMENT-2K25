package com.flipfit.service;

import com.flipfit.entity.WaitList;
import java.util.List;

public interface WaitListService {
    WaitList addToWaitList(WaitList waitList);
    List<WaitList> getWaitListBySlot(Long slotId);
    void removeFromWaitList(Long waitListId);
}
