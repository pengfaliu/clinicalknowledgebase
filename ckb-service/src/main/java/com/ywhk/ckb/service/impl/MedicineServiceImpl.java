package com.ywhk.ckb.service.impl;import com.ywhk.ckb.common.http.response.PaginationResponse;import com.ywhk.ckb.dao.model.core.DirectoryEntity;import com.ywhk.ckb.dao.model.core.MedSpecEntity;import com.ywhk.ckb.dao.model.core.MedSpecInstructionEntity;import com.ywhk.ckb.dao.repository.DirectoryRepository;import com.ywhk.ckb.dao.repository.MedSpecInstructionRepository;import com.ywhk.ckb.dao.repository.MedSpecRespository;import com.ywhk.ckb.service.MedicineService;import com.ywhk.ckb.service.dto.medspec.*;import org.springframework.beans.BeanUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Page;import org.springframework.stereotype.Service;import java.util.ArrayList;import java.util.Date;import java.util.List;@Service("medicineService")public class MedicineServiceImpl implements MedicineService {    @Autowired    private DirectoryRepository directoryRepository;    @Autowired    private MedSpecRespository medSpecRespository;    @Autowired    private MedSpecInstructionRepository medSpecInstructionRepository;    /**     * 查询所有药品分类     * @return     */    @Override    public List<DirectoryDto> queryMedType () {        return queryDirectoryByFParentID(0);    }    private List<DirectoryDto> queryDirectoryByFParentID (Integer id) {        List<DirectoryDto> ret = new ArrayList<>();        List<DirectoryEntity> directorys = directoryRepository.findByFParentID(id);        directorys.forEach(directory -> {            DirectoryDto d = new DirectoryDto();            BeanUtils.copyProperties(directory, d);            d.setChildrens(queryDirectoryByFParentID(directory.getDirectoryID()));            ret.add(d);        });        return ret;    }    /**     * 查询所有药品 以及模糊查询     * @param request     * @return     */    @Override    public PaginationResponse<QueryAllMedListResponse> queryAllMedList(QueryAllMedListRequest request) {        List<QueryAllMedListResponse> ret = new ArrayList<>();        Page<MedSpecEntity> lists;        if(request.getDirectoryID()!=null&&request.getFMedSpecName()!=null){            lists =medSpecRespository.findByDirectoryIDAndFMedSpecNameLike(request.getDirectoryID(),"%" + request.getFMedSpecName()+"%",request.getPageRequest());        }else if(request.getFMedSpecName()!=null){            lists =medSpecRespository.findByFMedSpecNameLike("%"+request.getFMedSpecName()+"%",request.getPageRequest());        }else if(request.getDirectoryID()!=null){            lists =medSpecRespository.findByDirectoryID(request.getDirectoryID(),request.getPageRequest());        }else{             lists = medSpecRespository.findAll(request.getPageRequest());        }        lists.getContent().forEach(list -> {            QueryAllMedListResponse d = new QueryAllMedListResponse();            BeanUtils.copyProperties(list, d);            ret.add(d);        });        return new PaginationResponse<>(lists, ret);    }    /**     * 根据药品分类查询药品目录     * @param request     * @return     */    @Override    public PaginationResponse<QueryMedListResponse> queryMedList (QueryMedListRequest request) {        List<QueryMedListResponse> ret = new ArrayList<>();        Page<MedSpecEntity> lists = medSpecRespository.findByDirectoryID(request.getDirectoryID(), request.getPageRequest());        lists.getContent().forEach(list -> {            QueryMedListResponse d = new QueryMedListResponse();            BeanUtils.copyProperties(list, d);            ret.add(d);        });        return new PaginationResponse<>(lists, ret);    }    /**     * 新增和修改药品信息     * @param request     * @return     */    @Override    public UpdateMedResponse updateMed(UpdateMedRequest request) {        Date date = new Date();        MedSpecEntity medSpecEntity = null;        if (request.getFMedSpecID() == null) {            medSpecEntity = new MedSpecEntity();            BeanUtils.copyProperties(request, medSpecEntity);            request.setFCreateDate(date);        } else {            medSpecEntity = medSpecRespository.findByFMedSpecID(request.getFMedSpecID());            if (medSpecEntity == null) {                System.out.println("当前药品不存在");                return null;            } else {                BeanUtils.copyProperties(request, medSpecEntity);            }        }        request.setFModifyDate(date);        medSpecRespository.save(medSpecEntity);        return new UpdateMedResponse();    }    /**     * 查询药品详情     * @param medSpecEntity     * @return     */    @Override    public List<MedSpecEntity> queryMedDetail(MedSpecEntity medSpecEntity) {//        return medSpecRespository.findByFMedSpecID(medSpecEntity.getFMedSpecID());        return null;    }    /**     * 根据药品ID查询药品说明书     * @param medSpecInstructionEntity     * @return     */    @Override    public  List<MedSpecInstructionEntity> queryMedInstructionById (MedSpecInstructionEntity medSpecInstructionEntity) {        return medSpecInstructionRepository.findByFMedSpecID(medSpecInstructionEntity.getFMedSpecID());    }    /**     * 批量删除药品详情     * @return     */    @Override    public void deleteInBatch(List<MedSpecEntity> list) {        medSpecRespository.deleteInBatch(list);    }}