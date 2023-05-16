package com.project.loremaster.models;

import javax.persistence.*;

@Entity(name = "Users")
public class Users {

    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    private long users_id;
    private String email;
    private String username;
    private String password;
    private int runeterra_highscore;
    private int demacia_highscore;
    private int noxus_highscore;
    private int freljord_highscore;
    private int ionia_highscore;
    private int targon_highscore;
    private int shurima_highscore;
    private int shadow_highscore;
    private int piltzaun_highscore;

    /*public Users(String email, String username, String password, int runeterra_highscore, int demacia_highscore, int noxus_highscore, int freljord_highscore, int ionia_highscore, int targon_highscore, int shurima_highscore, int shadow_highscore, int piltzaun_highscore) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.runeterra_highscore = runeterra_highscore;
        this.demacia_highscore = demacia_highscore;
        this.noxus_highscore = noxus_highscore;
        this.freljord_highscore = freljord_highscore;
        this.ionia_highscore = ionia_highscore;
        this.targon_highscore = targon_highscore;
        this.shurima_highscore = shurima_highscore;
        this.shadow_highscore = shadow_highscore;
        this.piltzaun_highscore = piltzaun_highscore;
    }

    public Users() {

    }*/

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRuneterra_highscore() {
        return runeterra_highscore;
    }

    public void setRuneterra_highscore(int runeterra_highscore) {
        this.runeterra_highscore = runeterra_highscore;
    }

    public int getDemacia_highscore() {
        return demacia_highscore;
    }

    public void setDemacia_highscore(int demacia_highscore) {
        this.demacia_highscore = demacia_highscore;
    }

    public int getNoxus_highscore() {
        return noxus_highscore;
    }

    public void setNoxus_highscore(int noxus_highscore) {
        this.noxus_highscore = noxus_highscore;
    }

    public int getFreljord_highscore() {
        return freljord_highscore;
    }

    public void setFreljord_highscore(int freljord_highscore) {
        this.freljord_highscore = freljord_highscore;
    }

    public int getIonia_highscore() {
        return ionia_highscore;
    }

    public void setIonia_highscore(int ionia_highscore) {
        this.ionia_highscore = ionia_highscore;
    }

    public int getTargon_highscore() {
        return targon_highscore;
    }

    public void setTargon_highscore(int targon_highscore) {
        this.targon_highscore = targon_highscore;
    }

    public int getShurima_highscore() {
        return shurima_highscore;
    }

    public void setShurima_highscore(int shurima_highscore) {
        this.shurima_highscore = shurima_highscore;
    }

    public int getShadow_highscore() {
        return shadow_highscore;
    }

    public void setShadow_highscore(int shadow_highscore) {
        this.shadow_highscore = shadow_highscore;
    }

    public int getPiltzaun_highscore() {
        return piltzaun_highscore;
    }

    public void setPiltzaun_highscore(int piltzaun_highscore) {
        this.piltzaun_highscore = piltzaun_highscore;
    }
}
