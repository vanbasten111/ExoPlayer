package com.fongmi.android.tv.bean;

import android.text.TextUtils;

import com.fongmi.android.tv.AppDatabase;
import com.fongmi.android.tv.R;
import com.fongmi.android.tv.utils.Utils;

import java.util.List;

public class Type extends Bean {

	private String pass;
	private List<Channel> channel;
	private boolean hidden;
	private int position;
	private int id;

	public static Type create(int id) {
		Type type = new Type();
		type.setId(id);
		type.setName(Utils.getString(id));
		return type;
	}

	public Type() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isHidden() {
		return hidden;
	}

	public List<Channel> getChannel() {
		return isKeep() ? AppDatabase.get().getDao().getKeep() : channel;
	}

	public void setChannel(List<Channel> channel) {
		this.channel = channel;
	}

	public String getPass() {
		return TextUtils.isEmpty(pass) ? "" : pass;
	}

	public boolean isKeep() {
		return getId() == R.string.type_keep;
	}

	public boolean isSetting() {
		return getId() == R.string.type_setting;
	}

	public int find(String number) {
		return getChannel().lastIndexOf(Channel.create(number));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (!(obj instanceof Type)) return false;
		Type it = (Type) obj;
		return getId() == it.getId();
	}
}
