package com.example.ElectronicVotingSyatem.Service;

import com.example.ElectronicVotingSyatem.DTO.Result;
import com.example.ElectronicVotingSyatem.DTO.VoterDTO;
import com.example.ElectronicVotingSyatem.Model.Voter;

public interface VoterService {

    public Result countTotalVoter();

    public Result getAllVoter();

    public Result getSingleVoter(int id);

    public Result craeteVoter(VoterDTO voter);

    public Result countTotalVoterByConstituency(String name);

    public Result totalVoterDetailsByConstituency(String name);

    public Result totalVoterByGender(String gender);
}
