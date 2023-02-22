/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsys.service;

import java.util.ArrayList;
import java.util.List;
import petsys.controller.Yoyaku;
import petsys.dao.PetSysDao;
import petsys.dto.PetSysDto;
import petsys.entity.PetSysEntity;

/**
 *
 * @author WU HAORAN
 */
public class PetSysService {

    PetSysDao petSysDao = new PetSysDao();
    PetSysEntity entity = new PetSysEntity();

    /**
     * 新規登録
     *
     * @param petSysDto
     */
    public void createPetSys(PetSysDto petSysDto) {

        System.out.println(petSysDto.getCustermnumber());
        System.out.println(petSysDto.getUserid());
        System.out.println(petSysDto.getPassword());
        System.out.println(petSysDto.getName());
        System.out.println(petSysDto.getSex());
        System.out.println(petSysDto.getBorn());
        System.out.println(petSysDto.getAddress());
        System.out.println(petSysDto.getTel());
        System.out.println(petSysDto.getEmail());
        System.out.println(petSysDto.getPettype());
        System.out.println(petSysDto.getMultiheaded());
        System.out.println(petSysDto.getPetname());
        System.out.println(petSysDto.getPetborn());
        System.out.println(petSysDto.getPetsex());
        System.out.println(petSysDto.getVaccinationdate());
        System.out.println(petSysDto.getPetmedicalhistory());
        System.out.println(petSysDto.getCreationdate());
        System.out.println(petSysDto.getUpdatingdate());

        entity.setCustermnunmber(petSysDto.getCustermnumber());
        entity.setUserid(petSysDto.getUserid());
        entity.setPassword(petSysDto.getPassword());
        entity.setName(petSysDto.getName());
        entity.setSex(petSysDto.getSex());
        entity.setBorn(petSysDto.getBorn());
        entity.setAddress(petSysDto.getAddress());
        entity.setTel(petSysDto.getTel());
        entity.setEmail(petSysDto.getEmail());
        entity.setPettype(petSysDto.getPettype());
        entity.setMultiheaded(petSysDto.getMultiheaded());
        entity.setPetname(petSysDto.getPetname());
        entity.setPetborn(petSysDto.getPetborn());
        entity.setPetsex(petSysDto.getPetsex());
        entity.setVaccinationdate(petSysDto.getVaccinationdate());
        entity.setPetmedicalhistory(petSysDto.getPetmedicalhistory());
        entity.setCreationdate(petSysDto.getCreationdate());
        entity.setUpdatingdate(petSysDto.getUpdatingdate());

        petSysDao.createPetSys(entity);

    }
    /**
     * お客様情報変更
     * @param petSysDto 
     */
    public void changePetSys(PetSysDto petSysDto) {
        
        System.out.println(petSysDto.getCustermnumber());
        System.out.println(petSysDto.getUserid());
        System.out.println(petSysDto.getPassword());
        System.out.println(petSysDto.getName());
        System.out.println(petSysDto.getSex());
        System.out.println(petSysDto.getBorn());
        System.out.println(petSysDto.getAddress());
        System.out.println(petSysDto.getTel());
        System.out.println(petSysDto.getEmail());
        System.out.println(petSysDto.getPettype());
        System.out.println(petSysDto.getMultiheaded());
        System.out.println(petSysDto.getPetname());
        System.out.println(petSysDto.getPetborn());
        System.out.println(petSysDto.getPetsex());
        System.out.println(petSysDto.getVaccinationdate());
        System.out.println(petSysDto.getPetmedicalhistory());
    

        entity.setCustermnunmber(petSysDto.getCustermnumber());
        entity.setUserid(petSysDto.getUserid());
        entity.setPassword(petSysDto.getPassword());
        entity.setName(petSysDto.getName());
        entity.setSex(petSysDto.getSex());
        entity.setBorn(petSysDto.getBorn());
        entity.setAddress(petSysDto.getAddress());
        entity.setTel(petSysDto.getTel());
        entity.setEmail(petSysDto.getEmail());
        entity.setPettype(petSysDto.getPettype());
        entity.setMultiheaded(petSysDto.getMultiheaded());
        entity.setPetname(petSysDto.getPetname());
        entity.setPetborn(petSysDto.getPetborn());
        entity.setPetsex(petSysDto.getPetsex());
        entity.setVaccinationdate(petSysDto.getVaccinationdate());
        entity.setPetmedicalhistory(petSysDto.getPetmedicalhistory());
     
        petSysDao.changePetSys(entity);
    }
    
    

    /**
     * ログイン
     *
     * @param petSysDto
     */
    public void loginPetSys(PetSysDto petSysDto) {

        String userid = petSysDto.getUserid();
        String password = String.valueOf(petSysDto.getPassword());

        if (userid.equals("123") && password.equals("123")) {
            System.out.print("登録出来ました");

            /**
             * 予約画面に遷移
             */
            Yoyaku ｙ = new Yoyaku();
            ｙ.setVisible(true);

        } else {
            System.out.print("IDまたパスワードが違います");
        }

    }

    /**
     * 全件検索
     *
     * @return
     */
    public List<PetSysDto> selectAll() {

        List<PetSysEntity> list = petSysDao.selectPetSys();

        List<PetSysDto> dto = new ArrayList<>();

        for (PetSysEntity e : list) {

            PetSysDto d = new PetSysDto();

            d.setCustermnunmber(e.getCustermnumber());
            d.setUserid(e.getUserid());
            d.setPassword(e.getPassword());
            d.setName(e.getName());
            d.setSex(e.getSex());
            d.setBorn(e.getBorn());
            d.setAddress(e.getAddress());
            d.setTel(e.getTel());
            d.setEmail(e.getEmail());
            d.setPettype(e.getPettype());
            d.setMultiheaded(e.getMultiheaded());
            d.setPetname(e.getPetname());
            d.setPetborn(e.getPetborn());
            d.setPetsex(e.getPetsex());
            d.setVaccinationdate(e.getVaccintiondate());
            d.setPetmedicalhistory(e.getPetmedicalhistory());
            d.setCreationdate(e.getCreationdate());
            d.setUpdatingdate(e.getUpdatingdate());
            dto.add(d);
        }

        return dto;

    }

}
