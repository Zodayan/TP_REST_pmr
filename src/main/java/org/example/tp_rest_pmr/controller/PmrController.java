package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.pmr_controller_data.DataGetPmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataPostAddPmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataDeletePmr;
import org.example.tp_rest_pmr.controller.pmr_controller_data.DataPutUpdatePmr;
import org.example.tp_rest_pmr.dto.PmrDTO;
import org.example.tp_rest_pmr.service.PmrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

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
    public ResponseEntity<ArrayList<PmrDTO>> getAllPmr()
    {
        return ResponseEntity.ok(pmrService.getAllPmr());
    }

    @GetMapping(value = "/pmr/getPmr")
    public ResponseEntity<PmrDTO> getPmr(DataGetPmr data)
    {
        try {
            PmrDTO pmr = pmrService.getPmr(data.getId());
            return ResponseEntity.ok(pmr);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/pmr/addPmr")
    public ResponseEntity<Response> postAddPmr(@RequestBody DataPostAddPmr data)
    {
        try {
            pmrService.addPmr(data.getNom(), data.getQuantite(), data.getDescription(), data.getPointGeo());
            return ResponseEntity.ok(new Response("Pmr Added"));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/pmr/updatePmr")
    public ResponseEntity<Response> putUpdatePmr(@RequestBody DataPutUpdatePmr data)
    {
        try {
            pmrService.updatePmr(data.getId(),data.getNom(), data.getQuantite(), data.getDescription(), data.getPoint_geo());
            return ResponseEntity.ok(new Response("Pmr Updated"));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/pmr/deletePmr")
    public ResponseEntity<Response> deletePmr(@RequestBody DataDeletePmr data)
    {
        try {
            pmrService.deletePmr(data.getId());
            return ResponseEntity.ok(new Response("Pmr Deleted"));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
