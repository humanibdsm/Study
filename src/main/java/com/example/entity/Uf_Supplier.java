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
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * 
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
@Table(name = "uf_supplier")
public class Uf_Supplier implements Serializable {


    @Id
    private Integer id;

    @Column(name = "mate_code")

    private String mate_code;


    private String supplier_code;


    private Boolean is_default;


    private Boolean enable;


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
        Uf_Supplier that = (Uf_Supplier) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
