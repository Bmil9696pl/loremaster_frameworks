package com.project.loremaster.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.List;

@Entity
@Table(name = "users", schema = "loremaster", catalog = "loremaster")
public class UsersEntity implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "users_id")
    private int usersId;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "runeterra_highscore")
    private Integer runeterraHighscore;
    @Basic
    @Column(name = "demacia_highscore")
    private Integer demaciaHighscore;
    @Basic
    @Column(name = "noxus_highscore")
    private Integer noxusHighscore;
    @Basic
    @Column(name = "freljord_highscore")
    private Integer freljordHighscore;
    @Basic
    @Column(name = "ionia_highscore")
    private Integer ioniaHighscore;
    @Basic
    @Column(name = "targon_highscore")
    private Integer targonHighscore;
    @Basic
    @Column(name = "shurima_highscore")
    private Integer shurimaHighscore;
    @Basic
    @Column(name = "shadow_highscore")
    private Integer shadowHighscore;
    @Basic
    @Column(name = "piltzaun_highscore")
    private Integer piltzaunHighscore;

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRuneterraHighscore() {
        return runeterraHighscore;
    }

    public void setRuneterraHighscore(Integer runeterraHighscore) {
        this.runeterraHighscore = runeterraHighscore;
    }

    public Integer getDemaciaHighscore() {
        return demaciaHighscore;
    }

    public void setDemaciaHighscore(Integer demaciaHighscore) {
        this.demaciaHighscore = demaciaHighscore;
    }

    public Integer getNoxusHighscore() {
        return noxusHighscore;
    }

    public void setNoxusHighscore(Integer noxusHighscore) {
        this.noxusHighscore = noxusHighscore;
    }

    public Integer getFreljordHighscore() {
        return freljordHighscore;
    }

    public void setFreljordHighscore(Integer freljordHighscore) {
        this.freljordHighscore = freljordHighscore;
    }

    public Integer getIoniaHighscore() {
        return ioniaHighscore;
    }

    public void setIoniaHighscore(Integer ioniaHighscore) {
        this.ioniaHighscore = ioniaHighscore;
    }

    public Integer getTargonHighscore() {
        return targonHighscore;
    }

    public void setTargonHighscore(Integer targonHighscore) {
        this.targonHighscore = targonHighscore;
    }

    public Integer getShurimaHighscore() {
        return shurimaHighscore;
    }

    public void setShurimaHighscore(Integer shurimaHighscore) {
        this.shurimaHighscore = shurimaHighscore;
    }

    public Integer getShadowHighscore() {
        return shadowHighscore;
    }

    public void setShadowHighscore(Integer shadowHighscore) {
        this.shadowHighscore = shadowHighscore;
    }

    public Integer getPiltzaunHighscore() {
        return piltzaunHighscore;
    }

    public void setPiltzaunHighscore(Integer piltzaunHighscore) {
        this.piltzaunHighscore = piltzaunHighscore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return usersId == that.usersId && Objects.equals(email, that.email) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(runeterraHighscore, that.runeterraHighscore) && Objects.equals(demaciaHighscore, that.demaciaHighscore) && Objects.equals(noxusHighscore, that.noxusHighscore) && Objects.equals(freljordHighscore, that.freljordHighscore) && Objects.equals(ioniaHighscore, that.ioniaHighscore) && Objects.equals(targonHighscore, that.targonHighscore) && Objects.equals(shurimaHighscore, that.shurimaHighscore) && Objects.equals(shadowHighscore, that.shadowHighscore) && Objects.equals(piltzaunHighscore, that.piltzaunHighscore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersId, email, username, password, runeterraHighscore, demaciaHighscore, noxusHighscore, freljordHighscore, ioniaHighscore, targonHighscore, shurimaHighscore, shadowHighscore, piltzaunHighscore);
    }
}
