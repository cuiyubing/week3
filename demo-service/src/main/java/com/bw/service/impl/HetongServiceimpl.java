package com.bw.service.impl;

import com.bw.dao.HeToDao;
import com.bw.dao.MoneysDao;
import com.bw.entity.Hetong;
import com.bw.entity.Moneys;
import com.bw.entity.MoneysVO;
import com.bw.service.HetongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class HetongServiceimpl implements HetongService {
    @Autowired
    private MoneysDao moneysDao;
    @Autowired
    private HeToDao heToDao;

    @Override
    public Page<Moneys> selectMoneyList(MoneysVO moneysVO) {
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                //根据收款人
                if(moneysVO.getType()!=null&&!moneysVO.getType().equals("")) {
                    if (moneysVO.getHuiName() != null && !moneysVO.getHuiName().equals("")) {
                        Predicate c = cb.like(root.get("huiName"), "%"+moneysVO.getHuiName()+"%");
                        list.add(c);
                    }
                }
                //根据余额查询
                if(moneysVO.getPropName()!=null&&!moneysVO.getPropName().equals("")){
                    //最小余额
                    if(moneysVO.getStartyue()!=null){
                        Predicate c1 = cb.gt(root.get("yue"), moneysVO.getStartyue());
                        list.add(c1);
                    }
                    //最大余额
                    if(moneysVO.getEndyue()!=null){
                        Predicate c2 = cb.lt(root.get("yue"), moneysVO.getEndyue());
                        list.add(c2);
                    }
                }
                //根据合同编号查询
                if(moneysVO.getId()!=null&&!moneysVO.getId().equals("")){
                    Predicate c3 = cb.like(root.get("id"), "%"+moneysVO.getId()+"%");
                    list.add(c3);
                }
                //回款日期
                if(moneysVO.getHuiTimestart()!=null&&!moneysVO.getHuiTimestart().equals("")){
                    Predicate c4 = cb.greaterThan(root.get("huiTime"), moneysVO.getHuiTimestart());
                    list.add(c4);
                }
                if(moneysVO.getHuiTimeend()!=null&&!moneysVO.getHuiTimeend().equals("")){
                    Predicate c5 = cb.lessThan(root.get("huiTime"), moneysVO.getHuiTimeend());
                    list.add(c5);
                }

                Predicate[] arr = list.toArray(new  Predicate[list.size()]);

                return cb.and(arr);
            }
        };
        return moneysDao.findAll(spec,PageRequest.of(moneysVO.getPageNum()-1,moneysVO.getPageSize()));
    }

    @Override
    public int add(Moneys moneys) {
        Moneys save = moneysDao.save(moneys);
        if(save!=null){
            return 1;
        }
        return 1;
    }


    @Override
    public int del(String[] ids) {

        return moneysDao.deleteAllByIds(ids);
    }

    @Override
    public List<Hetong> selectHetongList() {
        return heToDao.findAll();
    }
}
