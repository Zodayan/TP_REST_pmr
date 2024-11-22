package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.pmr_controller_data.DataGetPmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataPostAddPmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataDeletePmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataPutUpdatePmr;
import org.example.tp_rest_pmr.service.PmrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PmrController
{

    private final PmrService pmrService;

    @Autowired
    public PmrController(PmrService pmrService)
    {
        this.pmrService = pmrService;
    }

    @GetMapping(value = "/pmr/getAllPmr")
    public String getAllPmr()
    {
        return pmrService.getAllPmr().toString();
    }

    @GetMapping(value = "/pmr/getPmr")
    public String getPmr(DataGetPmr data)
    {
        return pmrService.getPmr(data.getId()).toString();
    }

    @PostMapping(value = "/pmr/addPmr")
    public String postAddPmr(@RequestBody DataPostAddPmr data)
    {
        pmrService.addPmr(data.getNom(), data.getQuantite(), data.getDescription(), data.getPointGeo());
        return "Pmr Added";
    }

    @PutMapping(value = "/pmr/updatePmr")
    public String putUpdatePmr(@RequestBody DataPutUpdatePmr data)
    {
        pmrService.updatePmr(data.getId(),data.getNom(), data.getQuantite(), data.getDescription(), data.getPointGeo());
        return "Pmr Updated";
    }

    @DeleteMapping(value = "/pmr/deletePmr")
    public String deletePmr(@RequestBody DataDeletePmr data)
    {
        pmrService.deletePmr(data.getId());
        return "Pmr Deleted";
    }
}
