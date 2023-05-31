package com.example.russianidioms.dao;

import com.example.russianidioms.domain.WordFromDic;
import com.example.russianidioms.domain.WordFromDrDic;

import java.util.List;

public interface RussionIdiomsDao {

    long insert(WordFromDic wordFromDic);
    List<WordFromDic> findAll();
    WordFromDic findById(long id);
    int update(long id, WordFromDic wordFromDic);
    int deleteById(long id);

}
