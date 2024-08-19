package com.example.ElectronicVotingSyatem.Controller;

import com.example.ElectronicVotingSyatem.DTO.ConstituencyDTO;
import com.example.ElectronicVotingSyatem.DTO.Result;
import com.example.ElectronicVotingSyatem.Model.Constituency;
import com.example.ElectronicVotingSyatem.Service.ConstituencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v2")
public class ConstituencyController {
    @Autowired
    private ConstituencyService constituencyService;

    @PostMapping("/post")
    public ResponseEntity<Result> craeteConstituency(@RequestBody ConstituencyDTO constituency){
        Result result = constituencyService.craeteConstituency(constituency);
        return new ResponseEntity<Result>(result, HttpStatus.CREATED);
    }

    @GetMapping("/get/constitute")
    public ResponseEntity<Result> getAllConstitute(){
        Result allConstitute = constituencyService.getAllConstitute();
        return new ResponseEntity<>(allConstitute,HttpStatus.OK);
    }
}
