package com.ywhk.ckb.service.impl;import com.ywhk.ckb.common.http.response.PaginationResponse;import com.ywhk.ckb.dao.model.core.TItemAdviceEntity;import com.ywhk.ckb.dao.repository.DiseaseListRepository;import com.ywhk.ckb.dao.repository.TItemAdviceRepository;import com.ywhk.ckb.service.TItemAdviceService;import com.ywhk.ckb.service.dto.titemadvice.*;import org.springframework.beans.BeanUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Page;import org.springframework.stereotype.Service;import java.util.ArrayList;import java.util.List;@Service("tItemAdvice")public class TItemAdviceServiceImpl implements TItemAdviceService {    @Autowired    private TItemAdviceRepository tItemAdviceRepository;    @Autowired    private DiseaseListRepository diseaseListRepository;    /**     * 查询方剂列表     * @param request     * @return     */    @Override    public PaginationResponse<QueryTItemAdviceListResponse> queryTItemAdviceList(QueryTItemAdviceListRequest request) {        List<QueryTItemAdviceListResponse> ret = new ArrayList<>();        Page<TItemAdviceEntity> lists = null;        if (request.getFNAME() == null) {            lists = tItemAdviceRepository.findAll(request.getPageRequest());        } else {            lists = tItemAdviceRepository.findByFNAMELike(request.getFNAME(), request.getPageRequest());        }        lists.getContent().forEach(list -> {            QueryTItemAdviceListResponse d = new QueryTItemAdviceListResponse();            BeanUtils.copyProperties(list, d);            ret.add(d);        });        return new PaginationResponse<>(lists, ret);    }    /**     * 新增、修改方剂信息     * @param request     * @return     */    @Override    public UpdateTItemAdviceResponse updateTItemAdvice(UpdateTItemAdviceRequest request) {        TItemAdviceEntity tItemAdviceEntity = null;        if (request.getFItemAdviceID() == null) {            tItemAdviceEntity = new TItemAdviceEntity();            BeanUtils.copyProperties(request, tItemAdviceEntity);        } else {            tItemAdviceEntity = tItemAdviceRepository.findByFItemAdviceID(request.getFItemAdviceID());            if (tItemAdviceEntity == null) {                return null;            } else {                BeanUtils.copyProperties(request, tItemAdviceEntity);            }        }        tItemAdviceRepository.save(tItemAdviceEntity);        return new UpdateTItemAdviceResponse();    }    /**     * 删除方剂     * @param request     * @return     */    @Override    public DelTItemAdviceResponse delTItemAdvice(DelTItemAdviceRequest request) {        if (tItemAdviceRepository.findByFItemAdviceID(request.getFItemAdviceID()) == null) {            System.out.println("当前方剂不存在");            return null;        }        tItemAdviceRepository.deleteById(request.getFItemAdviceID());        return new DelTItemAdviceResponse();    }}