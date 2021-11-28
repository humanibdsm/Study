package com.example.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author toolscat.com
 * @verison $Id: FormtableMain47 v 0.1 2021-11-26 17:34:34
 */
//流程主表
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "formtable_main_47")
public class FormtableMain47 {

    @Id
    private Integer id;

    //唯一
    private Integer requestId;

    //	发起人
    private Integer fqr;

    //	发起时间
    private String fqsj;

    //所属部门
    private Integer szbm;

    //物料录入单号
    private String wllrdh;

    //	大类
    private String dl;

    //	manager
    private Integer manager;

    //中类对应大类编码
    private String zldydlbm;

    //	归档时间
    private String gdsj;

    //	部门负责人
    private String bmfzr;

    //一级部门负责人
    private String yjbmfzr;

    //	供应商名称
    private String gysmc;

    //供应商编码
    private String gysbm;

    //	物料模板类型
    private Integer mblx;

    //	鞋服类隐藏
    private String xflyc;

    //	摘要
    private String zy;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FormtableMain47 that = (FormtableMain47) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}