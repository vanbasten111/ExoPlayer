package com.fongmi.android.ltv;

import android.app.Application;

import com.fongmi.android.ltv.utils.Token;
import com.fongmi.android.ltv.utils.Utils;

public class App extends Application {

	private static App instance;

	public App() {
		instance = this;
	}

	public static App getInstance() {
		return instance;
	}

	public static String getName() {
		return Utils.getString(R.string.app_name).toLowerCase();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Token.setProvider();
	}
}