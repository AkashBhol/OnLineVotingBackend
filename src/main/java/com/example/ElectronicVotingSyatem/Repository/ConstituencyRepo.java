package com.example.ElectronicVotingSyatem.Repository;

import com.example.ElectronicVotingSyatem.Model.Constituency;
import com.example.ElectronicVotingSyatem.Model.Voter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstituencyRepo extends JpaRepository<Constituency,Integer> {
    Constituency findByName(String name);
}
