package com.flipfit.service;

import com.flipfit.entity.WaitList;
import com.flipfit.repository.WaitListRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WaitListServiceImpl implements WaitListService {

    private final WaitListRepository waitListRepository;

    public WaitListServiceImpl(WaitListRepository waitListRepository) {
        this.waitListRepository = waitListRepository;
    }

    @Override
    public WaitList addToWaitList(WaitList waitList) {
        return waitListRepository.save(waitList);
    }

    @Override
    public List<WaitList> getWaitListBySlot(Long slotId) {
        return waitListRepository.findBySlotId(slotId);
    }

    @Override
    public void removeFromWaitList(Long waitListId) {
        waitListRepository.deleteById(waitListId);
    }
}
