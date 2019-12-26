package com.ywhk.ckb.service.dto.user;

import com.ywhk.ckb.common.doc.annotation.ApiDocElement;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class LoginResponse implements Serializable {
    @ApiDocElement("用户登录后token")
    private String token;

    @ApiDocElement("人员ID")
    private Integer FUserid;
    @ApiDocElement("科室ID")
    private Integer Fgroupid;
//    @ApiDocElement("科室名称")
//    private String FgroupName;
    @ApiDocElement("机构ID")
    private Integer MechanismID;
    @ApiDocElement("机构名称")
    private String MechanismName;
    @ApiDocElement("编码")
    private String FNumber;
    @ApiDocElement("名称")
    private String FName;
    @ApiDocElement("密码")
    private String FPassword;
    @ApiDocElement("职务")
    private String FJob;
    @ApiDocElement("类型")
    private Integer FType;
    //    @ApiDocElement("拼音码")
//    private String FPy;
//    @ApiDocElement("五笔码")
//    private String FWb;
//    @ApiDocElement("备注")
//    private String FExp;
//    @ApiDocElement("启用标识")
//    private Integer FMark;
    @ApiDocElement("创建日期")
    private Date FCreateDate;
    //    @ApiDocElement("创建人")
//    private Integer FCreateuserID;
    @ApiDocElement("修改日期")
    private Date FModifyDate;
//    @ApiDocElement("修改人")
//    private Integer FModifyUserID;

}
