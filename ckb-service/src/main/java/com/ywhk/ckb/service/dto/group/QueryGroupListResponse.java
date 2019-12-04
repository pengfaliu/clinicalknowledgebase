package com.ywhk.ckb.service.dto.group;import com.ywhk.ckb.common.doc.annotation.ApiDocElement;import lombok.Data;import java.io.Serializable;import java.util.Date;@Datapublic class QueryGroupListResponse implements Serializable {    @ApiDocElement("科室ID")    private Integer FGROUPID;    @ApiDocElement("机构ID")    private Integer MechanismID;    @ApiDocElement("序号")    private Integer FOrderNumber;    @ApiDocElement("编码")    private String FNumber;    @ApiDocElement("名称")    private String FName;    @ApiDocElement("拼音码")    private String FPy;    @ApiDocElement("五笔码")    private String FWb;    @ApiDocElement("备注")    private String FExp;    @ApiDocElement("启用标示")    private Integer Fmark;    @ApiDocElement("创建日期")    private Date FCreateDate;    @ApiDocElement("创建人")    private Integer FCreateuserID;    @ApiDocElement("修改日期")    private Date FModifyDate;    @ApiDocElement("修改人")    private Integer FModifyUserID;}