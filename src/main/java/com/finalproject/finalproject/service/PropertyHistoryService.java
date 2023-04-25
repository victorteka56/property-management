package com.finalproject.finalproject.service;

import com.finalproject.finalproject.domain.PropertyHistory;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PropertyHistoryService {

    List<PropertyHistory> findFirst10ByDate(Date date, Pageable pageable);
}
