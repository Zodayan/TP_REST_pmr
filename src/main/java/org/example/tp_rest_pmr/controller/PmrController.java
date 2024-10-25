package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.pmr_controller_data.DataGetPmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataPostAddPmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataDeletePmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataPutUpdatePmr;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/pmr", params = "action=updatePmr")
    public String putUpdatePmr(@RequestBody DataPutUpdatePmr data)
    {
        return "updatePmr" + data;
    }

    @DeleteMapping(value = "/pmr", params = "action=deletePmr")
    public String deletePmr(@RequestBody DataDeletePmr data)
    {
        return "deletePmr" + data;
    }
}
