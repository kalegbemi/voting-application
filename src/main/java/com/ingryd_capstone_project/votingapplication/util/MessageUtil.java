package com.ingryd_capstone_project.votingapplication.util;

import com.ingryd_capstone_project.votingapplication.dto.CandidateEmailDetails;

public class MessageUtil {

    public static String getVoterMessage(String to, String name, String role){
        return "Hello "+ name+",\n\nYou have been registered as a "+role+" on the INGRYD VOTING APPLICATION." +
                "\n\nFurther information will be communicated as the needs arises.\n\n\n\nThank you,\n\nSupport team.";
    }

    public static String getCandidateMessage(CandidateEmailDetails details){
        return "Hello "+ details.getName()+",\n\nYou have been registered as a "+details.getRole()+" on the INGRYD VOTING APPLICATION." +
                "\n\nYou were registered as a candidate contesting for the position of "+details.getPosition() +"under" +
                "the party "+details.getParty()+"."+
                "\n\nFurther information will be communicated as the needs arises.\n\n\n\nThank you,\n\nSupport team.";
    }
}
