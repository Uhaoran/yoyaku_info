/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoyakusys.service;

import yoyakusys.dao.YoyakuSysDao;
import yoyakusys.dto.YoyakuSysDto;
import yoyakusys.entity.YoyakuSysEntity;

/**
 *
 * @author WU HAORAN
 */
public class YoyakuSysService {

    YoyakuSysDao yoyakuSysDao = new YoyakuSysDao();

    public void createYoyakuSys(YoyakuSysDto yoyakuSysDto) {

        System.out.println(yoyakuSysDto.getUserid());
        System.out.println(yoyakuSysDto.getPettype());
        System.out.println(yoyakuSysDto.getCourse());
        System.out.println(yoyakuSysDto.getCheckin());
        System.out.println(yoyakuSysDto.getTimes());

        YoyakuSysEntity entity = new YoyakuSysEntity();

        entity.setUserid(yoyakuSysDto.getUserid());
        entity.setPettype(yoyakuSysDto.getPettype());
        entity.setCourse(yoyakuSysDto.getCourse());
        entity.setCheckin(yoyakuSysDto.getCheckin());
        entity.setTimes(yoyakuSysDto.getTimes());
        
        yoyakuSysDao.createYoyakuSys(entity);

    }
    
    public void deleteYoyakuSys(YoyakuSysDto yoyakuSysDto) {

        System.out.println(yoyakuSysDto.getUserid());
        System.out.println(yoyakuSysDto.getPettype());
        System.out.println(yoyakuSysDto.getCourse());
        System.out.println(yoyakuSysDto.getCheckin());
        System.out.println(yoyakuSysDto.getTimes());

        YoyakuSysEntity entity = new YoyakuSysEntity();

        entity.setUserid(yoyakuSysDto.getUserid());
        entity.setPettype(yoyakuSysDto.getPettype());
        entity.setCourse(yoyakuSysDto.getCourse());
        entity.setCheckin(yoyakuSysDto.getCheckin());
        entity.setTimes(yoyakuSysDto.getTimes());
        
        yoyakuSysDao.deleteYoyakuSys(entity);

    }
}
