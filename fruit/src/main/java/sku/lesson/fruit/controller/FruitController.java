package sku.lesson.fruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sku.lesson.fruit.dto.FruitDTO;
import sku.lesson.fruit.service.FruitService;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/fruit")
public class FruitController {

    @Autowired
    private FruitService fs;

    @RequestMapping(value = "/ajax", method = RequestMethod.POST)
    @ResponseBody
    public String checkId(@RequestParam("fruit") Integer id) {
        boolean check = fs.checkId(id);
        return "{\"result\":"+check+"}";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(@ModelAttribute FruitDTO dto, BindingResult br) {
        if(br.hasErrors()) {
            System.out.println("error handling >>>" + dto);
        }

        boolean flag = fs.registFruit(dto);
        return "redirect:list";
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Model model) {
        ArrayList<FruitDTO> list = fs.getFruitData();
        model.addAttribute("list", list);
        System.out.println(" list >>"+list.size());
        return "./list";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("fruitId") Integer id, Model model) {
        FruitDTO dto = fs.findById(id);
        model.addAttribute("dto", dto);
        System.out.println("search >>"+id); // 에러가 난다면 id가 인티저라 그럴수 있음 String으로 변환할것
        return "./detail";
    }

    @RequestMapping(value = "/updateView", method = RequestMethod.GET)
    public String updateView(@RequestParam("fruitId") Integer id, Model model) {
        FruitDTO dto = fs.findById(id);
        model.addAttribute("dto", dto);
        System.out.println("update view >>> "+id);
        return "./update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute FruitDTO dto) {
        fs.modifyFruit(dto);
        System.out.println("update >>> "+dto.getFruitId());
        return "redirect:search?fruitId="+dto.getFruitId();
    }
    //delete
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("FruitId") Integer id) {
        fs.remove(id);
        System.out.println("delete >>> "+id);
        return "redirect:list";
    }

}
