package com.appbootup.smspooler.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sachinsr on 01/09/13.
 */
public class BankingSMSRegexConstants {
    // Mobile Operator Code
    public static final String MOC_D = "D";// - Aircel, Dishnet Wireless
    public static final String MOC_A = "A";// - Bharti Airtel
    public static final String MOC_B = "B";// - BSNL
    public static final String MOC_L = "L";// - BPL, Loop Telecom
    public static final String MOC_C = "C";// - Datacom Solutions
    public static final String MOC_H = "H";// - HFCL Infotel
    public static final String MOC_I = "I";// - Idea, Aditya Birla Telecom
    public static final String MOC_M = "M";// - MTNL
    public static final String MOC_R = "R";// - Reliance Communications
    public static final String MOC_E = "E";// - Reliance Telecom
    public static final String MOC_S = "S";// - S. Tel Ltd
    public static final String MOC_Y = "Y";// - Shyam Telecom
    public static final String MOC_P = "P";// - Spice Communications
    public static final String MOC_W = "W";// - Swan Telecom
    public static final String MOC_T = "T";// - Tata Telecom
    public static final String MOC_U = "U";// - Unitech Group
    public static final String MOC_V = "V";// - Vodafone
    // Region Code
    public static final String MRC_A = "A";// - Andhra Pradesh
    public static final String MRC_S = "S";// - Assam
    public static final String MRC_B = "B";// - Bihar
    public static final String MRC_D = "D";// - Delhi
    public static final String MRC_G = "G";// - Gujarat
    public static final String MRC_H = "H";// - Haryana
    public static final String MRC_I = "I";// - Himachal Pradesh
    public static final String MRC_J = "J";// - Jammu & Kashmir
    public static final String MRC_X = "X";// - Karnataka
    public static final String MRC_L = "L";// - Kerala
    public static final String MRC_K = "K";// - Kolkata
    public static final String MRC_Y = "Y";// - Madhya Pradesh
    public static final String MRC_Z = "Z";// - Maharastra
    public static final String MRC_M = "M";// - Mumbai
    public static final String MRC_N = "N";// - North East
    public static final String MRC_O = "O";// - Orissa
    public static final String MRC_P = "P";// - Punjab
    public static final String MRC_R = "R";// - Rajasthan
    public static final String MRC_T = "T";// - Tamilnadu incl. Chennai
    public static final String MRC_E = "E";// - UP - East
    public static final String MRC_W = "W";// - UP - West
    public static final String MRC_V = "V";// - West Bengal
    // Bank Codes
    public static final String B_HDFCBK = "HDFCBK";
    public static final String B_CBSSBI = "CBSSBI";
    public static final String B_ATMSBI = "ATMSBI";
    public static final String B_SBIPSG = "SBIPSG";
    public static final String B_SBILOS = "SBILOS";
    public static final String B_SBIINB = "SBIINB";
    public static final String B_SBICRD = "SBICRD";
    public static final String B_SBGMBS = "SBGMBS";
    public static final String B_CBSSBM = "CBSSBM";
    public static final String B_AXISBK = "AxisBk";
    public static final String B_CANBNK = "CANBNK";
    public static final String B_VIJBNK = "VIJBNK";
    public static final String B_KOTAKB = "KOTAKB";
    public static final String B_KOTAKS = "KOTAKS";
    public static final String B_CITIBK = "Citibk";
    public static final String B_CORPBK = "CORPBK";
    public static final String B_ICICIB = "ICICIB";
    // Separator
    public static final String SEPARATOR = "-";
    // Permutations
    public static final List<String> smsBankingAddressCodes = new ArrayList<String>();
    // Test Codes
    public static final String TD_HDFCBK = MOC_T + MRC_D + SEPARATOR + B_HDFCBK;
    public static final String BT_HDFCBK = MOC_B + MRC_T + SEPARATOR + B_HDFCBK;
    public static final String DZ_HDFCBK = MOC_D + MRC_Z + SEPARATOR + B_HDFCBK;
    public static final String AM_HDFCBK = MOC_A + MRC_M + SEPARATOR + B_HDFCBK;
    public static final String MD_HDFCBK = MOC_M + MRC_D + SEPARATOR + B_HDFCBK;
    public static final String DM_HDFCBK = MOC_D + MRC_M + SEPARATOR + B_HDFCBK;
    public static final String LM_HDFCBK = MOC_L + MRC_M + SEPARATOR + B_HDFCBK;
    public static final String BX_ATMSBI = MOC_B + MRC_X + SEPARATOR + B_ATMSBI;
    public static final String BZ_ATMSBI = MOC_B + MRC_Z + SEPARATOR + B_ATMSBI;
    public static final String DM_CBSSBI = MOC_D + MRC_M + SEPARATOR + B_CBSSBI;
    public static final String BX_CBSSBI = MOC_B + MRC_X + SEPARATOR + B_CBSSBI;
    public static final String BZ_CBSSBI = MOC_B + MRC_Z + SEPARATOR + B_CBSSBI;
    public static final String BZ_CBSSBM = MOC_B + MRC_Z + SEPARATOR + B_CBSSBM;
    public static final String BX_CBSSBM = MOC_B + MRC_X + SEPARATOR + B_CBSSBM;
    public static final String MD_SBIPSG = MOC_M + MRC_D + SEPARATOR + B_SBIPSG;
    public static final String DM_SBGMBS = MOC_D + MRC_M + SEPARATOR + B_SBGMBS;
    public static final String LM_SBIINB = MOC_L + MRC_M + SEPARATOR + B_SBIINB;
    public static final String BX_SBIINB = MOC_B + MRC_X + SEPARATOR + B_SBIINB;
    public static final String BX_SBILOS = MOC_B + MRC_X + SEPARATOR + B_SBILOS;
    public static final String DM_SBICRD = MOC_D + MRC_M + SEPARATOR + B_SBICRD;
    public static final String MD_SBICRD = MOC_M + MRC_D + SEPARATOR + B_SBICRD;
    public static final String BZ_SBICRD = MOC_B + MRC_Z + SEPARATOR + B_SBICRD;
    public static final String DZ_AXISBK = MOC_D + MRC_Z + SEPARATOR + B_AXISBK;
    public static final String DM_AXISBK = MOC_D + MRC_M + SEPARATOR + B_AXISBK;
    public static final String LM_AXISBK = MOC_L + MRC_M + SEPARATOR + B_AXISBK;
    public static final String MD_AXISBK = MOC_M + MRC_D + SEPARATOR + B_AXISBK;
    public static final String BZ_VIJBNK = MOC_B + MRC_Z + SEPARATOR + B_VIJBNK;
    public static final String MD_VIJBNK = MOC_M + MRC_D + SEPARATOR + B_VIJBNK;
    public static final String BX_CANBNK = MOC_B + MRC_X + SEPARATOR + B_CANBNK;
    public static final String LM_VIJBNK = MOC_L + MRC_M + SEPARATOR + B_VIJBNK;
    public static final String DM_KOTAKB = MOC_D + MRC_M + SEPARATOR + B_KOTAKB;
    public static final String VM_KOTAKB = MOC_V + MRC_M + SEPARATOR + B_KOTAKB;
    public static final String DZ_KOTAKB = MOC_D + MRC_Z + SEPARATOR + B_KOTAKB;
    public static final String LM_KOTAKB = MOC_L + MRC_M + SEPARATOR + B_KOTAKB;
    public static final String LM_KOTAKS = MOC_L + MRC_M + SEPARATOR + B_KOTAKS;
    public static final String VM_KOTAKS = MOC_V + MRC_M + SEPARATOR + B_KOTAKS;
    public static final String LM_CITIBK = MOC_L + MRC_M + SEPARATOR + B_CITIBK;
    public static final String MD_CITIBK = MOC_M + MRC_D + SEPARATOR + B_CITIBK;
    public static final String BT_CORPBK = MOC_B + MRC_T + SEPARATOR + B_CORPBK;
    public static final String LM_ICICIB = MOC_L + MRC_M + SEPARATOR + B_ICICIB;
    public static final String DM_ICICIB = MOC_D + MRC_M + SEPARATOR + B_ICICIB;
    public static List<String> smsOperatorCodes = Arrays.asList(MOC_D, MOC_A, MOC_B, MOC_L, MOC_C, MOC_H, MOC_I, MOC_R, MOC_E,
            MOC_S, MOC_Y, MOC_P, MOC_W, MOC_T, MOC_U, MOC_V);
    public static List<String> smsRegionCodes = Arrays.asList(MRC_A, MRC_S, MRC_B, MRC_D, MRC_G, MRC_H, MRC_I, MRC_J, MRC_X,
            MRC_L, MRC_K, MRC_Y, MRC_Z, MRC_M, MRC_N, MRC_O, MRC_P, MRC_R,
            MRC_T, MRC_E, MRC_W, MRC_V);
    public static List<String> smsBankCodes = Arrays.asList(B_HDFCBK, B_CBSSBI, B_ATMSBI, B_SBIPSG, B_SBIINB, B_SBICRD,
            B_SBGMBS, B_CBSSBM, B_SBILOS, B_AXISBK, B_CANBNK, B_VIJBNK,
            B_KOTAKB, B_KOTAKS, B_CITIBK, B_CORPBK, B_ICICIB);
    public static List<String> knownSMSBankingAddressCodes = Arrays
            .asList(TD_HDFCBK, BT_HDFCBK, DZ_HDFCBK, AM_HDFCBK,
                    MD_HDFCBK, DM_HDFCBK, LM_HDFCBK, DM_CBSSBI, DM_SBICRD,
                    MD_SBICRD, BZ_SBICRD, BX_ATMSBI, BZ_ATMSBI, BZ_CBSSBI,
                    BX_CBSSBI, MD_SBIPSG, DM_SBGMBS, LM_SBIINB, BX_SBIINB,
                    BX_SBILOS, BZ_CBSSBM, BX_CBSSBM, DZ_AXISBK, DM_AXISBK,
                    LM_AXISBK, MD_AXISBK, BZ_VIJBNK, MD_VIJBNK, LM_VIJBNK,
                    BX_CANBNK, DM_KOTAKB, VM_KOTAKB, DZ_KOTAKB, LM_KOTAKB,
                    LM_KOTAKS, VM_KOTAKS, LM_CITIBK, MD_CITIBK, BT_CORPBK,
                    LM_ICICIB, DM_ICICIB);

    static {
        for (int i = 0; i < smsOperatorCodes.size(); i++) {
            for (int j = 0; j < smsRegionCodes.size(); j++) {
                for (int k = 0; k < smsBankCodes.size(); k++) {
                    String addresscode = smsOperatorCodes.get(i)
                            + smsRegionCodes.get(j) + SEPARATOR
                            + smsBankCodes.get(k);
                    smsBankingAddressCodes.add(addresscode);
                }
            }
        }
    }

}