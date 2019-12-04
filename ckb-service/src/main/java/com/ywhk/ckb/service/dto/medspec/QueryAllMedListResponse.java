package com.ywhk.ckb.service.dto.medspec;import com.ywhk.ckb.common.doc.annotation.ApiDocElement;import lombok.Data;import java.io.Serializable;import java.util.Date;@Datapublic class QueryAllMedListResponse implements Serializable {    @ApiDocElement("药品ID")    private Integer FMedSpecID;    @ApiDocElement("分类")    private Integer directoryID;    @ApiDocElement("序号")    private Integer FOrder;    @ApiDocElement("药品编码")    private String FNumber;    @ApiDocElement("名称")    private String FMedSpecName;    @ApiDocElement("别名")    private String FAlias;    @ApiDocElement("规格")    private String FSpec;    @ApiDocElement("单位")    private String FUnit;    @ApiDocElement("剂型")    private String FMedDosage;    @ApiDocElement("形态")    private String FShape;    @ApiDocElement("性状")    private String FCharacter;    @ApiDocElement("成分")    private String FComposition;    @ApiDocElement("药理作用")    private String FPharmacologicalEffects;    @ApiDocElement("炮制")    private String FProcessingDrugs;    @ApiDocElement("性味")    private String FFlavor;    @ApiDocElement("归经")    private String FChannelTropism;    @ApiDocElement("功能")    private String FFunction;    @ApiDocElement("主治")    private String Findications;    @ApiDocElement("类型")    private String FClassTypeID;    @ApiDocElement("注意事项")    private String FNote;    @ApiDocElement("临床应用")    private String FClinicalPractice;    @ApiDocElement("用法用量")    private String FDosage;    @ApiDocElement("处方举例")    private String FPrescribingExamples;    @ApiDocElement("拼音码")    private String FPy;    @ApiDocElement("五笔码")    private String FWb;    @ApiDocElement("备注")    private String FExp;    @ApiDocElement("启用标示")    private Integer FMark;    @ApiDocElement("创建日期")    private Date FCreateDate;    @ApiDocElement("创建人")    private Integer FCreateuserID;    @ApiDocElement("修改日期")    private Date FModifyDate;    @ApiDocElement("修改人")    private Integer FModifyUserID;}