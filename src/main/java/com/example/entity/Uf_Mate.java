package com.example.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

/**
 * <p>
 * 物料表
 * </p>
 *
 * @author tancy
 * @since 2021-11-05
 */
/*@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("mate")*/
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "uf_mate")
public class Uf_Mate implements Serializable {


    @Id
    private Long id;

    /**
     * 款式编号
     */
    @Column(name = "mate_code")
    private String mate_code;

    /**
     * 款式名称
     */

    private String mate_name;

    /**
     * 品牌编号
     */

    private String brand_code;

    /**
     * 国际69码
     */

    private String internation_code;

    /**
     * 大类编号
     */

    private String genera_code;

    /**
     * 中类编号
     */

    private String minor_defects_code;

    /**
     * 小类编号
     */

    private String subclass_code;

    /**
     * 性别编号
     */

    private String gender_code;

    /**
     * 年份
     */

    private String year_code;

    /**
     * 季度编号
     */

    private String season_code;

    /**
     * 基本计量单位
     */

    private String basic_unit_code;

    /**
     * 款属性编号
     */

    private String mate_prop_code;

    /**
     * 款类型编号
     */

    private String mate_type_code;

    /**
     * 产品线
     */

    private String prod_line_code;

    /**
     * 吊牌价
     */

    private BigDecimal brand_price;


    private Integer status;
    /**
     * 物料标签
     */

    private String tag;
    /**
     * 物料组id
     */

    private Integer mate_group_id;


    private String creator_code;

    private String creator_name;

    private LocalDateTime create_time;

    private String updater_code;

    private String updater_name;

    private LocalDateTime update_time;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(
            name = "mate_code"
            , referencedColumnName = "mate_code"
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private Set<Uf_MateSku> mateSkus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(
            name = "mate_code"
            , referencedColumnName = "mate_code"
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private Set<Uf_Supplier> mateSuppliers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Uf_Mate mate = (Uf_Mate) o;
        return id != null && Objects.equals(id, mate.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
