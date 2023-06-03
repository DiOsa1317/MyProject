package com.example.russianidioms.dao;

import com.example.russianidioms.domain.IdiomTest;
import com.example.russianidioms.domain.WordFromDic;

import java.util.List;

public interface IdiomTestsDao {
    long insert(IdiomTest idiomTest);
    List<IdiomTest> findAll();
    IdiomTest findById(long id);
    int update(long id, IdiomTest idiomTest);
    int deleteById(long id);
}
