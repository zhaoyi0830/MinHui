package com.minhuitianxia.myapplication.Utils;

/**
 * FragmentManager存储Fragment用的tag的枚举
 * tag表示Fragment的完整类名
 */
public enum FragmentTag {
	TAG_MALL("com.minhuitianxia.myapplication.Fragment.Mall_Fragment"),
	TAG_SYNOPSIS("com.minhuitianxia.myapplication.Fragment.Synopsis_Vertical_Fragment"),
	TAG_VIP("com.minhuitianxia.myapplication.Fragment.VipLoginFragment"),
	TAG_VIPINFO("com.minhuitianxia.myapplication.Fragment.Vip_Fragment");


	String tag;
	
	private FragmentTag(String tag){
		this.tag = tag;
	}
	
	public String getTag(){
		return tag;
	}
}
