package com.example.ElectronicVotingSyatem.ServiceImpl;

import com.example.ElectronicVotingSyatem.Config.BsicUtil;
import com.example.ElectronicVotingSyatem.DTO.ConstituencyDTO;
import com.example.ElectronicVotingSyatem.DTO.Result;
import com.example.ElectronicVotingSyatem.DTO.VoterDTO;
import com.example.ElectronicVotingSyatem.Model.Constituency;
import com.example.ElectronicVotingSyatem.Model.Voter;
import com.example.ElectronicVotingSyatem.Repository.ConstituencyRepo;
import com.example.ElectronicVotingSyatem.Repository.VoterRepo;
import com.example.ElectronicVotingSyatem.Service.VoterService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterRepo voterRepo;

    @Autowired
    private static final Logger log = LoggerFactory.getLogger(VoterServiceImpl.class);


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConstituencyRepo constituencyRepo;

    @Override
    public Result countTotalVoter() {
        List<Voter> all = voterRepo.findAll();
        log.debug("calling the findAll {}",all);
        int size = all.size();
        return BsicUtil.prepareResponseObject("002","Get Count of voter",size);
    }

    @Override
    public Result getAllVoter() {
        List<Voter> all = voterRepo.findAll();
        return BsicUtil.prepareResponseObject("001", "Voter fetch successfully", all);
    }

    @Override
    public Result getSingleVoter(int id) {
        log.debug("the given id id {}" + id);
        if (BsicUtil.isNullOrEmpty(id)) {
            return BsicUtil.prepareResponseObject("002", "No id available", null);
        }
        Voter voter = voterRepo.findById(id).get();
        log.debug("calling to the findById Method {}" + voter);
        return BsicUtil.prepareResponseObject("003", "Record fetched successfully", voter);
    }

    @Override
    public Result craeteVoter(VoterDTO voter) {
        if (BsicUtil.isNullOrEmpty(voter)) {
            return BsicUtil.prepareResponseObject("002", "NoVoter Data available", null);
        }
        Result validTocraete = isValidTocraete(voter);
        if (!validTocraete.getMessage().equals("")) {
            return validTocraete;
        }
        Voter map = this.modelMapper.map(voter, Voter.class);
        Constituency byName = constituencyRepo.findByName(voter.getConstituencyDTO().getName());
        if(BsicUtil.isNullOrEmpty(byName)){
            return BsicUtil.prepareResponseObject("003","constitute name was not present",null);
        }
        map.setConstituency(byName);
        Voter save = voterRepo.save(map);
        return BsicUtil.prepareResponseObject("002", "Voter created SuccessFully", map);
    }

    @Override
    public Result countTotalVoterByConstituency(String name) {
        if (BsicUtil.isNullOrEmpty(name)) {
            return BsicUtil.prepareResponseObject("002", "No name is avilable", null);
        }
        Constituency byName = constituencyRepo.findByName(name);
        if (BsicUtil.isNullOrEmpty(byName)) {
            return BsicUtil.prepareResponseObject("003", "No Data are avilable", null);
        }
        Pageable pageable = PageRequest.of(0, 10);
        Page<Voter> byConstituency = voterRepo.findByConstituency(byName, pageable);
        System.out.println(byConstituency);
        long totalElements = byConstituency.getTotalElements();
        return BsicUtil.prepareResponseObject("004", "Total no of countTotalVoterByConstituency", totalElements);
    }

    @Override
    public Result totalVoterDetailsByConstituency(String name) {
        log.warn("the given name {}" + name);
        if (BsicUtil.isNullOrEmpty(name)) {
         return BsicUtil.prepareResponseObject("002","name is not present",null);
        }
        Constituency byName = constituencyRepo.findByName(name);
        if(BsicUtil.isNullOrEmpty(byName)){
            return  BsicUtil.prepareResponseObject("003","No records found by the name",null);
        }
        Pageable pageable = PageRequest.of(0, 10);
        Page<Voter> byConstituency = voterRepo.findByConstituency(byName, pageable);
        return  BsicUtil.prepareResponseObject("004","All voter fetch successfully by the Constituency",byConstituency);
    }

    @Override
    public Result totalVoterByGender(String gender) {
        if(BsicUtil.isNullOrEmpty(gender)){
            return  BsicUtil.prepareResponseObject("003","No gender is available",null);
        }
        List<Voter> byGender = voterRepo.findByGender(gender);
        return  BsicUtil.prepareResponseObject("003","ALL voter fetch By gender",byGender);
    }

    private static Result isValidTocraete(VoterDTO voterDTO) {

        if (BsicUtil.isNullOrEmpty(voterDTO.getName())) {
            return BsicUtil.prepareResponseObject("", "name should not be empty", null);
        }
        if (BsicUtil.isNullOrEmpty(voterDTO.getAge())) {
            return BsicUtil.prepareResponseObject("", "age should not be empty", null);
        }
        if (BsicUtil.isNullOrEmpty(voterDTO.getGender())) {
            return BsicUtil.prepareResponseObject("", "Gender should not be empty", null);
        }
        return BsicUtil.prepareResponseObject("", "", null);
    }
}
