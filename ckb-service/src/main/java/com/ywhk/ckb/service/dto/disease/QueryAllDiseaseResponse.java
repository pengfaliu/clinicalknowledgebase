package com.ywhk.ckb.service.dto.disease;import com.ywhk.ckb.common.doc.annotation.ApiDocElement;import lombok.Data;import java.io.Serializable;import java.util.Date;@Datapublic class QueryAllDiseaseResponse implements Serializable {    @ApiDocElement("疾病ID")    private Integer FDiseaseID;    @ApiDocElement("疾病分类ID")    private Integer FDiseaseTypeID;    @ApiDocElement("序号")    private Integer FOrderNumber;    @ApiDocElement("疾病编码")    private String FDiseaseNumber;    @ApiDocElement("疾病名称")    private String FDiseaseName;    @ApiDocElement("疾病概况")    private String FGeneralSituation;    @ApiDocElement("辩证论治")    private String FSyndromeDifferentiationTreatment;    @ApiDocElement("调摄预防")    private String FGuardAgainst;    @ApiDocElement("治疗标准")    private String FStandard;    @ApiDocElement("疾病类型")    private Integer FDiseaseType;    @ApiDocElement("拼音码")    private String FPy;    @ApiDocElement("五笔码")    private String FWb;    @ApiDocElement("备注")    private String FExp;    @ApiDocElement("启用标示")    private Integer FMark;    @ApiDocElement("创建日期")    private Date FCreateDate;    @ApiDocElement("创建人")    private Integer FCreateuserID;    @ApiDocElement("修改日期")    private Date FModifyDate;    @ApiDocElement("修改人")    private Integer FModifyUserID;}