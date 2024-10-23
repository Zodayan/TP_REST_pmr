package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.pmr_controller_data.DataGetPmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataPostAddPmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataPostDeletePmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataPostUpdatePmr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PmrController
{

    @GetMapping(value = "/pmr", params = "action=getAllPmr")
    public String getAllPmr()
    {
        return "getAllPmr";
    }

    @GetMapping(value = "/pmr", params = "action=getPmr")
    public String getPmr(DataGetPmr data)
    {
        return "getPmr" + data;
    }

    @PostMapping(value = "/pmr", params = "action=addPmr")
    public String postAddPmr(@RequestBody DataPostAddPmr data)
    {
        return "postAddPmr" + data;
    }

    @PostMapping(value = "/pmr", params = "action=updatePmr")
    public String postUpdatePmr(@RequestBody DataPostUpdatePmr data)
    {
        return "updatePmr" + data;
    }

    @PostMapping(value = "/pmr", params = "action=deletePmr")
    public String postDeletePmr(@RequestBody DataPostDeletePmr data)
    {
        return "deletePmr" + data;
    }
}
