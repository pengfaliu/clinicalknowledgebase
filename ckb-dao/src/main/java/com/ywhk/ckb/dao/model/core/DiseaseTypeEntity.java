package com.ywhk.ckb.dao.model.core;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * 疾病分类
 */
@Data
@Entity
@Table(name = "KLN_BAS_DiseaseType")
public class DiseaseTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FDiseaseTypeID", nullable = false)
    private Integer FDiseaseTypeID;

    @Column(name = "FOrderNumber", nullable = false)
    private Integer FOrderNumber;

    @Column(name = "FNumber", nullable = false, length = 50)
    private String FNumber;

    @Column(name = "FName", nullable = false, length = 50)
    private String FName;

    @Column(name = "FDiseaseType", nullable = false)
    private Integer FDiseaseType;

    @Column(name = "FParentID", nullable = false)
    private Integer FParentID;

    @Column(name = "FPy", nullable = false, length = 50)
    private String FPy;

    @Column(name = "FWb", nullable = false, length = 50)
    private String FWb;

    @Column(name = "FExp", nullable = false, length = 200)
    private String FExp;

    @Column(name = "FMark", nullable = false)
    private Integer FMark;

    @Column(name = "FCreateDate", nullable = false, length = 8)
    private Date FCreateDate;

    @Column(name = "FCreateuserID", nullable = false)
    private Integer FCreateuserID;

    @Column(name = "FModifyDate", nullable = false, length = 8)
    private Date FModifyDate;

    @Column(name = "FModifyUserID", nullable = false)
    private Integer FModifyUserID;

}
