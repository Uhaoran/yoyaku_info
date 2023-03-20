/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsys.service;

import java.util.ArrayList;
import java.util.List;
import petsys.controller.LoginNG;
import petsys.controller.Yoyaku;
import petsys.dao.CustermInfoDao;
import petsys.dto.CustermInfoDto;
import petsys.entity.CustermSysEntity;

/**
 *
 * @author WU HAORAN
 */
public class CustermInfoService {

    CustermInfoDao custermSysDao = new CustermInfoDao();
    CustermSysEntity entity = new CustermSysEntity();

    /**
     * 新規登録
     *
     * @param custermSysDto
     *
     */
    public void createCusterm(CustermInfoDto custermSysDto) {

        System.out.println(custermSysDto.getCustermnumber());
        System.out.println(custermSysDto.getUserid());
        System.out.println(custermSysDto.getPassword());
        System.out.println(custermSysDto.getName());
        System.out.println(custermSysDto.getSex());
        System.out.println(custermSysDto.getBorn());
        System.out.println(custermSysDto.getAddress());
        System.out.println(custermSysDto.getTel());
        System.out.println(custermSysDto.getEmail());
        System.out.println(custermSysDto.getCreationdate());
        System.out.println(custermSysDto.getUpdatingdate());

        entity.setCustermnumber(custermSysDto.getCustermnumber());
        entity.setUserid(custermSysDto.getUserid());
        entity.setPassword(custermSysDto.getPassword());
        entity.setName(custermSysDto.getName());
        entity.setSex(custermSysDto.getSex());
        entity.setBorn(custermSysDto.getBorn());
        entity.setAddress(custermSysDto.getAddress());
        entity.setTel(custermSysDto.getTel());
        entity.setEmail(custermSysDto.getEmail());
        entity.setCreationdate(custermSysDto.getCreationdate());
        entity.setUpdatingdate(custermSysDto.getUpdatingdate());

        custermSysDao.createCusterm(entity);

    }

    /**
     * お客様情報変更
     *
     * @param petSysDto
     */
    public void changeCustermSys(CustermInfoDto petSysDto) {

        System.out.println(petSysDto.getCustermnumber());
        System.out.println(petSysDto.getUserid());
        System.out.println(petSysDto.getPassword());
        System.out.println(petSysDto.getName());
        System.out.println(petSysDto.getSex());
        System.out.println(petSysDto.getBorn());
        System.out.println(petSysDto.getAddress());
        System.out.println(petSysDto.getTel());
        System.out.println(petSysDto.getEmail());
       

        entity.setCustermnumber(petSysDto.getCustermnumber());
        entity.setUserid(petSysDto.getUserid());
        entity.setPassword(petSysDto.getPassword());
        entity.setName(petSysDto.getName());
        entity.setSex(petSysDto.getSex());
        entity.setBorn(petSysDto.getBorn());
        entity.setAddress(petSysDto.getAddress());
        entity.setTel(petSysDto.getTel());
        entity.setEmail(petSysDto.getEmail());
       

        custermSysDao.changePetSys(entity);
    }

    /**
     * ログイン
     *
     * @param custermSysDto
     */
    public void loginCustermSys(CustermInfoDto custermSysDto) {

        String userid = custermSysDto.getUserid();
        String password = String.valueOf(custermSysDto.getPassword());

        if (userid.equals(entity.getUserid()) && password.equals(entity.getTel())) {
            System.out.print("登録出来ました");

            /**
             * 予約画面に遷移
             */
            Yoyaku ｙ = new Yoyaku();
            ｙ.setVisible(true);

        } else {
            System.out.print("IDまたパスワードが違います");
            LoginNG l = new LoginNG();
            l.setVisible(true);
        }

    }

    /**
     * 全件検索,条件検索,個人情報ページ
     *
     * @return
     */
    public List<CustermInfoDto> selectAll() {

        List<CustermSysEntity> list = custermSysDao.selectAllPetSys();

        List<CustermInfoDto> dto = new ArrayList<>();

        for (CustermSysEntity e : list) {

            CustermInfoDto d = new CustermInfoDto();

            d.setCustermnumber(e.getCustermnumber());
            d.setUserid(e.getUserid());
            d.setPassword(e.getPassword());
            d.setName(e.getName());
            d.setSex(e.getSex());
            d.setBorn(e.getBorn());
            d.setAddress(e.getAddress());
            d.setTel(e.getTel());
            d.setEmail(e.getEmail());
            d.setCreationdate(e.getCreationdate());
            d.setUpdatingdate(e.getUpdatingdate());
            dto.add(d);
        }

        return dto;

    }

}
