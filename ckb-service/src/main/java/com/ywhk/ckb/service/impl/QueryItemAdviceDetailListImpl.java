package com.ywhk.ckb.service.impl;import com.aliyuncs.utils.StringUtils;import com.ywhk.ckb.common.http.response.PaginationResponse;import com.ywhk.ckb.dao.model.core.ItemAdviceDetailEntity;import com.ywhk.ckb.dao.repository.ItemAdviceDetailRepository;import com.ywhk.ckb.service.ItemAdviceDetailService;import com.ywhk.ckb.service.dto.itemadvicedetail.*;import org.springframework.beans.BeanUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Page;import org.springframework.stereotype.Service;import java.util.ArrayList;import java.util.List;@Service("itemAdviceSetail")public class QueryItemAdviceDetailListImpl implements ItemAdviceDetailService {    @Autowired    private ItemAdviceDetailRepository itemAdviceDetailRepository;    /**     * 中医方剂查询     * @return     */    @Override    public PaginationResponse<QueryItemAdviceDetailListResponse> queryUserList(QueryItemAdviceDetailListRequest request) {        List<QueryItemAdviceDetailListResponse> ret = new ArrayList<>();        Page<ItemAdviceDetailEntity> lists ;        if(request.getItemAdviceDetailID()!=null&&request.getFName()!=null){            lists=itemAdviceDetailRepository.findByItemAdviceDetailIDAndFName(request.getItemAdviceDetailID(), "%" + request.getFName() + "%", request.getPageRequest());        }else if(request.getItemAdviceDetailID()!=null){            lists=itemAdviceDetailRepository.findByItemAdviceDetailID(request.getItemAdviceDetailID(),request.getPageRequest());        }else if(request.getFName()!=null){            lists=itemAdviceDetailRepository.findByFName("%" + request.getFName() + "%", request.getPageRequest());        }else{            lists=itemAdviceDetailRepository.findAll(request.getPageRequest());        }        lists.getContent().forEach(list -> {            QueryItemAdviceDetailListResponse d = new QueryItemAdviceDetailListResponse();            BeanUtils.copyProperties(list, d);            ret.add(d);        });        return new PaginationResponse<>(lists, ret);    }    /**     * 修改、保存中医方剂信息     *     * @param request     * @return     */    @Override    public SaveAndUpdateItemAdviceDetailResponse saveUser(SaveAndUpdateItemAdviceDetailRequest request) {        ItemAdviceDetailEntity itemAdviceDetailEntity = null;        if (request.getItemAdviceDetailID() == null) {            itemAdviceDetailEntity = new ItemAdviceDetailEntity();            BeanUtils.copyProperties(request, itemAdviceDetailEntity);        } else {            itemAdviceDetailEntity = itemAdviceDetailRepository.deleteByItemAdviceDetailID(request.getItemAdviceDetailID());            if (itemAdviceDetailEntity == null) {                throw new RuntimeException("当前人员不存在");            } else {                BeanUtils.copyProperties(request, itemAdviceDetailEntity);            }        }        itemAdviceDetailRepository.save(itemAdviceDetailEntity);        return new SaveAndUpdateItemAdviceDetailResponse();    }    /**     * 删除中医方剂     * @param request     * @return     */    @Override    public DelItemAdviceDetailResponse delUser(DelItemAdviceDetailRequest request) {        if (request.getItemAdviceDetailID()==null) {            throw new NullPointerException("空指针异常");        }        itemAdviceDetailRepository.deleteById(request.getItemAdviceDetailID());        return new DelItemAdviceDetailResponse();    }    /**     * 批量删除中医方剂     * @return     */    @Override    public void deleteInBatch(List<ItemAdviceDetailEntity> list) {        itemAdviceDetailRepository.deleteInBatch(list);    }}