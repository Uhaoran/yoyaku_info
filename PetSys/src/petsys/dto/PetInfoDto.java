/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsys.dto;

import javax.swing.JTextField;

/**
 *
 * @author WU HAORAN
 */
public class PetInfoDto {

    private String user_id;
    private String pet_type;
    private String pet_headed;
    private String pet_name;
    private String pet_born;
    private String pet_sex;
    private String vaccination_date;
    private String rabies_vaccine_date;
    private String petmedical_history;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPet_type() {
        return pet_type;
    }

    public void setPet_type(String pet_type) {
        this.pet_type = pet_type;
    }

    public String getPet_headed() {
        return pet_headed;
    }

    public void setMulti_headed(String pet_headed) {
        this.pet_headed = pet_headed;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public String getPet_born() {
        return pet_born;
    }

    public void setPet_born(String pet_born) {
        this.pet_born = pet_born;
    }

    public String getPet_sex() {
        return pet_sex;
    }

    public void setPet_sex(String pet_sex) {
        this.pet_sex = pet_sex;
    }

    public String getVaccination_date() {
        return vaccination_date;
    }

    public void setVaccination_date(String vaccination_date) {
        this.vaccination_date = vaccination_date;
    }

    public String getRabies_vaccine_date() {
        return rabies_vaccine_date;
    }

    public void setRabies_vaccine_date(String rabies_vaccine_date) {
        this.rabies_vaccine_date = rabies_vaccine_date;
    }

    public String getPetmedical_history() {
        return petmedical_history;
    }

    public void setPetmedical_history(String petmedical_history) {
        this.petmedical_history = petmedical_history;
    }

    public void setUser_id(JTextField user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}