package com.example.ElectronicVotingSyatem.Repository;

import com.example.ElectronicVotingSyatem.Model.Constituency;
import com.example.ElectronicVotingSyatem.Model.Voter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoterRepo extends JpaRepository<Voter,Integer> {
    Page<Voter> findByConstituency(Constituency constituency, Pageable pageable);

    public List<Voter> findByGender(String gender);
}
