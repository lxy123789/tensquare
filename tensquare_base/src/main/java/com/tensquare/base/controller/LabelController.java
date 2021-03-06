package com.tensquare.base.controller;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 标签控制层
 */
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;
    /**
     * 查询全部列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findAll() );
    }
    /**
     * 根据ID查询标签
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        System.out.println("No.1");
        return new Result(true,StatusCode.OK,"查询成功",labelService.findById(id));
    }
    /**
     * 增加标签
     * @param label
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add( @RequestBody Label label){
        labelService.add(label);
        return new Result(true,StatusCode.OK,"增加成功");
    }
        /**
         * 修改标签
         * @param label
         * @return
         */
        @RequestMapping(value="/{id}" ,method = RequestMethod.PUT)
        public Result update( @RequestBody Label label,@PathVariable String id){
            label.setId(id);
            labelService.update(label);
            return new Result(true,StatusCode.OK,"修改成功");
        }
        /**
         * 删除标签
         * @param id
         * @return
         */
        @RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
        public Result deleteById(@PathVariable String id){
            labelService.deleteById(id);
            return new Result(true,StatusCode.OK,"删除成功");
        }

        @RequestMapping(value="/search/{page}/{size}",method = RequestMethod.POST)
        public Result searchLabelPage(@PathVariable Integer page,@PathVariable Integer size,@RequestBody Label label){
            return new Result(true,StatusCode.OK,"标签，模糊分页成功",labelService.searchLabelPage(page,size,label));
        }


    }