package com.flipfit.service;

import com.flipfit.entity.GymUser;
import org.springframework.stereotype.Service;


@Service
public class WaitListServiceImpl implements WaitListService {


    @Override
    public GymUser promoteUser(GymUser gymUser) {
        System.out.println("Promoting user: " + gymUser.getUserName());
        return gymUser;
    }
}
