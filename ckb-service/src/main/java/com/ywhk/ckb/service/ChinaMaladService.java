package com.ywhk.ckb.service;import com.ywhk.ckb.dao.model.core.ChinaMaladEntity;import com.ywhk.ckb.service.dto.medspec.UpdateMedRequest;import com.ywhk.ckb.service.dto.medspec.UpdateMedResponse;import org.springframework.stereotype.Service;import java.util.List;@Servicepublic interface ChinaMaladService {    List<ChinaMaladEntity> queryChinaMaladList();    void deleteChinaMaladById(Integer id);    ChinaMaladEntity updateChinaMaladEntity(ChinaMaladEntity chinaMaladEntity);    void deleteInBatch(List<ChinaMaladEntity> list);}