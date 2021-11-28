package com.example.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
//建模表
public class Uf_material_info {

    @Id
    private Integer id;


    private Integer requestId;


    private Integer formmodeid;


    private Integer modedatacreater;


    private Integer modedatacreatertype;


    private String modedatacreatedate;


    private String modedatacreatetime;


    private Integer modedatamodifier;


    private String modedatamodifydatetime;


    private String MODEUUID;


    private String gysmc;


    private String gysbm;


    private String dl;


    private String dlmc;


    private String zl;


    private String zlmc;


    private String xl;


    private String xlmc;


    private String khmc;


    private String wllx;


    private String wllxbm;


    private Integer nf;


    private Integer xb;


    private String jjbm;


    private String jj;


    private String jbjldw;


    private String jbjldwmc;


    private BigDecimal dpj;


    private String ysz;


    private String yszmc;


    private String ysbm;


    private String ysmc;


    private String cmz;


    private String cmzmc;


    private String cmbm;


    private String cmmc;


    private String hpzx;


    private String hpzxmc;


    private String ppbm;


    private String ppmc;


    private String cpx;


    private String cpxmc;


    private String gyskh;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Uf_material_info that = (Uf_material_info) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}