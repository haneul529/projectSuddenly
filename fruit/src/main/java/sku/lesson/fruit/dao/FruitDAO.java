package sku.lesson.fruit.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sku.lesson.fruit.dto.FruitDTO;

import java.util.ArrayList;

@Repository
public class FruitDAO {

    @Autowired
    private SqlSession sqlSession;

    public boolean insert(FruitDTO fruit) {
        boolean flag = false;
        int affectedCount = sqlSession.insert("mapper.fruit.insert", fruit);
        if(affectedCount>0) {
            flag = true;
        }
        return flag;
    }

    public ArrayList<FruitDTO> selectAll() {
        ArrayList<FruitDTO> list = null;
        list = (ArrayList)sqlSession.selectList("mapper.fruit.selectAll");

        return list;
    }

    public FruitDTO select(Integer id) {
        FruitDTO dto = null;
        dto = sqlSession.selectOne("mapper.fruit.select", id);

        return dto;
    }

    public boolean update(FruitDTO dto) {
        boolean flag = false;
        int affectedCount = sqlSession.update("mapper.fruit.update", dto);
        if(affectedCount>0) {
            flag = true;
        }
        return flag;
    }

    public boolean delete(Integer id) {
        boolean flag = false;
        int affectedCount = sqlSession.delete("mapper.fruit.delete", id);
        if(affectedCount>0) {
            flag = true;
        }
        return flag;
    }

    public boolean selectById(Integer id) {
        boolean flag = false;
        int affectedCount = sqlSession.selectOne("mapper.fruit.selectById", id);
        if(affectedCount>0) {
            flag = true;
        }
        return flag;
    }

}
