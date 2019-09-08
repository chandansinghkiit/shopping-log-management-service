package com.mystyle.log.management.sevice;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mystyle.log.management.model.Log;
import com.mystyle.log.management.model.Summary;
import com.mystyle.log.management.repository.LogRepository;
import com.mystyle.log.management.repository.SummaryRepository;

@Transactional
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    @Override
    public Summary findSummaryByProductId(Long productId) {
        return summaryRepository.findByProductId(productId).orElse(null);
    }

    @Override
    public Log saveOrUpdate(Log log) {
    	
        Summary existSummary = summaryRepository.findByProductId(log.getProductId()).orElse(null);
        if(existSummary!=null){
            summaryRepository.delete(existSummary);
            existSummary.setHitCount(existSummary.getHitCount()+1);
            summaryRepository.save(existSummary);
        }else{
            Summary summary = new Summary();
            summary.setProductId(log.getProductId());
            summary.setHitCount(1L);
            summaryRepository.save(summary);
        }
        log.setId(UUID.randomUUID());
        logRepository.save(log);
        return log;
    }

    @Override
    public Summary saveOrUpdate(Summary summary) {
        summaryRepository.save(summary);
        return summary;
    }


    @Override
    public List<Summary> findPopularProduct(){
        return summaryRepository.findPopularProduct();
    }
}