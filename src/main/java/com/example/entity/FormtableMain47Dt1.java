package com.example.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author toolscat.com
 * @verison $Id: FormtableMain47Dt1 v 0.1 2021-11-26 17:35:52
 */
//流程明细表
@Getter
@Setter
@ToString(exclude={"formtableMain47"})
@RequiredArgsConstructor
@Entity
@Table(name = "formtable_main_47_dt1")
public class FormtableMain47Dt1 {

    @Id
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "mainid"
            , referencedColumnName = "id"
            , columnDefinition = "int(11) comment '主表id'"
            ,foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private FormtableMain47 formtableMain47;

    //性别
    private Integer xb;

    //年份
    private Integer nf;

    //物料类型编码
    private String wllx;

    //基本计量单位编码
    private String jbjldw;

    //品牌编码
    private String ppbm;

    //中类编码
    private String zl;

    //小类编码
    private String xl;

    //季节编码
    private String jd;

    //颜色组编码
    private String ysz;

    //颜色编码
    private String ysbm;

    //尺码组编码
    private String cmz;

    //尺码编码
    private String cmbm;

    //产品线编码
    private String cpx;

    //货品属性编码
    private String hpzx;

    //供应商款号
    private String gyskh;

    //物料类型名称
    private String wllxmc;

    //基本计量单位名称
    private String jbjldwmc;

    //品牌名称
    private String ppmc;

    //中类名称
    private String zlmc;

    //小类名称
    private String xlmc;

    //季节
    private String jjmc;

    //颜色组名称
    private String yszmc;

    //颜色名称
    private String ysmc;

    //	尺码组名称
    private String cmzmc;

    //尺码名称
    private String cmmc;

    //	产品线名称
    private String cpxmc;

    //货品属性名称
    private String hpzxmc;

    //	吊牌价
    private BigDecimal dpj;

    //	小类对应中类编码
    private String xldyzlbm;

    //	款号名称
    private String khmc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FormtableMain47Dt1 that = (FormtableMain47Dt1) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}