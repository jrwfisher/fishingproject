package com.example.fishingproject.controller;

import com.example.fishingproject.dao.LureDao;
import com.example.fishingproject.dao.TackleboxDao;
import com.example.fishingproject.model.Lure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TackleboxController {
    @Autowired
    private LureDao lureDao;
    @Autowired
    private TackleboxDao tackleboxDao;

    @RequestMapping(path = "/tacklebox", method = RequestMethod.POST)
    public void addLure(Lure lure) {
        lureDao.addLure(lure);
    }

    @RequestMapping(path = "/tacklebox", method = RequestMethod.GET)
    public List<Lure> getAllLures() {
        return lureDao.getAllLures();
    }

    @RequestMapping(path = "/tacklebox/{userId}", method = RequestMethod.GET)
    public List<Lure> getLuresByUserId(int userId) {
        return tackleboxDao.getTacklebox(userId);
    }
}
