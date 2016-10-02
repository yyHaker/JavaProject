package cn.thinking.system.unit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.thinking.org.system.unit.Unit;
import cn.thinking.system.unit.service.UnitService;

@Controller
@RequestMapping(value = UnitController.modulePath)
public class UnitController {

    // 模块页面根路径
    public static final String modulePath = "module/system/unit";
    @Autowired
    private UnitService unitService;

    /**
     * 显示机构列表
     * @param model
     * @return
     */
    @RequestMapping
    public String list(Model model) {
        List<Unit> unitList = unitService.listAllParentUnit();
        model.addAttribute("unitList", unitList);
        return UnitController.modulePath + "/units.jsp";
    }

    /**
     * 请求新增机构页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/add")
    public String toAdd(Model model) {
        List<Unit> unitList = unitService.listAllParentUnit();
        model.addAttribute("unitList", unitList);
        return UnitController.modulePath + "/unit_info.jsp";
    }

    /**
     * 请求编辑机构页面
     * @param orgId
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit")
    public String toEdit(@RequestParam
    String orgId, Model model) {
        Unit unit = unitService.getUnitById(orgId);
        model.addAttribute("unit", unit);
        if (unit.getParentId() != null) {
            List<Unit> unitList = unitService.listAllParentUnit();
            model.addAttribute("unitList", unitList);
        }
        return UnitController.modulePath + "/unit_info.jsp";
    }

    /**
     * 保存机构信息
     * @param unit
     * @param model
     * @return
     */
    @RequestMapping(value = "/save")
    public String save(Unit unit, Model model) {
        unitService.saveUnit(unit);
        model.addAttribute("msg", "success");
        return "module/common/save_result.jsp";
    }

    /**
     * 获取当前机构的所有子机构
     * @param orgId
     * @param response
     */
    @RequestMapping(value = "/sub")
    public void getSub(@RequestParam
    String orgId, HttpServletResponse response) {
        List<Unit> subUnits = unitService.listSubUnitByParentId(orgId);
        JSONArray arr = JSONArray.fromObject(subUnits);
        PrintWriter out;
        try {
            response.setCharacterEncoding("utf-8");
            out = response.getWriter();
            String json = arr.toString();
            out.write(json);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 删除机构
     * @param orgId
     * @param out
     */
    @RequestMapping(value = "/del")
    public void delete(@RequestParam
    String orgId, PrintWriter out) {
        unitService.deleteUnitById(orgId);
        out.write("success");
        out.flush();
        out.close();
    }
}
