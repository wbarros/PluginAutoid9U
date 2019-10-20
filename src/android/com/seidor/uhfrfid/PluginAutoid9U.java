package com.seidor.uhfrfid;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.seuic.uhf.UHFService;
import com.seidor.uhfrfid.InventoryFragement;

/**
 * This class echoes a string called from JavaScript.
 */
public class PluginAutoid9U extends CordovaPlugin {
	private CallbackContext receiveScanCallback;
	static private UHFService instance = null;
    private InventoryFragement inventoryFragement;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        JSONObject my_obj = new JSONObject();
        if(action.equals("singleTag")) {
            inventoryFragement = InventoryFragement.getInstance();
            // my_obj.put("inventoryFragement",inventoryFragement);
            my_obj = inventoryFragement.singleTag();
            callbackContext.success(my_obj);
            return true;
        }
        return false;
    }

}
