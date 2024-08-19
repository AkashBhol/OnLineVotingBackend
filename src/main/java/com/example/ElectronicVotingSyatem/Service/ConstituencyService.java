package com.example.ElectronicVotingSyatem.Service;

import com.example.ElectronicVotingSyatem.DTO.ConstituencyDTO;
import com.example.ElectronicVotingSyatem.DTO.Result;
import com.example.ElectronicVotingSyatem.Model.Constituency;

public interface ConstituencyService {

    public Result craeteConstituency(ConstituencyDTO constituency);

    public Result getAllConstitute();
}
