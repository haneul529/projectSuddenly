package sku.lesson.fruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sku.lesson.fruit.dao.FruitDAO;
import sku.lesson.fruit.dto.FruitDTO;

import java.util.ArrayList;

@Service
public class FruitService {

    @Autowired
    private FruitDAO dao;

    public boolean checkId(Integer id) {
        boolean flag = false;
        flag = dao.selectById(id);
        return flag;
    }

    public boolean registFruit(FruitDTO fruit) {
        boolean flag = false;
        flag = dao.insert(fruit);
        return flag;
    }

    public ArrayList<FruitDTO> getFruitData() {
        ArrayList<FruitDTO> list = dao.selectAll();
        return list;
    }

    public FruitDTO findById(Integer id) {
        FruitDTO dto = null;
        dto = dao.select(id);
        return dto;
    }

    public boolean modifyFruit(FruitDTO dto) {
        boolean flag = false;
        dao.update(dto);
        return flag;
    }

    public boolean remove(Integer id) {
        boolean flag = false;
        flag = dao.delete(id);
        return flag;
    }


}
