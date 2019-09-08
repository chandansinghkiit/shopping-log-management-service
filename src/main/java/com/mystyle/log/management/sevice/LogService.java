package com.mystyle.log.management.sevice;
import java.util.List;

import com.mystyle.log.management.model.Log;
import com.mystyle.log.management.model.Summary;

public interface LogService {
    Summary findSummaryByProductId(Long productId);

    Log saveOrUpdate(Log log);

    Summary saveOrUpdate(Summary summary);

    List<Summary> findPopularProduct();
}