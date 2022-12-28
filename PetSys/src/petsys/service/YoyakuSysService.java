/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsys.service;

import java.util.ArrayList;
import java.util.List;
import petsys.dao.YoyakuSysDao;
import petsys.dto.YoyakuSysDto;
import petsys.entity.YoyakuSysEntity;

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

    public List<YoyakuSysDto> selectAll() {
        List<YoyakuSysEntity> list = yoyakuSysDao.selectYoyakuSys();

        List<YoyakuSysDto> dto = new ArrayList<>();
        for (YoyakuSysEntity e : list) {

            YoyakuSysDto d = new YoyakuSysDto();

            d.setUserid(e.getUserid());
            d.setPettype(e.getPettype());
            d.setCourse(e.getCourse());
            d.setCheckin(e.getCheckin());
            d.setTimes(e.getTimes());

            dto.add(d);
        }

        return dto;
    }

}
