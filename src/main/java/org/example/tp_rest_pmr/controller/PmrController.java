package org.example.tp_rest_pmr.controller;

import org.example.tp_rest_pmr.controller.pmr_controller_data.*;
import org.example.tp_rest_pmr.controller.utilisateur_controller_data.DataCheckUsername;
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

    @GetMapping(value = "/pmr/getPmr/{idPmr}")
    public ResponseEntity<PmrDTO> getPmr(@PathVariable Integer idPmr)
    {
        try {
            PmrDTO pmr = pmrService.getPmr(idPmr);
            return ResponseEntity.ok(pmr);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/pmr/isPmrCreate")
    public boolean isPmrCreate(@RequestBody DataCheckCreate data)
    {
        return pmrService.isPmrCreate(data.getId());
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

    @DeleteMapping(value = "/pmr/deletePmr/{pmrId}")
    public ResponseEntity<Response> deletePmr(@PathVariable Integer pmrId)
    {
        try {
            pmrService.deletePmr(pmrId);
            return ResponseEntity.ok(new Response("Pmr Deleted"));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
