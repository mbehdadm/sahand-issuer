package com.sahand.issuer.config;

import java.util.ArrayList;
import java.util.List;

import com.sahand.issuer.data.TLVData;
import com.sahand.issuer.enumeration.TLV;


public class TLVParse {
	
	public List<TLVData> parsRefrenceData(String refrenceData){
		List<TLVData> tlvList = new ArrayList<TLVData>();
	
		if (refrenceData != null && refrenceData.length() > 2) {
			do {
				TLVData tlv = new TLVData();
				String tag = refrenceData.substring(0, 2);
				String len = refrenceData.substring(2, 4);
				String data = refrenceData.substring(4,
						Integer.valueOf(len) + 4);
				tlv.setData(data);
				tlv.setLength(Integer.valueOf(len));
				tlv.setTag(Integer.valueOf(tag));
				tlvList.add(tlv);
				int lenRemove = (tag + len + data).length();
				refrenceData = refrenceData.substring(lenRemove);

			} while (refrenceData.length() > 2);
		}
		return tlvList;
	}

	public String getTarget(String refrenceData, TLV progData) {

		String value = null;
		List<TLVData> tlvDataList = parsRefrenceData(refrenceData);

		for (TLVData data : tlvDataList) {
			if (data.getTag() == progData.toValue())
				value = data.getData();
			System.out.println(TLV.fromValue(Integer.valueOf(value)));
		}
		return value;
	}

}
