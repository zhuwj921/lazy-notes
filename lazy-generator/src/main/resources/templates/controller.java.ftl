package ${package.Controller};


import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.zhuwj.common.response.ResponseResult;
import java.util.Map;
import com.zhuwj.common.enums.ErrorCodeEnum;
import org.springframework.web.bind.annotation.*;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
@RequiredArgsConstructor
@Slf4j
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    private final ${table.serviceName} ${table.serviceName?uncap_first};

    /**
    * 分页查询
    * @param pageNum
    * @param pageSize
    * @param map
    */
    @GetMapping("/page")
    public ResponseResult page(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize,Map map){
        Page page = new Page(pageNum,pageSize);
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        IPage result = ${table.serviceName?uncap_first}.page(page,wrapper);
        return ResponseResult.ok(result);
    }

    /**
    * 根据ID查找数据
    * @param id
    */
    @GetMapping("{id}")
    public ResponseResult find(@PathVariable("id") Long id){
        ${entity} result = ${table.serviceName?uncap_first}.getById(id);
        return ResponseResult.ok(result);
    }

    /**
    * 保存数据
    * @param ${entity?uncap_first}
    */
    @PostMapping
    public ResponseResult save(@RequestBody ${entity} ${entity?uncap_first}){
        ${entity?uncap_first}.init();
        ${table.serviceName?uncap_first}.save(${entity?uncap_first});
        return ResponseResult.ok();
    }

    /**
    * 修改数据
    * @param ${entity?uncap_first}
    */
    @PutMapping
    public ResponseResult update(@RequestBody ${entity} ${entity?uncap_first}) {

        ${entity} result = ${table.serviceName?uncap_first}.getById(${entity?uncap_first}.getId());
        if(result == null){
            return ResponseResult.error(ErrorCodeEnum.DATA_NOT_EXIST);
         }
        ${entity?uncap_first}.modify(result);
        ${table.serviceName?uncap_first}.updateById(${entity?uncap_first});
        return ResponseResult.ok();
    }

    /**
    * 根据id删除数据
    * @param id
    */
    @DeleteMapping("{id}")
    public ResponseResult delete(@PathVariable("id") Long id) {
        ${entity} result = ${table.serviceName?uncap_first}.getById(id);
        if(result == null){
          return ResponseResult.error(ErrorCodeEnum.DATA_NOT_EXIST);
        }
        ${table.serviceName?uncap_first}.removeById(id);
        return ResponseResult.ok();
    }
}
</#if>
