package com.example.metroui;

public abstract interface MyHomeView {
	public abstract void destroy();

	public abstract void initListener();

	public abstract void initView();

	public abstract void updateData();
}
