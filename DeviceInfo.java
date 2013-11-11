package com.gdpost.db.util;

import java.util.UUID;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
public final class DeviceInfo {
	public static String getDeviceId(Context context) {
		final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		final String tmDevice, tmSerial, tmPhone, androidId;
		tmDevice = "" + tm.getDeviceId();
		tmSerial = "" + tm.getSimSerialNumber();
		androidId = ""
				+ android.provider.Settings.Secure.getString(context.getContentResolver(),
						android.provider.Settings.Secure.ANDROID_ID);
		UUID deviceUuid = new UUID(androidId.hashCode(),
				((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
		Log.d("debug", "deviceID" + deviceUuid.toString());
		return deviceUuid.toString();
	}

	public static String getDeviceModel() {
		Log.d("debug", "deviceModel" + android.os.Build.MODEL);
		return android.os.Build.MODEL;
	}
}
