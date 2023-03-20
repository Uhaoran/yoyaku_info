/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsys.service;

import petsys.dao.PetInfoDao;
import petsys.dto.PetInfoDto;
import petsys.entity.PetInfoEntity;

/**
 *
 * @author WU HAORAN
 */
public class PetInfoService {

    PetInfoDao petInfoDao = new PetInfoDao();
    PetInfoEntity petInfoEntity=new PetInfoEntity();

    public void createPetInfo(PetInfoDto petInfoDto) {

        System.out.println(petInfoDto.getUser_id());
        System.out.println(petInfoDto.getPet_type());
        System.out.println(petInfoDto.getPet_headed());
        System.out.println(petInfoDto.getPet_name());
        System.out.println(petInfoDto.getPet_born());
        System.out.println(petInfoDto.getPet_sex());
        System.out.println(petInfoDto.getVaccination_date());
        System.out.println(petInfoDto.getRabies_vaccine_date());
        System.out.println(petInfoDto.getPetmedical_history());
      

        petInfoEntity.setUser_id(petInfoDto.getUser_id());
        petInfoEntity.setPet_type(petInfoDto.getPet_type());
        petInfoEntity.setPet_headed(petInfoDto.getPet_headed());
        petInfoEntity.setPet_name(petInfoDto.getPet_name());
        petInfoEntity.setPet_born(petInfoDto.getPet_born());
        petInfoEntity.setPet_sex(petInfoDto.getPet_sex());
        petInfoEntity.setVaccination_date(petInfoDto.getVaccination_date());
        petInfoEntity.setRabies_vaccine_date(petInfoDto.getRabies_vaccine_date());
        petInfoEntity.setPetmedical_history(petInfoDto.getPetmedical_history());
     
        petInfoDao.createPetInfo(petInfoEntity);

    }
}
