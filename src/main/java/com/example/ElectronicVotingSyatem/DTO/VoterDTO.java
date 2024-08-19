package com.example.ElectronicVotingSyatem.DTO;

import lombok.Data;

@Data
public class VoterDTO {
    private String name;

    private int age;

    private String gender;

    private ConstituencyDTO constituencyDTO;
}
