package com.seidor.uhfrfid;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import com.seuic.uhf.EPC;
import com.seuic.uhf.UHFService;

public class InventoryFragement {

	private UHFService mDevice;
	public boolean mInventoryStart = false;
	private static InventoryFragement inventoryfragement;

	public static InventoryFragement getInstance() {
		if (inventoryfragement == null)
			inventoryfragement = new InventoryFragement();
		return inventoryfragement;
	}

	public JSONObject singleTag() throws JSONException {
		JSONObject response = new JSONObject();
		EPC epc = new EPC();
		try {
			mDevice = UHFService.getInstance();
			if (mDevice.inventoryOnce(epc, 300)) {
				response.put("tag", epc.getId());
			} else {
				response.put("tag", -1);
			}
		} catch(Exception e) {
			response.put("error", e.getMessage());
		}
		return response;
	}

}
