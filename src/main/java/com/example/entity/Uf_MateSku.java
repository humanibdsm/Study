package com.example.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * sku
 * </p>
 *
 * @author tancy
 * @since 2021-11-05
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "uf_mate_sku")
public class Uf_MateSku implements Serializable {




    @Id
    private Integer id;


    private String code;


    private String name;


    @Column(name = "mate_code")
    private String mate_code;


    private String internation_code;


    private BigDecimal brand_price;


    /**
     * 状态
     */

    private String status;

    private String creator_code;


    private String creator_name;


    private LocalDateTime create_time;


    private String updater_code;


    private String updater_name;


    private LocalDateTime update_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Uf_MateSku mateSku = (Uf_MateSku) o;
        return id != null && Objects.equals(id, mateSku.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
