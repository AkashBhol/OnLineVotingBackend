package com.example.ElectronicVotingSyatem.ServiceImpl;

import com.example.ElectronicVotingSyatem.Config.BsicUtil;
import com.example.ElectronicVotingSyatem.DTO.ConstituencyDTO;
import com.example.ElectronicVotingSyatem.DTO.Result;
import com.example.ElectronicVotingSyatem.Model.Constituency;
import com.example.ElectronicVotingSyatem.Repository.ConstituencyRepo;
import com.example.ElectronicVotingSyatem.Service.ConstituencyService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstiTuencyServiceImpl implements ConstituencyService {

    @Autowired
    private ConstituencyRepo constituencyRepo;


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private static final Logger log = LoggerFactory.getLogger(ConstiTuencyServiceImpl.class);


    @Override
    public Result craeteConstituency(ConstituencyDTO constituency) {
        if (BsicUtil.isNullOrEmpty(constituency)) {
            return BsicUtil.prepareResponseObject("111", "ConstituencyDTO is enpty", null);
        }
        Result validTocraete = isValidTocraete(constituency);
        if (BsicUtil.isNullOrEmpty(validTocraete.getData() == null)) {
            return BsicUtil.prepareResponseObject("002", "data should not be null", null);
        }
        Constituency map = this.modelMapper.map(constituency, Constituency.class);
        Constituency save = constituencyRepo.save(map);
        return BsicUtil.prepareResponseObject("001", "Constituency created SuccessFylly", save);
    }

    @Override
    public Result getAllConstitute() {
        List<Constituency> all = constituencyRepo.findAll();
        return BsicUtil.prepareResponseObject("","All constitute fetched successfully",all);
    }

    private static Result isValidTocraete(ConstituencyDTO constituency) {

        if (BsicUtil.isNullOrEmpty(constituency.getName())) {
            return BsicUtil.prepareResponseObject("", "", null);
        }
        return BsicUtil.prepareResponseObject("", "", null);
    }

}
