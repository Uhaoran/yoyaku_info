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
    /**
     * 予約
     * @param yoyakuSysDto 
     */
    public void createYoyakuSys(YoyakuSysDto yoyakuSysDto) {

        System.out.println(yoyakuSysDto.getUserid());
        System.out.println(yoyakuSysDto.getCheckin());
        System.out.println(yoyakuSysDto.getTimes());
        System.out.println(yoyakuSysDto.getCourse());
        System.out.println(yoyakuSysDto.getPettype());

        YoyakuSysEntity entity = new YoyakuSysEntity();

        entity.setUserid(yoyakuSysDto.getUserid());
        entity.setCheckin(yoyakuSysDto.getCheckin());
        entity.setTimes(yoyakuSysDto.getTimes());
        entity.setCourse(yoyakuSysDto.getCourse());
        entity.setPettype(yoyakuSysDto.getPettype());

        yoyakuSysDao.createYoyakuSys(entity);

    }
    /**
     * 予約キャンセル
     * @param yoyakuSysDto 
     */
    public void deleteYoyakuSys(YoyakuSysDto yoyakuSysDto) {

        System.out.println(yoyakuSysDto.getUserid());
        System.out.println(yoyakuSysDto.getCheckin());
        System.out.println(yoyakuSysDto.getTimes());
        System.out.println(yoyakuSysDto.getCourse());
        System.out.println(yoyakuSysDto.getPettype());

        YoyakuSysEntity entity = new YoyakuSysEntity();

        entity.setUserid(yoyakuSysDto.getUserid());
        entity.setCheckin(yoyakuSysDto.getCheckin());
        entity.setTimes(yoyakuSysDto.getTimes());
        entity.setCourse(yoyakuSysDto.getCourse());
        entity.setPettype(yoyakuSysDto.getPettype());

        yoyakuSysDao.deleteYoyakuSys(entity);

    }
    /**
     *  予約変更
     * @param yoyakuSysDto 
     */
    public void changeYoyakuSys(YoyakuSysDto yoyakuSysDto) {

        System.out.println(yoyakuSysDto.getUserid());
        System.out.println(yoyakuSysDto.getCheckin());
        System.out.println(yoyakuSysDto.getTimes());
        System.out.println(yoyakuSysDto.getCourse());
        System.out.println(yoyakuSysDto.getPettype());

        YoyakuSysEntity entity = new YoyakuSysEntity();

        entity.setUserid(yoyakuSysDto.getUserid());
        entity.setCheckin(yoyakuSysDto.getCheckin());
        entity.setTimes(yoyakuSysDto.getTimes());
        entity.setCourse(yoyakuSysDto.getCourse());
        entity.setPettype(yoyakuSysDto.getPettype());

        yoyakuSysDao.changeYoyakuSys(entity);

    }

    public List<YoyakuSysDto> selectAll() {
        List<YoyakuSysEntity> list = yoyakuSysDao.selectYoyakuSys();

        List<YoyakuSysDto> dto = new ArrayList<>();
        for (YoyakuSysEntity e : list) {

            YoyakuSysDto d = new YoyakuSysDto();

            d.setUserid(e.getUserid());
            d.setCheckin(e.getCheckin());
            d.setTimes(e.getTimes());
            d.setCourse(e.getCourse());
            d.setPettype(e.getPettype());

            dto.add(d);
        }

        return dto;
    }

}
