package com.ywhk.ckb.service.dto.titemadvice;import com.ywhk.ckb.common.doc.annotation.ApiDocElement;import lombok.Data;@Datapublic class UpdateTItemAdviceRequest {    @ApiDocElement("方剂ID")    private Integer FItemAdviceID;    @ApiDocElement("疾病ID")    private Integer FDiseaseID;//    @ApiDocElement("疾病编码")//    private String FDiseaseNumber;//    @ApiDocElement("疾病名称")//    private String FDiseaseNAME;    @ApiDocElement("方剂编码")    private String FNumber;    @ApiDocElement("方剂名称")    private String FNAME;    @ApiDocElement("方剂内容")    private String FContent;    @ApiDocElement("启用标识")    private String FExp;}