package com.example.ElectronicVotingSyatem.Controller;

import com.example.ElectronicVotingSyatem.Config.BsicUtil;
import com.example.ElectronicVotingSyatem.DTO.Result;
import com.example.ElectronicVotingSyatem.DTO.VoterDTO;
import com.example.ElectronicVotingSyatem.Repository.VoterRepo;
import com.example.ElectronicVotingSyatem.Service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/voter")
    public ResponseEntity<Result> createVoter(@RequestBody VoterDTO voterDTO) {
        Result result = voterService.craeteVoter(voterDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/get/voter")
    public ResponseEntity<Result> getAllvoter() {
        Result allVoter = voterService.getAllVoter();
        return new ResponseEntity<Result>(allVoter, HttpStatus.OK);
    }

    @PostMapping("/get/countTotalVoterByConstituency")
    public ResponseEntity<Result> countTotalVoterByConstituency(@RequestParam String name) {
        Result result = voterService.countTotalVoterByConstituency(name);
        return new ResponseEntity<Result>(result, HttpStatus.OK);
    }

    @GetMapping("/get/single")
    public ResponseEntity<Result> voterCrenditalById(@RequestParam int id) {
        Result singleVoter = voterService.getSingleVoter(id);
        return new ResponseEntity<Result>(singleVoter, HttpStatus.OK);
    }

    @GetMapping("/get/countTotalVoter")
    public ResponseEntity<Result> countTotalVoter() {
        Result result = voterService.countTotalVoter();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/get/totalVoterDetailsByConstituency")
    public ResponseEntity<Result> totalVoterDetailsByConstituency(@RequestParam String name) {
        Result result = voterService.totalVoterDetailsByConstituency(name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getAllVoterByGender")
    public ResponseEntity<Result> totalVoterByGender(@RequestParam String gender) {
        Result result = voterService.totalVoterByGender(gender);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
